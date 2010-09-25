package gmedia

import gmedia.model.Band
import gmedia.service.upload.UploadService

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
    def bandInstance = new Band(params)
    
    // saving image File with the UploadService
    def imageSaved = uploadService.saveImageFile(request.getFile('logoFile'), bandInstance.name, "/"+bandInstance.name) 
    if (imageSaved) {
      bandInstance.logoPath = imageSaved
    } else {
      flash.error = 'Bad image type. Authorized are : jpeg, gif and png'
      render(view: "create", model: [bandInstance: bandInstance])
      return
    }
    
    // image saving is ok, saving bandInstance to DB
    if (bandInstance.save(flush:true)) {
      redirect(action: "show", id: bandInstance.id)
    }
    else {
      flash.error = "Error when saving band"
      render(view: "create", model: [bandInstance: bandInstance])
    }
  }
  
}
