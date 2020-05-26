package assign;

import java.util.ArrayList;
import java.util.Scanner;

import exception.MultipleOfferException;
import exception.NoApplicantException;

public class Employer extends SystemUser {

	private ArrayList<JobOffer> offers = new ArrayList<JobOffer>();
	private ArrayList<Interview> interviews = new ArrayList<Interview>();
	static transient Scanner scan = new Scanner(System.in);

	public Employer(String username, String password, Status status) {
		super(username, password, status);
	}
	
	public String getDetails() {
		String print = super.getDetails();
		return print;
	}
	
	public void createOffer() {
		String Title;
		String Description;
		double Wage;
		System.out.println("Enter the details of the job");
		System.out.println("Please enter the applicant username");
		String Name = scan.next();
		scan.nextLine();
		try {
			offerHandle(Name);
		} catch (MultipleOfferException e) {
			System.err.println(e);
			return;
		}
		boolean found = false;
		String User = null;
		for (Interview I : interviews) {
			for (int i = 0; i < interviews.size(); ++i) {
				I = interviews.get(i);
				if (I.getUser().equals(Name) && (getUsername().equals(Driver.cUser.getUsername()))) {
					User = I.getUser();
					found = true;
					break;
				}
			}
		}
		if (!found) {
			System.out.println("No interview for that Applicant User");
			return;
		}
		
		System.out.println("Title: ");
		Title = scan.nextLine();
		System.out.println("Description: ");
		Description = scan.nextLine();
		System.out.println("Wage per hour: ");
		Wage = scan.nextDouble();
		OfferStatus Status = OfferStatus.Pending;
		JobOffer offer = new JobOffer(Title, Description, Wage, Status, User);
		offers.add(offer);
		System.out.println(offer.getJobOffer());
	}

	private void offerHandle(String name) throws MultipleOfferException {
		for (int i = 0; i < offers.size(); ++i) {
			JobOffer offer = offers.get(i);
			OfferStatus stat = offer.getStatus();
			String user = offer.getUser();
			if ((stat.equals(OfferStatus.Pending)) && (user.equals(name))) {
				throw new MultipleOfferException(
						"There is already an 'Pending' offer created by the Employer for the applicant " + user);
			}
		}
	}

	public void searchApplicant() {
		int Select;
		int applicantType;
		int applicantStatus;
		int count = 0;
		do {
			System.out.println("Search and View Applicants: 1. By Type 2. By Availability");
			Select = scan.nextInt();
		} while (!(Select == 1 || Select == 2));

		if (Select == 1) {
			do {
				System.out.println("Enter the appplicant type searching for 0. Local 1. International ");
				applicantType = scan.nextInt();
			} while (!(applicantType == 0 || applicantType == 1));

			Type appType;
			if (applicantType == 0) {
				appType = Type.Local;
			} else {
				appType = Type.International;
			}

			for (int i = 0; i < Driver.users.size(); ++i) {
				User user = Driver.users.get(i);
				if (user instanceof Applicant) {
					Type app = ((Applicant) user).getType();
					if (app.equals(appType)) {
						System.out.println(user.getDetails());
						count++;
					}
				}
			}
		} else {
			System.out.println("Searching and viewing the applicants with status 'AVAILABLE'");
			for (int i = 0; i < Driver.users.size(); ++i) {
				User user = Driver.users.get(i);
				if (user instanceof Applicant) {
					Status stat = ((SystemUser) user).getStatus();
					if (stat.equals(Status.Available)) {
						System.out.println(user.getDetails());
						count++;
					}
				}
			}
		}

		if (count == 0) {
			try {
				searchHandle(count);
			} catch (NoApplicantException e) {
				System.err.println(e);
				return;
			}
		}
	}

	public void searchHandle(int value) throws NoApplicantException {
		if (value == 0) {
			throw new NoApplicantException(
					"There no Applicant available for the search applied ");
		}
	}

	public  void setInterview() {
		String Name;
		String Title;
		String Description;
		String Venue;
		String Time;
		System.out.println("Please enter the applicant username for Interview");
		Name = scan.next();
		scan.nextLine();
		String User = null;
		boolean found = false;
		for (User u : Driver.users) {
			for (int i = 0; i < Driver.users.size(); ++i) {
				u = Driver.users.get(i);
				if (u instanceof Applicant) {
					if (u.getUsername().equals(Name)) {
						User = u.getUsername();
						found = true;
						break;
					}
				}
			}
		}
		if (!found) {
			System.out.println("Invalid applicant username");
			return;
		}
		
		System.out.println("Title: ");
		Title = scan.nextLine();
		System.out.println("Description: ");
		Description = scan.nextLine();
		System.out.println("Venue: ");
		Venue = scan.nextLine();
		System.out.println("Time: ");
		Time = scan.nextLine();
		Interview interview = new Interview(User, Title, Description, Venue, Time);
		interviews.add(interview);
		System.out.println(interview.getInterview());
	}
	
	public ArrayList<JobOffer> getOfferArrayList() {
		return offers;
	}
	
	public ArrayList<Interview> getInterviewArrayList() {
		return interviews;
	}
}
