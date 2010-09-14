package gmedia

import gmedia.model.Playlist
import gmedia.UserController

class PlaylistController {

  def scaffold = Playlist
  def beforeInterceptor = [action:UserControler.&auth]
  
}
