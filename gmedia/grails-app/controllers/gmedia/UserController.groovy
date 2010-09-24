package gmedia
import gmedia.model.User
class UserController {
  
  def scaffold = User
  
  def beforeInterceptor = [action:this.&auth, except:["login","authenticate","create","save"]]
  
  def auth = {
    if(!session.user) {
      flash.message="Log before do that"
      redirect(controller:"user", action:"login")
      return false
    }
  }
  def save = {
    def user = new User(params)
    if (user.save(flush: true)) {
      flash.message = "User "+user.name+" succesfully created."
      session.user = user
      redirect(uri:"/")
    }
    else {
      render(view: "create", model: [user: user])
    }
  }

  def login={}
  
  def authenticate = {
    def user = User.findByNameAndPassword(params.name, params.password)
    if(user){
      session.user = user
      flash.message = "Hello ${user.name}!"
      redirect(uri:"/")      
    }else{
      def username = params?.name ? " "+params.name+"!":"."
      flash.message = "Invalid user${username}"
      redirect(controller:"user", action:"login")
    }
  }
  
  def logout = {
    flash.message = "Goodbye  ${session.user.name}"
    session.user = null
    redirect(uri:"/")      
  }  
}
