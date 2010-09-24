package gmedia

import gmedia.model.Playlist

class PlaylistController {

  def scaffold = Playlist
  def beforeInterceptor = [action:this.&auth]
  
  static navigation = [
    group:'tabs', 
    order:2, 
    title:'Manage Playlist', 
    action:'list'
  ]
  
  def auth() {
    if(!session.user) {
      redirect(controller:"user", action:"login")
      return false
    }
  }
}
