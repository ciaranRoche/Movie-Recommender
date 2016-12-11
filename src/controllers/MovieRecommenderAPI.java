package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.User;
import models.Movie;
import utils.DataInput;
import utils.Serializer;

import models.Rating;

/**
 * This is an API(java application program interface) class.
 * This class performs the majority of actions that can be chosen in the CLI.
 * 
 * @author ciaran
 * @version Asparagus
 * @date 11/12/2016
 *
 */
public class MovieRecommenderAPI implements Recommender{

	/**
	 * There are 3 hashmaps below;
	 * 
	 * 1) a user id mapped to User type object
	 * 2) a movie id mapped to a Movie type object
	 * 3) a rating id mapped to a Rating type object
	 */
	public Map<Long, User> userIndex = new HashMap<>();
	public Map<Long, Movie> movieIndex = new HashMap<>();
	public Map<Long, Rating> ratingIndex = new HashMap<>();
	
	private Serializer serializer;
	Rating rating;
	
	/**
	 * Blank constructor to over come bug
	 */
	public MovieRecommenderAPI(){
		
	}
	
	/**
	 *Constructor that instantiates serializer.
	 * @param serializer
	 */
	public MovieRecommenderAPI(Serializer serializer){
		this.serializer = serializer;
	}
	
	
	@Override
	public User addUser(String firstName, String lastName, String gender, String age, String occupation) {
		User user = new User(firstName, lastName, gender, age, occupation);
		user.id = userIndex.size() + 1l;
		userIndex.put(user.id, user);
		return user;
	}
	
	@Override
	public void removeUser(Long userID) throws Exception{
		userIndex.remove(userID);
	}
	
	@Override
	public User getUserById(long userId){
		return userIndex.get(userId);
	}
	
	@Override
	public User getUser(Long id){
		for(User user : userIndex.values())
			if(user.id == id)
				return user;
	    return null;
	  }
	/**
	 * Extra method thrown in to give the max number of users
	 * @return Largest number of users in the userIndex
	 */
	public Long getMaxUserId(){
		Long maxId = 0l;
		for (Long id : userIndex.keySet()){
			if (id>maxId){
				maxId = id;
			}
		}return maxId;
	}
	
	@Override
	public Collection<User> getUsers(){
		return userIndex.values();
	}
	
	@Override
	public Movie addMovie(String title, String year, String url) {
		Movie movie = new Movie(title, year, url);
		movie.id = movieIndex.size() + 1l;
		movieIndex.put(movie.id, movie);
		return movie;
	}
	
	@Override
	public void removeMovie(Movie movie) throws Exception{
		movieIndex.remove(movie.id);	
	}
	
	@Override
	public Collection<Movie> getMovies(){
		return movieIndex.values();
	}

	@Override
	public Rating addRating(long userID, long movieID, double rating) {
		Rating r = new Rating(userID, movieID, rating);
		r.id = ratingIndex.size() + 1l;
		//Movie movie = getMovie(movieID);
		//movie.ratings.add(r);
		ratingIndex.put(r.id, r);
		return r;	
	}
	/**
	 * Another method added in practice for keySet
	 * @return Long of the max number of movies in movieIndex
	 */
	public Long getMaxMovieId(){
		Long maxId = 0l;
		for(Long id : movieIndex.keySet()){
			if(id>maxId){
				maxId=id;
			}
		}return maxId;
	}

	@Override
	public Movie getMovie(long movieID) {	
		for(Movie movie : movieIndex.values())
			if(movie.id == movieID)
				return movie;
			
		return null;	
	}

	@Override
	public double getUserRating(long userID) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	@Override
//	public List<Rating> getRating(Long userID){
//		if(movieIndex.containsKey(userID)){
//			return movieIndex.get(userID).getRatings();
//		}else{
//			return null;
//		}
//	}
	
	@Override
	public Rating getRating(long movieId){
		return ratingIndex.get(movieId);
	}

