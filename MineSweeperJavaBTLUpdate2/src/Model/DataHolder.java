package Model;

public class DataHolder {
	
	String date;
	float time;
	String level;
	
	public DataHolder(String date, float time, String level) {
		super();
		this.date = date;
		this.time = time;
		this.level = level;
	}
	
	public String getDate() {
		return date;
	}
	public float getTime() {
		return time;
	}
	public String getLevel() {
		return level;
	}
	
}
