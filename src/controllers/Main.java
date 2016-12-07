package controllers;

import java.io.File;
import java.util.Collection;

import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import models.User;
import utils.Serializer;
import utils.XMLSerializer;
import models.Movie;
public class Main {
	
	public MovieRecommenderAPI moviAPI;
	
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
	
//	public static void main(String[] args) throws Exception{
//	File datastore = new File("dataStore.xml");
//	Serializer serializer = new XMLSerializer(datastore);
//	
//	MovieRecommenderAPI movieRecommenderAPI = new MovieRecommenderAPI(serializer);
//	if(datastore.isFile()){
//		movieRecommenderAPI.load();
//	}
//	
//	movieRecommenderAPI.prime();
//	
//	//movieRecommenderAPI.addUser("Joe", "Bloggs", "male", "21", "coder");
//	//movieRecommenderAPI.addUser("Jane", "Bloggs", "female", "22", "hacker");
//	
//	
//	Collection<User> users = movieRecommenderAPI.getUsers();
//	System.out.println(users);
//	
//	Collection<Movie> movies = movieRecommenderAPI.getMovies();
//	System.out.println(movies);
//	
//	movieRecommenderAPI.write();
//	
//	
//	}

}
