package gmedia.controllers
import gmedia.domain.User

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


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
    params["password"]=params["password"].encodeAsPassword()
    params["confirmPassword"]= params["confirmPassword"].encodeAsPassword()

    def user = new User(params)

    if (user.save(flush: true)) {
      flash.message = "User "+user.name+" succesfully created."
      session.user = user
      redirect(uri:"/")
    }
    else{
      flash.error = "Error when creating user "+user.name+"."
      redirect(controller: "user", action:"create")
    }
  }

  def login={}
  
  def authenticate = {
    if(params.name || params.password?.encodeAsPassword()){ 
      def user = User.findByNameAndPassword(params.name, params.password.encodeAsPassword())
      
      if(user){
	session.user = user
	flash.message = "Hello ${user.name}!"
	redirect(uri:"/")      
      }else{
	flash.error = "Invalid user ${params.name}!"
	redirect(controller:"user", action:"login")
      }
    }
    else{ 
      flash.error = "Invalid user!"
      redirect(controller:"user", action:"login")
    }
  }
  
  def logout = {
    flash.message = "Goodbye ${session.user.name}."
    session.user = null
    redirect(uri:"/")      
  }  
  def edit={[user:session.user] }
  def show={[user:session.user] }
  def index={  redirect controller:"user", action:"show"  }
}
