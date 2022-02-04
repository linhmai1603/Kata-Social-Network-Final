package kata_socialnetwork.command;

import java.util.List;
import kata_socialnetwork.domain.Message;
import kata_socialnetwork.domain.User;

public class Wall implements Command {
	private final User user;
	private final long timestamp;

	public Wall(User user, long timestamp) {
		this.user = user;
		this.timestamp = timestamp;
	}

	@Override
	public void execute() {
		List<Message> messages = user.wall();

		showMessages(messages);
	}

	private void showMessages(List<Message> messages) {
		for (Message message : messages) {
			message.showWallOnConsole(timestamp);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Wall)) {
			return false;
		}

		Wall that = (Wall) obj;

		if (!(this.user.equals(that.user))) {
			return false;
		}

		if (!(this.timestamp == timestamp)) {
			return false;
		}

		return true;
	}
}
