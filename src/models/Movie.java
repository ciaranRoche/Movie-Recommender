package models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.Objects;

public class Movie {
	static Long	counter = (long) 01;
	
	public String title;
	public int year;
	public String url;

	public Long id;
	
	public Movie(String title, int year, String url){
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
			return Objects.equals(title, other.title)
					&& Objects.equals(year, other.year)
					&& Objects.equals(url, other.url);
		}else{
			return false;
		}
	}

}
