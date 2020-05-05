package assign;
import java.util.*;
import exception.*;
public class Driver {
	static ArrayList<User> users = new ArrayList<>();
	static ArrayList<JobOffer> offers = new ArrayList<>();
	static ArrayList<Complaint>complaints = new ArrayList<>();
	static User cUser = null;// current user;
	static User tUser = null;// target user;
	static boolean login = false;// determine login/logout
	static String resp = null; // user's response
	static boolean quit = false;
	static Scanner scan = new Scanner(System.in);
	static User aUser;
	static Complaint aComplaint;

	public static void main(String[] args)  {
		aUser = new Applicant("a1","1",Status.Available,Type.Local);
		users.add(aUser);
		aUser = new Employer("e1","1",Status.Available);
		users.add(aUser);
		aUser = new SystemStaff("s1","1");
		users.add(aUser);
		aUser = new Applicant("a2","1",Status.Available,Type.International);
		users.add(aUser);
		aUser = new Employer("e2","1",Status.Available);
		users.add(aUser);
		aUser = new SystemStaff("s2","1");
		users.add(aUser);

		
		do {
			System.out.println("**Student Casual Employment System**");
	       	System.out.println("1. Log in");
	       	System.out.println("2. Register as applicant");
	       	System.out.println("3. Register as employer");
	       	System.out.println("4. Quit");
	    	System.out.println("Please Enter Your Choice:");
	    	resp = scan.next();
	    	scan.nextLine();
	    	switch(resp) {
	    	case("1"):
	    		login();
	    		while(login) {
	    			menu();
	    		}
	    		break;
	    	case("2"):
	    		Register(1);
	    		break;
	    	case("3"):
	    		Register(2);
	    		break;
	    	case("4"):
	    		System.out.println("Thank your for using Student Casual Employment System");
	    		quit = true;
	    		break;
	    	default:
	    		System.out.println("Sorry, No matched option, please try again");
	    	}
		}while(!quit);
			
	}

	public static void login() {
		System.out.println("Please enter your username:");
		String username = scan.next();
		scan.nextLine();
		boolean found = false;
		for(User u:users) {
			if(u.getUsername().equals(username)) {
				cUser = u;
				found =true;
				break;
			}
		}
		if(!found) {
			System.out.println("No such username.");
			return;
		}
		System.out.println("Please enter password:");
		String password = scan.next();
		scan.nextLine();
		if(password.equals(cUser.getPassword())) {
			login= true;
		}
		else {
			System.out.println("Wrong password");
		}
	}
	
	public static void logout(){
		login = false;
		System.out.println("You have logged out");
	}
	
