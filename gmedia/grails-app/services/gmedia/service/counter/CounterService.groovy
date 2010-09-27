package gmedia.service.counter

import gmedia.domain.Music
import gmedia.domain.User
import gmedia.domain.PlayCounter
import gmedia.domain.SkipCounter

class CounterService{ 

  def incrementPlayCounter(User user, Music music){ 
    def counter = PlayCounter.findByUserAndMusic(user,music)
    if(counter){ 
      counter.value++
    }else{ 
      counter = new PlayCounter(user:user,music:music)
      counter.save(flush:true)
    }
  }

  def incrementSkipCounter(User user,Music music){ 
    def counter = SkipCounter.findByUserAndMusic(user,music)
    if(counter){ 
      counter.value++
    }else{ 
      counter = new SkipCounter(user,music)
      counter.save(flush:true)
    }
  }

  
}