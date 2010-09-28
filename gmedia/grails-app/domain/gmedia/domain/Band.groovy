package gmedia.domain

/**
 * Classe de domaine représentant un groupe de musique.
 * 
 * @author Benjamin Dreux(benjiiiiii@gmail.com)
 *
 */
class Band extends Author{

  static hasMany = [members:Person]
  
  String logoPath
  String webSite
  
  Date dateCreated
  Date lastUpdated
  
  static constraints = {
    webSite(url:true, nullable:true)
    logopath(nullable:true)
  }
}
