package gmedia.domain


/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class Policy extends Resource{

  Resource resource
  User user
  String right

  static mapping = {
    user cascade:'all-delete-orphan'
    resource cascade:'all-delete-orphan'
  }
}
