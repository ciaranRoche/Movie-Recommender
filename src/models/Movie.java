package models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;

import com.google.common.base.Objects;

/**
 * Movie class that is a representation of what a movie object is.
 * @author ciaran
 * @version asparagus
 * @date 11/12/2016
 *
 */

public class Movie implements Comparable<Movie>{
	static Long	counter = 0l;
	
	public String title;
	public String year;
	public String url;
	public List<Rating> ratings = new ArrayList<Rating>();

	public Long id;
	
	/**
	 * one of 2 constructors for type movie
	 * Used in cliche shell
	 * @param title
	 * @param year
	 * @param url
	 */
	public Movie(String title, String year, String url){
		this.id = counter ++;
		this.title = title;
		this.year = year;
		this.url = url;
	}
	
	/**
	 * one of 2 constructors
	 * used when data is being parsed in data input.
	 * @param id
	 * @param title
	 * @param year
	 * @param url
	 */
	public Movie(Long id, String title, String year, String url){
		this.id = id;
		if(id >= counter){
			counter = id + 1;
		}
		this.title = title;
		this.year = year;
		this.url = url;
	}
	
	@Override
	public String toString(){
		return toStringHelper(this).addValue(id)
				                   .addValue(title)
				                   .addValue(year)
				                   .addValue(url)
				
				                   .toString();
	}
	
	@Override
	public boolean equals(final Object obj){
		if (obj instanceof Movie){
			final Movie other = (Movie) obj;
			return Objects.equal(title, other.title)
					&& Objects.equal(year, other.year)
					&& Objects.equal(url, other.url);
		}else{
			return false;
		}
		
	}
	
	
	/**
	 * Getters and setters
	 * @param rating
	 */
	public void addRating(Rating rating){
		ratings.add(rating);
	}
	
	public List<Rating> getRatings(){
		return ratings;
	}
	
	public void setRatings(List<Rating> ratings){
		this.ratings = ratings;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getUrl(){
		return url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public void setYear(String year){
		this.year = year;
	}
	
	public String getYear(){
		return year;
	}
	
	/**
	 * Method for calculating an average rating
	 * itterates over ratings adding ratings together
	 * incrementing a count 
	 * ratings total plus count divided together to give an average
	 * @return
	 */
	public double averageRating(){
		double total = 0;
		int count = 0;
		for(Rating rating : ratings){
			total += rating.rating;
			count++;
		}
		if(count != 0){
			return total/count;
		}else{
			return 0;
		}	
	}
	
	@Override
	public int hashCode(){
		return Objects.hashCode(this.id, this.title, this.url);
	}
	
	
	/**
	 * Compares average ratings of movies
	 */
	@Override
	public int compareTo(Movie other) {
		
		return Double.compare(this.averageRating(), other.averageRating());
	}

	
}
