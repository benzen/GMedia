package gmedia

import gmedia.model.Music

class MusicController {
def beforeInterceptor =[action:this.&auth]
def scaffold = Music

def auth() {
    if(!session.user){
      redirect(controller:'user',action:'login')
      return false
    }
}
}