package assign;
import java.util.Scanner;
public class SystemStaff extends User{
	Scanner scanner = new Scanner(System.in);
	
	public SystemStaff(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	public void staffMenu() {
		System.out.println("Welcome to Staff System");
		System.out.println("**Staff Menu**");
		System.out.println("1. View blacklist");
		System.out.println("2. View Job Categories");
		System.out.println("3. Log out");
    	System.out.println("Please Enter Your Choice:");
    	int option = scanner.nextInt();
    	switch(option) {
    	case(1):
    		//View blacklist
    		break;
    	case(2):
    		//View Job Categories
    		break;
    	case(3):
    		System.exit(3);
    	}
	}
}
