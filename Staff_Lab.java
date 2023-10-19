/*This is the class of Staff_Lab who inherited from User abstract class
*....... */
public class Staff_Lab extends User {
    
    /*Within the constructor, initial states for nickname and birthday are assigned.
    *States of username, hashed_password, category, email are referred to the parent class's states via super keyword*/
    public Staff_Lab(String username,String hashed_password,String category, int access_level){ 
        super(username, hashed_password, category, access_level);
    }

    public void display_Staff_LabAccess() {
        System.out.println("Lab Test Prescriptions:"+Patientdatalog.getLab_test_prescription());
    }

  
}
