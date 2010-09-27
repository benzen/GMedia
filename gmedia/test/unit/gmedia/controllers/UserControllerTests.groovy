package gmedia.controllers

import grails.test.*
import gmedia.domain.User
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNull
class UserControllerTests extends ControllerUnitTestCase {
  

    protected void setUp() {
        super.setUp()
	String.metaClass.encodeAsPassword={delegate}

    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSaveComplete() {
      mockParams.name="fakeUser"
      mockParams.email="fake@mail.fr"
      mockParams.password="fakePass"
      mockParams.confirmPassword="fakePass"
       
      def testInstance= []
      mockDomain(User,testInstance)
      mockForConstraintsTests(User)
      controller.save()
        
      assertEquals "User fakeUser succesfully created.", mockFlash.message
      assertNull mockFlash.error
      assertEquals "fakeUser", controller.session.user.name
      assertEquals "/", controller.redirectArgs.uri
      
    }
  
  void testSaveFail() {
      mockParams["name"]="fakeUser"
      mockParams["email"]="fake@mail.fr"
      mockParams["password"]="fakePass"
      mockParams["confirmPassword"]=""
      mockDomain(User,[])
      controller.save(mockParams)
      assertEquals "Error when creating user fakeUser.", mockFlash.error
      assertNull mockFlash.message
      assertNull controller.session.user
      assertEquals "create", controller.redirectArgs.action 
      assertEquals "user", controller.redirectArgs.controller
    }

}
