package controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import models.User;
import models.Movie;

import utils.Serializer;

public class MovieRecommenderAPI implements Recommender{

	public Map<Long, User> userIndex = new HashMap<>();
	public Map<Long, Movie> movieIndex = new HashMap<>();
	
	private Serializer serializer;
	
	public MovieRecommenderAPI(){
		
	}
	
	public MovieRecommenderAPI(Serializer serializer){
		this.serializer = serializer;
	}

	public User addUser(String firstName, String lastName, String gender, int age, String occupation) {
		User user = new User(firstName, lastName, gender, age, occupation);
		userIndex.put(user.id, user);
		return user;
	}

	public void removeUser(long userID) {
		userIndex.clear();
	}
	
	
	public User getUser(Long id){
	    return userIndex.get(id);
	  }
	
	public Collection<User> getUsers(){
		return userIndex.values();
	}

	public Movie addMovie(String title, String year, String url) {
		Movie movie = new Movie(title, year, url);
		movieIndex.put(movie.id, movie);
		return movie;
	}


	public void addRating(long userID, long movieID, double rating) {
		// TODO Auto-generated method stub
		
	}

	
	public double getMovie(long movieID) {
		return movieID;
		// TODO Auto-generated method stub
	}

	
	public double getUserRathing(long userID) {
		// TODO Auto-generated method stub
		return 0;
	}


	public double getUserRecommendations(long userID) {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getTopTenMovie() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		serializer.read();
		userIndex		= (Map<Long, User>)		serializer.pop();
		
	}

	
	public void write() throws Exception {
		serializer.push(userIndex);
		serializer.write();
		
	}
}
