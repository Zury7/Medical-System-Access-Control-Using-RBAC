/*This is the class of Patient who inherited from User abstract class
*....... */
import java.util.ArrayList;
import java.util.List;
public class Patient extends User {
    private static List<Patient> Patients = new ArrayList<Patient>();
    public static List getPatientsList() {
        return Patients;
    }
    
    /*Within the constructor, initial states for nickname and birthday are assigned.
    *States of username, hashed_password, category, email are referred to the parent class's states via super keyword*/
    public Patient(String username,String hashed_password,String category, int access_level){ 
        super(username, hashed_password, category, access_level);
    }

    public static void display_PatientAcess() {
        System.out.println("Personal Details:"+Patientdatalog.getPersonal_details());
        System.out.println("Sickness Details:"+Patientdatalog.getSickness_details());
        System.out.println("Drug Prescriptions:"+Patientdatalog.getDrug_prescriptions());
        System.out.println("Lab Test Prescriptions:"+Patientdatalog.getLab_test_prescription());
    }
}