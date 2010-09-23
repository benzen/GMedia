package gmedia.model
import gmedia.model.Person
import java.io.File

class Music extends Resource{

  static belongsTo = [author:Person]
  String title
  int length=0
  int nbRead=0
  int nbSkip=0
  Person author
  String mp3Path
  String oggPath
}
