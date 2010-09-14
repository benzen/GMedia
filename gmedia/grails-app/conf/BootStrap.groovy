import gmedia.model.Music
import gmedia.model.User
class BootStrap {

    def init = { servletContext ->
      new Music( title:"die another day", length:22, nbSkip:0, nbRead:0 ).save()    
      new User(name:"ben23",password:"zen23",email:"fake@mail.fr")
    }
    def destroy = {
    }
}
