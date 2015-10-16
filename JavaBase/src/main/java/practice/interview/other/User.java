package practice.interview.other;

public class User {
	private int id;
	private String na;
	public User(int id, String na) {
		super();
		this.id = id;
		this.na = na;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", na=" + na + "]";
	}
	
	public void setNa(String str) { this.na = str; }

}
