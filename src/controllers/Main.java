package controllers;

import java.io.File;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import models.User;
import utils.Serializer;
import utils.XMLSerializer;
import models.Movie;
public class Main {
	
	public MovieRecommenderAPI moviAPI;
	
	private static User loginUser;

	private Scanner input;

	private User user;
	private Movie movie;
	
	public Main() throws Exception{
		input = new Scanner(System.in);
		
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
	public String removeUser(@Param(name="userID") long userID) throws Exception{	
		user = moviAPI.removeUser(userID);
		return "\nUser: " + user.firstName + " removed.";	
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
	public String removeMovie(@Param(name="movieID") long movieID) throws Exception{
		
		movie = moviAPI.removeMovie(movieID);
		
		return "\nMovie: " + movie.title + " removed.";
	}
	
	@Command(description="Get a specific movie")
	public String getMovie(@Param(name="movieID") long movieID){
		movie = moviAPI.getMovie(movieID);
		return movie.toString();	
	}
	
	
}
