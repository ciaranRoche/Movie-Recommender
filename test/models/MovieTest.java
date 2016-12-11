package models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * This is a Junit test class which tests the movie class
 * @author ciaran
 * @version asparagus
 * @date 11/12/2016
 *
 */
public class MovieTest {

	public List<Rating> ratings = new ArrayList<Rating>();
	
	Movie logan = new Movie("Logan", "42-Jan-4242", "www.logan.com");
	Movie star = new Movie("Star Wars", "42-Jan-4242", "www.starwars.com");
	
	@Test
	public void testCreate(){
		assertEquals("Logan", logan.title);
		assertEquals("42-Jan-4242", logan.year);
		assertEquals("www.logan.com", logan.url);
		assertEquals("Star Wars", star.title);
		assertEquals("42-Jan-4242", star.year);
		assertEquals("www.starwars.com", star.url);
		assertNotSame("Star Wars", logan.title);
	}
	
	@Test
	public void testToString(){
		assertEquals("Movie{" + logan.id + ", Logan, 42-Jan-4242, www.logan.com}", logan.toString());
	}
	
	@Test
	public void testEquals(){
		assertEquals(logan, logan);
		assertFalse(logan.equals(star));
		assertNotEquals(logan, star);
		assertEquals(star, star);
	}
	
	@Test
	public void testCompareToLessThan(){
		logan.ratings.add(new Rating(0, 1, 5));
		star.ratings.add(new Rating(0, 2, 4));
		
		logan.compareTo(star);
		
		assertEquals(1, logan.compareTo(star));
	}
	
	@Test
	public void testCompareToSame(){
		logan.ratings.add(new Rating(0, 1, 5));
		star.ratings.add(new Rating(0, 2, 5));
		
		logan.compareTo(star);
		
		assertEquals(0, logan.compareTo(star));
	}
	
	@Test
	public void testCompareToGreater(){
		logan.ratings.add(new Rating(0, 1, 4));
		star.ratings.add(new Rating(0, 2, 5));
		
		logan.compareTo(star);
		
		assertEquals(-1, logan.compareTo(star));
	}

}
