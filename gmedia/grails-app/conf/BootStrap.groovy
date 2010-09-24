import gmedia.model.Music
import gmedia.model.Person
import gmedia.model.User
class BootStrap {

    def init = { servletContext -> 
      def user = new User(name:"ben", email:"ben@ben.fr", password:"zen".encodeAsPassword(),confirmPassword:"zen".encodeAsPassword())
      user.save(flush:true)
      def p = new Person(firstName:"a", lastName:"b")
      p.save(flush:true)
      def m= new Music(author:p,title:"test music")
      m.mp3Path=("/test2.mp3")
      m.oggPath=("/test2.ogg")
      m.save(flush:true)
      
      
    }
    def destroy = {
    }
}
