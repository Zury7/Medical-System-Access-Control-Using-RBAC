import java.util.*;
import java.io.*;
import java.lang.*;
import java.time.*;
/*This is the CLI class to control the Medical System Acess Control simulation*/
class Terminal {
public static void main(String[] args) throws FileNotFoundException, IOException {
/*Create objects of the entities described at configuration file */

ConfigurationFile_handler configurationFile_handler = new ConfigurationFile_handler();
configurationFile_handler.readConfigurationFile();
System.out.println("Initialization process is completetd ! \n");



/*Authentication process*/
Scanner scanner = new Scanner(System.in);
System.out.println("Please enter your username: ");
String username = scanner.nextLine();
System.out.println("Please enter your password: ");
String password = scanner.nextLine();

/*The user is authenticated by calling the authenticateUser() method*/
configurationFile_handler.authenticateUser(username, password);


}
}