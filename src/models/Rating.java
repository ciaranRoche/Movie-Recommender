package models;

import static com.google.common.base.MoreObjects.toStringHelper;

public class Rating {
	
	static long counter = 0l;

	public long userId;
	public long movieId;
	public long rating;
	
	public long id; 
	
	public Rating(long userId, long movieId, long rating){
		
		
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
}
