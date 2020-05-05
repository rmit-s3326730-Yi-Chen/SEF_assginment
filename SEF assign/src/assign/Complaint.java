package assign;


public class Complaint {
		private String description;
		private User creater;
		private String target;
		
		public Complaint(User creater,String description,String target) {
			this.creater =creater;
			this.description = description;
			this.target = target;
		}
		
		public String getTarget() {
			return target;
		}
		
	}
