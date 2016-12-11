package utils;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.In;
import models.User;

import models.Movie;

import models.Rating;

/**
 * This is a data input method. This class parses in the dat file format information
 * int the methods temporary array list. seperating the data with a | . This data is then 
 * split and parsed.
 * @author ciaran
 * @version asparagus
 * @data 11/12/2016
 *
 */
public class DataInput {
	
	
	public static void main(String[] args){

	}
	
	public List<User> loadUsers(String filename) throws Exception{
		File usersFile = new File(filename);
		In inUsers = new In(usersFile);
		
		String delims = "[|]";
		List<User> users = new ArrayList<User>();
		while(!inUsers.isEmpty()){
			String userDetails = inUsers.readLine();
			String[] userTokens = userDetails.split(delims);
			if(userTokens.length == 7){
				Long id 		  = Long.parseLong(userTokens[0]);
				String firstName  = userTokens[1];
				String lastName	  = userTokens[2];
				String age		  = userTokens[3];
				String gender	  = userTokens[4];
				String occupation = userTokens[6];
				
				users.add(new User(id, firstName, lastName, gender, age, occupation));					
			}else{
				throw new Exception("Invalid member lenght: " + userTokens.length);
			}
		}
		return users;
	}
	

	public List<Movie> loadMovies (String filename) throws Exception{
		File moviesFile = new File(filename);
		In inMovies = new In(moviesFile);
		
		String delims = "[|]";
		List<Movie> movies = new ArrayList<Movie>();
		while(!inMovies.isEmpty()){
			String movieDetails = inMovies.readLine();
			String[] movieTokens = movieDetails.split(delims);
			if(movieTokens.length == 23){
				String id 			= movieTokens[0];
				String title		= movieTokens[1];
				String year			= movieTokens[2];
				String url			= movieTokens[3];
				
				movies.add(new Movie(title, year, url));
			}else{
				throw new Exception("Invalid movie lenght: " + movieTokens.length);
			}
		}
		return movies;
	}
	
	public List<Rating> loadRatings (String filename) throws Exception{
		File ratingsFile = new File(filename);
		In inRatings = new In(ratingsFile);
		
		String delims = "[|]";
		List<Rating> ratings = new ArrayList<Rating>();
		while(!inRatings.isEmpty()){
			String ratingDetails = inRatings.readLine();
			String[] ratingTokens = ratingDetails.split(delims);
			if(ratingTokens.length == 4){
				long userId 	= Long.parseLong(ratingTokens[0]);
				long movieId	= Long.parseLong(ratingTokens[1]);
				int rating   = Integer.parseInt(ratingTokens[2]);
				
				ratings.add(new Rating(userId, movieId, rating));	
			}else{
				throw new Exception("Invalid ratings length: " + ratingTokens.length);
			}
		}
		return ratings;
	}
}
