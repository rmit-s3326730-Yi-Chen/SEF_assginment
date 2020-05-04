package assign;
import java.time.LocalDate;
import java.util.*;
import assign.JobCategory;
public class Applicant extends SystemUser{
	private Type type;
	Scanner scan = new Scanner(System.in);
	boolean login = false;
	private String applicantEmail;
	private Status status;
	private String companyName;
	private String jobName;
	private String jobResponsibility;
	private LocalDate beginDate;
	private LocalDate endDate;
	private List<String> jobCategories = new ArrayList<>(
            Arrays.asList("Engineer","Teacher","Nurse","Librarian")
    );
	User cUser; //current user

	  public Applicant(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	private List<String> jobPreferences = new ArrayList<>();
	  
	public List<String> getJobPreferences() {
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
		System.out.println("6. Update Job Preferences");
		System.out.println("7. Complaint");
		System.out.println("8. Log out");
    	System.out.println("Please Enter Your Choice:");
    	int response = scan.nextInt();
    	switch (response) {
    	case(1):
    		// update employment records
    		
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
	                  removeJobPreference();
	                    break;
	                case (3):
	                   viewPreferences();
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
	
	private void addJobPreference(){
		System.out.println("Please type one of these job preferences to add to your selected preferences\n");
	    for (String jc :  getJobCategories()) {
	        System.out.println(jc);
	    }
	    String response = scan.nextLine();

	    if (getJobCategories().contains(response)) {
	        this.jobPreferences.add(response);
	      } else {
	        System.out.println("Wrong input");
	        
	      }
	}
	private void removeJobPreference() {
	    System.out.println("Please type one of your job preferences you want to remove \n");
	    for (String jp : getJobPreferences()) {
	        System.out.println(jp);
	    }
	    String response = scan.nextLine();

	    if (getJobPreferences().contains(response)) {
	        this.jobPreferences.remove(response);
	      } else {
	        System.out.println("Wrong input");
	      }
	}
	private void viewPreferences() {
		System.out.println("Your job preferences are now..");
        for (String jp : getJobPreferences()) {
            System.out.println(jp);
        }
	}
	
	//employment record
//		private List<String> pastJob = new ArrayList<>(
//	            Arrays.asList("Engineer","Teacher","Nurse","Librarian")
//	    );
//		public List<String> getPastJob() {
//			return pastJob;
//		}
		
		public void setJobPreferences(List<String> jobPreferences) {
		this.jobPreferences = jobPreferences;
	}

		public List<String> getJobCategories() {
		return jobCategories;
	}

	public void setJobCategories(List<String> jobCategories) {
		this.jobCategories = jobCategories;
	}
	public void addJobCategory(String jobCategory) {
        jobCategories.add(jobCategory.toUpperCase());
    }
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getJobName() {
			return jobName;
		}
		public void setJobName(String jobName) {
			this.jobName = jobName;
		}
		public String getJobResponsibility() {
			return jobResponsibility;
		}
		public void setJobResponsibility(String jobResponsibility) {
			this.jobResponsibility = jobResponsibility;
		}
		public LocalDate getBeginDate() {
			return beginDate;
		}
		public void setBeginDate(LocalDate beginDate) {
			this.beginDate = beginDate;
		}
		public LocalDate getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		
		
	
}
