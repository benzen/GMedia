package gmedia.service.policyEnforcementPoint
import gmedia.domain.User
import gmedia.domain.Resource

class PolicyEnforcementPointService {

  def pap

  static transactional = true
  
  def serviceMethod() {
    
  }
  
  def checkPermission(Resource res, User user, String right) throws PermissionDeniedException{ 
    println user
    println res
    if(pap.readPolicy(res,user).find{p->p.right.equals(right) } == null )
      throw new PermissionDeniedException("User "+user+" can not perform " + right+" action on "+res+" resource")
  }
}
