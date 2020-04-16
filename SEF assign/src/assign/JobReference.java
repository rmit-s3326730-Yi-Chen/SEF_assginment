package assign;

public class JobReference {
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
