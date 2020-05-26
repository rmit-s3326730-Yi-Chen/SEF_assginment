package assign;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Interview implements Serializable{
	public enum Outcome {
		Called,
		Noappearance,
		Success,
		Fail;
	}
	
	private static String Title;
	private String User;
	private static String Description;
	private String Venue;
	private LocalTime Time;
	private String Username;
	private Outcome Result;
	private LocalDate Date;

	public Interview(String User, String Title, String Description, String Venue, LocalDate Date, LocalTime Time, String Username, Outcome Result) {
		this.User = User;
		this.Title = Title;
		this.Description = Description;
		this.Venue = Venue;
		this.Date = Date;
		this.Time = Time;
		this.Result = Outcome.Called;
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

	public void setDate(LocalDate Date) {
		this.Date = Date;
	}

	public LocalDate getDate() {
		return Date;
	}

	public void setTime(LocalTime Time) {
		this.Time = Time;
	}

	public LocalTime getTime() {
		return Time;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}
	
	public void setResult(Outcome Result) {
		this.Result = Result;
	}

	public Outcome getResult() {
		return Result;
	}

	public String getInterview() {
		String print = "\n";
		print = "The Interview Details are \n";
		print = print + "Applicant Username: " + User + "\n";
		print = print + "Title: " + Title + "\n";
		print = print + "Description: " + Description + "\n";
		print = print + "Venue: " + Venue + "\n";
		print = print + "Date: " + Date + "\n";
		print = print + "Time: " + Time + "\n";
		print = print + "Creator: " + Username + "\n";
		return print;
	}
}
