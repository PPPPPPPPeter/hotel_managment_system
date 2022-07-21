package property;

public class Bathroom {

	private String addrPostcode, addrHouse;
	
	private int bathID, toilet, bath, shared, shower;
	
	public String getAddrPostcode() {
		return addrPostcode;
	}
	
	public void setAddrPostcode(String postcode) {
		this.addrPostcode = postcode;
	}
	
	public String getAddrHouse() {
		return addrHouse;
	}
	
	public void setAddrHouse(String house) {
		this.addrHouse = house;
	}
	
	public int getBathID() {
		return bathID;
	}
	
	public void setBathID(int bathID) {
		this.bathID = bathID;
	}
	
	public int getToilet() {
		return toilet;
	}
	
	public void setToilet(int toilet) {
		this.toilet = toilet;
	}
	
	public int getBath() {
		return bath;
	}
	
	public void setBath(int bath) {
		this.bath = bath;
	}
	
	public int getShared() {
		return shared;
	}
	
	public void setShared(int shared) {
		this.shared = shared;
	}
	
	public int getShower() {
		return shower;
	}
	
	public void setShower(int shower) {
		this.shower = shower;
	}
	
}
