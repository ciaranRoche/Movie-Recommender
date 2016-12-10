package controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import models.Movie;
import models.User;
import models.Rating;

import static models.Fixtures.users;
import static models.Fixtures.movies;
import static models.Fixtures.ratings;

public class MovieRecommenderAPITest {

	MovieRecommenderAPI moviAPI;
	
	@Before
	public void setup(){
		moviAPI = new MovieRecommenderAPI();
		
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
	
	@After
	public void tearDown(){
		moviAPI = null;
	}
	
	@Test
	public void testUser(){
		assertEquals(users.length, moviAPI.getUsers().size());
		moviAPI.addUser("Mr", "Robot", "M", "42", "Coder");
		assertEquals (users.length+1, moviAPI.getUsers().size());	
	}
	
	@Test
	public void testMovie(){
		assertEquals(movies.length, moviAPI.getMovies().size());
		moviAPI.addMovie("Mr Robot", "2015", "www.mrrobot.com");
		assertEquals(movies.length+1, moviAPI.getMovies().size());
	}
	
	@Test
	public void testRating(){
//		assertEquals(ratings.length, moviAPI.getRatings().size());
//		moviAPI.addRating(0, 0, 0.0);
//		assertEquals(ratings.length+1, moviAPI.getRatings().size());
	}
	
	@Test
	public void testRemoveUser() throws Exception{
		assertEquals(users.length, moviAPI.getUsers().size());
		User test = moviAPI.addUser("TEST", "TEST", "TEST", "TEST", "TEST");
		assertEquals(users.length+1, moviAPI.getUsers().size());
		moviAPI.removeUser(test);
		assertEquals(users.length, moviAPI.getUsers().size());
	}
	
	@Test
	public void testAddUser(){
		assertEquals(users.length, moviAPI.getUsers().size());
		moviAPI.addUser("bob", "bob", "m", "22", "job");
		assertEquals(users.length+1, moviAPI.getUsers().size());
	}
	
	@Test
	public void testAddMovie(){
		assertEquals(movies.length, moviAPI.getMovies().size());
		moviAPI.addMovie("title", "year", "url");
		assertEquals(movies.length+1, moviAPI.getMovies().size());
	}
	
	@Test
	public void testRemoveMovie() throws Exception{
		assertEquals(movies.length, moviAPI.getMovies().size());
		Movie test = moviAPI.addMovie("title", "year", "url");
		assertEquals(movies.length+1, moviAPI.getMovies().size());
		moviAPI.removeMovie(test);
		assertEquals(movies.length, moviAPI.getMovies().size());	
	}
	
}
