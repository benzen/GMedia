package gmedia.controllers

import gmedia.domain.Style
/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class StyleController {

  def scaffold = Style
  def beforeInterceptor = [action:this.&auth]
  
  def auth() {
    if(!session.user) {
      redirect(controller:"user", action:"login")
      return false
    }
  }
  
}
