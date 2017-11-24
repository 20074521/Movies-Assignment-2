package controllers;

import model.Movies;
import model.Rating;
import model.User;

public interface MovieAPIInterface {
	public User createUser(String fName, String lName, String age, String gender, String job ); 
	public void deleteUser(Long userID);
	public Movies addMovie(long id, String name, String date, String link);
	public Rating createRating(Long ID, Long movieID, double ratingLeft);
	public Movies getMovie(Long iD);
	
	//public void load(File file) throws Exception;
	//public void write();
	
	
}
