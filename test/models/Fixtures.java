package models;

import model.Movies;
import model.Rating;
import model.User;

public class Fixtures
{
  public static User[] users =
  {
    new User ("marge", "simpson", "30",  "female", "house wife",""),
    new User ("lisa",  "simpson", "10",   "female", "N/A","admin"),
    new User ("bart",  "simpson", "12", "male", "N/A","default"),
    new User ("maggie","simpson", "1", "femalet", "N/A","something else")
  };
  
  
  public static Rating[] ratings = 
	  {
			  new Rating (0l,001l,5),
			  new Rating (02l,002l,3),
			  new Rating (03l,003l,4),
			  new Rating (04l,004l, 3),
			  new Rating (05l, 005l, 2),
			  
	  };
  
  public static Movies[] movie = 
	  {
			 new Movies("toy story","1998","toy.com"), 
			 new Movies("mulan","2000","mulan.com"), 
			 new Movies("antz","2007","antz.com"), 
			 new Movies("flubber","1998","flubber.com"), 
			 new Movies("cars","2004","cars.com"), 
			 
	  };
			  
			  
			  
	  }
  
  
  
  
  
  
  
  
  
  
