package kata_socialnetwork.kata_socialnetwork;

import org.junit.Rule;
import org.junit.Test;

import kata_socialnetwork.command.Command;
import kata_socialnetwork.command.Follow;
import kata_socialnetwork.command.Publish;
import kata_socialnetwork.command.Timeline;
import kata_socialnetwork.command.Wall;
import kata_socialnetwork.domain.User;
import kata_socialnetwork.domain.UserImpl;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;

public class TestCommand {
	@Rule
	public final JUnitRuleMockery userMock = new JUnitRuleMockery();
	final long time = System.currentTimeMillis();
	final User user = userMock.mock(User.class);

	@Test
	public void publishCommand() {
		final String message = "Testing publish";
		Command publish = new Publish(user, message, time);
		userMock.checking(new Expectations() {
			{
				oneOf(user).publish(message, time);
			}
		});
		publish.execute();
	}

	@Test
	public void timelineCommand() {
		Command timeline = new Timeline(user, time);
		userMock.checking(new Expectations() {
			{
				oneOf(user).getTimeline();
			}
		});
		timeline.execute();
	}

	@Test
	public void followCommand() {
		final User followed = new UserImpl("Test2");
		Command follow = new Follow(user, followed);

		userMock.checking(new Expectations() {
			{
				oneOf(user).follow(followed);
			}
		});
		follow.execute();
	}

	@Test
	public void wallCommand() {
		Command wall = new Wall(user, time);
		userMock.checking(new Expectations() {
			{
				oneOf(user).wall();
			}
		});
		wall.execute();
	}
}
