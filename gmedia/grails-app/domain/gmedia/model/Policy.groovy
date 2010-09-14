package gmedia.model
import gmedia.model.Resource

class Policy extends Resource{

  Resource resource
  User user
  String right

  static mapping = {
    user cascade:'all-delete-orphan'
    resource cascade:'all-delete-orphan'
  }
}
