package gmedia

import grails.test.*
import org.junit.Test
import org.junit.Before
import org.junit.After
import gmedia.model.Music
import gmedia.model.User
import gmedia.model.PlayCounter
import gmedia.service.counter.CounterService

class CounterServiceTests extends GrailsUnitTestCase{ 
  def counterService
  def user
  def music
  
  @Before
  public void setup(){ 
    counterService = new CounterService()
    user = new User(name:"fakename",password:"fakePass",email:"fake@email.com")
    user.save(flush:true)
    music = new Music()
    music.save(flush:true)
  }

  @Test
  public void playCounterCreation(){ 
    counterService.incrementPlayCounter(user,music)
    def counter = PlayCounter.findByUser(user).first()
    def excpectedCounter = new PlayCounter(user,music,1)
    assertEquals(expectedCounter, counter)
  }

  
}