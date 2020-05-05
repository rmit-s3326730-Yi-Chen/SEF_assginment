package assign;

import java.util.ArrayList;

public class JobOffer {
	private static Type OfferType;
	private static String Title;
	private static String Username;
	private static String Description;
	private static double Wage;
	private static OfferStatus Status;
	private ArrayList<JobOffer> offers = new ArrayList<>();

	public JobOffer(String Title, String Description, String Username, Double Wage, Type OfferType) {
		this.Title = Title;
		this.Description = Description;
		this.Username = Username;
		this.Wage = Wage;
		this.OfferType = OfferType;
		this.Status = OfferStatus.Available;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	
	public static String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public double setWage(Double Wage) {

		return Wage;
	}

	public void getWage() {
		this.Wage = Wage;
	}

	public void setOfferType(Type OfferType) {
		this.OfferType = OfferType;
	}

	public Type getOfferType() {
		return OfferType;
	}

	public static OfferStatus getStatus() {
		return Status;
	}

	public void setStatus(OfferStatus Status) {
		this.Status = Status;
	}

	public static String getJobOffer() {
		String print = "\n";
		print = print + "Title: " + Title + "\n";
		print = print + "Description: " + Description + "\n";
		print = print + "Creator: " + Username + "\n";
		print = print + "Wage per hour: " + Wage + "\n";
		print = print + "Type of Applicant: " + OfferType + "\n";
		print = print + "Status: " + Status + "\n";
		return print;

	}

}
