package Level1Task1;

import java.util.Scanner;
import java.util.HashMap;

public class Online_Rerservation_System {
	
	private static HashMap<String, String> users= new HashMap<>();
	private static HashMap<Integer, Reservation>reservations = new HashMap<>();
	private static int nextPNR = 987654;
 
	public static void main(String[]args) {
		users.put("Mustafa", "9949");
		users.put("user2", "password2");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Online Reservation System");
			System.out.println();
			System.out.println("1. Login");
			System.out.println("2. Exit");
			System.out.println();
			System.out.print("Choose an option: ");
			int choice = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch(choice) {
			case 1:
				login();
				break;
			case 2:
				System.out.println("GoodBye..!");
				System.exit(0);
			default:
					System.out.println("Invalid choice ..?..Please try agin");	
			}
		}
	}
  private static void login() {
	  Scanner input = new Scanner(System.in);
		System.out.print("Enter your username: ");
		String username = input.nextLine();
		
		System.out.print("Enter your password: ");
		String password= input.nextLine();
		
		if(users.containsKey(username)&& users.get(username).equals(password)){
			System.out.println("Login Successful");
			showReservationMenu(input);
		}else {
			System.out.println("Login failed.Invalid username or password");
		}
	}
  private static void showReservationMenu(Scanner input) {
		while(true) {
			System.out.println("\nReservation Menu");
			System.out.println("1. Make a Reservation");
			System.out.println("2. Cancel a Reservation");
			System.out.println("3. Logout");
			System.out.print("Choose an option");
			int choice = input.nextInt();
			input.nextLine();
			
			switch(choice) {
			case 1:
				makeReservation(input);
				break;
			case 2:
				cancelReservation(input);
				break;
			case 3:
				return;
				default:
		               System.out.println("Invalid choice..?..Please try agin");
		}
      }
	}
  private static void makeReservation(Scanner input) {
		
		System.out.print("Enter your Name");
		String name = input.nextLine();
		
		System.out.print("Enter your contact inforamation");
		String contactInfo = input.nextLine();
		
		System.out.print("Enter the train name");
		int trainNumber= input.nextInt();
		input.nextLine();
		
		System.out.print("Enter the departure place");
		String departurePlace = input.nextLine();
		
		System.out.print("Enter the destination");
		String destination = input.nextLine();
		
		Reservation reservation = new Reservation(name, contactInfo, trainNumber, departurePlace, destination); 
		reservations.put(nextPNR, reservation);
		System.out.println("Reservation successful Your PNR Number");
		nextPNR++;
	}
  private static void cancelReservation(Scanner input) {
		System.out.print("Enter youur PNR Number");
		int pnr = input.nextInt();
		input.nextLine();
			
		if(reservations.containsKey(pnr)) {
		  Reservation reservation = reservations.get(pnr);
		  System.out.println("Reservation deatils");
		  System.out.println("reservation.toString");
		  System.out.print("Confirm cancellation (yes/no):..");
	      String confirmation = input.nextLine().toLowerCase();
			     
		   if(confirmation.equals("yes")) {
		    reservations.remove(pnr);
			System.out.println("Reservation cancled successfully..");
			}else {
			System.out.println("Cancellation not confirmed");
		    }
			}else {
			System.out.println("Invalid PNR number Please try agin");
		      }
			}
		}

  class Reservation{
		private String name;
		private String contactInfo;
		private int trainNumber;
		private String departureplace;
		private String destination;
		
		public Reservation(String name, String contactInfo, int trainNumber, String departureplace, String destination) {
			
			this.name = name;
			this.contactInfo = contactInfo;
			this.trainNumber = trainNumber;
			this.departureplace = departureplace;
			this.destination = destination;
		}
  public String toString() {
			return "Name: " + name + "\nContact Information: " + contactInfo
		                + "\nTrain Number: " + trainNumber + "\nDeparture Place: " + departureplace
		                + "\nDestination: " + destination;
			}
		}
