package gmedia.model
import gmedia.model.Person

class Music extends Resource{

  static belongsTo = [author:Person]
  String title
  int length
  int nbRead
  int nbSkip
  Person author
}
