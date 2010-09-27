package gmedia.service.membership
import gmedia.domain.User

class MembershipService {

    static transactional = true

    def createUser(String name,String password, String email){
      def user = new User(name:name,password:password,confirmPassword:password,email:email)
      user.save(flush:true)
    }
    def listUser(){
     User.list()
    }

    def deleteUser(User user){
    user.delete()
    }
  def getUser(long id){ 
    User.get(id)
  }
}
