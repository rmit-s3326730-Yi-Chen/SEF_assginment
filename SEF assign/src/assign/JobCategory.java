package assign;

public class JobCategory {
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
		super();
		this.jobName = jobName;
		this.jobDescription = jobDescription;
	}
	
	

}
