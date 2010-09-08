package gmedia.service

import grails.test.*
import org.junit.Test
import org.junit.Before
import org.junit.After
import gmedia.service.upload.UploadService
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class UploadServiceTests extends GrailsUnitTestCase {

  def uploadService

  @Before
  public void setUp() {
  uploadService = new UploadService()
  }

  @After
  public void tearDown() {
  
  }
  @Test
  void copyingFile() {
    def file = new File("originalFile")
    file << "test text"
    uploadService.copyFile(file,"testFile.txt")
    def newFile = new File("testFile.txt")
    assertEquals( file.getText(), newFile.getText() )
    
    file.delete()
    newFile.delete()
  }
}
