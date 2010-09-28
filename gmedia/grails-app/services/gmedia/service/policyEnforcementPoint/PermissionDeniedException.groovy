package gmedia.service.policyEnforcementPoint
/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */

class PermissionDeniedException extends Exception{ 
  def PermissionDeniedException(String msg){ 
    super(msg);
  }
}
