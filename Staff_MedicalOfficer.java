/*This is the class of Staff_MedicalOffcier who inherited from User abstract class
*....... */
public class Staff_MedicalOfficer extends User {
    
    /*Within the constructor, initial states for nickname and birthday are assigned.
    *States of username, hashed_password, category, email are referred to the parent class's states via super keyword*/
    public Staff_MedicalOfficer(String username,String hashed_password,String category, int access_level){ 
        super(username, hashed_password, category, access_level);
    }

    public void display_Staff_MedicalOfficerAccess(){
        System.out.println("Personal Details:"+Patientdatalog.getPersonal_details());
        System.out.println("Sickness Details:"+Patientdatalog.getSickness_details());
        System.out.println("Drug Prescriptions:"+Patientdatalog.getDrug_prescriptions());
        System.out.println("Lab Test Prescriptions:"+Patientdatalog.getLab_test_prescription());
    }
}