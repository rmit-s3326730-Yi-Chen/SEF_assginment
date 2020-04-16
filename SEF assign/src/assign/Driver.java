package assign;
import java.util.*;
public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		User cUser = null;// current user;
		boolean login = false;// determine login/logout
		int resp=0; // user integer response
		String resp2=null; //user String response
		ArrayList<User> users = new ArrayList<>();
		User aUser = new Applicant("a1","1");
		users.add(aUser);
		aUser = new Employer("e1","1");
		users.add(aUser);
		aUser = new Staff("s1","1");
		users.add(aUser);
		
		do {
			System.out.println("**Student Casual Employment System**");
	       	System.out.println("1. Log in");
	       	System.out.println("2. Quit");
	    	System.out.println("Please Enter Your Choice:");
	    	try {
	    		resp = scan.nextInt();
	    		
	    	}
	    	catch(Exception e) {
	    		System.out.println("Invaild Input! Please enter number");
	    	}
	    	scan.nextLine();
	    	
	    	if(resp ==1) {//login
	    		System.out.println("Please enter your username:");
	    		resp2 = scan.next();
	    		scan.nextLine();
	    		boolean found = false;
	    		for(User u:users) {
	    			if(u.getUsername().equals(resp2)) {
	    				cUser = u;
	    				found =true;
	    				break;
	    			}
	    		}
	    		if(!found) {
	    			System.out.println("No such username.");
	    			continue;
	    		}
	    		System.out.println("Please enter password");
	    		resp2 = scan.next();
	    		scan.nextLine();
	    		if(resp2.equals(cUser.getPassword())) {
	    			login= true;
	    		}
	    		else {
	    			System.out.println("Wrong password");
	    		}
	    	}
	    	
	    	if(resp == 2) {
	    		System.out.println("Thank your for using Student Casual Employment System");
	    	}
	    	
	    	while(login) {
				if(cUser instanceof Applicant) {
					System.out.println("Welcome " +cUser.getUsername());
					System.out.println("**Applicant Menu**");
					System.out.println("1. Update job history");
					System.out.println("2. View interview");
					System.out.println("3. View offer");
					System.out.println("4. Upload CV");
					System.out.println("5. Change Details");
					System.out.println("9. Log out");
			    	System.out.println("Please Enter Your Choice:");
				}
				if(cUser instanceof Employer) {
					System.out.println("Welcome " +cUser.getUsername());
					System.out.println("**Employer Menu**");
					System.out.println("1. View applicant");
					System.out.println("2. Create interview");
					System.out.println("3. Create offer");
					System.out.println("9. Log out");
			    	System.out.println("Please Enter Your Choice:");
					
				}
				if(cUser instanceof Staff) {
					System.out.println("Welcome " +cUser.getUsername());
					System.out.println("**Staff Menu**");
					System.out.println("1. View blacklist");
					System.out.println("9. Log out");
			    	System.out.println("Please Enter Your Choice:");
					
				}
		       	
		    	try {
		    		resp = scan.nextInt();
		    		
		    	}
		    	catch(Exception e) {
		    		System.out.println("Invaild Input! Please enter number");
		    	}
		    	scan.nextLine();
		    	
		    	
		    	if(resp ==9) {
		    		login =false;
		    	}
	    	}
			
		}while(resp!=2);
		
		
	}

}
