package assign;
import java.util.ArrayList;
import java.util.Scanner;
public class SystemStaff extends User{
	Scanner scan = new Scanner(System.in);
	
	
	public SystemStaff(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	public void viewBlacklist() {
		System.out.println("Blacklist:");
		for(User u:Driver.users) {
			if(u instanceof SystemUser) {
				if(((SystemUser) u).getStatus()==Status.Blacklisted) {
					System.out.println(u.getUsername());
				}
			}
		}
	}
	
	public void addJobCategory() {
		
		System.out.println("Please enter the category name:");
		String name = scan.next();
		scan.nextLine();
		System.out.println("Please enter the description:");
		String desc = scan.next();
		scan.nextLine();
		JobCategory jc = new JobCategory(name,desc);
        Applicant.getJobCategories().add(jc);
    }
	public void manageBlacklist() {
		for(User u:Driver.users) {
			if( u instanceof SystemUser) {
				System.out.println("User name: "+u.getUsername());
				System.out.println("User Status: " +((SystemUser)u).getStatus());
			}
		}
		System.out.println("Please enter the user name");
		String username = scan.next();
		scan.nextLine();
		User cUser = null;
		boolean found = false;
		for(User u:Driver.users) {
			if( u instanceof SystemUser) {
				if(u.getUsername().equals(username)) {
					cUser = u;
					found = true;
					break;
				}
			}
		}
		if(!found) {
			System.out.println("No user found");
			return;
		}
		System.out.println("enter 1 for blacklist the user.");
		System.out.println("enter 1 for make the user available again.");
		String input = scan.next();
		scan.nextLine();
		switch(input){
		case("1"):
			((SystemUser)cUser).setStatus(Status.Blacklisted);
			System.out.println("User: "+cUser.getUsername()+" is in blacklist");
		break;
		case("2"):
			((SystemUser)cUser).setStatus(Status.Available);
			System.out.println("User: "+cUser.getUsername()+" is available");
		break;
		default:
			System.out.println("No such option");
			
		}
	}
}
