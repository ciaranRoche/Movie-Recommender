package controllers;

import java.io.File;
import java.util.Collection;

import models.User;
import utils.Serializer;
import utils.XMLSerializer;
import models.Movie;
public class Main {
	
	public static void main(String[] args) throws Exception{
	File datastore = new File("dataStore.xml");
	Serializer serializer = new XMLSerializer(datastore);
	
	MovieRecommenderAPI movieRecommenderAPI = new MovieRecommenderAPI(serializer);
	if(datastore.isFile()){
		movieRecommenderAPI.load();
	}
	
	movieRecommenderAPI.prime();
	
	//movieRecommenderAPI.addUser("Joe", "Bloggs", "male", "21", "coder");
	//movieRecommenderAPI.addUser("Jane", "Bloggs", "female", "22", "hacker");
	
	
	Collection<User> users = movieRecommenderAPI.getUsers();
	System.out.println(users);
	
	Collection<Movie> movies = movieRecommenderAPI.getMovies();
	System.out.println(movies);
	
	movieRecommenderAPI.write();
	
	
	}

}
