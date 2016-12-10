package models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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
		logan.ratingList.add(new Rating(0, 1, 5));
		star.ratingList.add(new Rating(0, 2, 4));
		
		logan.compareTo(star);
		
		assertEquals(1, logan.compareTo(star));
	}
	
	@Test
	public void testCompareToSame(){
		logan.ratingList.add(new Rating(0, 1, 5));
		star.ratingList.add(new Rating(0, 2, 5));
		
		logan.compareTo(star);
		
		assertEquals(0, logan.compareTo(star));
	}
	
	@Test
	public void testCompareToGreater(){
		logan.ratingList.add(new Rating(0, 1, 4));
		star.ratingList.add(new Rating(0, 2, 5));
		
		logan.compareTo(star);
		
		assertEquals(-1, logan.compareTo(star));
	}

}
