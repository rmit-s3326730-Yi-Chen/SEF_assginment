package assign;

public class EmploymentRecord {
	private String companyName;
	private String jobName;
	private String jobResponsibility;
	private String start_endTime;
	
	//update employment records
	public EmploymentRecord(String companyName, String jobName, String jobResponsibility, String start_endTime){
		this.companyName = companyName;
		this.jobName = jobName;
		this.jobResponsibility = jobResponsibility;
		this.start_endTime= start_endTime;
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
	public String getStart_endTime() {
		return start_endTime;
	}
	public void setStart_endTime(String start_endTime) {
		this.start_endTime = start_endTime;
	}
	@Override
	public String toString() {
		String er =  "companyName=" + companyName + ", jobName=" + jobName + ", jobResponsibility="
				+ jobResponsibility + ", start_endTime=" + start_endTime ;
	
	return er;
	}
}
