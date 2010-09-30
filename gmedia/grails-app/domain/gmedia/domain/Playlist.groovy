package gmedia.domain

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class Playlist extends Resource{

   static hasMany = [tracks: Music,styles:Style]

   String name
   static constraints = {
		styles(nullable:true)	
	}
}
