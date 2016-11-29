package controllers;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.xml.internal.security.encryption.Serializer;

import models.User;
import models.Movie;

public class MovieRecommenderAPI implements Recommender{

	public Map<Long, User> userIndex = new HashMap<>();
	public Map<Long, Movie> movieIndex = new HashMap<>();
	
	private Serializer serializer;
	
	public MovieRecommenderAPI(){
		
	}

	@Override
	public User addUser(String firstName, String lastName, String gender, int age, String occupation) {
		User user = new User(firstName, lastName, gender, age, occupation);
		userIndex.put(user.id, user);
		return user;
	}

	@Override
	public void removeUser(long userID) {
		userIndex.clear();
	}

	@Override
	public Movie addMovie(String title, int year, String url) {
		Movie movie = new Movie(title, year, url);
		movieIndex.put(movie.id, movie);
		return movie;
	}

	@Override
	public void addRating(long userID, long movieID, double rating) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getMovie(long movieID) {
		return movieID;
		// TODO Auto-generated method stub
	}

	@Override
	public double getUserRathing(long userID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getUserRecommendations(long userID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTopTenMovie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}
}
