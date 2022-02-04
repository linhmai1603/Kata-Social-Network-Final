package kata_socialnetwork.command;

import java.util.List;
import kata_socialnetwork.domain.Message;
import kata_socialnetwork.domain.User;

public class Timeline implements Command {
	private final long timestamp;
	private final User user;

	public Timeline(User user, long timestamp) {
		this.user = user;
		this.timestamp = timestamp;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		List<Message> messages = user.getTimeline();

		displayMessages(messages);
	}

	private void displayMessages(List<Message> messages) {
		for (Message message : messages) {
			message.showTimelineOnConsole(timestamp);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Timeline)) {
			return false;
		}

		Timeline that = (Timeline) obj;

		if (!(this.user.equals(that.user))) {
			return false;
		}

		if (!(this.timestamp == that.timestamp)) {
			return false;
		}

		return true;
	}
}
