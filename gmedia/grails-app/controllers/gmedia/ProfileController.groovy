package gmedia
import gmedia.service.membership.MembershipService
class ProfileController {

  def membershipService
  def beforeInterceptor = [action:this.&auth]

  def auth() {
    if(!session.user) {
      redirect(controller:"user", action:"login")
      return false
    }
  }


  def index = { redirect(action:show)}
  def show={return [user:session.user]}
  def edit={return [user:session.user]}
  
  def update={ 
    def user = membershipService.getUser(session.user.id)

    // checking password is not the same as old value
    if (!params.password.encodeAsPassword().equals(user.password)) {
      // applying password, look User constraints to see the 'passwd == confirmPasswd' validator
      user.password = params.password.encodeAsPassword()
      user.confirmPassword = params.confirmPassword.encodeAsPassword()
    }
    
    // saving or returning to edition
    if (user.save()) {
      flash.message = 'Profile updated'
      redirect action: 'show'
    } else {
      flash.error = 'Profile could not be saved, please retry'
      redirect action="edit"
    }
  }
}
