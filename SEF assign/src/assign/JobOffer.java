package assign;

import java.util.ArrayList;

public class JobOffer {
	private  Type OfferType;
	private  String Title;
	private String Username;
	private String Description;
	private double Wage;
	private OfferStatus Status;
	private User tUser;
	private ArrayList<JobOffer> offers = new ArrayList<>();

	public JobOffer(String Title, String Description, String Username, Double Wage, Type OfferType, User tUser) {
		this.Title = Title;
		this.Description = Description;
		this.Username = Username;
		this.Wage = Wage;
		this.OfferType = OfferType;
		this.tUser = tUser;
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
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public void setWage(Double Wage) {
		this.Wage = Wage;
	}

	public double getWage() {
		return Wage;
	}

	public void setOfferType(Type OfferType) {
		this.OfferType = OfferType;
	}

	public Type getOfferType() {
		return OfferType;
	}

	public OfferStatus getStatus() {
		return Status;
	}

	public void setStatus(OfferStatus Status) {
		this.Status = Status;
	}
	public User getUser() {
		return tUser;
	}

	public String getJobOffer() {
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
