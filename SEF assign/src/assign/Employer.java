package assign;

public class Employer extends SystemUser {

	public Employer(String username, String password, Status status) {
		super(username, password, status);
	}
	
	public String getDetails() {
		String print = super.getDetails();
		return print;
	}	
}
