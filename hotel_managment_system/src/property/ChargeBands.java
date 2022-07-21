package property;

public class ChargeBands extends Property{
	
	private int pkBandID, pricePerNight, serviceCharge, 
	cleaningCharge, startDate, endDate;
	
	public int getPkBandID() {
		return pkBandID;
	}

	public void setPkBandID(int pkBandID) {
		this.pkBandID = pkBandID;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public int getCleaningCharge() {
		return cleaningCharge;
	}

	public void setCleaningCharge(int cleaningCharge) {
		this.cleaningCharge = cleaningCharge;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public String getFkPostCode() {
		return fkPostCode;
	}

	public void setFkPostCode(String fkPostCode) {
		this.fkPostCode = fkPostCode;
	}

	public String getFkHouse() {
		return fkHouse;
	}

	public void setFkHouse(String fkHouse) {
		this.fkHouse = fkHouse;
	}

	private String fkPostCode, fkHouse;
	
	
}
