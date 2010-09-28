package gmedia.domain

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


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
    confirmPassword(blank:false, password:true,validator :{val, obj ->
      if (obj.password != val) {
	return 'default.invalid.confirmPasswd.message'
      }})}

  def String toString(){
    "User("+name+","+email+")"
  }

  public boolean equals(Object u){ 
   return this.name.equals(u.name)&&
   this.password.equals(u.password)&& 
   this.email.equals(u.email)
    
  }

}
