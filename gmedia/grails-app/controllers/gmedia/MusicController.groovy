package gmedia

class MusicController {
def beforeInterceptor =[action:this.&auth]
def scaffold = true

def auth() {
    if(!session.user){
    redirect(controller:'user',action:'login')
    return false
    }
}
}