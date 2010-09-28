package gmedia

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class LoginTagLib {
  def loginControl = {
    if(session.user){
      out << "Hello ${session.user.name}  "
      out << "${link(action:'logout', controller:'user'){'[Logout]'}}"
    } else {
      out << "${link(action:'login',  controller:'user'){'[Login]'}}"
      out << "${link(action:'create', controller:'user'){'[Subscribe]'}}"
   
    }
  }
}
