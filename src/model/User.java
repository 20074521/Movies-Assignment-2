package model;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

import model.Rating;


public class User implements Comparable<User> {
	
 
public String fName, lName, Age, Gender, Job ;
 public String role;
 public long UserId;
 public static Long counter = (long) 01;
public Map<Long, Rating> TheRating = new HashMap<>();
 
 public Map<Long , Movies> movies = new HashMap<Long , Movies>();
 
 
 /*public User(String fName, String lName, String age, String gender, String job)
 {
   this(fName,lName, age, gender, job, "default");
 }*/
 


public User(String fName, String lName, String age, String gender, String job , String role) {
	
	this.fName = fName;
	this.lName = lName;
	this.Age = age;
	this.Gender = gender;
	this.Job = job;
	this.role = role;
	
	
	this.UserId = counter++ ;
}

@Override
public String toString()
{
  return toStringHelper(this).addValue(fName)
                             .addValue(lName)
                             .addValue(Age)
                             .addValue(Gender)   
                             .addValue(Job) 
                             .addValue(role)
                            
                             .addValue(UserId) 
                             .toString();
}


@Override  
public int hashCode()  
{  
   return Objects.hashCode(this.fName, this.lName, this.Age, this.Gender , this.Job , this.role);  
}

@Override  
public boolean equals(final Object obj)
{
	if (obj instanceof User)
	{
		final User other = (User) obj;
		return Objects.equal(fName, other.fName)
				&& Objects.equal(lName, other.lName)
				&& Objects.equal(Age, other.Age)
				&& Objects.equal(Gender, other.Gender)
				&& Objects.equal(Job, other.Job)
				&& Objects.equal(UserId, other.UserId);
	}
	else
	{
		return false;
	}
}

@Override
public int compareTo(User user) 
{
	return this.lName.compareTo(user.lName);
}

	}
