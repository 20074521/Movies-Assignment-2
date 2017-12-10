package model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Objects;

import model.Movies;
import model.Rating;

public class Movies implements Comparable<Movies>{

	public long MovieId;
	public static Long counter=(long) 01;
	public String title , date , link ;
	
	
	public Map<Long, Rating> rateIndex = new HashMap<>();
	 
	public List<Rating>movie = new ArrayList<>();

	public Movies( String title, String date, String link) {
		
		this.MovieId = counter ++;
		this.title = title;
		this.date = date;
		this.link = link;
	}
	 
	@Override
	public String toString()
	{
	  return toStringHelper(this).addValue(title)
	                             .addValue(date)
	                             .addValue(link)
	                             .addValue(MovieId)
	                             .toString();
	 
	 }
	
	@Override  
	public int hashCode()  
	{  
	   return Objects.hashCode(this.title, this.date, this.link, this.MovieId  );  
	}

	@Override  
	public boolean equals(final Object obj)
	{
		if (obj instanceof Movies)
		{
			final Movies other = (Movies) obj;
			return Objects.equal(title, other.title)
					&& Objects.equal(date, other.date)
					&& Objects.equal(link, other.link);
		}
		else
		{
			return false;
		}
	}

	@Override
	 public int compareTo(Movies movies)
		{
			return this.title.compareTo(movies.title);
	}
	}
	
