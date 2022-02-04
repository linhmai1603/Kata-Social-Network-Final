package kata_socialnetwork.domain;


public interface UserList {
    User getUser(String userName);

  User findUserFromRepository(String username);
}
