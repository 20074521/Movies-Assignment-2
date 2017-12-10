package controllers;

import com.google.common.base.Optional;

import asg.cliche.Command;
import asg.cliche.Param;
import model.Rating;
import model.User;

public class DefaultMenu {

		  private String name;
		  private User user;
		  private MoviesInterFace moApi;

		  public DefaultMenu(MoviesInterFace moApi, User user) {
		    this.moApi = moApi;
		    this.setName(user.fName);
		    this.user = user;
		  }
		  
		  
		  @Command(description="Save File")
			public void save() throws Exception {
				moApi.store();
			}
		  
		  
		  @Command(description = "Get a Users detail")
			public void getUser(@Param(name = "first name") String fName) {
				User user = moApi.getUserByfName(fName);
				System.out.println(user);
			}
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
		  public void setName(String userName) {
		    this.name = userName;
		  }
		}

