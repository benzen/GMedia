package gmedia.domain

/**
 * Classe de domaine représentant un groupe de musique.
 * 
 * @author Benjamin Dreux(benjiiiiii@gmail.com)
 *
 */
class Band extends Person{

  static hasMany = [albums: Album, styles:Style, members:Person]
  
  String name
  String logoPath
  String webSite
  
  Date dateCreated
  Date lastUpdated
  
  static constraints = {
    name(nullable:false, emtpy:false, validator:{val,obj->
        val.equals(obj.firstName+" "+obj.lastName)
        })
    description(nullable:false)
    webSite(url:true, nullable:true)
    logopath(nullable:true)
    
  }
}
