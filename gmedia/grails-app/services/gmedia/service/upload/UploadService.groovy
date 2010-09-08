package gmedia.service.upload

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class UploadService{ 
  static final uploadDirectory = "gmedia-files/upload"
  
  def uploadFile(String path){ 
    def file = new File(path)
    copyFile(file, upload+UUID.randomUUID())
  }
  
  def copyFile(File file, String  newPath){ 
    def newFile = new File(newPath)
    newFile << file.getText()
    newFile
  }
}