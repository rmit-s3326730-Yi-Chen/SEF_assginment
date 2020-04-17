package assign;

public class JobOffer {
  private Type OfferType;
  
	public Type getOfferType() {
		return this.OfferType;
	}
	
	private String Title;
	private String Description;
	
	public JobOffer(String Title, String Description, Double Wage, Type OfferType) {
		this.Title = Title;
		this.Description  = Description;
		this.Wage = Wage;
		this.OfferType = OfferType;
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
		this.Wage = Wage;
	}
	
	public void getWage() {
		return Wage;
	}
	
	public void setOfferType(Type OfferType) {
		this.OfferType = OfferType;
	}
	
	public Type getOfferType() {
		return OfferType;
	}

}
