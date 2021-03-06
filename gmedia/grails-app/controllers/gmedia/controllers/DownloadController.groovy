package gmedia.controllers

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class DownloadController {
    
   def images = {
      String filename = params.id
      log.debug "dl image file : ${filename}"
        
      def file = new File(grailsApplication.config.storage.image.directory + filename)
      if (file.exists()) {
         response.setContentType("application/octet-stream")
         response.setHeader("Content-Disposition", "attachment; filename=${filename}")
         response.setContentLength(file.readBytes().size())
         response.getOutputStream() <<file.readBytes()
      }
      response.flush()
   }
}
