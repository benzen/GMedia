package gmedia.domain

/**
  * Authors can be responsible for creation of multiple albums
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */

class Author{
  static hasMany = [albums: Album, styles:Style]
  String name
  
  static constraints = {
      name(nullable:false, emtpy:false)}
}
