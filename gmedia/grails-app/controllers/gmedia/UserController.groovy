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
    println  params
    params["password"]=params["password"].encodeAsPassword()
    params["confirmPassword"]= params["confirmPassword"].encodeAsPassword()
    println     params["password"]
    def user = new User(params)

    if (user.save(flush: true)) {
      flash.message = "User "+user.name+" succesfully created."
      session.user = user
      redirect(uri:"/")
    }
    else {
      flash.error = "Error when creating user "+user.name+"."
      redirect(controller: "user", action:"create")
    }
  }

  def login={}
  
  def authenticate = {
    println "pass"+params.password
    println "coded pass"+params.password.encodeAsPassword()
    println "user pass" +User.findByName("ben").password
    def user = User.findByNameAndPassword(params.name, params.password.encodeAsPassword())
    if(user){
      session.user = user
      flash.message = "Hello ${user.name}!"
      redirect(uri:"/")      
    }else{
      def username = params?.name ? " "+params.name+"!":"."
      flash.error = "Invalid user${username}"
      redirect(controller:"user", action:"login")
    }
  }
  
  def logout = {
    flash.message = "Goodbye  ${session.user.name}"
    session.user = null
    redirect(uri:"/")      
  }  
}
