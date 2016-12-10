package controllers;

import java.util.List;

import models.Movie;
import models.Rating;
import models.User;

public interface Recommender {

	public User addUser(String firstName,String lastName,String gender,int age,String occupation);
	
	public void removeUser(User user) throws Exception;
	
	public Movie addMovie(String title, String year, String url);
	
	public Rating addRating(long userID,long movieID,double rating);
	
	public Movie getMovie(long movieID);
	
	public double getUserRating(long userID);
	
	public double getUserRecommendations(long userID);
	
	public List<Movie> getTopTenMovie();
	
	public void load() throws Exception;
	
	public void write() throws Exception;
	
	public void prime() throws Exception;
}
