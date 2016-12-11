package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

/**
 * Ratings class that is a representation of what a rating object is.
 * @author ciaran
 * @version asparagus
 * @date 11/12/2016
 *
 */
public class Rating {
	
	static long counter = 0l;

	public long userId;
	public long movieId;
	public double rating;
	
	public long id; 
	
	/**
	 * One of two constructors
	 * Used in Cliche Shell.
	 * @param userId
	 * @param movieId
	 * @param rating
	 */
	public Rating(long userId, long movieId, double rating){
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
	}
	
	/**
	 * One of two constructors,
	 * Used when data is parsed in dataInput
	 * @param id
	 * @param userId
	 * @param movieId
	 * @param rating
	 */
	public Rating(long id, long userId, long movieId, double rating){
		this.id = id;
		if(id >= counter){
			counter = id + 1;
		}
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
	}
	
	@Override
	public String toString(){
		return toStringHelper(this).addValue(userId)
				                   .addValue(movieId)
				                   .addValue(rating)
				                   .toString();
	}
	
	@Override
	public int hashCode(){
		return Objects.hashCode(this.userId, this.movieId, this.rating);
	}
	
	public int compareTo(Rating that){
		return Double.compare(this.getRating(), that.getRating());
	}
	
	@Override
	public boolean equals(final Object obj){
		if(obj instanceof Rating){
			final Rating other = (Rating) obj;
			return Objects.equal(userId, other.userId)
					&& Objects.equal(movieId, other.movieId)
					&& Objects.equal(rating, other.rating);
		}else{
			return false;
		}
	}
	
	/**
	 * Setters and Getters
	 * @return
	 */
	
	public double getRating(){
		return rating;
	}
	
	public void setRating(Long rating){
		this.rating = rating;
	}
	
	public long getUserId(){
		return userId;
	}
	
	public void setUserId(long userId){
		this.userId = userId;
	}
	
	public long getMovieId(){
		return movieId;
	}
	
	public void setMovieId(long movieId){
		this.movieId = movieId;
	}
}
