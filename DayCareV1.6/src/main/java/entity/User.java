package entity;

public class User {
	
	private int teacherId;
	private String username;
	private String pwd;
	
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [teacherId=" + teacherId + ", username=" + username + ", pwd=" + pwd + "]";
	}
	
	
	
	
	

	
	
	
	

}
