package assign;

import java.util.*;

public class Employer extends User {

	public Employer(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	int choice;
		Scanner input = new Scanner(System.in);
		try {
			do {
				System.out.println("Welcome to Employer System");
				System.out.println("** Employer Menu **\n" + "1. Create Offer\n" + "2. Search and View Applicants\n"
						+ "3. Set Interview Time\n" + "4. Update Interview Outcome\n" + "5. Complaint\n" + "6. Log Out\n");
				System.out.print("Enter your choice\n");
				choice = input.nextInt();
				switch (choice) {
				case 6:
					System.out.println("Thank You! You have logged out of the system");
					break;
				case 1:
					createOffer();
					break;
				case 2:
					searchApplicant();
					break;
				case 3:
					setInterview();
					break;
				case 4:
					interviewOutcome();
					break;
				case 5:
					complaint();
					break;
				default:
					System.out.println("Invalid option please try again and choose between 1 to 6");
					break;
				}
			} while (!(choice <= 6));
		} catch (InputMismatchException e) {
			System.out.println("Please enter an integer value");
		}
	private static void interviewOutcome() {

	}

	private static void setInterview() {

	}

	private static void searchApplicant() {
		String s1 = auser.getType;
		String s2 = offer.getType;
		if(s1.equalsto(s2))
			System.out.println(auser.getUsername);
	}

	private static void createOffer() {
		
	}
	
	private static void complaint() {
	
	}

}
