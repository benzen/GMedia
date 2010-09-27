package gmedia

import grails.test.*
import gmedia.domain.User
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNull
class UserControllerTests extends ControllerUnitTestCase {
  

    protected void setUp() {
        super.setUp()
	String.metaClass.encodeAsPassword={ id->id}
	mockForConstraintsTests(User)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSaveComplete() {
      mockParams["name"]="fakeUser"
      mockParams["email"]="fake@mail.fr"
      mockParams["password"]="fakePass"
      mockParams["confirmPassword"]="fakePass"

      def testInstance= []
      mockDomain(User,testInstance)

      controller.save()
      println testInstance
      assertEquals "User fakeUser succesfully created.", mockFlash.message
      assertNull mockFlash.error
      
    }
  
  void testSaveFail() {
      mockParams["name"]="fakeUser"
      mockParams["email"]="fake@mail.fr"
      mockParams["password"]="fakePass"
      mockParams["confirmPassword"]="fakePass"
      mockDomain(User,[])
      controller.save(mockParams)
      assertEquals "Error when creating user fakeUser.", mockFlash.error
      assertNull mockFlash.message
    }

}
