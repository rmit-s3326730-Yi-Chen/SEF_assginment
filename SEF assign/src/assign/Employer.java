package assign;

import java.util.*;

public class Employer extends SystemUser {

	public Employer(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	private ArrayList<JobOffer> offers = new ArrayList<>();

	Scanner input = new Scanner(System.in);
	int choice;

	public void DisplayMenu() {
		int choice;
		try {
			do {
				System.out.println("Welcome to Employer System");
				System.out.println("** Employer Menu **\n" + "1. Create Offer\n" + "2. Search and View Applicants\n"
						+ "3. Set Interview Time\n" + "4. Update Interview Outcome\n" + "5. Complaint\n"
						+ "6. Log Out\n");
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

	}

	private void complaint() {

	}

	private void interviewOutcome() {

	}

	private void setInterview() {

	}

	private void searchApplicant() {
		for (int i = 0; i < offers.size(); ++i) {
			JobOffer offer = offers.get(i);
			Type s1 = offer.getOfferType();
		}//in progress search by type
		
		for (int i = 0; i < offers.size(); ++i) {
			JobOffer offer = offers.get(i);
			Status s2 = offer.getStatus();
		}//in progress search by status when offer is available

	}

	private void createOffer() {
		String title, description;
		double wage;
		Type offertype;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the details of the job");
		System.out.println("Title: ");
		title = input.nextLine();
		System.out.println("Description: ");
		description = input.nextLine();
		System.out.println("Wage per hour: ");
		wage = input.nextDouble();
		System.out.println("Applicant type required for the offer: ");
		offertype = Type.valueOf(input.nextLine());
		JobOffer offer = new JobOffer(title, description, wage, offertype);
		offers.add(offer);

	}
}
