package kata_socialnetwork.parser;

import kata_socialnetwork.command.Command;
import kata_socialnetwork.command.Follow;
import kata_socialnetwork.command.Publish;
import kata_socialnetwork.command.Timeline;
import kata_socialnetwork.command.Wall;
import kata_socialnetwork.domain.UserList;

public class InputParser {
  private final UserList userList;

  public InputParser(UserList userList) {
    this.userList = userList;
  }

  public Command parse(String input) {
    String username;

    if (input.contains(" -> ")) {
      String[] inputSplit = input.split(" -> ");
      username = inputSplit[0].trim();
      String message = inputSplit[1].trim();

      return new Publish(userList.getUser(username), message, System.currentTimeMillis());
    }

    if (input.contains(" follows ")) {
      String[] inputSplit = input.split(" follows ");
      username = inputSplit[0].trim();
      String followed = inputSplit[1].trim();

      return new Follow(userList.getUser(username), userList.getUser(followed));
    }

    if (input.contains(" wall")) {
      username = input.split(" wall")[0].trim();

      return new Wall(userList.getUser(username), System.currentTimeMillis());
    }

    return new Timeline(userList.getUser(input), System.currentTimeMillis());
  }
}
