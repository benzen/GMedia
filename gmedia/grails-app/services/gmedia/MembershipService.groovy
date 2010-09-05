package gmedia

class MembershipService {

    static transactional = true

    def createUser(User user){
     user.save()
    }
    def listUser(){
     User.list()
    }
    def readUser(int userId){
    	User.get(userId)
    }
    def deleteUser(User user){
    user.delete
    }
}
