package assign;


public class JobOffer {
	private String Title;
	private String Username;
	private String Description;
	private double Wage;
	private OfferStatus Status;
	private String tUser;

	public JobOffer(String Title, String Description, String Username, Double Wage, OfferStatus Status, String tUser) {
		this.Title = Title;
		this.Description = Description;
		this.Username = Username;
		this.Wage = Wage;
		this.Status = OfferStatus.Pending;
		this.tUser = tUser;
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
		print = print + "Title: " + Title + "\n";
		print = print + "Description: " + Description + "\n";
		print = print + "Creator: " + Username + "\n";
		print = print + "Wage per hour: " + Wage + "\n";
		print = print + "Status: " + Status + "\n";
		print = print + "Job request to: " + tUser + "\n";
		return print;
	}
}
