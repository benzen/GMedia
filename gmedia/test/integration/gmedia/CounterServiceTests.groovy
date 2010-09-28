package gmedia

import grails.test.*
import org.junit.Test
import org.junit.Before
import org.junit.After
import gmedia.domain.Music
import gmedia.domain.User
import gmedia.domain.PlayCounter
import gmedia.domain.Person
import gmedia.domain.Album
import gmedia.domain.Style
import gmedia.service.counter.CounterService

class CounterServiceTests extends GrailsUnitTestCase{ 
  def counterService
  def user
  def music
  
  @Before
  public void setup(){ 
    counterService = new CounterService()
    user = new User(name:"fakename",password:"fakePass",confirmPassword:"fakePass",email:"fake@email.com")
    user.save(flush:true)
 
    def johnny = new Person(name:"Johnny Hallyday")
    music = new Music(title:"Retiens la nuit",length:20,nbRead:0,nbSkip:0)
    music.author= johnny
    music.album = new Album(name:"johnny halliday sa vie son oeuvre", author:johnny)
    music.album.addToStyles(new Style(name:"rock"))
    music.album.addToTracks(music)
    music.mp3Path = "/fake/path.mp3"
    music.oggPath = "/fake/path.ogg"
    music.author.save(flush:true)
    music.album.save(flush:true)
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
