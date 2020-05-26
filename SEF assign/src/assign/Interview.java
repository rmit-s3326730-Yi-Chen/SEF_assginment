package assign;

import java.io.Serializable;

public class Interview implements Serializable{
	private String Title;
	private String User;
	private String Description;
	private String Venue;
	private String Time;
	private String Username;
	private String Result;


	public Interview(String User, String Title, String Description, String Venue, String Time, String Username) {
		this.User = User;
		this.Title = Title;
		this.Description = Description;
		this.Venue = Venue;
		this.Time = Time;
		this.Username = Username;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String User) {
		this.User = User;
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

	public void setVenue(String Venue) {
		this.Venue = Venue;
	}

	public String getVenue() {
		return Venue;
	}

	public void setTime(String Time) {
		this.Time = Time;
	}

	public String getTime() {
		return Time;
	}
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public void setResult(String Result) {
		this.Result = Result;
	}

	public String getResult() {
		return Result;
	}

	public String getInterview() {
		String print = "\n";
		print = "The Interview Details are: \n";
		print = print + "Applicant Username: " + User + "\n";
		print = print + "Title: " + Title + "\n";
		print = print + "Description: " + Description + "\n";
		print = print + "Venue: " + Venue + "\n";
		print = print + "Time: " + Time + "\n";
		print = print + "Creator: " + Username + "\n";
		return print;
	}

}
