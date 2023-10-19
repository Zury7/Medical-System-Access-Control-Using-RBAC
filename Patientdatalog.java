import java.util.ArrayList;
import java.util.List;
public class Patientdatalog {
    private static  String username;
    private static String personal_details;
    private static String sickness_details;
    private static String drug_prescriptions;
    private static String lab_test_prescription;

    private static List<Patientdatalog> Patientdatalogs = new ArrayList<Patientdatalog>();
    public static List getPatientdatalogsList() {
        return Patientdatalogs;
    }

    public Patientdatalog(String username, String personal_details, String sickness_details, String drug_prescriptions, String lab_test_prescription) {
        Patientdatalog.username = username;
        Patientdatalog.personal_details = personal_details;
        Patientdatalog.sickness_details = sickness_details;
        Patientdatalog.drug_prescriptions = drug_prescriptions;
        Patientdatalog.lab_test_prescription = lab_test_prescription;
    }

    public static String getUsername() {
        return username;
    }
    public static String getPersonal_details() {
        return personal_details;
    }
    public static String getSickness_details() {
        return sickness_details;
    }
    public static String getDrug_prescriptions() {
        return drug_prescriptions;
    }
    public static String getLab_test_prescription() {
        return lab_test_prescription;
    }
}
