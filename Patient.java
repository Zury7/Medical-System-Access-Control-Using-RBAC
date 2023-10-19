/*This is the class of Patient who inherited from User abstract class
*....... */
public class Patient extends User {
    
    /*Within the constructor, initial states for nickname and birthday are assigned.
    *States of username, hashed_password, category, email are referred to the parent class's states via super keyword*/
    public Patient(String username,String hashed_password,String category, int access_level){ 
        super(username, hashed_password, category, access_level);
    }
}