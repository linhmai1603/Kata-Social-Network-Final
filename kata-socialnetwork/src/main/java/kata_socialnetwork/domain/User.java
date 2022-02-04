package kata_socialnetwork.domain;

import java.util.List;

public interface User {
  public void publish(String message, long timeOfPublishing);

  public List<Message> getTimeline();

  public void follow(User user);

  public List<User> getFollowedUsers();

  public List<Message> wall();
}
