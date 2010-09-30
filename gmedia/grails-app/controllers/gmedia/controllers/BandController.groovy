package gmedia.controllers

import gmedia.domain.Band
import gmedia.domain.Style
import gmedia.service.upload.UploadService

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class BandController {
  
  def scaffold= Band
  def beforeInterceptor = [action:this.&auth]
  def uploadService
  def auth = {
    if(!session.user) {
      flash.message="Log before do that"
      redirect(controller:"user", action:"login")
      return false
    }
  }

  def save = {
    convertStyleNameToStyles(params)
    def bandInstance = new Band(params)
    if(params.logoPath){
      // saving image File with the UploadService
      def imageSaved = uploadService.saveImageFile(request.getFile(params.logoPath), params.name, "/"+params.name) 
      if (imageSaved) {
        bandInstance.logoPath = imageSaved
      } else {
        flash.error = 'Bad image type. Authorized are : jpeg, gif and png'
        redirect(view: "create", model: [bandInstance: bandInstance])
      }
    }
    if(    bandInstance.save(flush:true)){
      redirect(action: "show", id: bandInstance.id)
    }else {
      render(view: "create", model: [bandInstance: bandInstance])
    }
  }
  
  def update = {
    convertStyleNameToStyles(params)
    def bandInstance = Band.get(params.id)
    if (bandInstance) {
      if (params.version) {
        def version = params.version.toLong()
        if (bandInstance.version > version) {
          bandInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'band.label', default: 'Band')] as Object[], "Another user has updated this Band while you were editing")
          render(view: "edit", model: [bandInstance: bandInstance])
          return
        }
      }
      bandInstance.properties = params           
      if (!bandInstance.hasErrors() && bandInstance.save(flush: true)) {
        flash.message = "${message(code: 'default.updated.message', args: [message(code: 'band.label', default: 'Band'), bandInstance.id])}"
        redirect(action: "show", id: bandInstance.id)
      }else {
        render(view: "edit", model: [bandInstance: bandInstance])
      }
    }else {
      flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'band.label', default: 'Band'), params.id])}"
      redirect(action: "list")
    }
  }
     
  private void convertStyleNameToStyles( params){
    if (params.stylesField &&params.stylesField!=""){
      params.styles = params.styles +","+params.stylesField
    }
    params.styles = params.styles.split(",").collect{s-> 
      def styleS = Style.findByName(s)
      if(!styleS){
        def newStyle = new Style(name:s)
        newStyle.save(flush:true)
        newStyle
      }else{
        styleS
      }
    }
  }
 
}
