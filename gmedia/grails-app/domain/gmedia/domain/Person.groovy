package gmedia.domain

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class Person extends Resource{

  static hasMany=[music:Music]
  String firstName
  String lastName       
  
}
