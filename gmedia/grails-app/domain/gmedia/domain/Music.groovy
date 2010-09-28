package gmedia.domain

import java.io.File

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class Music{

  static belongsTo = [author:Author, album:Album]
  String title
  int length=0
  int nbRead=0
  int nbSkip=0
  String mp3Path
  String oggPath
}
