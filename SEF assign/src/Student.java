import java.util.*;
public class Student extends User{
	private StudentType type;
	private static ArrayList<Complaint> complaints = new ArrayList<Complaint>();
	private ArrayList<Offer> offers = new ArrayList<Offer>();
	private ArrayList<Interview> interviews = new ArrayList<Interview>();
	

	public Student(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
		
	}
	public boolean setType(int typeChecker) {
		if(typeChecker ==0) {
			this.type=StudentType.Local;
			System.out.println("Success! Set to local student");
			return true;
		}
		else if(typeChecker ==1) {
			this.type =StudentType.International;
			System.out.println("Success! Set to international student");
			return true;
		}
		else {
			System.out.println("The input need to be 0 for Local, 1 for international");
			return false;
		}
	}
	public StudentType getType() {
		return this.type;
	}
	
	public boolean handleComplaint() {
		return false;
		
	}
	public boolean handleInterview() {
		return false;
	}
	public boolean handleOffer() {
		return false;
	}

}
