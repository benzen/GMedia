package gmedia.controllers

import gmedia.domain.Music


/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */

class MusicController {
  def beforeInterceptor =[action:this.&auth]
  def scaffold = Music

  def auth() {
    if(!session.user){
      redirect(controller:'user',action:'login')
      return false
    }
  }
  def play={
    if(!params.id || !Music.exists(params.id)){ 
      flash.error = "No music exist for this id"
    }else{ 
      params.music= Music.findById(params.id)
    }
  }
}
