package gmedia.model

class Album {

	static belongsTo = [band: Band]
	static hasMany = [tracks: Music,styles:Style]

	String name
	String logoPath
	Date dateCreated
	Date lastUpdated

	static constraints = {
		name(nullable:false)	
	}
}
