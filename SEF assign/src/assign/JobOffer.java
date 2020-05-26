package assign;

import java.io.Serializable;

public class JobOffer implements Serializable {
	private String Title;
	private String Description;
	private double Wage;
	private OfferStatus Status;
	private String tUser;
	private static int jobCount =1;
	private String ID;

	public JobOffer(String Title, String Description, Double Wage, OfferStatus Status, String tUser) {
		this.Title = Title;
		this.Description = Description;
		this.Wage = Wage;
		this.Status = OfferStatus.Pending;
		this.tUser = tUser;
		this.setID("job"+jobCount);
		jobCount++;
	}

	public String getTitle() {
		return Title;
	}
	public void setID(String ID) {
		this.ID=ID;
	}
	public String getID() {
		return ID;
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


	public void setWage(Double Wage) {
		this.Wage = Wage;
	}

	public double getWage() {
		return Wage;
	}

	public OfferStatus getStatus() {
		return Status;
	}

	public void setStatus(OfferStatus Status) {
		this.Status = Status;
	}

	public void setUser(String tUser) {
		this.tUser = tUser;
	}

	public String getUser() {
		return tUser;
	}

	public String getJobOffer() {
		String print = "\n";
		print = print + "ID: " +ID +"\n";
		print = print + "Title: " + Title + "\n";
		print = print + "Description: " + Description + "\n";
		print = print + "Wage per hour: " + Wage + "\n";
		print = print + "Status: " + Status + "\n";
		print = print + "Job request to: " + tUser;
		return print;
	}
}
