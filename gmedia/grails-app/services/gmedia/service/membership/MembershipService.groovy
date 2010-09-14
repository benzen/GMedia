package gmedia.service.membership
import gmedia.model.User

class MembershipService {

    static transactional = true

    def createUser(String name,String password, String email){
      def user = new User(name:name,password:password,email:email)
      user.save()
    }
    def listUser(){
     User.list()
    }

    def deleteUser(User user){
    user.delete()
    }
}
