# Assignment 2 - Movie Recommender.

Name: ... andrew cullen 20074521 ...

## Overview.
...... A short statement of the concept and objectives ........


## Functionality
 . . . . . List of the functional features you implemented from the specification . . . .

 + implement cliche commands
 + implement log in 
 + have sub menus for default and admin users
 + have certin methods for admin and default users
 + etc

## Installation requirements
. . . .  List of software, libraries and tools used (hint: everything on your build path libraries ) . . . . . . .
+ Java JRE v1.8
+ Guava v0.1
+ cliche
+ xstream-1.4.10

## Getting started
. . . . . . i started off by creating a movie class with all he nessary variables to match the data file we were supplied 
the same for users and ratings 
once i had that done i started on my main menu which i used a switch statement in the menu but then changed it out for cliche that made it easier to 
implement sub menus then i started to code in sub menus i found this tricky and could only get it to work by hard coding in the admin users and setting the rest of the users to default 

>The project comes with data in CSV format that can be used to prime the application with initial data.
- In the CLI, execute the prime command to import data from the CSV movie files:
```
The Cliche Movie Shell
Enter ?l to list available commands.
Movies> ?list
abbrev	name	params
li	log-in	(user name, password)
p	prime	()
Movies> p
Movies>
```
- Log in as the administrator user (leonard@simpson.com)
```
Movies> li leonard@simpson.com secret
You are logged in as leonard@simpson.com
Admin
Movies/Leonard>
```

## Data Model Design.

Describe the program's data model (see example below) AND/OR a sample of the data used (XML, JSON or equivalent).

![][image1]

Use meaningful sample data from your program.

## Examples

. . . . . Examples of program's user interface (e.g. CLI)  (see example below) with appropriate captions (user regeneration and login views, if implemented, can be omitted) . . . . . . .

- Get top ten movies
```
Movies/Leonard> gttm
Movie{1, Toy Story (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Toy%20Story%20(1995), 3}
Movie{8, Babe (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Babe%20(1995), 3}
Movie{10, Richard III (1995), 22-Jan-1996, http://us.imdb.com/M/title-exact?Richard%20III%20(1995), 2}
Movie{3, Four Rooms (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Four%20Rooms%20(1995), 1}
Movie{6, Shanghai Triad (Yao a yao yao dao waipo qiao) (1995), 01-Jan-1995, http://us.imdb.com/Title?Yao+a+yao+yao+dao+waipo+qiao+(1995), 1}
Movie{7, Twelve Monkeys (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Twelve%20Monkeys%20(1995), 1}
Movie{2, GoldenEye (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?GoldenEye%20(1995), 0}
Movie{4, Get Shorty (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Get%20Shorty%20(1995), -1}
Movie{9, Dead Man Walking (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Dead%20Man%20Walking%20(1995), -2}
Movie{5, Copycat (1995), 01-Jan-1995, http://us.imdb.com/M/title-exact?Copycat%20(1995), -3}
```

- Getting movie recommendations for Gregory (test data):
```
Movies/Gregory> gur
Movie{10, Richard III (1995), 22-Jan-1996, http://us.imdb.com/M/title-exact?Richard%20III%20(1995), 2}
Movie{6, Shanghai Triad (Yao a yao yao dao waipo qiao) (1995), 01-Jan-1995, http://us.imdb.com/Title?Yao+a+yao+yao+dao+waipo+qiao+(1995), 1}
Movies/Gregory>
```


## Independent learning.

. . . . . State what you learned that was not covered in class or labs . . . .  



[image1]: ./model.png
