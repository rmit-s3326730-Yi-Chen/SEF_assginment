package assign;

public class SystemUser extends User{
	private Status status;

	public SystemUser(String username, String password) {
		super(username, password);
		this.status = Status.Available;
		// TODO Auto-generated constructor stub
		
	}
	private void blacklist() {
		this.status = Status.Blacklisted;
	}
	
	

	
}
