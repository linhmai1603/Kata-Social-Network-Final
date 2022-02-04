package kata_socialnetwork.domain;

import java.util.HashMap;
import java.util.Map;

public class UserListImpl implements UserList {
  Map<String, User> repository = new HashMap<String, User>();

  public User getUser(String username) {
    User user = findUserFromRepository(username);

    if (user == null) {
      user = new UserImpl(username);
      repository.put(username, user);
    }

    return user;
  }

  public User findUserFromRepository(String username) {
    return repository.get(username);
  }
}
