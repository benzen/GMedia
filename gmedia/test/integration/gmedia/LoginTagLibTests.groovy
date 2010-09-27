package gmedia

import grails.test.*
import gmedia.model.User
class LoginTagLibTests extends TagLibUnitTestCase {

  void setUp() {
    super.setUp()
    LoginTagLib.metaClass.link = {map -> "<a href='/${map.controller}/${map.action}'>${map.link}</a>"}
  }
 
  void tearDown() {
    super.tearDown()
  }
  void testUnloggedOutput() {
    mockSession.clearAttributes() 
    tagLib.loginControl(mockSession)

    assertEquals '<a href="/user/login">[Login]</a><a href="/user/create">[Subscribe]</a>',  tagLib.out.toString()
  }
  void testLoggedOutput(){ 

    def user = new User(name:"fakeUser",
			password:"fakePass",
			confirmPassword:"fakePass",
			email:"fake@mail.com")
    mockSession.setAttribute("user",user)

    tagLib.loginControl(mockSession)
    
    assertEquals 'Hello fakeUser  <a href="/user/logout">[Logout]</a>', tagLib.out.toString()
  }
}
