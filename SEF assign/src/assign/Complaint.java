package assign;


public class Complaint {
		private String description;
		private User creater;
		private User target;
		
		public Complaint(User creater,String description,User target) {
			this.creater =creater;
			this.description = description;
			this.target = target;
		}
		
		public User getTarget() {
			return target;
		}
		
	}
