package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.common.base.Optional;

import model.Movies;
import model.Rating;
import model.User;
import utils.Serializer;

public class MoviesAPI implements MovieAPIInterface

{

	private Serializer serializer;
	
	 private static Map<Long, User> userIndex = new HashMap<Long, User>();
	 private Map<String, User> fNameIndex = new HashMap<String, User>();
	 private static Map<Long, Movies > movieIndex = new HashMap<Long, Movies>();
	 
	 public MoviesAPI() 
	 {}
	 
	 public MoviesAPI(Serializer serializer)
	  {
	    this.serializer = serializer;
	  }
	 
	 @SuppressWarnings("unchecked")
	  public void load() throws Exception
	  {
	   serializer.read();
	    {
	      
	      userIndex       = (Map<Long, User>)    serializer.pop() ;
	      movieIndex     = (Map<Long, Movies>)  serializer.pop();
	     }
	  }
	 
	 void store() throws Exception
	  {
	 
		  serializer.push(userIndex);
		  serializer.push(movieIndex);
		  serializer.write();
	 }
	 

	  public Collection<User> getUsers ()
	  {
	    return userIndex.values();
	  }

  
@Override
  public User createUser(String fName, String lName, String age, String gender, String job ) 
  {
    User user = new User (fName, lName, age, gender, job );
    userIndex.put(user.UserId, user);
    fNameIndex.put(fName, user);
    return user;
  }
  
  public User getUserByfName(String fName) {
		
		return fNameIndex.get(fName) ;
	}
  
  public User getUser(Long id) 
  {
	  return userIndex.get(id);
  }

  @Override
  public void deleteUser(Long id) 
  {
	  User user = userIndex.remove(id);
	  fNameIndex.remove(user.fName);
  }
  
public  void deleteUsers() 
  {
	  userIndex.clear();
	  fNameIndex.clear();
  }

public void removeUser(String fName)
{
	User user = userIndex.remove(fName);
	userIndex.remove(user.fName);
}


  
 
  

  
  
  @Override
  public Movies addMovie (long id , String name, String date ,String link )
  {
	  Movies movies = null;
	  Optional<User> user = Optional.fromNullable(userIndex.get(id));
	  if(user.isPresent())
	  {
		  movies = new Movies(name , date, link);
		  user.get().movies.put(movies.MovieId , movies);
		  movieIndex.put(movies.MovieId , movies);
	  }
	  return movies;
  }
  @Override

public Movies getMovie(Long id) 
{
	return movieIndex.get(id);
}
  
public void initalLoad() throws IOException {
	String delims = "[|]";
	Scanner scanner = new Scanner(new File("./data/users5.dat"));
	while (scanner.hasNextLine()) {
		String userDetails = scanner.nextLine();
		// parse user details string
		String[] userTokens = userDetails.split(delims);

		if (userTokens.length == 7) {
			createUser(userTokens[1], userTokens[2], userTokens[3], userTokens[4], userTokens[5]);
		} else {
			scanner.close();
			throw new IOException("Invalid member length: " + userTokens.length);
		}
	}
	scanner.close();
}

@Override
public Rating createRating(Long userID, Long movieID, double ratingLeft) {
	Optional <Movies> movies = Optional .fromNullable(movieIndex.get(movieID));
	 if (movies.isPresent())
	 {
		 movies.get().movie.add(new Rating(userID , movieID , ratingLeft));
	 }
	return null;
}
}