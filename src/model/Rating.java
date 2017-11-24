package model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;

import com.google.common.base.Objects;

public class Rating {

	public long Id;
	 static Long   counter = 0l;
	 
	 public Long userId , movieId ;
	 public double ratingLeft ;
	 
	 public ArrayList<Movies> route = new ArrayList<Movies>();
	 
	 
	 public Rating()
	 {
		 
	 }

	public Rating(  Long userId, Long movieId, double ratingLeft) 	
	{
		this.movieId = userId;
		this.movieId = movieId;
		this.ratingLeft = ratingLeft;
		this.Id = counter ++;
	}
	 
	@Override
	public String toString()
	{
	  return toStringHelper(this).addValue(Id)
	                             .addValue(movieId)
	                             .addValue(userId)
	                             .addValue(ratingLeft)
	                             .toString();
	 
	 }
	
	@Override  
	public int hashCode()  
	{  
	   return Objects.hashCode(this.movieId, this.userId, this.ratingLeft, this.Id  );  
	}

	@Override
	public boolean equals(final Object obj)
	{
		if(obj instanceof Rating)
		{
			final Rating other = (Rating) obj;
			return Objects.equal(movieId, other.movieId)
					&& Objects.equal(userId, other.userId)
					&& Objects.equal(ratingLeft, other.ratingLeft)
					&& Objects.equal(route, other.route);
		}
		else
		{
			return false;
		}
		
	}
	
}