package property;

import java.sql.Date;

public class ProBooking extends Property{
	
	private int pkProBookNo, fkBandID, fkGuestID, bookingCon;
	
	private Date fstNightDate, lstNightDate;
	
	private String fkPostcode, fkHouse;
	
	public int getPkProBookNo() {
		return pkProBookNo;
	}

	public void setPkProBookNo(int pkProBookNo) {
		this.pkProBookNo = pkProBookNo;
	}

	public int getFkBandID() {
		return fkBandID;
	}

	public void setFkBandID(int fkBandID) {
		this.fkBandID = fkBandID;
	}

	public int getFkGuestID() {
		return fkGuestID;
	}

	public void setFkGuestID(int fkGuestID) {
		this.fkGuestID = fkGuestID;
	}

	public Date getFstNightDate() {
		return fstNightDate;
	}

	public void setFstNightDate(Date fstNightDate) {
		this.fstNightDate = fstNightDate;
	}

	public Date getLstNightDate() {
		return lstNightDate;
	}

	public void setLstNightDate(Date lstNightDate) {
		this.lstNightDate = lstNightDate;
	}

	public int getBookingCon() {
		return bookingCon;
	}

	public void setBookingCon(int bookingCon) {
		this.bookingCon = bookingCon;
	}

	public String getFkPostcode() {
		return fkPostcode;
	}

	public void setFkPostcode(String fkPostcode) {
		this.fkPostcode = fkPostcode;
	}

	public String getFkHouse() {
		return fkHouse;
	}

	public void setFkHouse(String fkHouse) {
		this.fkHouse = fkHouse;
	}


}
