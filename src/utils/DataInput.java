package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.introcs.In;
import models.User;

public class DataInput {
	
	Scanner scanner;
	
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
				String id 		  = userTokens[0];
				String firstName  = userTokens[1];
				String lastName	  = userTokens[2];
				String age		  = userTokens[3];
				String gender	  = userTokens[4];
				String occupation = userTokens[6];
				
				users.add(new User(firstName, lastName, gender, age, occupation));					
			}else{
				throw new Exception("Invalid member lenght: " + userTokens.length);
			}
		}
		return users;
	}
	

//	public static void readInData() throws FileNotFoundException{
//		File file = new File("././data/items5.dat");
//		Scanner inData = new Scanner(file);
//		
//		String delims = "[|]";
//		while(inData.hasNextLine()){
//			String dataDetails = inData.nextLine();
//			
//			String[] dataTokens = dataDetails.split(delims);
//			
//			System.out.println("id: "+dataTokens[0]+"Title: " +dataTokens[1]+ " Date: "+dataTokens[2]+ " Url: "+dataTokens[3]);
//
//
//		}
//	}
}
