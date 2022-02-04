package kata_socialnetwork.kata_socialnetwork;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import kata_socialnetwork.domain.User;
import kata_socialnetwork.domain.UserImpl;
import kata_socialnetwork.domain.UserList;
import kata_socialnetwork.domain.UserListImpl;

public class GettingUser {
	@Test
	public void returnNewUserIfNotExist() {
		User userTest = new UserImpl("Test");
		UserList repository = new UserListImpl();
		assertEquals(null, repository.findUserFromRepository("Test"));
		assertEquals(userTest , repository.getUser("Test"));
		
	}

	@Test
	public void returnExsitingUser() {
		UserList userList = new UserListImpl();
		User userTest = userList.getUser("Test");
		User userTest2 = userList.getUser("Test2");
		assertEquals(userTest, userList.findUserFromRepository("Test"));
		assertEquals(userTest2, userList.findUserFromRepository("Test2"));
	}
}
