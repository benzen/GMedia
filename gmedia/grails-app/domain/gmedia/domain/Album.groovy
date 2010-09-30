package gmedia.domain

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class Album {

	static belongsTo = [author: Author]
	static hasMany = [tracks: Music,styles:Style]

	String name
	String logoPath
	Date dateCreated
	Date lastUpdated

	static constraints = {
		logoPath(nullable:true)	
	}
}
