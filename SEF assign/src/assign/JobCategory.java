package assign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JobCategory {
	private String jobName;
	private String jobDescription;
	private  List<String> jobCategories = new ArrayList<>(
            Arrays.asList("Engineer","Teacher","Nurse","Librarian")
    );
	public List<String> getJobCategories(Scanner sc) {
		return jobCategories;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public JobCategory(String jobName, String jobDescription) {
		super();
		this.jobName = jobName;
		this.jobDescription = jobDescription;
	}
	
	

}
