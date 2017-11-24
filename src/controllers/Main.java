package controllers;

import java.io.File;
import java.util.Collection;

import com.google.common.base.Optional;

import asg.cliche.*;
import model.Movies;
import model.User;
import utils.Serializer;
import utils.XMLSerializer;

public class Main
{
		public MoviesAPI movie;
	
	public Main() throws Exception {
		File movies = new File ("datastore.xml");
		Serializer serializer = new XMLSerializer(movies);
		movie = new MoviesAPI(serializer);
		if(movies.isFile())
		{
			movie.load();
		}
	}
	
/*	public static void Menu()
	{
		System.out.println("1. Create User");
		System.out.println("2. Get User by First Name");
		System.out.println("3  delete User");
		System.out.println("4. Add Movie");
		System.out.println("5. Add Ratings");
		System.out.println("6. Store");
		System.out.println("7. Exit");
		
	}*/
	
	/**
	 * @param args
	 * @throws Exception
	 */
/*	public static void main(String[] args) throws Exception 

	{
		Main api = new Main();
		String  usersfName, lName, gender, age, job, movies name, date, link ;
		
		long ratings movieId , UserId;;
		int choice=0;
		double ratingsrateingLeft;
		char answer;
		
	
	api.movie.initalLoad();
	do {
		Menu();
		System.out.println("Please select an option between 1-7: ");
		choice= EasyScanner.nextInt();
		
		switch (choice)
		{
		case 1:
			   System.out.println("Enter your first name: ");
		       fName = EasyScanner.nextString();
		       
		       System.out.println("Enter your last name: ");
		       lName = EasyScanner.nextString();
		       
		       System.out.println("Enter your age: ");
		       age = EasyScanner.nextString();
		       
		       System.out.println("Enter your gender: ");
		       gender = EasyScanner.nextString();
		       
		       System.out.println("Enter your job: ");
		       job = EasyScanner.nextString();
		       
		       api.addUser(fName, lName, age, gender, job);
		       api.movie.store();		     			       
		break;
		
		case 2:
			 System.out.println("Get user by name: ");
			 fName = EasyScanner.nextString();
	         api.getUserByfName(fName);
	        
	         
		break;
		
		case 3:
			  System.out.println("Please enter the name of who you want to remove: ");
		      fName = EasyScanner.nextString();
		      api.deleteUser(fName);
		      
		break;
		
		case 4:			
			   System.out.println("Enter the movie Id: ");
		       movieId = EasyScanner.nextLong();
		       
			   System.out.println("Enter the movie Title: ");
		       name = EasyScanner.nextString();
		        
		       System.out.println("Enter date movie was releasd: ");
		       date = EasyScanner.nextString();
		       
		       System.out.println("Enter url link of movie: ");
		       link = EasyScanner.nextString();
		       
		       api.addMovie(movieId, name, date, link);
		       api.movie.store();	
		break;
				
		case 5:		     
			   System.out.println("Enter your user ID: ");
		       UserId = EasyScanner.nextLong();
		       
		       System.out.println("Enter movie ID: ");
		       movieId = EasyScanner.nextLong();
		        
		       System.out.println("Enter ratings: ");
		       rateingLeft = EasyScanner.nextDouble();
		       
		       api.addRatings(UserId, movieId,  rateingLeft);
		break;
			
		case 6:
			 System.out.println("Would you like to store the data entered? [y/n]: ");
			 answer = EasyScanner.nextChar();
			 if (answer == 'y' || answer == 'Y')
			 {
				 api.movie.store();
			 }
		break;
			
		case 7:
			 System.out.println("Thank you. Goodbye");
		break;
			
		default:
			 System.out.println("Please ONLY choose options 1-7 .Thank you");
		break;
		}
		
	}while(choice!=7);
	
}*/
	@Command()
	
	public void getAllUsers() {
		Collection<User> user = movie.getUsers();
		System.out.println(user);
	}
	
	
	public static void main(String[] args) throws Exception 
	{
		Main main = new Main();
		ShellFactory.createConsoleShell("welcome"," ",main).commandLoop();
		
	}
	
	
	
	
	
	
	/*private void addRatings(long UserId, long movieId, double rateingLeft) {
		Optional<Movies> ratings = Optional.fromNullable(movie.getMovie(movieId));
		if(ratings.isPresent())
		{
			movie.createRating( UserId,movieId, rateingLeft);
		}
		
	}

	private void deleteUser(String fName) {
		Optional<User> user = Optional.fromNullable(movie.getUserByfName(fName));
		if(user.isPresent())
		{
			movie.deleteUser(user.get().UserId);
		}
		
	}
	

	private void getUserByfName(String fName) {
		Optional<User> user = Optional.fromNullable(movie.getUserByfName(fName));
		if(user.isPresent())
		{
			System.out.println(user);
		}
		else
		{
			System.out.println("User Cant Be Found ");
			System.out.println("    ");
		}
		}
		
		
	

	private void addUser(String fName, String lName, String age, String gender, String job) {
		movie.createUser(fName, lName, age, gender, job);
		
	}

	private void addMovie(long Id, String name, String date, String link) {
		Optional<User> movies = Optional.fromNullable(movie.getUser(Id));
		if(movies.isPresent())
		{
			movie.addMovie(Id, name, date, link);
		}
		
	}*/
}
