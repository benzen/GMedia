package gmedia

import gmedia.model.Playlist

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
