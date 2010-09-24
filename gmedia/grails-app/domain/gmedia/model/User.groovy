package gmedia.model

class User extends Resource{
  String name
  String password
  String email
  String confirmPassword
  
  static transients={'confirmPassword' }
  
  def static constraints = {
    name(blank:false)
    email(email:true)
    password(blank:false, password:true)
    confirmPassword(validator :
     {val, obj ->
       if (obj.properties['passwd'] != val) {
	 return 'default.invalid.confirmPasswd.message'
       }
     }
    )
  }

  def String toString(){
    "User("+name+","+email+")"
  }

  def equals(User u){ 
    name.equals(u.name)&&
    password.equals(u.password)&&
    email.equals(u.email)
  }

}
