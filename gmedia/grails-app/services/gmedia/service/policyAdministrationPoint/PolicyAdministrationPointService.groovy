package gmedia.service.policyAdministrationPoint
import gmedia.domain.User
import gmedia.domain.Resource
import gmedia.domain.Policy

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


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
    readPolicy(res,user).each{p->p.lock();p.delete()}
  }
  def updatePolicy(Resource res, User user,List policies){
    def currentPolicy = readPolicy(res,user)
    policies.each{ p->
      if(!currentPolicy.find{cp->cp.right.equals(p)})
	createPolicy(res,user,[p])
    }
  }

  def readPolicy(Resource res, User user){
    Policy.findAllByResourceAndUser(res, user)
  }

  
}
