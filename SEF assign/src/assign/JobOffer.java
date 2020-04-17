package assign;

public class JobOffer {
  private Type type;
  
  public boolean setType(int typeChecker) {
		if(typeChecker ==0) {
			this.type=Type.Local;
			System.out.println("Offer for local student");
			return true;
		}
		else if(typeChecker ==1) {
			this.type =Type.International;
			System.out.println("Offer for international student");
			return true;
		}
		else {
			System.out.println("The input need to be 0 for Local, 1 for international");
			return false;
		}
	}
  
	public Type getOfferTypes() {
		return this.type;
	}

}
