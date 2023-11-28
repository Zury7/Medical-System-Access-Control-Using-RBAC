import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Controller {
    String userList_filePath = "Configuration.txt";
    String patientdata_filePath = "Patientdata.txt";

    /*This method is used to read the configuration file and store the data in the ArrayList objects*/
    public void readConfigurationFile() throws FileNotFoundException, IOException {
        /*The file is read using FileReader and BufferedReader objects*/
        FileReader fr = new FileReader(userList_filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        /*The file is read line by line and each line is split into tokens using the split() method*/
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");
            
            /*The third token is used to determine the type of the object to be created*/
            if (tokens[2].equals("patient")) {
                /*A Patient object is created and added to the ArrayList*/
                Patient patient = new Patient(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                Globals.getPatientsList().add(patient);
                
            /*The third token  and fourth token is used to determine the type of the Staffobject to be created*/
            } else if (tokens[2].equals("staff")){
                if (tokens[3].equals("0")) {
                    Staff_Lab staff_lab = new Staff_Lab(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                    Globals.getStaff_LabList().add(staff_lab);}
                else if (tokens[3].equals("1")) {
                    Staff_Nurse staff_nurse = new Staff_Nurse(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                    Globals.getStaff_NurseList().add(staff_nurse);}
                else if (tokens[3].equals("2")) {
                    Staff_MedicalOfficer staff_medicalOfficer = new Staff_MedicalOfficer(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                    Globals.getStaff_MedicalOfficerList().add(staff_medicalOfficer);}
            }
        }
        /*The file is closed*/
        br.close();
    }

    /*This method is used to authenticate the user using username and password*/
    public String authenticateUser(String username, String hashed_password) {
        /*Generate the MD5 hashed value of user provided password input*/
        String passwordToHash = hashed_password;
        String generatedPassword = null;
        String activeUser = null;
        
        
        try 
        {
        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Add password bytes to digest
        md.update(passwordToHash.getBytes());

        // Get the hash's bytes
        byte[] bytes = md.digest();

        // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        // Get complete hashed password in hex format
        generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        /*The generated MD5 hashed value is compared with the stored MD5 hashed value*/
        int authbit = 0;
        
        List <Patient> Patients = Globals.getPatientsList();
        for (Patient patient : Patients) {
            if (patient.getUsername().equals(username) && patient.getHashed_password().equals(generatedPassword)) {
                System.out.println("Patient: "+username+" is authenticated");
                activeUser = username;
                authbit = 1;
            
            }
        }
        List <Staff_Lab> Staff_Lab = Globals.getStaff_LabList();
        for (Staff_Lab staff_lab : Staff_Lab) {
            if (staff_lab.getUsername().equals(username) && staff_lab.getHashed_password().equals(generatedPassword)) {
                System.out.println("Staff_Lab: "+username+" is authenticated");
                activeUser = username;
                authbit = 1;
                
            }
        }
        List <Staff_Nurse> Staff_Nurse = Globals.getStaff_NurseList();
        for (Staff_Nurse staff_nurse : Staff_Nurse) {
            if (staff_nurse.getUsername().equals(username) && staff_nurse.getHashed_password().equals(generatedPassword)) {
                System.out.println("Staff_Nurse: "+username+" is authenticated");
                activeUser = username;
                authbit = 1;    
               
            }
        }
        List <Staff_MedicalOfficer> Staff_MedicalOfficer = Globals.getStaff_MedicalOfficerList();
        for (Staff_MedicalOfficer staff_medicalOfficer : Staff_MedicalOfficer) {
            if (staff_medicalOfficer.getUsername().equals(username) && staff_medicalOfficer.getHashed_password().equals(generatedPassword)) {
                System.out.println("Staff_MedicalOfficer: "+username+" is authenticated");
                activeUser = username;
                authbit = 1;
                
            }
        }
        if (authbit == 0) {
            System.out.println("Authentication failed");
        }
        return activeUser;
    }

    public int getActiveUserAccessLevel(String activeUser) {
        int accessLevel = 0;
        List <Patient> Patients = Globals.getPatientsList();
        for (Patient patient : Patients) {
            if (patient.getUsername().equals(activeUser)) {
                accessLevel = patient.getAccess_level();
            }
        }
        List <Staff_Lab> Staff_Lab = Globals.getStaff_LabList();
        for (Staff_Lab staff_lab : Staff_Lab) {
            if (staff_lab.getUsername().equals(activeUser)) {
                accessLevel = staff_lab.getAccess_level();
            }
        }
        List <Staff_Nurse> Staff_Nurse = Globals.getStaff_NurseList();
        for (Staff_Nurse staff_nurse : Staff_Nurse) {
            if (staff_nurse.getUsername().equals(activeUser)) {
                accessLevel = staff_nurse.getAccess_level();
            }
        }
        List <Staff_MedicalOfficer> Staff_MedicalOfficer = Globals.getStaff_MedicalOfficerList();
        for (Staff_MedicalOfficer staff_medicalOfficer : Staff_MedicalOfficer) {
            if (staff_medicalOfficer.getUsername().equals(activeUser)) {
                accessLevel = staff_medicalOfficer.getAccess_level();
            }
        }
        return accessLevel;
    }

    public void readPatientdataFile() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(patientdata_filePath);
        BufferedReader br = new BufferedReader(fr);
        String lline;
        while ((lline = br.readLine()) != null) {
            String[] tokens = lline.split(",");
            Patientdatalog patientdatalog = new Patientdatalog(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
            Globals.getPatientdatalogsList().add(patientdatalog);
        }
        br.close();

        List <Patientdatalog> patientdatalogs = Globals.getPatientdatalogsList();
        System.out.println(patientdatalogs.size());
        System.out.println(patientdatalogs.get(2).getUsername());
        // for (Patientdatalog log : patientdatalogs) {
        //      System.out.println(log.getPersonal_details()); // Example: print each log
        // }
        
    }
    // List<Patientdatalog> patientdatalogs = Patientdatalog.getPatientdatalogsList();
    // for (Patientdatalog patientdatalog : patientdatalogs) {
    //     System.out.println(Patientdatalog.getUsername());
    //     }
}
