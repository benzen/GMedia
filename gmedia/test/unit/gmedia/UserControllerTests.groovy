package gmedia

import grails.test.*
import gmedia.model.User
class UserControllerTests extends ControllerUnitTestCase {
  

    protected void setUp() {
        super.setUp()
	String.metaClass.encodeAsPassword={ id->id}
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSave() {
      mockParams["name"]="fakeUser"
      mockParams["email"]="fake@mail.fr"
      mockParams["password"]="fakePass"
      mockParams["confirmPassword"]="fakePass"
      mockDomain(User,[])
      controller.save(mockParams)
    }
}
