package gmedia.controllers

import gmedia.domain.Person

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class PersonController {

def beforeInterceptor = [action:this.&auth]

  def auth() {
    if(!session.user) {
      redirect(controller:"user", action:"login")
      return false
    }
  }
    def scaffold = Person
}
