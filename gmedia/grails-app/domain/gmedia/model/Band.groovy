package gmedia.model

import gmedia.model.User

/**
 * Classe de domaine représentant un groupe de musique.
 * 
 * @author Benjamin Dreux(benjiiiiii@gmail.com)
 *
 */
class Band {

  static hasMany = [albums: Album, styles:Style]
  
  String name
  String logoPath
  String webSite
  
  Date dateCreated
  Date lastUpdated
  
  static constraints = {
    name(nullable:false, emtpy:false)
    description(nullable:false)
    webSite(url:true)
  }
}
