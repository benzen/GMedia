package gmedia

import org.junit.Test
import org.junit.Before
import org.junit.After
import grails.test.*
import gmedia.service.membership.MembershipService

class MembershipServiceTests  extends GrailsUnitTestCase{ 
  def service

  @Before
  public void before(){ 
    service = new MembershipService()
  }

  @Test
  public void createUser(){
    service.createUser("fakeuser","fakePass","email@mail.fr")
    def user = new User(name:"fakeuser",password:"fakePass", email:"email@mail.fr")
    assertEquals([user] ,service.listUser())
  }
  
  @Test
  public void listDeletedUser(){ 
    service.createUser("fakeUser","fakePass","email@mail.fr")
   def user = User.findByNameAndEmail("fakeUser","email@mail.fr")
   service.deleteUser(user)
   assertEquals([], service.listUser())
  }

}