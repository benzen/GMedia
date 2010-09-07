package gmedia

class User extends Resource{

    String name
    String password
    String email

    def static constraints = {
    	email(email:true)
	password(blank:false, password:true)
    }
    def String toString(){
    "User("+name+","+email+")"
    }

}
