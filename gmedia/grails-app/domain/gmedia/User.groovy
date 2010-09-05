package gmedia

class User extends Resource{

    String name
    String password
    String email
    Date creationDate
    Date lastModificationDate

    def static constraints = {
    	email(email:true)
	password(blank:false, password:true)
    }
    def toString{
    "User("+name","+email")"
    }

}
