package kata_socialnetwork.command;

import kata_socialnetwork.domain.User;

public class Publish implements Command {
	private final long timestamp;
	private final User user;
	private String message;

	public Publish(User user, String message, long timestamp) {
		this.user = user;
		this.message = message;
		this.timestamp = timestamp;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		user.publish(message, timestamp);
	}

	@Override
	public boolean equals(Object obj) {

		Publish that = (Publish) obj;

		if (!(this.user.equals(that.user))) {
			return false;
		}

		if (!(this.message.equals(that.message))) {
			return false;
		}

		if (!(this.timestamp == that.timestamp)) {
			return false;
		}

		return true;
	}
}
