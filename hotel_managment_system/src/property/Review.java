package property;

public class Review extends Property{
	
	public int getPkReviewID() {
		return pkReviewID;
	}

	public void setPkReviewID(int pkReviewID) {
		this.pkReviewID = pkReviewID;
	}

	public int getCleanLiness() {
		return cleanLiness;
	}

	public void setCleanLiness(int cleanLiness) {
		this.cleanLiness = cleanLiness;
	}

	public int getCommunication() {
		return communication;
	}

	public void setCommunication(int communication) {
		this.communication = communication;
	}

	public int getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(int checkIn) {
		this.checkIn = checkIn;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getTextDesc() {
		return textDesc;
	}

	public void setTextDesc(String textDesc) {
		this.textDesc = textDesc;
	}

	public String getFkPC() {
		return fkPC;
	}

	public void setFkPC(String fkPC) {
		this.fkPC = fkPC;
	}

	public String getFkHouse() {
		return fkHouse;
	}

	public void setFkHouse(String fkHouse) {
		this.fkHouse = fkHouse;
	}

	private int pkReviewID, cleanLiness, communication, checkIn,
	accuracy, location, value;
	
	private String textDesc, fkPC, fkHouse;
	
	
}
