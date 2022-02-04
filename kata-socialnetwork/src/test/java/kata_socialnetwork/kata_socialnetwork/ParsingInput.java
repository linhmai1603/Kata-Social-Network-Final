package kata_socialnetwork.kata_socialnetwork;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kata_socialnetwork.command.Command;
import kata_socialnetwork.command.Follow;
import kata_socialnetwork.command.Publish;
import kata_socialnetwork.command.Timeline;
import kata_socialnetwork.command.Wall;
import kata_socialnetwork.domain.UserImpl;
import kata_socialnetwork.domain.UserListImpl;
import kata_socialnetwork.parser.InputParser;

public class ParsingInput {
	Command command;
	InputParser parser;
	String input;

	@Before
	public void init() {
		parser = new InputParser(new UserListImpl());
	}

	@Test
	public void TestPublishParsing() {
		input = "Test -> testing 123456";
		command = new Publish(new UserImpl("Test"), "testing 123456", System.currentTimeMillis());
		assertEquals(command, parser.parse(input));
	}

	@Test
	public void TestTimelineParsing() {
		input = "Test";
		command = new Timeline(new UserImpl("Test"), System.currentTimeMillis());

		assertEquals(command, parser.parse(input));
	}

	@Test
	public void TestFollowParsing() {
		input = "Test follows Test2";
		command = new Follow(new UserImpl("Test"), new UserImpl("Test2"));

		assertEquals(command, parser.parse(input));
	}

	@Test
	public void TestWallParsing() {
		input = "Test wall ";
		command = new Wall(new UserImpl("Test"), System.currentTimeMillis());

		assertEquals(command, parser.parse(input));
	}

}
