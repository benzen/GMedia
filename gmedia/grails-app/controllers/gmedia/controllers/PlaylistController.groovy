package gmedia.controllers

import gmedia.domain.Playlist

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class PlaylistController {

  def scaffold = Playlist
  def beforeInterceptor = [action:this.&auth]
  
  def auth() {
    if(!session.user) {
      redirect(controller:"user", action:"login")
      return false
    }
  }
}
