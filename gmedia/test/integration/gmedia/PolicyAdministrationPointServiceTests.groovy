package gmedia

import grails.test.*
import gmedia.service.policyAdministrationPoint.PolicyAdministrationPointService
import gmedia.domain.User
import gmedia.domain.Resource
import gmedia.domain.Policy
import org.junit.Test
import org.junit.After
import org.junit.Before

class PolicyAdministrationPointServiceTests extends GrailsUnitTestCase {
  
  def pap
  def resource
  def user
  def res
  
  @Before
  public void setUp() {
    pap = new PolicyAdministrationPointService()
    res = new Resource()
    user = new User(name:"fakeUser",
		    password:"fakePassword",
		    confirmPassword:"fakePassword",
		    email:"fakeUser@fakeHost.fr")
    res.save()
    user.save(flush:true)
  }

  @After
  public void tearDown() {
    Policy.findAll().each{p->p.delete() }
    res.delete()
    user.delete()
  }
  
  @Test
  void createPolicy() {
    pap.createPolicy(res,user,["read"])
    def actualRights = pap.readPolicy(res,user).collect{policy->policy.right}
    assertEquals(["read"], actualRights)
  }
  
  @Test
  void deletePolicy(){ 
    pap.createPolicy(res,user,["read"])
    pap.deletePolicy(res,user)
    assertEquals([], pap.readPolicy(res, user))
  } 

  @Test
  void updatePolicy(){ 
    pap.createPolicy(res,user,["read"])
    pap.updatePolicy(res,user,["read","write"])
    def actualRights = pap.readPolicy(res,user).collect{policy->policy.right}
    assertEquals(["read","write"], actualRights)
  }

  @Test
  void deletePolicyWhenNoPolicyExist(){ 
    pap.deletePolicy(res,user)
    assertEquals([],pap.readPolicy(res,user))
  }
  
  @Test
  void createExistingPolicy(){ 
    pap.createPolicy(res,user,["read"])
    pap.createPolicy(res,user,["read"])
  }
}
