package controllers;

import models.Movie;
import models.User;

public interface Recommender {

	public User addUser(String firstName,String lastName,String gender,String age,String occupation);
	
	public User removeUser(long userID) throws Exception;
	
	public Movie addMovie(String title, String year, String url);
	
	public void addRating(long userID,long movieID,double rating);
	
	public double getMovie(long movieID);
	
	public double getUserRathing(long userID);
	
	public double getUserRecommendations(long userID);
	
	public String getTopTenMovie();
	
	public void load() throws Exception;
	
	public void write() throws Exception;
	
	public void prime() throws Exception;
}
