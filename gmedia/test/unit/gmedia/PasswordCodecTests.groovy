package gmedia
import gmedia.PasswordCodec
import grails.test.*
import static org.junit.Assert.assertFalse
class PasswordCodecTests extends GroovyTestCase{ 

  static final String PASSWORD = "fakePass"
  static final String ENCODED_PASSWORD = PasswordCodec.encode(PASSWORD)
  protected void setUp() { super.setUp()  }
  
  protected void tearDown() {super.tearDown() }
  
  def testNotIdentity(){ 
    assertFalse PASSWORD.equals(ENCODED_PASSWORD)
  }
  def testNotSubString(){ 
  assertFalse(PASSWORD.contains(ENCODED_PASSWORD))
  assertFalse(ENCODED_PASSWORD.contains(PASSWORD))
  }
  def testStability(){ 
    assertEquals ENCODED_PASSWORD, PasswordCodec.encode(PASSWORD)
  }
  def testNonReversible(){ 
    assertFalse PASSWORD.equals( PasswordCodec.encode(ENCODED_PASSWORD))
  }
}