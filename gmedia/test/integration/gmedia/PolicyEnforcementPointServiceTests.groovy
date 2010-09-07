package gmedia

import grails.test.*
import org.junit.Test
import org.junit.Before
import org.junit.After
import gmedia.service.policyAdministrationPoint.PolicyAdministrationPointService
import gmedia.service.policyEnforcementPoint.PermissionDeniedException
import gmedia.service.policyEnforcementPoint.PolicyEnforcementPointService

class PolicyEnforcementPointServiceTests extends GrailsUnitTestCase {
  def pap
  def pep
  def user
  def res

  
  @Before
  public void setUp() {
    super.setUp()
    pap = new PolicyAdministrationPointService()
    pep = new PolicyEnforcementPointService()
    pep.pap = pap

    user = new User(name:"fakeUser",password:"fakePass",email:"fakeUser@fakeMail.com")
    res =  new Resource()
        
    res.save()
    user.save(flush:true)
  }

  @After
  public void tearDown() {
    super.tearDown()
    Policy.findAll().each{p->p.delete() }
    res.delete()  
    user.delete() 
 }
  
  @Test(expected=PermissionDeniedException.class)
  void impossiblePermission(){ 
    pep.checkPermission(res,user,"write")
  }
  
  @Test
  void possiblePermition() {
    pap.createPolicy(res,user,["read"])
    pep.checkPermission(res,user,"read")
  }
  
  
}
