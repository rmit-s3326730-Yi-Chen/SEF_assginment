package assign;

import java.util.InputMismatchException;

import java.util.Scanner;

public class ApplicantMenu {
    Scanner sc = new Scanner(System.in);
	public void DisplayApplicantMenu() {
        //TODO: selecting interview slot/time
        boolean isLoggedIn = true;
        int response;

        while (isLoggedIn) {
                try {
                    System.out.printf("What would you like to do?\n\n" +
                            "1. Update Your Job Preferences\n" +
                            "2. Update Your Availabilities\n" +
                            "3. Update Your Employment Records\n" +
                            "4. Update CV\n" +
                            "5. View All Currently Posted Jobs\n" +
                            "6. Apply For A Job\n" +
                            "7. View Jobs Shortlisted For\n" +
                            "8. View Job Offer\n" +
                            "9. Accept/Reject Job Offer\n" +
                            "10. View Emails\n" +
                            "11. Change Login Details\n\n" +
                            "0. Logout\n\n");
                    response = sc.nextInt();
                    sc.nextLine();
                    switch (response) {
                        case (1):
                            updateJobPreferences();
                            break;
                        case (0):
                            isLoggedIn = false;
                            break;
                    }
                } catch (InputMismatchException e) {
                    printInputMismatchMessage();
                }
            

        }
    }

	private void printInputMismatchMessage() {
		// TODO Auto-generated method stub
		System.out.println("Wrong number, please try 1, 2 or 0");
		
	}
    

private void updateJobPreferences() {
    boolean goBack = false;
    while (!goBack) {
        try {
            System.out.printf("What would you like to do?\n\n" +
                    "1. Add A Job Preference\n" +
                    "2. Remove A Job Preference\n" +
                    "3. View Preferences\n" +
                    "0. Go back\n\n");
            int response = sc.nextInt();
            sc.nextLine();
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
            printInputMismatchMessage();
        }
    }
}

private void addJobPreference() {
	System.out.println("Please type your Job Peference");
    for (String jc : JobReference.getJobCategories()) {
        System.out.println(jc);
    }
    System.out.println("\n");
    String response = sc.nextLine();
}
private void removeJobPreference() {
    System.out.println("Please type one of these job preferences to removed to your selected preferences\n");
    for (String jp : JobReference.getJobPreferences()) {
        System.out.println(jp);
    }
    System.out.println("\n");
    String response = sc.nextLine();
}

private void viewPreferences() {
    System.out.println("Your job preferences are now..");
    for (String jp : JobReference.getJobPreferences()) {
        System.out.println(jp);
    }
    System.out.println("\n");
}


}
