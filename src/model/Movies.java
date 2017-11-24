package model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

public class Movies {

	public long MovieId;
	public static Long   counter = 0l;
	public String Name , date , link ;
	
	
	 public List<Rating> movie  = new ArrayList<>();
	 
	

	public Movies( String name, String date, String link) {
		
		this.MovieId = counter ++;
		this.Name = name;
		this.date = date;
		this.link = link;
	}
	 
	@Override
	public String toString()
	{
	  return toStringHelper(this).addValue(Name)
	                             .addValue(date)
	                             .addValue(link)
	                             .addValue(MovieId)
	                             .toString();
	 
	 }
	
	@Override  
	public int hashCode()  
	{  
	   return Objects.hashCode(this.Name, this.date, this.link, this.MovieId  );  
	}

	@Override  
	public boolean equals(final Object obj)
	{
		if (obj instanceof Movies)
		{
			final Movies other = (Movies) obj;
			return Objects.equal(Name, other.Name)
					&& Objects.equal(date, other.date)
					&& Objects.equal(link, other.link);
		}
		else
		{
			return false;
		}
	}
		
	}
	
