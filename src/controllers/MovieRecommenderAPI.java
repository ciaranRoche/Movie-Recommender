package controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.User;
import models.Movie;
import utils.DataInput;
import utils.Serializer;

import models.Rating;
import models.User;

public class MovieRecommenderAPI implements Recommender{

	public Map<Long, User> userIndex = new HashMap<>();
	public Map<Long, Movie> movieIndex = new HashMap<>();
	public Map<Long, Rating> ratingIndex = new HashMap<>();
	
	private Serializer serializer;
	
	public MovieRecommenderAPI(){
		
	}
	
	public MovieRecommenderAPI(Serializer serializer){
		this.serializer = serializer;
	}

	public User addUser(String firstName, String lastName, String gender, String age, String occupation) {
		User user = new User(firstName, lastName, gender, age, occupation);
		userIndex.put(user.id, user);
		return user;
	}

	public User removeUser(long userID) throws Exception {
		User user = getUser(userID);
		
		userIndex.remove(user);

		return user;
	}
	
	
	public User getUser(Long id){
		for(User user : userIndex.values())
			if(user.id == id)
				return user;
	    return null;
	  }
	
	public Collection<User> getUsers(){
		return userIndex.values();
	}

	public Movie addMovie(String title, String year, String url, int rating) {
		Movie movie = new Movie(title, year, url, rating);
		movieIndex.put(movie.id, movie);
		return movie;
	}
	
	public Movie removeMovie(Long movieID) throws Exception{
		Movie movie = getMovie(movieID);
		
		movieIndex.remove(movie);
		
		return movie;
		
	}
	
	public Collection<Movie> getMovies(){
		return movieIndex.values();
	}


	public Rating addRating(long userID, long movieID, int rating) {
		Rating r = new Rating(userID, movieID, rating);
		Movie movie = getMovie(movieID);
		movie.rating += rating;
		
		ratingIndex.put(movieID, r);
		return r;
		
	}

	
	public Movie getMovie(long movieID) {	
		for(Movie movie : movieIndex.values())
			if(movie.id == movieID)
				return movie;
			
		return null;	
	}

	
	public double getUserRating(long userID) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Rating getRating(long movieID){
		return ratingIndex.get(movieID);
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
		ratingIndex		= (Map<Long, Rating>)	serializer.pop();
		movieIndex		= (Map<Long, Movie>)	serializer.pop();
		userIndex		= (Map<Long, User>)		serializer.pop();	
	}

	
	public void write() throws Exception {
		serializer.push(userIndex);
		serializer.push(movieIndex);
		serializer.push(ratingIndex);
		serializer.write();	
	}

	@Override
	public void prime() throws Exception {
		DataInput loader = new DataInput();
		List<User> users = loader.loadUsers("././data/users5.dat");
		for (User user : users){
			userIndex.put(user.id, user);
		}
		List<Movie> movies = loader.loadMovies("././data/items5.dat");
		for (Movie movie : movies){
			movieIndex.put(movie.id, movie);
		}
		List<Rating> ratings = loader.loadRatings("././data/ratings5.dat");
		for (Rating rating : ratings){
			ratingIndex.put(rating.id, rating);
		}
	}
}
