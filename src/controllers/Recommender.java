package controllers;

import java.util.Collection;
import java.util.List;

import models.Movie;
import models.Rating;
import models.User;

/**
 * Interface to be implemented in MovieRecommenderAPI
 * 
 * @author ciaran
 * @version Asparagus
 * @date 11/12/2016
 */
public interface Recommender {

	/**
	 * method for adding object type user to map or list
	 * 
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param age
	 * @param occupation
	 * @return
	 */
	public User addUser(String firstName,String lastName,String gender,String age,String occupation);
	/**
	 * method for removing user, throws exception if wrong user id used
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void removeUser(Long id) throws Exception;
	
	
	/**
	 * method for adding object type movie to map or list
	 * 
	 * @param title
	 * @param year
	 * @param url
	 * @return
	 */
	public Movie addMovie(String title, String year, String url);
	
	
	/**
	 * method for adding object type rating to map or list
	 * 
	 * @param userID
	 * @param movieID
	 * @param rating
	 * @return
	 */
	public Rating addRating(long userID,long movieID,double rating);
	
	/**
	 * method for returning movie by id
	 * 
	 * @param movieID
	 * @return
	 */
	public Movie getMovie(long movieID);
	
	/**
	 * method for finding a users ratings
	 * 
	 * @param userID
	 * @return
	 */
	public double getUserRating(long userID);
	
	
	/**
	 * method for returning a users recommendations
	 * @param userID
	 * @return
	 */
	public double getUserRecommendations(long userID);
	
	
	/**
	 * method for calculating top ten movies in database
	 * @return List of type movie
	 */
	public List<Movie> getTopTenMovie();
	
	
	/**
	 * method to load data(pop) from the serializer
	 * @throws Exception
	 */
	public void load() throws Exception;
	
	
	/**
	 * method to write data(push) to the serializer
	 * @throws Exception
	 */
	public void write() throws Exception;
	
	
	/**
	 * method takes in parsed data from datainput class
	 * populates maps or lists
	 * @throws Exception
	 */
	public void prime() throws Exception;

	
	/**
	 * finds user by id
	 * @param userId
	 * @return User
	 */
	User getUserById(long userId);

	/**
	 * Finds user
	 * @param id
	 * @return User
	 */
	User getUser(Long id);

	/**
	 * Collection of all users
	 * @return Users
	 */
	Collection<User> getUsers();

	
	/**
	 * Removes movie from index
	 * @param movie
	 * @throws Exception
	 */
	void removeMovie(Movie movie) throws Exception;

	
	/**
	 * Collection of ratings stored
	 * @return ratings
	 */
	Collection<Rating> getRatings();

	/**
	 * Collection of movies stored
	 * @return movies
	 */
	Collection<Movie> getMovies();

	/**
	 * Finds ratings for specific movie
	 * @param movieId
	 * @return ratings
	 */
	Rating getRating(long movieId);
}
