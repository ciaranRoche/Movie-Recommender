package models;

import static com.google.common.base.MoreObjects.toStringHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
	
	static Long counter= 0l;
	
	public Long id;
	public String firstName;
	public String lastName;
	public String gender;
	public String age;
	public String occupation;
	
	
	public List<Rating> ratings = new ArrayList<>();
	
	public User(){
		
	}
	
	public User(String firstName, String lastName, String gender, String age, String occupation){
		this.id = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender	= gender;
		this.age = age;
		this.occupation = occupation;
	}
	
	public String toString(){
		return toStringHelper(this).addValue(id)
								   .addValue(firstName)
								   .addValue(lastName)
								   .addValue(gender)
								   .addValue(age)
								   .addValue(occupation)
								   .toString();
	}
	
	@Override
	public boolean equals(final Object obj){
		if(obj instanceof User){
			final User other = (User) obj;
			return Objects.equals(firstName, other.firstName)
					&& Objects.equals(lastName, other.lastName)
					&& Objects.equals(gender, other.gender)
					&& Objects.equals(age, other.age)
					&& Objects.equals(occupation, other.occupation)
					&& Objects.equals(ratings, other.ratings);
		}else{
			return false;
		}
	}
	

}
