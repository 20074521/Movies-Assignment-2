package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Movies;

import static models.Fixtures.movie;


public class MoviesTest {
	
	 private Movies one;
	  private Movies two;
	
	  @Before
	  public void setup()
	  {
	    one = new Movies("cars 2", "2005", "cars2.com");
	    two = new Movies("the green mile", "1998", "greenmile.com");
	  }
	
	
	 @After
	  public void tearDown()
	  {
	    one = two = null;
	  }

	

	@Test
	public void testCreate()
	{
		assertEquals ("cars 2", "2005", "cars2.com");
		assertEquals ("the green mile", "1998", "greenmile.com");
		 
		
	}
	
	@Test
	public void testIds()
	{
		assertNotEquals(one.MovieId, two.MovieId);
	}

	
	@Test
	public void testToString()
	{
		assertEquals ("Movies{" + movie[0].MovieId +" , cars 2 , 2005 ,cars2.com}", movie[0].toString());
	}
}
