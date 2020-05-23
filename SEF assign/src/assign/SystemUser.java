package assign;

import java.util.ArrayList;

public class SystemUser extends User{
	private Status status;
	private int complaintCount;
	private static ArrayList<Complaint>complaints = new ArrayList<>();
	
	
	public SystemUser(String username, String password, Status status ) {
		super(username, password);
		this.status = Status.Available;
		this.complaintCount =0;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
	public static ArrayList<Complaint> getComplaints() {
		return complaints;
	}
	
	public String getDetails() {
		String print = super.getDetails();
		print = print + "Status: " + status + "\n";
		return print;
	}
	public void blacklist() {
		this.status = Status.Blacklisted;
	}	
	public void setComplaintCount(int count) {
		this.complaintCount = count;
	}
	public void handleNewComplaint() {
		this.complaintCount++;
		if(complaintCount>=3) {
			blacklist();
			System.out.println("The user:" +super.getUsername()+" is blacklisted");
		}
	}
}
