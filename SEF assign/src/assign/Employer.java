package assign;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import assign.Interview.Outcome;
import exception.MultipleOfferException;
import exception.NoApplicantException;

public class Employer extends SystemUser {

	static ArrayList<User> users = Driver.getUsersArrayList();
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
		String Title = null;
		String Description = null;
		double Wage;
		System.out.println("Enter the details of the job ");
		System.out.println("Please enter the applicant username ");
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
			if (I.getUser().equals(Name) && (I.getUsername().equals(this.getUsername()))) {
				User = I.getUser();
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No interview for that Applicant User");
			return;
		}
		
		for (Interview I : interviews) {
			if (I.getUser().equals(User)) {
				Title = Interview.getTitle();
				Description = Interview.getDescription();
			}
		}

		do {
			System.out.println("Wage per hour: ");
			Wage = scan.nextDouble();
		} while (!validValue(Wage));
		
		String Username = this.getUsername();
		OfferStatus Status = null;
		JobOffer offer = new JobOffer(Title, Description, Username, Wage, Status, User);
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
		int count = 0;

		do {
			System.out.println("Search and View Applicants: 1. By Type 2. By Availability ");
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

			for (int i = 0; i < users.size(); ++i) {
				User user = users.get(i);
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
			for (int i = 0; i < users.size(); ++i) {
				User user = users.get(i);
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
			throw new NoApplicantException("There no Applicant available for the search applied " + this.getUsername());
		}
	}

	public  void setInterview() {
		String Name;
		String Title;
		String Description;
		String Venue;
		String dateLine;
		String timeLine;
		LocalDate Date = null;
		LocalTime Time = null;
		System.out.println("Enter the interview details ");
		System.out.println("Please enter the applicant username for Interview ");
		Name = scan.next();
		scan.nextLine();
		String User = null;
		boolean found = false;
		for (User u : users) {
			if (u instanceof Applicant) {
				if (u.getUsername().equals(Name)) {
					User = u.getUsername();
					found = true;
					break;
				}
			}
		}
		if (!found) {
			System.out.println("Invalid applicant username");
			return;
		}

		try {
			interviewHandle(Name);
		} catch (MultipleOfferException e) {
			System.err.println(e);
			return;
		}
		
		do {
			System.out.println("Title: ");
			Title = scan.nextLine();
		} while (!validString(Title));

		do {
			System.out.println("Description: ");
			Description = scan.nextLine();
		} while (!validString(Description));

		do {
			System.out.println("Venue: ");
			Venue = scan.nextLine();
		} while (!validString(Venue));

		do {
			System.out.println("Date (dd/MM/yyyy): ");
			dateLine = scan.nextLine();
		} while (!validateDate(dateLine));

		DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Date = LocalDate.parse(dateLine, dt);

		do {
			System.out.println("Time 24HRS (HH:mm): ");
			timeLine = scan.nextLine();
		} while (!validateTime(timeLine));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		Time = LocalTime.parse(timeLine, dtf);

		Outcome Result = null;
		String Username = this.getUsername();
		Interview interview = new Interview(User, Title, Description, Venue, Date, Time, Username, Result);
		interviews.add(interview);
		System.out.println(interview.getInterview());
	}
	
	private void interviewHandle(String name) throws MultipleOfferException {
		for (int i = 0; i < interviews.size(); ++i) {
			Interview I = interviews.get(i);
			if ((I.getUser().equals(name)) && (I.getUsername().equals(this.getUsername()))) {
				throw new MultipleOfferException("There is already an Interview created by the Employer "
						+ this.getUsername() + " for the applicant " + I.getUser());
			}
		}
	}

	private static boolean validValue(double value) {
		if (value <= 0) {
			System.out.println("Enter an value greater than 0 please try again");
			return false;
		}
		return true;
	}

	private static boolean validString(String value) {
		if (value.trim().equals("")) {
			System.out.println("Enter valid string input as it can't be empty please try again");
			return false;
		}
		return true;
	}

	private static boolean validateDate(String date) {
		if (date.trim().equals("")) {
			System.out.println("Please enter a date for the interview");
			return false;
		} else {
			DateTimeFormatter dfrmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			try {
				LocalDate date1 = LocalDate.parse(date, dfrmt);
				LocalDate date2 = java.time.LocalDate.now();
				if (date1.compareTo(date2) >= 0) {
					return true;
				} else {
					System.out.println("Date is already over please enter future date");
					return false;
				}
			}

			catch (DateTimeParseException e) {
				System.out.println(date + " invalid date format please try again");
				return false;
			}
		}
	}

	private static boolean validateTime(String time) {
		if (time.trim().equals("")) {
			System.out.println("Please enter a time for the interview");
			return false;
		} else {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
			try {
				LocalTime time1 = LocalTime.parse(time, dtf);
				LocalTime time2 = java.time.LocalTime.now();
				if (time1.compareTo(time2) > 0) {
					return true;
				} else {
					System.out.println("Time is already over please enter future time");
					return false;
				}
			} catch (DateTimeParseException e) {
				System.out.println(time + " invalid time format please try again");
				return false;
			}
		}
	}

	public void interviewOutcome() {
		System.out.println("Please enter the applicant username you wish to update the results for ");
		String Name = scan.next();
		scan.nextLine();
		boolean found = false;
		String User = null;
		for (Interview I : interviews) {
			if (I.getUser().equals(Name) && (I.getUsername().equals(this.getUsername()))) {
				User = I.getUser();

				LocalDate date1 = I.getDate();
				LocalDate date2 = java.time.LocalDate.now();
				
				LocalTime time1 = I.getTime();
				LocalTime time2 = java.time.LocalTime.now();
				
				if ((date2.compareTo(date1) >= 0) && (time1.compareTo(time2) > 0)) {
					System.out.println("The interview outcomes of the applicant " + User);
					int option;
					do {
						System.out.println("Choose one of the option: ");
						System.out.println("1. Success 2. Fail 3. No Appearance ");
						option = scan.nextInt();
						if (option == 1) {
							I.setResult(Outcome.Success);
						}
						if (option == 2) {
							I.setResult(Outcome.Fail);
						}
						if (option == 3) {
							I.setResult(Outcome.Noappearance);
						}
					} while (!(option == 1 || option == 2 || option == 3));
					System.out.println(I.getInterview() + "\n" + I.getResult());
				} else {
					System.out.println("You can't update as there is still some time for the Interview ");
				}
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No interview held for that applicant user");
			return;
		}
	}

	public static ArrayList<JobOffer> getOfferArrayList() {
		return offers;
	}

	public static ArrayList<Interview> getInterviewArrayList() {
		return interviews;
	}
}
