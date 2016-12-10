package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

public class Rating {
	
	static long counter = 0l;

	public long userId;
	public long movieId;
	public double rating;
	
//	public List<Movie> movie = new ArrayList<Movie>();
	
	public long id; 
	
	public Rating(long userId, long movieId, double rating){
		
		
		if(userId < 0 || movieId < 0)
			throw new IllegalArgumentException();
		
		this.id = counter ++;
		
		this.userId = userId;
		this.movieId = movieId;
		this.rating = rating;
	}
	
	
	@Override
	public String toString(){
		return toStringHelper(this).addValue(id)
				                   .addValue(userId)
				                   .addValue(movieId)
				                   .addValue(rating)
				                   .toString();
	}
	
	@Override
	public int hashCode(){
		return Objects.hashCode(this.userId, this.movieId, this.rating);
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
}
