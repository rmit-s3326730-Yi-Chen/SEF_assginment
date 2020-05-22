package assign;
import java.util.ArrayList;
import java.util.Scanner;
public class SystemStaff extends User{
	Scanner scanner = new Scanner(System.in);
	private static ArrayList<Complaint>complaints = new ArrayList<>();
	
	public SystemStaff(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<Complaint> getComplaints() {
		return complaints;
	}
}
