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
}
else if (active_user_AL == 1){
    System.out.println("Welcome to the Medical System Laboratory Staff Access Portal !");
}
else if (active_user_AL == 2){
    System.out.println("Welcome to the Medical System Nurse Staff Access Portal !");
}
else if (active_user_AL == 3){
    System.out.println("Welcome to the Medical System Medical Officer Staff Access Portal !");
}
else if (active_user_AL == 4){
    System.out.println("Welcome to the Medical System Administrator Access Portal !");
}


}
}
