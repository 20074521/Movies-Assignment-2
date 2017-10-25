package controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.User;

public class MoviesAPI
{
	 private Map<Long, User> userIndex = new HashMap<Long, User>();
	 private Map<String, User> fNameIndex = new HashMap<String, User>();

	  public Collection<User> getUsers ()
	  {
	    return userIndex.values();
	  }

  public  void deleteUsers() 
  {
	  userIndex.clear();
	  fNameIndex.clear();
  }

  public User createUser(String fName, String lName, String age, String gender, String job ) 
  {
    User user = new User (fName, lName, age, gender, job );
    userIndex.put(user.id, user);
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

  public void deleteUser(Long id) 
  {
	  userIndex.remove(id);
  }


}