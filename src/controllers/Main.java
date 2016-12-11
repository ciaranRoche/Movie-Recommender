package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import models.User;
import utils.Serializer;
import utils.XMLSerializer;
import models.Movie;
import models.Rating;

public class Main {
	
	public MovieRecommenderAPI moviAPI;
	private User user;
	private Movie movie;
	private Rating rating;
	
	public Main() throws Exception{	
		File datastore = new File("dataStore.xml");
		Serializer serializer = new XMLSerializer(datastore);
		
		moviAPI = new MovieRecommenderAPI(serializer);
		if(datastore.isFile()){
			moviAPI.load();
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		Main main = new Main();
		Shell shell = ShellFactory.createConsoleShell("EMDB", "<-------------------->\n   Welcome to EMDB\nEclipse Movie Data Base\n<-------------------->\n   - ?help for instructions", main);
		shell.commandLoop();
		main.moviAPI.write();
	}
	
	
	@Command(description="Load data")
	public String load() throws Exception{
		moviAPI.load();
		return "Data Loaded";
	}
	
	
	@Command(description="Save data")
	public String save() throws Exception{
		moviAPI.write();
		return "Data Saved";
	}
	
	
	@Command(description="Get List of Users")
	public void getUsers(){
		Collection<User>users = moviAPI.getUsers();
		System.out.println(users);
	}
	
	
	@Command(description="Add a new user")
	public String addUser(@Param(name="first name") String firstName,
										@Param(name="last name") String lastName,
										@Param(name="age") String age,
										@Param(name="gender") String gender,
										@Param(name="occupation") String occupation){
		user = moviAPI.addUser(firstName, lastName, gender, age, occupation);
		return "\nUSER: " + user.firstName + " added.";
	}
	
	
	@Command(description="Remove a user")
	public void removeUser(@Param(name="userID") long userID) throws Exception{	
		User user = moviAPI.getUser(userID);
		moviAPI.removeUser(userID);
		System.out.println("\nUser: " + user.firstName + " removed.");	
	}
	
	
	@Command(description="Get a specific user")
	public String getUser(@Param(name="userID") long userID){
		user = moviAPI.getUser(userID);
		return user.toString();
	}
	
	
	@Command(description="Get List of Movies")
	public void getMovies(){
		Collection<Movie>movies = moviAPI.getMovies();
		System.out.println(movies);
	}
	
	
	@Command(description="Add a new movie")
	public String addMovie(@Param(name="title") String title,
									@Param(name="year") String year,
									@Param(name="URL") String url){
		
		movie = moviAPI.addMovie(title, year, url);
		return "\nMovie: " + movie.title + " added";
	}
	
	
	@Command(description="Remove a movie")
	public void removeMovie(@Param(name="movieID") long movieID) throws Exception{
		Movie movie = moviAPI.getMovie(movieID);
		moviAPI.removeMovie(movie);
		System.out.println("\nMovie: " + movie.title + " removed.");
	}
	
	
	@Command(description="Get a specific movie")
	public String getMovie(@Param(name="movieID") long movieID){
		movie = moviAPI.getMovie(movieID);
		return movie.toString();	
	}
	
	
	@Command(description="Add a Rating")
	public String addRating(@Param(name="userID") long userID, @Param(name="movieID") long movieID, @Param(name="rating") double rating){
		moviAPI.addRating(userID, movieID, rating);
		movie = moviAPI.getMovie(movieID);
		user = moviAPI.getUser(userID);
		return "Movie " + movie.title + " Rated " + rating + " by " + user.firstName;
	}
	
	
	@Command(description="Get a Rating based on id")
	public String getRating(@Param(name="id") long id){
		rating = moviAPI.getRating(id);
		return rating.toString();
	}
	
//	@Command(description="Get a Movie Rating")
//	public void getRating(@Param(name="movieID") long movieID){
//		List<Rating> ratings = moviAPI.getRating(movieID);
//		if(ratings==null){
//			System.out.println("No matching movie ID. FATAL ERROR!");
//		}else if(ratings.size()==0){
//			System.out.println("No one has rated this yet, be the first!!!!");
//		}else{
//			for(Rating r : ratings){
//				System.out.println(r.toString());
//			}
//		}
//	}
	
	
	@Command(description="Get top ten movies")
	public void getTopTenMovies(){
		ArrayList<Movie> movies = new ArrayList<>(moviAPI.getTopTenMovie());
		if(movies.size()>0){
			for(Movie movie : movies){
				System.out.println(movie.toString());
			}
		}else{
			System.out.println("No top movies to show");
		}
	}
	

	@Command(description="Get all ratings")
	public void getRatings(){
		Collection<Rating> ratings = moviAPI.getRatings();
		System.out.println(ratings);
	}
	
}
