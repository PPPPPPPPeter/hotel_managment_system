package property;

public class Bedroom {

	private int bedID;
	
	private String bed1, bed2, addrPostcode, addrHouse;
	
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
	
	public int getBedID() {
		return bedID;
	}
	
	public void setBedID(int bedID) {
		this.bedID = bedID;
	}
	
	public String getBed1() {
		return bed1;
	}
	
	public void setBed1(String bed) {
		this.bed1 = bed;
	}

	public String getBed2() {
		return bed2;
	}
	
	public void setBed2(String bed) {
		this.bed2 = bed;
	}
	
}
