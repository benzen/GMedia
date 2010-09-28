package gmedia.service.player

import gmedia.domain.Music
import gmedia.domain.User

class PlayerService {
  
  def counterService
  
  def serviceMethod() {
    
  }

  def playMusic(User user, Music music){ 
    counterService.incrementPlayCounter(user,music)
    
  }
  def skipMusic(User user,Music music){ 
    counterService.incrementSkipCounter(user,music)
  }
    
}
