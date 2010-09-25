package gmedia

import org.junit.Test
import org.junit.Before
import org.junit.After
import static org.junit.Assert.assertThat
import static org.junit.Assert.assertFalse
import static org.junit.matchers.JUnitMatchers.hasItem
import grails.test.*
import gmedia.service.membership.MembershipService
import gmedia.model.User

class MembershipServiceTests  extends GrailsUnitTestCase{ 
  def service

  @Before
  public void before(){ 
    service = new MembershipService()
  }

  @Test
  public void createUser(){
    service.createUser("fakeuser","fakePass","email@mail.fr")
    def user = new User(name:"fakeuser",password:"fakePass",confirmPassword:"fakePass", email:"email@mail.fr")
    assertThat(service.listUser(), hasItem(user))
  }
  
  @Test
  public void listDeletedUser(){ 
    service.createUser("fakeUser","fakePass","email@mail.fr")
   def user = User.findByNameAndEmail("fakeUser","email@mail.fr")
   service.deleteUser(user)
   assertFalse(service.listUser().toString().contains(user.toString()))
  }

}