package controllers;

public interface Recommender {

	public void addUser(String firstName,String lastName,int age,String gender,String occupation);
	
	public void removeUser(double userID);
	
	public void addMovie(String title, int year, String url);
	
	public void addRating(double userID,double movieID,double rating);
	
	public double getMovie(double movieID);
	
	public double getUserRathing(double userID);
	
	public double getUserRecommendations(double userID);
	
	public String getTopTenMovie();
}
