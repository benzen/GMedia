package gmedia.controllers

import grails.test.*
import gmedia.domain.User
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNull

class DownloadControllerTests extends ControllerUnitTestCase {
  
  
  protected void setUp() {
        super.setUp()
    }
  
  protected void tearDown() {
      super.tearDown()
    }
  def testImage(){
    params.id=22
    controller.image()
    assertTrue false
  }

}
