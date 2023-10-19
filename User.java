/*This is the abstract class of the user.
*The username, MD5 hashed password and Access level of the user is defined here since these two
* states are common to the all 3 types of users.*/

abstract class User {
private String username;
private String hashed_password;
private String category;
private int access_level;
//Within the constructor,initial state assignments are defined.
public User(String username,String hashed_password,String category, int access_level) {
this.username = username;
this.hashed_password = hashed_password;
this.category = category;
this.access_level = access_level;
}
//getter method for username
public String getUsername () {
return this.username;
}
//getter method for hashed password
public String getHashed_password() {
return this.hashed_password;
}
//getter method for category    
public String getCategory() {
return this.category;
}
//getter method for access level 
public int getAccess_level() {
return this.access_level;
}
}
