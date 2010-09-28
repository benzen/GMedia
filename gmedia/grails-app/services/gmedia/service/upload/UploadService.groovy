package gmedia.service.upload

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class UploadService{ 
  static final uploadDirectory = "gmedia-files/upload"
  def authorizedImageContentType = [ 'image/jpeg' :'jpg', 'image/gif' :'gif', 'image/png' :'png']
  def authorizedAudioContentType = [ 'audio/mp3':'mp3','audio/ogg':'ogg']
  
  def uploadFile(String path){ 
    def file = new File(path)
    copyFile(file, upload+UUID.randomUUID())
  }
  
  def copyFile(File file, String  newPath){ 
    def newFile = new File(newPath)
    newFile << file.getText()
    newFile
  }
  def saveImageFile(imageFile, name, storagePath) {
    if (!imageFile.empty) {
      FileNameMap fileNameMap = URLConnection.getFileNameMap();
      def contentType = fileNameMap.getContentTypeFor(imageFile.originalFilename)
      
      if ( authorizedImageContentType.keySet().contains(contentType) ) {
	File storageDir = new File(storagePath)
	if (!storageDir.exists()) {
	  if (!storageDir.mkdir()) {
	    log.error 'Directory does not exist and cannot be created '+storagePath
	    return false
	  }
	}
	
	// Pour un minimum de standardisation, on génère le nom du fichier à enregistré à partir du paramètre
	// 'name' et du type mime
	def targetFilename = name + '_logo.' + authorizedImageContentType[contentType]
	
	// sauvegarde du fichier
	imageFile.transferTo( new File(storagePath + targetFilename) )
        
	return targetFilename
      }
      return false
    }
  }
}
