package assign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JobReference {
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
	

	
	private String jobReferenceName;
	// update job references
	public JobReference(String jobReferenceName) {
		this.jobReferenceName = jobReferenceName;
	}
	public String getJobLike() {
		return jobReferenceName;
	}
	public void setJobLike(String jobReferenceName) {
		this.jobReferenceName = jobReferenceName;
	}
}
