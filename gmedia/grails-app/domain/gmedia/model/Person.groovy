package gmedia.model

class Person extends Resource{

  static hasMany=[music:Music]
  String firstName
  String lastName
  
}
