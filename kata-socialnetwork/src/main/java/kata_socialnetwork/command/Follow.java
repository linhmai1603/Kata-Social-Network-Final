package kata_socialnetwork.command;

import kata_socialnetwork.domain.User;

public class Follow implements Command {
  private final User follower;
  private final User followed;

  public Follow(User follower, User followed) {
    this.follower = follower;
    this.followed = followed;
  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    follower.follow(followed);
  }
  
  @Override
  public boolean equals(Object obj) {

      Follow that = (Follow) obj;

      if(!(this.follower.equals(that.follower))) {
          return false;
      }

      if(!(this.followed.equals(that.followed))) {
          return false;
      }

      return true;
  }
}
