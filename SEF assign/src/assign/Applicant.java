package assign;
import java.time.LocalDate;
import java.util.*;
import assign.JobCategory;
public class Applicant extends SystemUser{
	private Type type;
	Scanner scan = new Scanner(System.in);

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
