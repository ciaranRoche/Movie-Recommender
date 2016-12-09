package models;

public class Fixtures {
	
	public static User[] users = {
			new User("Joe", "Bloggs", "male", "21", "programmer"),
			new User("Jane", "Bloggs", "female", "22", "programmer"),
			new User("Alice", "Bloggs", "female", "42", "programmer"),
			new User("Bob", "Bloggs", "male", "28", "programmer")
	};
	
	public static Movie[] movies ={
			new Movie("The Matrix", "42-Jan-4242", "www.thematrix.com"),
			new Movie("Iron Man", "42-Jan-4242", "www.ironman,com"),
			new Movie("World War Z", "42-Jan-4242", "www.worldwarz.com"),
			new Movie("Resident Evil", "42-Jan-4242", "www.residentevil.com"),
			new Movie("Up", "42-Jan-4242", "www.up.com")
	};
	
	public static Rating[] ratings ={
			new Rating(0, 0, 2),
			new Rating(1, 1, 3),
			new Rating(2, 2, 4),
			new Rating(3, 3, 5),
			new Rating(0, 4, 2)
	};
}
