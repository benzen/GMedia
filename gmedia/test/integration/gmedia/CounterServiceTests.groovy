package gmedia

import grails.test.*
import org.junit.Test
import org.junit.Before
import org.junit.After
import gmedia.model.Music
import gmedia.model.User
import gmedia.model.PlayCounter
import gmedia.model.Person
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
 
    def johnny = new Person(firstName:"Johnny", lastName:"Hallyday")
    music = new Music(title:"Retiens la nuit",length:20,nbRead:0,nbSkip:0,)
    music.mp3Path("/fake/path.mp3")
    music.oggPath("/fake/path.ogg")
    johnny.addToMusic(music)
    johnny.save(flush:true)
    music.save(flush:true)



  }

  @Test
  public void playCounterCreation(){ 
    counterService.incrementPlayCounter(user,music)
    def counter = PlayCounter.findByUserAndMusic(user,music)
    def expectedCounter = new PlayCounter(user:user,music:music)
    assertEquals(expectedCounter.value, counter.value)
  }

  
}