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
	private String title;
	private String responsibility;
	private LocalDate beginDate;
	private LocalDate endDate;	
	private String referenceName;
	private String licenceName;
	private String licenceNumber;
	private String issuer;
	private LocalDate issuedDate;
	private LocalDate validDate;
	private List<String> pastJobs = new ArrayList<>();
	private List<String> jobPreferences = new ArrayList<>();
	private List<String>licences = new ArrayList<>();
	private static List<String> jobCategories = new ArrayList<>(
            Arrays.asList("Engineer","Teacher","Nurse","Librarian")
    );
	private List<String>references = new ArrayList<>();

	  public Applicant(String username, String password,  Status status, Type type) {
		super(username, password, status);
		this.type = type;
	}

	public Applicant(String username, String password, Status status, String applicantEmail) {
		super(username, password, status);
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
	
	public String getDetails() {
		String print = super.getDetails();
		print = print + "Type: " + type + "\n";
		return print;
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
	
// update employment record
	public void updateEmploymentRecord() {
		boolean uer = false;
		while(!uer) {
			try {
			System.out.printf("Please update your employment record:\n"
													+ "1. Add a past Job\n"
													+ "2. Remove a past Job\n"
													+ "3. View past Jobs\n"
													+ "4. Add a Reference\n"
													+ "5. Remove a Reference\n"
													+ "6. View References\n"
													+ "0. Go Back\n");
			int rep = scan.nextInt();
			scan.nextLine();
			switch(rep) {
			case(1):
				addPastJob();
				break;
			case(2):
				removePastJob();
				break;
			case(3):
				viewPastJob();
				break;
			case(4):
				addReference();
				break;
			case(5):
				removeReference();
				break;
			case(6):
				viewReference();
				break;
			case(0):
				uer = true;
				break;
			
			}
			}catch(InputMismatchException e) {
	            System.out.println("Invalid input!");
	   
	        }
			
		}
	}
	  
    private void addPastJob() {
        boolean validInput = false;

        while(!validInput)
        {
            try
            {
                System.out.println("For what company?");
                companyName = scan.nextLine();

                System.out.println("What was your title?");
                title = scan.nextLine();

                System.out.println("When did you start? (Format: DD-MM-YYYY)");
                String startDateStr = scan.nextLine();
                Scanner s = new Scanner(startDateStr).useDelimiter("-");
                int day = s.nextInt();
                int month = s.nextInt();
                int year = s.nextInt();
                beginDate = LocalDate.of(year,month,day);

                System.out.println("When did you end? (Format: DD-MM-YYYY)");
                String endDateStr = scan.nextLine();
                Scanner s2 = new Scanner(endDateStr).useDelimiter("-");
                int day2 = s2.nextInt();
                int month2 = s2.nextInt();
                int year2 = s2.nextInt();
                endDate = LocalDate.of(year2,month2,day2);

                System.out.println("What where your responsibilities?");
                responsibility = scan.nextLine();
     
               this.pastJobs.add(companyName);
               this.pastJobs.add(title);
               this.pastJobs.add(startDateStr);
               this.pastJobs.add(endDateStr);
               this.pastJobs.add(responsibility);
               
                validInput = true;
                System.out.println("Successfully added past job");
            }
            catch (InputMismatchException e)
            {
               System.out.println("Invalid Input");
            }
        }
    }
	
	private void removePastJob() {	
        System.out.println("Please type the details of the past jobs you want to remove\n");
        int count = 1;
        for (String pj : pastJobs) {
            System.out.println(count + ". " + pj.toString());
            count++; 
            	System.out.println("*********************");
        }

        String response = scan.nextLine();
        if (getPastJobs().contains(response)) {
	        this.pastJobs.remove(response);
	      } else {
	        System.out.println("Wrong input");
	      }
        String response1 = scan.nextLine();
        if (getPastJobs().contains(response1)) {
	        this.pastJobs.remove(response1);
	      } else {
	        System.out.println("Wrong input");
	      }
        String response2 = scan.nextLine();
        if (getPastJobs().contains(response2)) {
	        this.pastJobs.remove(response2);
	      } else {
	        System.out.println("Wrong input");
	      }
        String response3 = scan.nextLine();
        if (getPastJobs().contains(response3)) {
	        this.pastJobs.remove(response3);
	      } else {
	        System.out.println("Wrong input");
	      }
        String response4= scan.nextLine();
        if (getPastJobs().contains(response4)) {
	        this.pastJobs.remove(response4);
	      } else {
	        System.out.println("Wrong input");
	      }

	}
	
	private void viewPastJob() {
        System.out.println("Your past job are..\n");
        int count = 1;
        for (String pj : pastJobs) {
            System.out.println(count + ". " + pj.toString());
            count++; 
            if((count-6)%5==0) {
            	System.out.println("*********************");
            }         
        }
	}
	
	private void addReference(){
        boolean validInput = false;

        while(!validInput) {
        			try {
        					System.out.println("What is the reference name?");
        					referenceName = scan.nextLine();

        					this.references.add(referenceName);
        					validInput = true;

        					System.out.println("Successfully added a reference");
        			} catch (InputMismatchException e) {
        					System.out.println("Invalid input");
        }
    }
	}
	
	private void removeReference() {
	    System.out.println("Please type one of these references to remove\n");
        for (String r : references) {
        	System.out.println(r);
        }
        System.out.println("\n");
       String response = scan.nextLine();
       
       if(getReferences().contains(response)) {
    	   this.references.remove(response);
       }else {
    	   System.out.println("Wrong input");
       }
        
	}
	
	private void viewReference() {
        System.out.println("Your references are..\n");

        for (String r : references) {
            System.out.println(r+"\n");

        }

	}
	
	// upload CV
	public void uploadCv() {
		boolean goBack = false;
        while (!goBack) {
            try {
                System.out.printf("What would you like to do?\n\n" +
                        "1. Add A Licence\n" +
                        "2. Remove A Licence\n" +
                        "3. View Licences\n" +
                        "4. Add a Qualification\n" +
                        "5. Remove a Qualification\n" +
                        "6. View Qualifications\n" +
                        "0. Go back\n\n");
                int response = scan.nextInt();
                scan.nextLine();
                switch (response) {
                    case (1):
                        addLicence();
                        break;
                    case (2):
                        removeLicence();
                        break;
                    case (3):
                        viewLicence();
                        break;
                    case (4):
//                        addQualification();
                        break;
                    case (5):
//                        removeQualification();
                        break;
                    case (0):
                        goBack = true;
                        break;
                }
            } catch (InputMismatchException e) {
               System.out.println("Invalid Input");
            }     
        }
	}
	
	private void addLicence() {
        boolean validInput = false;

        while(!validInput)
        {
            try
            {
                System.out.println("What Licence name?");
                licenceName = scan.nextLine();

                System.out.println("What is the licence number?");
                licenceNumber = scan.nextLine();

                System.out.println("Who issued it?");
                issuer = scan.nextLine();

                System.out.println("When was it issued? (Format: DD-MM-YYYY)");
                String issuedDateStr = scan.nextLine();
                Scanner s = new Scanner(issuedDateStr).useDelimiter("-");
                int day = s.nextInt();
                int month = s.nextInt();
                int year = s.nextInt();
                issuedDate = LocalDate.of(year,month,day);

                System.out.println("When is it valid till? (Format: DD-MM-YYYY)");
                String validDateStr = scan.nextLine();
                Scanner s2 = new Scanner(validDateStr).useDelimiter("-");
                int day2 = s2.nextInt();
                int month2 = s2.nextInt();
                int year2 = s2.nextInt();
                validDate = LocalDate.of(year2,month2,day2);

                this.licences.add(licenceName);
                this.licences.add(licenceNumber);
                this.licences.add(issuer);
                this.licences.add(issuedDateStr);
                this.licences.add(validDateStr);
                validInput = true;

                System.out.println("Successfully added a licence");
                
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid Input");
            }
        }
	}
	
	private void removeLicence() {
	       System.out.println("Please type the licences details you want to remove\n");
	        int count = 1;
	        for (String li : licences) {
	            System.out.println(count + ". " + li.toString());
	            count++; 
	            	System.out.println("*********************");
	        }

	        String response = scan.nextLine();
	        if (getLicences().contains(response)) {
		        this.licences.remove(response);
		      } else {
		        System.out.println("Wrong input");
		      }
	        String response1 = scan.nextLine();
	        if (getLicences().contains(response1)) {
		        this.licences.remove(response1);
		      } else {
		        System.out.println("Wrong input");
		      }
	        String response2 = scan.nextLine();
	        if (getLicences().contains(response2)) {
		        this.licences.remove(response2);
		      } else {
		        System.out.println("Wrong input");
		      }
	        String response3 = scan.nextLine();
	        if (getLicences().contains(response3)) {
		        this.licences.remove(response3);
		      } else {
		        System.out.println("Wrong input");
		      }
	        String response4= scan.nextLine();
	        if (getLicences().contains(response4)) {
		        this.licences.remove(response4);
		      } else {
		        System.out.println("Wrong input");
		      }
	}
	
	private void viewLicence() {
        System.out.println("Your licences are..\n");
        int count = 1;
        for (String l : licences) {
            System.out.println(count + ". " + l.toString());
            count++;
            if((count-6)%5 == 0) {
            	System.out.println("********************");
            }
        }
	}
	
	// update details
	public void updateDetails() {
		
	}
	
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

		public LocalDate getBeginDate() {
			return beginDate;
		}
		public String getResponsibility() {
			return responsibility;
		}

		public void setResponsibility(String responsibility) {
			this.responsibility = responsibility;
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
		public List<String> getPastJobs() {
			return pastJobs;
		}
		public List<String> getJobPreferences() {
			return jobPreferences;
		}

		public String getApplicantEmail() {
			return applicantEmail;
		}
		public void setApplicantEmail(String applicantEmail) {
			this.applicantEmail = applicantEmail;
		}

		public List<String> getReferences() {
			return references;
		}

		public void setReferences(List<String> references) {
			this.references = references;
		}

		public String getReferenceName() {
			return referenceName;
		}

		public void setReferenceName(String referenceName) {
			this.referenceName = referenceName;
		}

		public List<String> getLicences() {
			return licences;
		}

		public void setLicences(List<String> licences) {
			this.licences = licences;
		}

		public String getLicenceName() {
			return licenceName;
		}

		public void setLicenceName(String licenceName) {
			this.licenceName = licenceName;
		}

		public String getLicenceNumber() {
			return licenceNumber;
		}

		public void setLicenceNumber(String licenceNumber) {
			this.licenceNumber = licenceNumber;
		}

		public String getIssuer() {
			return issuer;
		}

		public void setIssuer(String issuer) {
			this.issuer = issuer;
		}

		public LocalDate getIssuedDate() {
			return issuedDate;
		}

		public void setIssuedDate(LocalDate issuedDate) {
			this.issuedDate = issuedDate;
		}

		public LocalDate getValidDate() {
			return validDate;
		}

		public void setValidDate(LocalDate validDate) {
			this.validDate = validDate;
		}
	
}
