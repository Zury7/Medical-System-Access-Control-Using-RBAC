import java.util.*;
import java.io.*;
import java.lang.*;
import java.time.*;
 
/*This is the CLI class to control the Medical System Acess Control simulation*/
class Terminal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
/*Create objects of the entities described at configuration file */

Controller controller = new Controller();
controller.readConfigurationFile();
System.out.println("Initialization process is completetd ! \n");



/*Authentication process*/
Scanner scanner = new Scanner(System.in);
System.out.println("Please enter your username: ");
String username = scanner.nextLine();
System.out.println("Please enter your password: ");
String password = scanner.nextLine();

/*The user is authenticated by calling the authenticateUser() method*/
String active_user = controller.authenticateUser(username, password);

int active_user_AL = controller.getActiveUserAccessLevel(active_user);

controller.readPatientdataFile();

if (active_user_AL == 0){
    System.out.println("Welcome to the Medical System Patient Access Portal !");
    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Choose your option to proceed with:");
    System.out.println(" 1: View my Personal Details");
    System.out.println(" 2: Edit my Personal Details");
    System.out.println(" 3: View my Sick Details ");
    System.out.println(" 4: View my Drug Prescriptions");
    System.out.println(" 5: View my Lab Report Prescriptions");
    String input = scanner1.nextLine();
}
else if (active_user_AL == 1){
    System.out.println("Welcome to the Medical System Laboratory Staff Access Portal !");
    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Choose your option to proceed with:");
    System.out.println(" 1: View A Pateint's Sickness Details");
    System.out.println(" 1: View A Pateint's Lab Report Prescription Details");
    String input = scanner1.nextLine();
   
}
else if (active_user_AL == 2){
    System.out.println("Welcome to the Medical System Nurse Staff Access Portal !");
    System.out.println("Choose your option to proceed with:");
    System.out.println(" 1: View A Pateint's Perosnal Details");
    System.out.println(" 2: View A Patient's Sickness Details");
    System.out.println(" 3: Edit A Patient's Sickness Details");
    System.out.println(" 4: View A Patient's Drug Prscriptions");
    System.out.println(" 5: View A Patient's Lab Report Prescriptions");
}
else if (active_user_AL == 3){
    System.out.println("Welcome to the Medical System Medical Officer Staff Access Portal !");
    System.out.println("Choose your option to proceed with:");
    System.out.println(" 1: View A Pateint's Perosnal Details");
    System.out.println(" 2: View A Patient's Sickness Details");
    System.out.println(" 3: Edit A Patient's Sickness Details");
    System.out.println(" 4: View A Patient's Drug Prscriptions");
    System.out.println(" 5: Edit A Patient's Drug Prscriptions");
    System.out.println(" 6: View A Patient's Lab Report Prescriptions");
    System.out.println(" 7: Edit A Patient's Drug Prscriptions");
}
else if (active_user_AL == 4){
    System.out.println("Welcome to the Medical System Administrator Access Portal !");
    System.out.println("Choose your option to proceed with:");
    System.out.println(" 1: View A Pateint's Perosnal Details");
    System.out.println(" 2: Edit A Pateint's Perosnal Details");
    System.out.println(" 2: View A Patient's Sickness Details");
    System.out.println(" 3: Edit A Patient's Sickness Details");
    System.out.println(" 4: View A Patient's Drug Prscriptions");
    System.out.println(" 5: Edit A Patient's Drug Prscriptions");
    System.out.println(" 6: View A Patient's Lab Report Prescriptions");
    System.out.println(" 7: Edit A Patient's Drug Prscriptions");
}
}
}
