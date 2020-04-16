package assign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JobReference {
    private static List<String> jobCategories = new ArrayList<>(
            Arrays.asList("Engineer","Teacher","Nurse","Librarian")
    );
	public static List<String> getJobCategories() {
		return jobCategories;
	}
	  private static List<String> jobPreferences = new ArrayList<>();
	  
	public static List<String> getJobPreferences() {
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
