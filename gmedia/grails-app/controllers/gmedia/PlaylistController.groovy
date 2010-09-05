package gmedia

class PlaylistController {

   def scaffold = true
def beforeInterceptor = [action:this.&auth]

  def auth() {
    if(!session.user) {
      redirect(controller:"user", action:"login")
      return false
    }
  }
}
