package controllers;

import java.util.Collection;
import java.util.List;

import models.Movie;
import models.Rating;
import models.User;

public interface Recommender {

	public User addUser(String firstName,String lastName,String gender,String age,String occupation);
	
	public void removeUser(Long id) throws Exception;
	
	public Movie addMovie(String title, String year, String url);
	
	public Rating addRating(long userID,long movieID,double rating);
	
	public Movie getMovie(long movieID);
	
	public double getUserRating(long userID);
	
	public double getUserRecommendations(long userID);
	
	public List<Movie> getTopTenMovie();
	
	public void load() throws Exception;
	
	public void write() throws Exception;
	
	public void prime() throws Exception;

	User getUserById(long userId);

	User getUser(Long id);

	Collection<User> getUsers();

	void removeMovie(Movie movie) throws Exception;

	Collection<Rating> getRatings();

	Collection<Movie> getMovies();

	Rating getRating(long movieId);
}
