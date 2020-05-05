package assign;

public class SystemUser extends User{
	private static Status status;
	
	public SystemUser(String username, String password, Status status ) {
		super(username, password);
		this.status = Status.Available;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
	
	public String getDetails() {
		String print = super.getDetails();
		print = print + "Status: " + status + "\n";
		return print;
	}
	private void blacklist() {
		this.status = Status.Blacklisted;
	}	
}
