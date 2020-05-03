package assign;
import java.util.*;
public class Applicant extends SystemUser{
	private Type type;
	private static ArrayList<Complaint> complaints = new ArrayList<Complaint>();
	private ArrayList<JobOffer> offers = new ArrayList<>();
	private ArrayList<Interview> interviews = new ArrayList<Interview>();
	Scanner scan = new Scanner(System.in);
	boolean login = false;
	
	public Applicant(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
		
	}
	public boolean setType(int typeChecker) {
		if(typeChecker ==0) {
			this.type=Type.Local;
			System.out.println("Success! Set to local student");
			return true;
		}
		else if(typeChecker ==1) {
			this.type =Type.International;
			System.out.println("Success! Set to international student");
			return true;
		}
		else {
			System.out.println("The input need to be 0 for Local, 1 for international");
			return false;
		}
	}
	public Type getType() {
		return this.type;
	}
	
	public boolean handleComplaint() {
		return false;
		
	}
	public boolean handleInterview() {
		return false;
	}
	public boolean handleOffer() {
		return false;
	}
	public void applicantMenu() {
		System.out.println("Welcome to Applicant System");
		System.out.println("**Applicant Menu**");
		System.out.println("1. Update job history");
		System.out.println("2. View interview");
		System.out.println("3. View offer");
		System.out.println("4. Upload CV");
		System.out.println("5. Update Details");
		System.out.println("6. Update job References");
		System.out.println("7. Complaint");
		System.out.println("8. Log out");
    	System.out.println("Please Enter Your Choice:");
    	int response = scan.nextInt();
    	switch (response) {
    	case(1):
    		// update job history
    		break;
    	case(2):
    		//View interview
    		break;
    	case(3):
    		//view offer
    		break;
    	case(4):
    		//Upload CV
    		break;
    	case(5):
    		//Update Details
    		break;
        case (6):
//            ApplicantMenu.updateJobPreferences();
            break;
        case(7):
        	//Complaint
        	break;
        case (8):
            login = false;
            break;
    }
	}
	
}
