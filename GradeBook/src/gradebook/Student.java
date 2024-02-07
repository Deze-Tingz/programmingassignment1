package gradebook;
/*
  Description: Keeps track of students info: first name (String), last name
(String), 7-digit ID (int), and grade (Grade).

*/

public class Student {
	
	 	private String firstName;
	 	private String lastName;
	 	private String pid;
	 	private Grade grade;
	    
	   /*----------------------Getters-------------------------------------*/
	 
	    public String getFirstName() {
	        return firstName;
	    }
	    public String getLastName() {
	        return lastName;
	    }
	    public String getPid() {
	        return pid;
	    }
	    public Grade getGrade() {
	        return grade;
	    }
	    /*----------------------Setters-------------------------------------*/
	    
	    public void setFirstName(String firstName) {
	    	this.firstName = firstName;
	    	
	    }
	    
	    public void setLastName(String lastName) {
	    	this.lastName = lastName;
	    	
	    }
	    
	    public void setPid(String pid) {
	    	this.pid = pid;
	    	
	    }
	    
	   
		
		public void setGrade(Grade grade) {
			this.grade = grade;
		}
	    
	    
		
}