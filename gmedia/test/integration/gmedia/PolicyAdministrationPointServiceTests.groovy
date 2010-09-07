package gmedia

import grails.test.*
import gmedia.service.policyAdministrationPoint.PolicyAdministrationPointService
import gmedia.User
import gmedia.Resource
class PolicyAdministrationPointServiceTests extends GrailsUnitTestCase {
  
  def pap
  def resource
  def user
  def res
  
  protected void setUp() {
    super.setUp()
    pap = new PolicyAdministrationPointService()
    res = new Resource()
    user = new User()
    res.save()
    user.save()
  }
  
  protected void tearDown() {
    super.tearDown()
    Policy.findAll().each{p->p.delete() }
    res.delete()
    user.delete()
  }
  
  void testCreatePolicy() {
    pap.createPolicy(res,user,["read"])
    def actualRights = pap.readPolicy(res,user).collect{policy->policy.right}
    assertEquals(["read"], actualRights)
  }

  void testDeletePolicy(){ 
    pap.createPolicy(res,user,["read"])
    pap.deletePolicy(res,user)
    assertEquals([], pap.readPolicy(res, user))
  } 
  void testUpdatePolicy(){ 
    pap.createPolicy(res,user,["read"])
    pap.updatePolicy(res,user,["read","write"])
    def actualRights = pap.readPolicy(res,user).collect{policy->policy.right}
    assertEquals(["read","write"], actualRights)
  }
  
  void testDeleteUpdatePolicyWhenNoPolicyExist(){ 
    pap.deletePolicy(res,user)
    assertEquals([],pap.readPolicy(res,user))
  }
}
