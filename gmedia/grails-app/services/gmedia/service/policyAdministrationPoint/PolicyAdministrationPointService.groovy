package gmedia.service.policyAdministrationPoint
import gmedia.User
import gmedia.Resource
import gmedia.Policy
class PolicyAdministrationPointService {
  
  static transactional = true
  
  def serviceMethod() {
    
  }
  def createPolicy(Resource res, User user,List policies){
    policies.each{p->
      def policy  = new Policy(resource:res,user:user,right:p)  
      policy.resource.save()
      policy.user.save()
      policy.save(flush:true)
    }
    
  }
  def deletePolicy(Resource res, User user){
    readPolicy(res,user).each{p->p.delete()}
  }
  def updatePolicy(Resource res, User user,List policies){
    deletePolicy(res,user)
    createPolicy(res,user,policies)
    }

  def readPolicy(Resource res, User user){
    Policy.findAllByResourceAndUser(res, user)?:[]
    
  }

  
}
