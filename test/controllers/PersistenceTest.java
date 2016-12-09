package controllers;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import models.Movie;
import models.User;
import utils.Serializer;
import utils.XMLSerializer;
import models.Rating;

import static models.Fixtures.users;
import static models.Fixtures.movies;
import static models.Fixtures.ratings;

public class PersistenceTest {

	MovieRecommenderAPI moviAPI;
	
	void populate(MovieRecommenderAPI moviAPI){
		for(User user : users){
			moviAPI.addUser(user.firstName, user.lastName, user.gender, user.age, user.occupation);
		}
		for(Movie movie : movies){
			moviAPI.addMovie(movie.title, movie.year, movie.url);
		}
//		for(Rating rating : ratings){
//			moviAPI.addRating(rating.userId, rating.movieId, rating.rating);
//		}
	}
	
	@Test
	public void testEmpty(){
		moviAPI = new MovieRecommenderAPI(null);
		assertEquals(0, moviAPI.movieIndex.size());
		assertEquals(0, moviAPI.ratingIndex.size());
		assertEquals(0, moviAPI.userIndex.size());
		populate(moviAPI);
	}
	
	@Test
	public void testPopulate(){
		moviAPI = new MovieRecommenderAPI(null);
		assertEquals(0, moviAPI.movieIndex.size());
		assertEquals(0, moviAPI.ratingIndex.size());
		assertEquals(0, moviAPI.userIndex.size());
		populate(moviAPI);
		
		assertEquals(4, moviAPI.getUsers().size());
		assertEquals(5, moviAPI.getMovies().size());
		//assertEquals(5, moviAPI.getRatings().size());
	}
	
	@Test
	public void testXMLSerializer() throws Exception{
		String dataStoreFile = "testDataStore.xml";
		
		Serializer serializer = new XMLSerializer(new File (dataStoreFile));
		
		moviAPI = new MovieRecommenderAPI(serializer);
		assertEquals(0, moviAPI.getUsers().size());
		assertEquals(0, moviAPI.getMovies().size());
		assertEquals(0, moviAPI.getRatings().size());
		
		populate(moviAPI);
		moviAPI.write();
		
		MovieRecommenderAPI moviAPI2 = new MovieRecommenderAPI(serializer);
		
		moviAPI2.load();
		
		assertEquals(moviAPI.getUsers().size(), moviAPI2.getUsers().size());
		for(User user : moviAPI.getUsers()){
			assertTrue(moviAPI2.getUsers().contains(user));
		}
	}

}
