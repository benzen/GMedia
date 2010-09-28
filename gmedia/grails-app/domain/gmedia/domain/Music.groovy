package gmedia.domain

import java.io.File

class Music extends Resource{

  static belongsTo = [author:Person, album:Album]
  String title
  int length=0
  int nbRead=0
  int nbSkip=0
  Person author
  Album album
  String mp3Path
  String oggPath
}
