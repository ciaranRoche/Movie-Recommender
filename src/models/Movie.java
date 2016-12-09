package models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;

import com.google.common.base.Objects;

public class Movie implements Comparable<Movie>{
	static Long	counter = 0l;
	
	public String title;
	public String year;
	public String url;
	
	//public double rating;
	public List<Rating> rating = new ArrayList<Rating>();

	public Long id;
	
	public Movie(String title, String year, String url){
		this.id = counter ++;
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
	
	
	public String getTitle(){
		return title;
	}
	
	public double averageRating(){
		double total = 0;
		int count = 0;
		for(Rating rating : rating){
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

	@Override
	public int compareTo(Movie other) {
		
		return Double.compare(this.averageRating(), other.averageRating());
	}

}
