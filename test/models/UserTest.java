package models;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static models.Fixtures.users;

public class UserTest {

	User Joe = new User("Joe", "Bloggs", "Male", "21", "Programmer");
	User Jane = new User("Jane", "Bloggs", "Female", "22", "Hacker");
	
	@Test
	public void testCreate(){
		assertEquals("Joe", Joe.firstName);
		assertEquals("Bloggs", Joe.lastName);
		assertEquals("Male", Joe.gender);
		assertEquals(21, Joe.age);
		assertEquals("Programmer", Joe.occupation);
	}
	
	@Test
	public void testIds(){
		Set<Long> ids = new HashSet<>();
		for(User user: users){
			ids.add(user.id);
		}
		assertEquals(users.length, ids.size());
	}
	
	@Test
	public void testToString(){
		assertEquals("User{" + Joe.id + ", Joe, Bloggs, Male, 21, Programmer}", Joe.toString());
	}
	
	@Test
	public void testEquals(){
		User Joei = new User("Joe", "Bloggs", "Male", "21", "Programmer");
		
		assertEquals(Joe, Joe);
		assertEquals(Joe, Joei);
		assertNotEquals(Joe, Jane);
	}

}
