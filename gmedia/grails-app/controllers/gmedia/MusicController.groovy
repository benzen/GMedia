package gmedia

import gmedia.model.Music

class MusicController {
  def beforeInterceptor =[action:this.&auth]
  def scaffold = Music

  static navigation = [
    group:'tabs', 
    order:1, 
    title:'Play a song', 
    action:'play'
  ]
  
  def auth() {
    if(!session.user){
      redirect(controller:'user',action:'login')
      return false
    }
  }
  def play={
    if(!params.id || !Music.exists(params.id)){ 
      flash.message = "No music exist for this id"
    }else{ 
      params.music= Music.findById(params.id)
    }
  }
}