	@Override
	public double getUserRecommendations(long userID) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Collection<Rating> getRatings(){
		return ratingIndex.values();
	}
	
//	public double averageRating(){
//		List<Rating> ratedMovies = new ArrayList<Rating>();
//		double total = 0;
//		int count = 0;
//		for(Rating rating : ratingIndex.values()){
//			total += rating.rating;
//			count++;
//		}
//		if(count != 0){
//			return total/count;
//		}else{
//			return 0;
//		}
//			
//	}
//	
//	@Override
//	public String getTopTenMovie(){
//		List<String> returnList = new ArrayList<String>();
//		Long bestMovie = null;
//		long bestRate = -1;
//		Movie bestMovieItem = null;
//		
//		List<Rating>tempList = new ArrayList<Rating>();
//		tempList.add((Rating) ratingIndex.values());
//		
//		for(Rating rating : tempList){
//			if(rating.getRating()>bestRate){
//				bestRate = (long) rating.getRating();
//				bestMovie = rating.getMovieId();
//				bestMovieItem = movieIndex.get(bestMovie);
//				returnList.add(bestMovieItem.getTitle());
//			}
//		}
//		Collections.sort(returnList);
//		
//		return ""+returnList.subList(0,	10);
//	}
//	
//	public List<Rating> ratings(){
//		ArrayList<Rating> ratingIndex = new ArrayList<Rating>();
//		for(User user : userIndex.values()){
//			for(Rating rating : user.getRatings()){
//				ratingIndex.add(rating);
//			}
//		}return ratingIndex;
//	}
//	
//	@Override
//	public List<Movie> getTopTenMovie(){
//		List<Movie> movies = new ArrayList<Movie>();
//		for(Movie movie : movieIndex.values()){
//			movies.add(movie);
//		}
//		Collections.sort(movies);
//		Collections.reverse(movies);
//		if(movies.size()<10){
//			return movies;
//		}else{
//			return movies.subList(0, 10);
//		}
//	}
//	
	
	
//	public double averageRatings(long movieID) throws Exception{
//		double rating = 0;
//		int count = 0;
//		
//		Movie movie = getMovie(movieID);
//		
//		for(Rating r : ratingIndex.values()){
//			rating += movie.rating;
//			count ++;
//		}
//		if(count != 0){
//			return rating/count;
//		}else{
//			return 0;
//		}
//		
//	}
	
//	public List<Movie>topTopTenMovie() throws Exception{
//		for (Movie m : movieIndex.values())
//			averageRatings(m.id);
//		
//		List<Movie> movie = new ArrayList<>();
//		
//		Collections.sort(movie, new Comparator<Movie>(){
//			public int compare(Movie movie, Movie other){
//				return (int) (movie.rating - other.rating);
//			}
//		});
//		
//		if(movie.size()<10){
//			return movie;
//		}else{
//		return movie.subList(0, 10);
//		}
//	}
//	
//
	@Override
	public List<Movie>getTopTenMovie(){
		Collection<Movie> allMovie = getMovies();
		List<Movie> movieList = new ArrayList<Movie>(allMovie);
		//Collections.sort(movieList);
		//Collections.reverse(movieList);
		List<Movie> sub = movieList.subList(0, 10 > movieList.size() ? movieList.size() : 10);
		return sub;	
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		serializer.read();
		ratingIndex		= (Map<Long, Rating>)	serializer.pop();
		movieIndex		= (Map<Long, Movie>)	serializer.pop();
		userIndex		= (Map<Long, User>)		serializer.pop();	
	}

	@Override
	public void write() throws Exception {
		serializer.push(userIndex);
		serializer.push(movieIndex);
		serializer.push(ratingIndex);
		serializer.write();	
	}
	

	/**
	 * Prime method is a method that takes in the parased data from dataInput
	 * It populates the hash maps that have the object type as a value
	 * This is done for user, movie and rating parsed in objects.
	 */
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
//			for(Map.Entry<Long, Movie> mRatings : movieIndex.entrySet()){
//				if(mRatings.getKey().equals(rating.getMovieId())){
//					mRatings.getValue().addRating(rating);
//				}
//			}
//			for(Map.Entry<Long, User> uRatings : userIndex.entrySet()){
//				if(uRatings.getKey().equals(rating.getUserId())){
//					uRatings.getValue().addRating(rating);
//				}
//			}
			addRating(rating.userId, rating.movieId, rating.rating);
			//addRatingList(rating.userId, rating.movieId, rating.rating);
		}
	}	
}
