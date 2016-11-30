package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataInput {
	
	Scanner scanner;
	
	public static void main(String[] args){
		System.out.println("hello world");
		try {
			readInData();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readInData() throws FileNotFoundException{
		File file = new File("././data/items5.dat");
		Scanner inData = new Scanner(file);
		
		String delims = "[|]";
		while(inData.hasNextLine()){
			String dataDetails = inData.nextLine();
			
			String[] dataTokens = dataDetails.split(delims);
			
			if(dataTokens.length == 4){
				System.out.println("id: "+dataTokens[0]+"Title: " +dataTokens[1]+ " Date: "+dataTokens[2]+ " Url: "+dataTokens[3]);
			}else{
				try {
					throw new Exception("Invalid movie length: "+dataTokens.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
