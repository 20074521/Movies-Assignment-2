package controllers;

import java.io.IOException;
import java.util.Collection;

import model.Movies;
import model.Rating;
import model.User;

public interface MoviesInterFace {

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#load()
	 */
	void load() throws Exception;

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getUsers()
	 */
	Collection<User> getUsers();

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#deleteUsers()
	 */
	void deleteUsers();

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#createUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	User createUser(String fName, String lName, String age, String gender, String job , String role);

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getUserByfName(java.lang.String)
	 */
	User getUserByfName(String fName);

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getUser(java.lang.Long)
	 */
	User getUser(Long id);

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#deleteUser(java.lang.Long)
	 */
	void deleteUser(Long id);

	
	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getRating(java.lang.Long)
	 */
	Rating getRating(Long id);

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#addMovie(long, java.lang.String, java.lang.String, java.lang.String)
	 */
	Movies addMovie(long id, String name, String date, String link);

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getMovies()
	 */
	Collection<Movies> getMovies();

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#getMovie(java.lang.Long)
	 */
	Movies getMovie(Long id);

	
	

	/* (non-Javadoc)
	 * @see controllers.MoviesInterFace#initalLoad()
	 */
	void initalLoad() throws IOException;

	// simplified login method
	/* (non-Javadoc)
	* @see controllers.MoviesInterFace#login(java.lang.Long, java.lang.String)
	*/
	boolean login(Long UserId, String password);

	// simplified and generalized version of my logout method
	/* (non-Javadoc)
	* @see controllers.MoviesInterFace#logout()
	*/
	void logout();

	void store() throws Exception;

	     

	Rating createRating(Long userID, Long movieID, double ratingLeft);

	

	

}