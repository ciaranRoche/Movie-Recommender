package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class RatingTest {

		Rating rat0 = new Rating(0, 0, 0);
		Rating rat1 = new Rating(1, 1, 1);
		Rating rat2 = new Rating(2, 2, 2);
		
		@Test
		public void testCreate(){
			assertEquals(0, rat0.userId);
			assertNotEquals(1, rat0.userId);
			assertEquals(0, rat0.movieId);
			assertNotEquals(1, rat0.movieId);
			assertNotEquals(1, rat0.rating);				
		}
		
		@Test
		public void testToString(){
			assertEquals("Rating{0, 0, 0, 0.0}", rat0.toString());
		}
		
		@Test
		public void testEquals(){
			assertEquals(rat0, rat0);
			assertEquals(rat1, rat1);
			assertNotEquals(rat0, rat1);
		}
		
}


