package assign;

import java.util.ArrayList;

public class JobOffer {
	private Type OfferType;
	private String Title;
	private String Description;
	private double Wage;
	private Status Status;
	private ArrayList<JobOffer> offers = new ArrayList<>();
	
	public JobOffer(String Title, String Description, Double Wage, Type OfferType) {
		this.Title = Title;
		this.Description = Description;
		this.Wage = Wage;
		this.OfferType = OfferType;
		this.Status= Status.Available;
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
	
	public Status getStatus() {
		return Status;
	}
	
	public void setStatus(Status Status) {
		this.Status = Status;
	}

}
