package assign;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmploymentRecord {
    private static List<String> pastJob = new ArrayList<>(
            Arrays.asList("Engineer","Teacher","Nurse","Librarian")
    );
	public static List<String> getPastJob() {
		return pastJob;
	}
	private String companyName;
	private String jobName;
	private String jobResponsibility;
	  private LocalDate beginDate;
	  private LocalDate endDate;
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
	@Override
	public String toString() {
		return "companyName=" + companyName + ", jobName=" + jobName + ", jobResponsibility="
				+ jobResponsibility + ", beginDate=" + beginDate + ", endDate=" + endDate ;
	}
	

}
