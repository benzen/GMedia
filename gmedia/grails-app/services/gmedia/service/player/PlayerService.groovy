package gmedia.service.player

import gmedia.model.Music
import gmedia.model.User

class PlayerService {
  
  def counterService
  
  static transactional = true
  
  def serviceMethod() {
    
  }

  def playMusic(User user, Music music){ 
    counterService.incrementPlayCounter(user,music)
    
  }
  def skipMusic(User user,Music music){ 
    counterService.incrementSkipCounter(user,music)
  }
    
}
