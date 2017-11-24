package models;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Rating;

public class RatingTest
{
  private Rating[] ratings =
  {
    new Rating (01l,  001l, 5),
    new Rating (02l,  002l, 3 ),
    new Rating (03l,  003l, 4),
    new Rating (04l,  004l,  1),
    new Rating (05l,  005l, 2)
  };

  Rating test = new Rating (01l,  001l, 5);

  
@Test
  public void testCreate()
  {
    assertEquals ("01l",          test.userId);
    assertEquals ("001l",        test.movieId);
    assertEquals ( 5 ,  test.ratingLeft, 5);    
  }

  @Test
  public void testToString()
  {
    assertEquals ("Rating{" + test.userId + ", 01, 001 , 5, []}", test.toString());
  }

public Rating[] getRatings() {
	return ratings;
}

public void setRatings(Rating[] ratings) {
	this.ratings = ratings;
}
}