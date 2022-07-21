package initUI;

public class GetguestID {
	
	private static int guestID;
	
	private static boolean haveSignedIn = false;

	public static boolean isHaveSignedIn() {
		return haveSignedIn;
	}

	public static void setHaveSignedIn(boolean haveSignedIn) {
		GetguestID.haveSignedIn = haveSignedIn;
	}

	public static int getGuestID() {
		return guestID;
	}

	public static void setGuestID(int guestID) {
		GetguestID.guestID = guestID;
	}
}
