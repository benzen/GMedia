package gmedia
import gmedia.model.User
class UserController {
  
  def scaffold = User
  
  def beforeInterceptor = [action:this.&auth, except:["login","logout","authenticate","create"]]
  
  def auth = {
    if(!session.user) {
      redirect(controller:"user", action:"login")
      return false
    }
  }
  
  def login={}
  
  def authenticate = {
    def user = User.findByNameAndPassword(params.name, params.password)
    if(user){
      session.user = user
      flash.message = "Hello ${user.name}!"
      redirect(controller:"home", action:"index")      
    }else{
      def username = params?.name ? " "+params.name+"!":"."
      flash.message = "Invalid user${username}"
      redirect(controller:"user", action:"login")
    }
  }
  
  def logout = {
    def username = session?.user?.name?:""
    flash.message = "Goodbye  ${username}"
    session.user = null
    redirect( action:'login')      
  }  
}
