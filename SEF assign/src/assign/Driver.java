package assign;
import java.util.*;
public class Driver {
	static ArrayList<User> users = new ArrayList<>();
	static ArrayList<Complaint>complaints = new ArrayList<>();
	static User cUser = null;// current user;
	static boolean login = false;// determine login/logout
	static String resp = null; // user's response
	static boolean quit = false;
	static Scanner scan = new Scanner(System.in);
	static User aUser;
	static Complaint aComplaint;

	public static void main(String[] args)  {
		aUser = new Applicant("a1","1");
		users.add(aUser);
		aUser = new Employer("e1","1");
		users.add(aUser);
		aUser = new SystemStaff("s1","1");
		users.add(aUser);
		Applicant applicant = new Applicant("","");
		Employer employer = new Employer("","");
		SystemStaff systemStaff = new SystemStaff("","");
		
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
		System.out.println("Pleas enter your username:");
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
		System.out.println("You have logouted");
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
	    		
	    		break;
	    	case("8"):
	    		logout();
	    		break;
	    	default:
	    		System.out.println("Sorry, No matched option, please try again");
	    	
	    	}
		}
		if(cUser instanceof Employer) {
			System.out.println("Welcome to Employer System");
			System.out.println("** Employer Menu **");
			System.out.println("1. Create Offer");
			System.out.println("2. Search and View Applicants");
			System.out.println("3. Create Interview");
			System.out.println("4. Update Interview Outcome");
			System.out.println("5. Complaint");
			System.out.println("6. Log Out");
			System.out.println("Please Enter your choice:");
			resp = scan.next();
	    	scan.nextLine();
	    	switch(resp) {
	    	case("5"):
	    		
	    		break;
	    	case("6"):
	    		logout();
	    		break;
	    	default:
	    		System.out.println("Sorry, No matched option, please try again");
	    	
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
			aUser = new Applicant(username,password);
			users.add(aUser);
			System.out.println("You have registered as applicant, "+username);
		}
		else if(type ==2) {
			aUser = new Employer(username,password);
			users.add(aUser);
			System.out.println("You have registered as employer, "+username);
		}
	}// end of register
	public static void ComplaintHandler() {
		
	}


}
