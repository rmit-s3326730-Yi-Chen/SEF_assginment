package assign;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JobCategory implements Serializable {
	private String jobName;
	private String jobDescription;


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
		this.jobName = jobName;
		this.jobDescription = jobDescription;
	}
	
	

}
