package controllers;

import java.io.IOException;
import java.util.Collection;
import model.User;

public class Main
{
  public static void main(String[] args) throws IOException
  {    
    MoviesAPI MoviesAPI = new MoviesAPI();

    MoviesAPI.createUser("Bart",  "Simpson", "12",  "male", "N/A" );
    MoviesAPI.createUser("Homer", "Simpson", "34", "male", "Power Plant");
    MoviesAPI.createUser("Lisa",  "Simpson", "10",  "female", "N/A");

    Collection<User> users = MoviesAPI.getUsers();
    System.out.println(users);
    
    User homer = MoviesAPI.getUserByfName("homer");
    System.out.println(homer);

    MoviesAPI.deleteUser(homer.id);
    users = MoviesAPI.getUsers();
    System.out.println(users);
  }
}	
