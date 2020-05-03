package assign;
import java.util.*;
public class Applicant extends SystemUser{
	private Type type;
	private ArrayList<Complaint> complaints = new ArrayList<Complaint>();
	private ArrayList<JobOffer> offers = new ArrayList<>();
	private ArrayList<Interview> interviews = new ArrayList<Interview>();
	Scanner scan = new Scanner(System.in);
	boolean login = false;
	private String applicantEmail;
	private  List<String> jobCategories = new ArrayList<>(
            Arrays.asList("Engineer","Teacher","Nurse","Librarian")
    );
	public List<String> getJobCategories(Scanner sc) {
		return jobCategories;
	}
	  private List<String> jobPreferences = new ArrayList<>();
	  
	public List<String> getJobPreferences(Scanner sc) {
		return jobPreferences;
	}

	public String getApplicantEmail() {
		return applicantEmail;
	}
	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}
	public Applicant(String username, String password, String applicantEmail) {
		super(username, password);
		// TODO Auto-generated constructor stub
		this.applicantEmail = applicantEmail;
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
		System.out.println("1. Update Employment Records");
		System.out.println("2. View interview");
		System.out.println("3. View offer"); //view offer and can make a choice to accept or reject offer, or just view and do not handle it 
		System.out.println("4. Upload CV");
		System.out.println("5. Update Details");//availability + type +email
		System.out.println("6. Update Job References");
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
        	updateJobPreferences();
            break;
        case(7):
        	//Complaint
        	break;
        case (8):
            login = false;
            break;
    						}
	}
	
	public void updateJobPreferences() {
	    boolean goBack = false;
	    while (!goBack) {
	        try {
	            System.out.printf("What would you like to do?\n\n" +
	                    "1. Add A Job Preference\n" +
	                    "2. Remove A Job Preference\n" +
	                    "3. View Preferences\n" +
	                    "0. Go back\n\n");
	            int response = scan.nextInt();
	            scan.nextLine();
	            switch (response) {
	                case (1):
	                   addJobPreference();
	                    break;
	                case (2):
	                    //removeJobPreference();
	                    break;
	                case (3):
	                   // viewPreferences();
	                    break;
	                case (0):
	                    goBack = true;
	                    break;
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input!");
	        }
	    }
	}
	
	public void addJobPreference(){
		User cUser;
		System.out.println("Please type your Job Peference");
	    for (String jc : cUser.getJobCategories(sc)) {
	        System.out.println(jc);
	        String sc=jc;
	    }
	    String response = scan.nextLine();

	}
	
}
