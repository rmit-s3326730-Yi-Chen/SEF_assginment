package assign;
import java.util.ArrayList;
import java.util.Scanner;
public class SystemStaff extends User{

	
	
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
	
	public static void addJobCategory() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the category name:");
		String name = scan.next();
		scan.nextLine();
		System.out.println("Please enter the description:");
		String desc = scan.next();
		scan.nextLine();
		JobCategory jc = new JobCategory(name,desc);
        Applicant.getJobCategories().add(jc);
    }
}
