package gmedia.controllers

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class PlayerController {
    def counterService
    
    def index = {}
    def play={
      counterService.incrementPlayCounter(music:Music.get(params.id),user:session.user)
    }
    def next={
      counterService.incrementSkipCounter(music:Music.get(params.id),user:session.user)
    }
    def stop={}
    def pause={}
    def previous={}
}
