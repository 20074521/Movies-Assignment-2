package controllers;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import com.google.common.base.Optional;

import asg.cliche.Command;
import asg.cliche.Param;
import model.Movies;
import model.Rating;
import model.User;

public class AdminMenu {

	  private String name;
	  private User user;
	  private MoviesInterFace moApi;

	  public AdminMenu(MoviesInterFace moApi, String userName) {

	    this.moApi = moApi;
	    this.setName(userName);
	    
	  }

	  /*TreeSet instead of hash map, easier to use*/
	  @Command(description = "Get users and sort by full name")
	  public void GetAllUsers() {
		  TreeSet<User> sortedUsers = new TreeSet<User>();
			sortedUsers.addAll(moApi.getUsers());
			Iterator<User> iteratoR = sortedUsers.iterator();
			while(iteratoR.hasNext()) {
				User usrs = iteratoR.next();
				System.out.println(usrs.lName + " " + usrs.fName);  
	  }
	  }

		@Command(description = "Get a Users detail")
		public void getUser(@Param(name = "first name") String fName) {
			User user = moApi.getUserByfName(fName);
			System.out.println(user);
		}

		@Command(description = "Create a new User")
		public void addUser(@Param(name = "first name") String fName, @Param(name = "last name") String lName,
				@Param(name = "age") String age, @Param(name = "gender") String gender, @Param(name = "job") String job  , @Param(name = "role") String role ){
			moApi.createUser(fName, lName, age, gender, job , role );
		}

		@Command(description = "Delete a User")
		public void deleteUser(@Param(name = "first name") String fName) {
			Optional<User> user = Optional.fromNullable(moApi.getUserByfName(fName));
			if (user.isPresent()) {
				moApi.deleteUser(user.get().UserId);
			}
		}

		// MOVIE COMMANDS
		@Command(description = "Create a new Movie")
		public void addMovie(long Id, String title, String date, String link) {
			Optional<User> movies = Optional.fromNullable(moApi.getUser(Id));
			if (movies.isPresent()) {
				moApi.addMovie(Id, title, date, link);
				System.out.print("movie added thank you ");
			} else {
				System.out.print("could not add movie ");
			}

		}
		
		
		
		
		@Command(description = "Get a Movie detail")
		public void getMovie(@Param(name = "Id") Long Id) {
			Movies movie = moApi.getMovie(Id);
			System.out.println(movie);
		}
		

		//TreeSet instead of hash map, easier to use. Iterator is for loop using collections//
	  @Command(description = "Get movies and sort by title")
	  public void getAllMovies() {
		  TreeSet<Movies> sortedMovies = new TreeSet<Movies>();
			sortedMovies.addAll(moApi.getMovies());
			Iterator<Movies> iteratoR = sortedMovies.iterator();
			System.out.println("List of movies sorted by the title and released date");
			while(iteratoR.hasNext()) {
				Movies moviE = iteratoR.next();
				System.out.println("Title: " + moviE.title + " " + "Released Date: " +moviE.date);  
	  }
	  }
		

		// RATING COMMANDS
		@Command(description = "Add an rating")
		public void addRating(@Param(name = "user-id") Long userId, @Param(name = "movie-id") Long movieId,
				@Param(name = "rating") double ratingLeft) {
			Optional<User> user = Optional.fromNullable(moApi.getUser(userId));
			if (user.isPresent()) {
				moApi.createRating(userId, movieId, ratingLeft);
			}
		}

		@Command(description = "Add Movie to an Rating")
		public void addMovie(@Param(name = "Rating-id") Long Id, @Param(name = "link") String link,
				@Param(name = "Title") String name, @Param(name = "Release date") String date) {
			Optional<Rating> rating = Optional.fromNullable(moApi.getRating(Id));
			if (rating.isPresent()) {
				moApi.addMovie(rating.get().Id, name, date, link);
			}
		}
		public String getName() {
		    return name;
		  }
		  public void setName(String name) {
		    this.name = name;
		  }
		  @Command(description="Save File")
			public void save() throws Exception {
				moApi.store();
			}
	}