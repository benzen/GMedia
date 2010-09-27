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
  def testAuthRejected(){ 
    mockSession.user= null
    assertFalse controller.auth()
    assertEquals mockFlash.message,  "Log before do that"
    assertEquals "login", controller.redirectArgs.action
    assertEquals "user", controller.redirectArgs.controller
  }

  def testAuthAccepted(){ 
    mockSession.user="user"
    controller.auth()
  }
  
  def testAuthenticateValidUser(){ 
    mockParams.name="fakeUser"
    mockParams.password="fakePass"
    def user = new User(name:"fakeUser",
			email:"fake@mail.fr",
			password:"fakePass",
			confirmPassword:"fakePass")
    mockDomain(User,[user])
    controller.authenticate()
    assertEquals user, controller.session.user
    assertEquals "Hello fakeUser!", mockFlash.message.toString()
    assertEquals "/", controller.redirectArgs.uri
  }
  def testAuthenticateInvalidUserWithName(){ 
    mockParams.name="fakeuser"
    mockParams.password="fakePass"
    mockDomain(User,[])
    controller.authenticate()
    assertEquals "Invalid user fakeuser!", mockFlash.error.toString()
    assertEquals "login", controller.redirectArgs.action
    assertEquals "user", controller.redirectArgs.controller
  }
  def testAuthenticateInvalidUserWithoutName(){ 
    mockDomain(User,[])
    controller.authenticate()
    assertEquals "Invalid user!", mockFlash.error.toString()
    assertEquals "login", controller.redirectArgs.action
    assertEquals "user", controller.redirectArgs.controller
  }

}
