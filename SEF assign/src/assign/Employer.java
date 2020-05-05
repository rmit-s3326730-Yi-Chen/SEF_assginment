package assign;

import java.time.LocalDate;
import java.util.*;

public class Employer extends SystemUser {

	public Employer(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	private ArrayList<JobOffer> offers = new ArrayList<>();

	Scanner input = new Scanner(System.in);
	int choice;


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
