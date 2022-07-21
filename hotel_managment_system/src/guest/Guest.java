package guest;

public class Guest {

	public int getGuestID() {
		return guestID;
	}

	public void setGuestID(int guestID) {
		this.guestID = guestID;
	}

	public String getPublicGName() {
		return publicGName;
	}

	public void setPublicGName(String publicGName) {
		this.publicGName = publicGName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	private String publicGName, email;
	
	private int guestID;
}
