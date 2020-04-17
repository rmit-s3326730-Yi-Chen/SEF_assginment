package assign;

public class JobOffer {
  private Type OfferType;

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
	
	public boolean setOfferType(int typeChecker) {
		if(typeChecker ==0) {
			this.OfferType=Type.Local;
			System.out.println("Offer for local student");
			return true;
		}
		else if(typeChecker ==1) {
			this.OfferType =Type.International;
			System.out.println("Offer for international student");
			return true;
		}
		else {
			System.out.println("The input need to be 0 for Local, 1 for international");
			return false;
		}
	
	public Type getOfferType() {
		return OfferType;
	}

}
