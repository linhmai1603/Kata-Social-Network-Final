package kata_socialnetwork.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserImpl implements User {
	private final String username;
	private LinkedList<Message> messages = new LinkedList<Message>();
	private LinkedList<User> followedUsers = new LinkedList<User>();

	public UserImpl(String username) {
		this.username = username;
	}

	public void publish(String message, long timeOfPublishing) {
		messages.push(new Message(message, timeOfPublishing, username));
	}

	@Override
	public List<Message> getTimeline() {
		// TODO Auto-generated method stub
		return messages;
	}

	@Override
	public void follow(User user) {
		// TODO Auto-generated method stub
		followedUsers.push(user);
	}

	@Override
	public List<User> getFollowedUsers() {
		// TODO Auto-generated method stub
		return followedUsers;
	}

	@Override
	public List<Message> wall() {
		// TODO Auto-generated method stub
		List<Message> messagesOnWall = new ArrayList<Message>();

		messagesOnWall.addAll(messages);
		addFollowedMessages(followedUsers, messagesOnWall);

		return messagesOnWall;
	}

	private void addFollowedMessages(LinkedList<User> followedUsers, List<Message> messageOnWall) {
		// TODO Auto-generated method stub
		for (User user : followedUsers) {
			messageOnWall.addAll(user.getTimeline());
		}
	}

	@Override
	public boolean equals(Object obj) {
		UserImpl that = (UserImpl) obj;

		return this.username.equals(that.username);
	}
}
