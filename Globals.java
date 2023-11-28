import java.util.ArrayList;
import java.util.List;

public class Globals {
    private static String keyword;
    public static void setKeyword(String keyword) {
        Globals.keyword = keyword;
    }
    public static String getKeyword() {
        return keyword;
    }

    private static List<Patient> Patient  = new ArrayList<Patient>();
    public static List getPatientsList() {
        return Patient;
    }

    private static List<Staff_Lab> Staff_Lab  = new ArrayList<Staff_Lab>();
    public static List getStaff_LabList() {
        return Staff_Lab;
    }

    private static List<Staff_Nurse> Staff_Nurse = new ArrayList<Staff_Nurse>();
    public static List getStaff_NurseList() {
        return Staff_Nurse;
    }

    private static List<Staff_MedicalOfficer> Staff_MedicalOfficer = new ArrayList<Staff_MedicalOfficer>();
    public static List getStaff_MedicalOfficerList() {
        return Staff_MedicalOfficer;
    }

    private static List<Patientdatalog> Patientdatalogs = new ArrayList<Patientdatalog>();
    public static List getPatientdatalogsList() {
        return Patientdatalogs;
    }
    
    


    
}
