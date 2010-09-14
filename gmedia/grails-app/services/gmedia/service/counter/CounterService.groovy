package gmedia.service.counter

import gmedia.model.Music
import gmedia.model.User
import gmedia.model.PlayCounter
import gmedia.model.SkipCounter

class CounterService{ 

  def incrementPlayCounter(User user, Music music){ 
    def counter = PlayCounter.findByUserAndMusic(user,music)
    if(counter){ 
      counter.value++
    }else{ 
      counter = new PlayCounter(user,music)
      user.save()
      music.save()
      counter.save(flush:true)
    }
  }

  def incrementSkipCounter(User user,Music music){ 
    def counter = SkipCounter.findByUserAndMusic(user,music)
    if(counter){ 
      counter.value++
    }else{ 
      counter = new SkipCounter(user,music)
      user.save()
      music.save()
      counter.save(flush:true)
    }
  }

  
}