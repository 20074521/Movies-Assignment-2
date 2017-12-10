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
import utils.FileLogger;
import utils.Serializer;

public class MoviesAPI implements MoviesInterFace

{

	private Serializer serializer;

	private Map<Long, User> userIndex = new HashMap<>();
	private Map<Long, Movies> moviesIndex = new HashMap<>();
	private Map<String, User> fNameIndex = new HashMap<>();
	private Map<Long, Rating> ratingIndex = new HashMap<>();
	Optional<User> currentUser;
	
	
	public MoviesAPI() {
	}

	public MoviesAPI(Serializer serializer) {
		this.serializer = serializer;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		serializer.read();
		userIndex = (Map<Long, User>) serializer.pop();
		moviesIndex = (Map<Long, Movies>) serializer.pop();
		ratingIndex = (Map<Long, Rating>) serializer.pop();
		
	}
	
	
	@Override
	public void store() throws Exception {
		serializer.push(ratingIndex);
		serializer.push(moviesIndex);
		serializer.push(userIndex);	
		serializer.write();
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getUsers()
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getUsers()
	 */
	@Override
	public Collection<User> getUsers() {
		return userIndex.values();
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#deleteUsers()
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#deleteUsers()
	 */
	@Override
	public void deleteUsers() {
		userIndex.clear();
		fNameIndex.clear();
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#createUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#createUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public User createUser(String fName, String lName, String age, String gender, String job , String role  ) {
		User user = new User(fName, lName, age, gender, job, role);
		userIndex.put(user.UserId, user);
		fNameIndex.put(fName, user);
		return user;
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getUserByfName(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getUserByfName(java.lang.String)
	 
	@Override
	public User getUserByfName(String fName) {

		return fNameIndex.get(fName);
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getUser(java.lang.Long)
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getUser(java.lang.Long)
	 */
	@Override
	public User getUser(Long id) {
		return userIndex.get(id);
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#deleteUser(java.lang.Long)
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#deleteUser(java.lang.Long)
	 */
	@Override
	public void deleteUser(Long id) {
		User user = userIndex.remove(id);
		fNameIndex.remove(user.fName);
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#createRating(java.lang.Long, java.lang.Long, double)
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#createRating(java.lang.Long, java.lang.Long, double)
	 */
	@Override
	public Rating createRating(Long userID, Long movieID, double ratingLeft) {
		Optional<Movies> movies = Optional.fromNullable(moviesIndex.get(movieID));
		if (movies.isPresent()) {
			movies.get().movie.add(new Rating(userID, movieID, ratingLeft));
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getRating(java.lang.Long)
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getRating(java.lang.Long)
	 */
	@Override
	public Rating getRating(Long id) {
		return ratingIndex.get(id);
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#addMovie(long, java.lang.String, java.lang.String, java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#addMovie(long, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Movies addMovie(long id, String name, String date, String link) {
		Movies movies = null;
		Optional<User> user = Optional.fromNullable(userIndex.get(id));
		if (user.isPresent()) {
			movies = new Movies(name, date, link);
			user.get().movies.put(movies.MovieId, movies);
			moviesIndex.put(movies.MovieId, movies);
		}
		return movies;
	}
	
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getMovies()
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getMovies()
	 */
	@Override
	public Collection<Movies> getMovies() {
		return moviesIndex.values();
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getMovie(java.lang.Long)
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getMovie(java.lang.Long)
	 */
	@Override
	public Movies getMovie(Long id) {
		return moviesIndex.get(id);
	}

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getMovieByTitle(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getMovieByTitle(java.lang.String)
	 */
	

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#initalLoad()
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#initalLoad()
	 */

	
	@Override
	public void initalLoad() throws IOException {
		String delims = "[|]";
		Scanner scanner = new Scanner(new File("./data/users5.dat"));
		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
			// parse user details string
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 7) {
				createUser(userTokens[1], userTokens[2], userTokens[3], userTokens[4], userTokens[5], userTokens[6]);
			} else {
				scanner.close();
				throw new IOException("Invalid member length: " + userTokens.length);
			}
		}
		
		scanner = new Scanner(new File("./data/items5.dat"));
		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
			// parse user details string
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 23) {
				addMovie(0, userTokens[1], userTokens[2], userTokens[3]);
			} else {
				scanner.close();
				throw new IOException("Invalid member length: " + userTokens.length);
			}
		}
		
		scanner = new Scanner(new File("./data/ratings5.dat"));
		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
			// parse user details string
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 4) {
				addMovie(0, userTokens[1], userTokens[2], userTokens[3]);
			} else {
				scanner.close();
				throw new IOException("Invalid member length: " + userTokens.length);
			}
		}
		scanner.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// simplified login method
	  /* (non-Javadoc)
	 * @see controllers.MoviesInterFace#login(java.lang.Long, java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#login(java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean login(Long UserId, String lName) {
		Optional<User> user = Optional.fromNullable(userIndex.get(UserId));
	    if (user.isPresent() && user.get().lName.equals(lName)) {
	      currentUser = user;    
	      return true;
	    }
	    return false;
	  }
	
	
	
	  
	  // simplified and generalized version of my logout method
	  /* (non-Javadoc)
	 * @see controllers.MoviesInterFace#logout()
	 */
	
	@Override
	public void logout() {
	    Optional<User> user = currentUser;
	    if (user.isPresent()) {
	      FileLogger.getLogger().log(currentUser.get().fName + " logged out...");
	      currentUser = Optional.absent();
	    }
	  }

	@Override
	public User getUserByfName(String fName) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}