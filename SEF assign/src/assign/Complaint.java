package assign;

import java.io.Serializable;

public class Complaint implements Serializable{
		private String description;
		private User creater;
		private User target;
		
		public Complaint(User creater,String description,User target) {
			this.creater =creater;
			this.description = description;
			this.target = target;
		}
		
		public String getTarget() {
			return target.getUsername();
		}
		
	}
