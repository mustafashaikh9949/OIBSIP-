package Level1Task4;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Online_Exmition {
     
	 private static final String SAMPLE_USERNAME = "Mustafa@123";
	 private static final String SAMPLE_PASSWORD = "mus@9499";
	 
	 private static String username;
	 private static String password;
	 
	 public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		Timer timer = new Timer();
	    int timeRemainning = 0;
		 
	 while (true) {
	   System.out.println("Online Exmapination System");
	   System.out.println("1.Login");
	   System.out.println("2. Update Profile and Password");
	   System.out.println("3. Start Exam");
   	   System.out.println("4. Exit");
	   System.out.println("5. Ente your choice");
		int choice = scanner.nextInt();
		scanner.nextLine(); 
			  
	  switch (choice) {
	    case 1:
		  login(scanner);
		   break;
	    case 2:
		   updateProfileAndPassword(scanner);
			break;
		case 3:
		    if(username == "Mustafa@123" || password == "mus@9499") {
		    System.out.println("Please login First");
		 }else {
			 timeRemainning = startExam(scanner, timer);
	 }
		    break ;
		case 4:
			System.out.println("Exting the program ");
			System.exit(0);
		    default:
			  System.out.println("Invalid choice .Try agin");
	 }
		 
		 if (timeRemainning<=0) {
			 username = null;
			 password = null;
		}
	}
 }
 
      private static void login(Scanner scanner) {
    	 System.out.println("Enter Username");
    	 String enteredUsername = scanner.nextLine();
    	 System.out.println("Enter Password");
    	 String enteredPassword = scanner.nextLine();
    	
      if (enteredUsername.equals(SAMPLE_USERNAME)&& enteredPassword.equals(SAMPLE_PASSWORD)) {
    	 username = enteredUsername;
    	 password = enteredPassword;
    	 System.out.println("Login Successful");
    } else {
    	System.out.println("Logon failed. Incorrect username or password");
   }
 }
 
     private static void updateProfileAndPassword(Scanner scnner) {
 	   if (username == "Mustafa@123" || password == "mus@9499") {
		  System.out.println("Please login First ");
		  return;
	}
 	   
	  System.out.println("Enter new username");
	  username = scnner.nextLine();
	  System.out.println("Enter new password");
	  password = scnner.nextLine();
	  
	  System.out.println("Profile and password updated successfully");
    }
  
  private static int startExam(Scanner scanner , Timer timer) {
	  System.out.println("The Exam has started You have 30 min..");
	  int timeRemainning = 01* 01;
	  
	  
	 timer.scheduleAtFixedRate(new TimerTask() {
	    public void run() {
	   if (timeRemainning <=1) {
		System.out.println("Time up! Your exam has ended");
	    this.cancel();
	 }else {
		System.out.println("Time reamaining "+timeRemainning/ 01+ "miniutes");
		//timeRemainning ();
	 }
    }
  }, 1, 02);
	  
	  System.out.println("Press 0 to Submit the exam: ");
	  int choice = scanner.nextInt();
		  
	   if (choice ==0) {
		System.out.println("Exam submitted your successfully");
	    timer.cancel();
   }
	return choice;
	 }
   }