	public static void menu() {
		if(cUser instanceof Applicant) {
			System.out.println("Welcome to Applicant System");
			System.out.println("**Applicant Menu**");
			System.out.println("1. Update Employment Records");
			System.out.println("2. View interview");
			System.out.println("3. View offer"); //view offer and can make a choice to accept or reject offer, or just view and do not handle it 
			System.out.println("4. Upload CV");
			System.out.println("5. Update Details");//availability + type +email
			System.out.println("6. Update Job Preferences");
			System.out.println("7. Complaint");
			System.out.println("8. Log out");
	    	System.out.println("Please Enter Your Choice:");
	    	resp = scan.next();
	    	scan.nextLine();
	    	switch(resp) {
	    	case("7"):
	    		try {
					complaintHandler();
				} catch (TargetNotFoundException e) {
					System.err.println(e);
				} catch (WrongTargetTypeException e) {
					System.err.println(e);
				}
	    		break;
	    	case("8"):
	    		logout();
	    		break;
	    	default:
	    		System.out.println("Sorry, No matched option, please try again");
	    	
	    	}
		}
		if(cUser instanceof Employer) {
			System.out.println("Welcome to Employer System " + cUser.getUsername());
			try {
				int choose = employerMenu();
				switch (choose) {

				case (6):
					logout();
					break;
				case (1):
					// Create offer
					createOffer();
					break;
				case (2):
					// Search and View applicant
					searchApplicant();
					break;
				case (3):
					// Create interview
					break;
				case (4):
					// Interview outcome
					break;
				case (5):
					// Make complaint
					break;
				default:
					System.out.println("Sorry, No matched option, please try again");

				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter an integer value");
			}
		}
		if(cUser instanceof SystemStaff) {
			System.out.println("Welcome to Staff System");
			System.out.println("**Staff Menu**");
			System.out.println("1. View blacklist");
			System.out.println("2. View Job Categories");
			System.out.println("3. Log out");
	    	System.out.println("Please Enter Your Choice:");
	    	resp = scan.next();
	    	scan.nextLine();
	    	switch(resp) {
	    	case("3"):
	    		logout();
	    		break;
	    	default:
	    		System.out.println("Sorry, No matched option, please try again");
	    	
	    	}	
		}
		
	}// end of menu
	public static void Register(int type) {
		System.out.println("Please enter username:");
		String username = scan.next();
		scan.nextLine();
		for(User u:users) {
			if(u.getUsername().equals(username)) {
				System.out.println("The username already exists");
				return;
			}
		}
		
		System.out.println("Please enter password:");
		String password = scan.next();
		scan.nextLine();
		if(type ==1) {
			aUser = new Applicant(username,password,Status.Available,Type.International);
			users.add(aUser);
			System.out.println("You have registered as applicant, "+username);
		}
		else if(type ==2) {
			aUser = new Employer(username,password,Status.Available);
			users.add(aUser);
			System.out.println("You have registered as employer, "+username);
		}
	}// end of register
	public static void complaintHandler() throws TargetNotFoundException,WrongTargetTypeException{
		System.out.println("Please enter target's username for your complaint");
		resp = scan.next();
		scan.nextLine();
		boolean found = false;
		for(User u:users) {
			if(u.getUsername().equals(resp)) {
				tUser =u;
				found = true;
				break;
			}
		}
		if(!found) {
			throw new TargetNotFoundException("Could not find the target with username: " +resp);
		}
		if(cUser instanceof Applicant) {
			if(tUser instanceof Applicant) {
				throw new WrongTargetTypeException("The target is an applicant as well, you can't complaint: " +resp);
			}
		}
		if(cUser instanceof Employer) {
			if(tUser instanceof Employer) {
				throw new WrongTargetTypeException("The target is an employer as well, you can't complaint: " +resp);
			}
		}
		System.out.println("Please enter complaint description");
		String description = scan.nextLine();
		aComplaint = new Complaint(cUser,description,tUser);
		complaints.add(aComplaint);
		System.out.println("you have create the complaint");
		
	}
	
	private static int employerMenu() {
		int opt;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("** Employer Menu **");
			System.out.println("1. Create Offer");
			System.out.println("2. Search and View Applicants");
			System.out.println("3. Create Interview");
			System.out.println("4. Update Interview Outcome");
			System.out.println("5. Complaint");
			System.out.println("6. Log Out");
			System.out.println("Please Enter your choice:");
			opt = scan.nextInt();
		} while (!(opt <= 6));
		return opt;
	}

	private static void createOffer() {
		String title, description;
		double wage;
		int type;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the details of the job");
		System.out.println("Title: ");
		title = input.nextLine();
		System.out.println("Description: ");
		description = input.nextLine();
		System.out.println("Wage per hour: ");
		wage = input.nextDouble();
		System.out.println("Applicant type required for the offer: ");
		type = input.nextInt();
		Type offertype = setOfferType(type);
		String username = cUser.getUsername();
		JobOffer offer = new JobOffer(title, description, username, wage, offertype);
		offers.add(offer);
		System.out.println(offer.getJobOffer());
	}

	private static Type setOfferType(int typeChecker) {
		if (typeChecker == 0) {
			System.out.println("Offer to Local Students");
			return Type.Local;
		} else if (typeChecker == 1) {
			System.out.println("Offer to International Students");
			return Type.International;
		} else {
			System.out.println("The input need to be 0 for Local, 1 for international");
			return null;
		}
	}

	private static void searchApplicant() {
		int select;
		int applicantType;
		int applicantStatus;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Search and View Applicants: 1. By Type 2. By Availability");
			select = input.nextInt();
		} while (!(select == 1 || select == 2));

		if (select == 1) {

			do {
				System.out.println("Enter the appplicant type searching for 0. Local 1. International ");
				applicantType = input.nextInt();
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
					}

				}
			}
		}
	}
}
