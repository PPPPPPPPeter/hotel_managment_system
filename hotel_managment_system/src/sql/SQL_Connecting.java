
package sql;
/**
 * 
 * @author peterwong
 */
import java.sql.*;

import java.util.ArrayList;


import property.*;

import guest.*;
import person.*;

public class SQL_Connecting {
	
	private String url = "jdbc:mysql://stusql.dcs.shef.ac.uk";
	
	private String user = "team022" ;
	
	private String psw = "d38ee10c"; 

//	private ArrayList<Property> propertiesList = new ArrayList<>();
//	
//	private ArrayList<Guest> guestList = new ArrayList<>();
//	
//	private ArrayList<Person> personList = new ArrayList<>();
//	
//	private ArrayList<ProBooking> proBookingList = new ArrayList<>();
	
	//add to guest table :
	/**
	 * 
	 * @param form
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public void addToGuestTable (Guest form) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			
			String sql = "INSERT INTO team022.guest VALUES(?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			//
			pstmt.setInt(1, form.getGuestID());
			pstmt.setString(2, form.getPublicGName());
			pstmt.setString(3, form.getEmail());
			int count = pstmt.executeUpdate();
	
			if (count >=1) {
				System.out.println("insert to the guest database successfully! ");
			}
			else {
				System.err.println("didn't insert to the guest database! ");
			}
			
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}	
		finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}	
		}
		//this.guestList.add(form);
	}
	/**
	 * 
	 * @param form
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public void addToPersonTable (Person form) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = "INSERT INTO team022.person VALUES(?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, form.getPkEmail());
			pstmt.setString(2, form.getTitle());
			pstmt.setString(3, form.getForename());
			pstmt.setString(4, form.getSurname());
			pstmt.setInt(5, form.getPhoneNum());
			pstmt.setString(6, form.getPsw());
			
			int count = pstmt.executeUpdate();
			
			if (count >=1) {
				System.out.println("insert to the person database successfully! ");
			}
			else {
				System.err.println("didn't insert to the person database! ");
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		//this.personList.add(form);
	}
	
	/**
	 * 
	 * @param guestID
	 * @return
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public Guest findGuestByID (int guestID) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			
			String sql = "SELECT * FROM team022.guest WHERE guestID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, guestID);
			
			rs = pstmt.executeQuery();
			
			if (rs == null) {
				return null;
			}
			
			if (rs.next()) {
				
				Guest result_lst = new Guest();
				result_lst.setGuestID(rs.getInt("guestID"));
				result_lst.setEmail(rs.getString("email"));
				result_lst.setPublicGName(rs.getString("publicGName"));
				
				return result_lst;
			}
			
			else {
				return null;
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param guestEmail
	 * @return
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public Guest findGuestByEmail (String guestEmail) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			
			String sql = "SELECT * FROM team022.guest WHERE email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, guestEmail);
			
			rs = pstmt.executeQuery();
			
			if (rs == null) {
				return null;
			}
			
			if (rs.next()) {
				
				Guest result_lst = new Guest();
				result_lst.setGuestID(rs.getInt("guestID"));
				result_lst.setEmail(rs.getString("email"));
				result_lst.setPublicGName(rs.getString("publicGName"));
				
				return result_lst;
			}
			
			else {
				return null;
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 
	 * @param form
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public void addToProperty(Property form) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = 
					"INSERT INTO team022.property VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, form.getAddrPostcode());
			pstmt.setString(2, form.getAddrHouse());
			pstmt.setString(3, form.getAddrStreet());
			pstmt.setString(4, form.getAddrCity());
			pstmt.setString(5, form.getPropName());
			pstmt.setString(6, form.getLongDesc());
			pstmt.setString(7, form.getGenbLocal());
			pstmt.setInt(8, form.getBreakfast());
			pstmt.setInt(9, form.getHairDryer());
			pstmt.setInt(10, form.getShampoo());
			pstmt.setInt(11, form.getToiletPaper());
			pstmt.setInt(12, form.getBedLinin());
			pstmt.setInt(13, form.getTowels());
			pstmt.setInt(14, form.getFridge());
			pstmt.setInt(15, form.getMicrowave());
			pstmt.setInt(16, form.getOven());
			pstmt.setInt(17, form.getStove());
			pstmt.setInt(18, form.getDishwasher());
			pstmt.setInt(19, form.getTableware());
			pstmt.setInt(20, form.getCookware());
			pstmt.setInt(21, form.getBasics());
			pstmt.setInt(22, form.getWifi());
			pstmt.setInt(23, form.getTelevision());
			pstmt.setInt(24, form.getSatellite());
			pstmt.setInt(25, form.getStreaming());
			pstmt.setInt(26, form.getDvdPlayer());
			pstmt.setInt(27, form.getBoardGames());
			pstmt.setInt(28, form.getHeating());
			pstmt.setInt(29, form.getWashingMachine());
			pstmt.setInt(30, form.getDryer());
			pstmt.setInt(31, form.getFireExting());
			pstmt.setInt(32, form.getSmokeAlarm());
			pstmt.setInt(33, form.getFirstAidKit());
			pstmt.setInt(34, form.getFreeParking());
			pstmt.setInt(35, form.getRoadParking());
			pstmt.setInt(36, form.getPaidParking());
			pstmt.setInt(37, form.getPatio());
			pstmt.setInt(38, form.getBarbeque());
			pstmt.setInt(39, form.getHostID());
			
			int count = pstmt.executeUpdate();
			
			if (count >=1) {
				System.out.println("insert to the property database successfully! ");
			}
			else {
				System.err.println("didn't insert to the property database! ");
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		//this.propertiesList.add(form);
		
	}
	
	public void deleteFromProperty(Property form) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			//delete bedroom
			String sql = "DELETE FROM team022.bedroom WHERE addrPostcode=? AND addrHouse=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, form.getAddrPostcode());
			pstmt.setString(2, form.getAddrHouse());
			
			int count = pstmt.executeUpdate();
			
			//delete bathroom
			String sql2 = "DELETE FROM team022.bathroom WHERE addrPostcode=? AND addrHouse=?";
			pstmt2 = con.prepareStatement(sql2);
			
			pstmt2.setString(1, form.getAddrPostcode());
			pstmt2.setString(2, form.getAddrHouse());
			
			count =+ pstmt2.executeUpdate();
			
			//delete review
			String sql3 = "DELETE FROM team022.review WHERE addrPostcode=? AND addrHouse=?";
			pstmt3 = con.prepareStatement(sql3);
			
			pstmt3.setString(1, form.getAddrPostcode());
			pstmt3.setString(2, form.getAddrHouse());
			
			count =+ pstmt3.executeUpdate();
			
			//delete proBooking
			String sql4 = "DELETE FROM team022.proBooking WHERE addrPostcode=? AND addrHouse=?";
			pstmt4 = con.prepareStatement(sql4);
			
			pstmt4.setString(1, form.getAddrPostcode());
			pstmt4.setString(2, form.getAddrHouse());
			
			count =+ pstmt4.executeUpdate();
			
			//delete chargeBand
			String sql5 = "DELETE FROM team022.chargeBand WHERE addrPostcode=? AND addrHouse=?";
			pstmt5 = con.prepareStatement(sql5);
			
			pstmt5.setString(1, form.getAddrPostcode());
			pstmt5.setString(2, form.getAddrHouse());
			
			count =+ pstmt5.executeUpdate();
			
			//delete property
			String sql6 = "DELETE FROM team022.property WHERE addrPostcode=? AND addrHouse=?";
			pstmt6 = con.prepareStatement(sql6);
			
			pstmt6.setString(1, form.getAddrPostcode());
			pstmt6.setString(2, form.getAddrHouse());
			
			count += pstmt6.executeUpdate();
			
			if (count >=1) {
				System.out.println("delete from the property database successfully! ");
			}
			else {
				System.err.println("didn't delete from the property database! ");
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		//this.propertiesList.add(form);
		
	}
	
	
	public int findNextBathroomID(){
		int id = 1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = "SELECT * FROM team022.bathroom ORDER BY bathID DESC LIMIT 0, 1";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			rs.next();
			id = rs.getInt("bathID") + 1;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return id;
	}
	
	public int findNextBedroomID(){
		int id = 1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = "SELECT * FROM team022.bedroom ORDER BY bedID DESC LIMIT 0, 1";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			rs.next();
			id = rs.getInt("bedID") + 1;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return id;
	}
	
	
	
	public void addToBathroom(Bathroom form) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = 
					"INSERT INTO team022.bathroom VALUES"
					+ "(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, form.getBathID());
			pstmt.setInt(2, form.getToilet());
			pstmt.setInt(3, form.getBath());
			pstmt.setInt(4, form.getShower());
			pstmt.setInt(5, form.getShared());
			pstmt.setString(6, form.getAddrPostcode());
			pstmt.setString(7, form.getAddrHouse());
			
			int count = pstmt.executeUpdate();
			
			if (count >=1) {
				System.out.println("insert to the property database successfully! ");
			}
			else {
				System.err.println("didn't insert to the property database! ");
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		//this.propertiesList.add(form);
		
	}
	
	
	public void addToBedroom(Bedroom form) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = 
					"INSERT INTO team022.bedroom VALUES"
					+ "(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, form.getBedID());
			pstmt.setString(2, form.getBed1());
			pstmt.setString(3, form.getBed2());
			pstmt.setString(4, form.getAddrPostcode());
			pstmt.setString(5, form.getAddrHouse());
			
			int count = pstmt.executeUpdate();
			
			if (count >=1) {
				System.out.println("insert to the property database successfully! ");
			}
			else {
				System.err.println("didn't insert to the property database! ");
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		//this.propertiesList.add(form);
		
	}
	
	
	/**
	 * 
	 * @param pc
	 * @return
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public Property findPropertyByPostCode(String pc) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = "SELECT * FROM team022.property WHERE addrPostcode=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, pc);
			
			rs = pstmt.executeQuery();
			
			if (rs == null) {
				return null;
			}
			
			if (rs.next()) {
				
				Property result_lst= new Property();
				result_lst.setAddrPostcode(rs.getString("addrPostcode"));
				result_lst.setAddrHouse(rs.getString("addrHouse"));
				result_lst.setAddrStreet(rs.getString("addrStreet"));
				result_lst.setAddrCity(rs.getString("addrCity"));
				result_lst.setPropName(rs.getString("propName"));
				result_lst.setLongDesc(rs.getString("longDesc"));
				result_lst.setGenbLocal(rs.getString("genLocal"));
				result_lst.setBreakfast(rs.getInt("breakfast"));
				result_lst.setHairDryer(rs.getInt("hairDryer"));
				result_lst.setShampoo(rs.getInt("shampoo"));
				result_lst.setToiletPaper(rs.getInt("toiletPaper"));
				result_lst.setBedLinin(rs.getInt("bedLinin"));
				result_lst.setTowels(rs.getInt("towels"));
				result_lst.setFridge(rs.getInt("fridge"));
				result_lst.setMicrowave(rs.getInt("microwave"));
				result_lst.setOven(rs.getInt("oven"));
				result_lst.setStove(rs.getInt("stove"));
				result_lst.setDishwasher(rs.getInt("dishwasher"));
				result_lst.setTableware(rs.getInt("tableware"));
				result_lst.setCookware(rs.getInt("cookware"));
				result_lst.setBasics(rs.getInt("basics"));
				result_lst.setWifi(rs.getInt("wifi"));
				result_lst.setTelevision(rs.getInt("television"));
				result_lst.setSatellite(rs.getInt("satellite"));
				result_lst.setStreaming(rs.getInt("streaming"));
				result_lst.setDvdPlayer(rs.getInt("dvdPlayer"));
				result_lst.setBoardGames(rs.getInt("boardGames"));
				result_lst.setHeating(rs.getInt("heating"));
				result_lst.setWashingMachine(rs.getInt("washingMachine"));
				result_lst.setDryer(rs.getInt("dryer"));
				result_lst.setFireExting(rs.getInt("fireExting"));
				result_lst.setSmokeAlarm(rs.getInt("smokeAlarm"));
				result_lst.setFirstAidKit(rs.getInt("firstAidKit"));
				result_lst.setFreeParking(rs.getInt("freeParking"));
				result_lst.setRoadParking(rs.getInt("roadParking"));
				result_lst.setPaidParking(rs.getInt("paidParking"));
				result_lst.setPatio(rs.getInt("patio"));
				result_lst.setBarbeque(rs.getInt("barbeque"));
				result_lst.setHostID(rs.getInt("hostID"));
				return result_lst;
			}
			
			else {
				return null;
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 
	 * @param form
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public void addToProBookingTable(ProBooking form) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = "INSERT INTO team022.proBooking VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, form.getPkProBookNo());
			pstmt.setDate(2, form.getFstNightDate());
			pstmt.setDate(3, form.getLstNightDate());
			pstmt.setInt(4, form.getBookingCon());
			pstmt.setString(5, form.getFkPostcode());
			pstmt.setString(6, form.getFkHouse());
			pstmt.setInt(7, form.getFkGuestID());
			
			
			int count = pstmt.executeUpdate();
			
			if (count >=1) {
				System.out.println("insert to the proBooking database successfully! ");
			}
			else {
				System.err.println("didn't insert to the proBooking database! ");
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		//this.proBookingList.add(form);
	}



	public ProBooking findProbookByGuestID(int guestID) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			
			String sql = "SELECT * FROM team022.proBooking WHERE guestID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, guestID);
			
			rs = pstmt.executeQuery();
			
			if (rs == null) {
				return null;
			}
			
			if (rs.next()) {
				ProBooking result_lst= new ProBooking();
				result_lst.setPkProBookNo(rs.getInt("proBookingNo"));
				result_lst.setFstNightDate(rs.getDate("firstNight"));
				result_lst.setLstNightDate(rs.getDate("lastNight"));
				result_lst.setBookingCon(rs.getInt("comfirmed"));
				result_lst.setAddrPostcode(rs.getString("addrPostcode"));
				result_lst.setAddrHouse(rs.getString("addrHouse"));
				result_lst.setFkGuestID(rs.getInt("guestID"));
				return result_lst;
				
				
			}
			
			else {
				return null;
			}
				
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 
	 * @param bookingNo
	 * @return
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
//	public ProBooking findProbookByBookingNo(int bookingNo) {
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = DriverManager.getConnection(url, user, psw);
//			
//			if (con == null ) {
//				System.err.println("didn't connect to the database! ");
//			}
//			else {
//				System.out.println("connect the database successfully! ");
//			}
//			
//			String sql = "SELECT * FROM team022.proBooking WHERE addrPostcode=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, bookingNo);
//			
//			rs = pstmt.executeQuery();
//			
//			if (rs == null) {
//				return null;
//			}
//			
//			if (rs.next()) {
//				ProBooking result_lst= new ProBooking();
//				result_lst.setProBookingNo(rs.getInt("proBookingNo"));
//				result_lst.setFirstNight(rs.getDate("firstNight"));
//				result_lst.setLastNight(rs.getDate("lastNight"));
//				result_lst.setConfirmed(rs.getInt("confirmed"));
//				result_lst.setAddrPostcode(rs.getString("addrPostcode"));
//				result_lst.setAddrHouse(rs.getString("addrHouse"));
//				result_lst.setGuestID(rs.getInt("guestID"));
//				return result_lst;
//				
//				
//			}
//			
//			else {
//				return null;
//			}
//				
//		}
//		catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		finally {
//
//			try {
//				if(pstmt != null) pstmt.close();
//				if(con != null) con.close();  
//			}
//			catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		}
//		return null;
//	}
//	
//	public ArrayList<ProBooking> returnBookings(Property form) {
//		
//		ArrayList<ProBooking> lists = new ArrayList<>();
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = DriverManager.getConnection(url, user, psw);
//			
//			if (con == null ) {
//				System.err.println("didn't connect to the database! ");
//			}
//			else {
//				System.out.println("connect the database successfully! ");
//			}
//			
//			String sql = "SELECT * FROM team022.proBooking WHERE addrPostcode=? AND addrHouse=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, form.getAddrPostcode());
//			pstmt.setString(2, form.getAddrHouse());
//			
//			rs = pstmt.executeQuery();
//			
//			if (rs == null) {
//				return null;
//			}
//			while (rs.next()) {
//				ProBooking result_lst= new ProBooking();
//				result_lst.setProBookingNo(rs.getInt("proBookingNo"));
//				result_lst.setFirstNight(rs.getDate("firstNight"));
//				result_lst.setLastNight(rs.getDate("lastNight"));
//				result_lst.setConfirmed(rs.getInt("confirmed"));
//				result_lst.setAddrPostcode(rs.getString("addrPostcode"));
//				result_lst.setAddrHouse(rs.getString("addrHouse"));
//				result_lst.setGuestID(rs.getInt("guestID"));
//				
//				lists.add(result_lst);
//			}
//		
//		}
//		catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		finally {
//
//			try {
//				if(pstmt != null) pstmt.close();
//				if(con != null) con.close();  
//			}
//			catch (Exception ex) {
//				ex.printStackTrace();
//			}
//		}
//		return lists;
//	}

	
	public ArrayList<Property> findAllProperties(){
		
		ArrayList<Property> lists = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = "SELECT * FROM team022.property ";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				Property result_lst= new Property();
				result_lst.setAddrPostcode(rs.getString("addrPostcode"));
				result_lst.setAddrHouse(rs.getString("addrHouse"));
				result_lst.setAddrStreet(rs.getString("addrStreet"));
				result_lst.setAddrCity(rs.getString("addrCity"));
				result_lst.setPropName(rs.getString("propName"));
				result_lst.setLongDesc(rs.getString("longDesc"));
				result_lst.setGenbLocal(rs.getString("genLocal"));
				result_lst.setBreakfast(rs.getInt("breakfast"));
				result_lst.setHairDryer(rs.getInt("hairDryer"));
				result_lst.setShampoo(rs.getInt("shampoo"));
				result_lst.setToiletPaper(rs.getInt("toiletPaper"));
				result_lst.setBedLinin(rs.getInt("bedLinin"));
				result_lst.setTowels(rs.getInt("towels"));
				result_lst.setFridge(rs.getInt("fridge"));
				result_lst.setMicrowave(rs.getInt("microwave"));
				result_lst.setOven(rs.getInt("oven"));
				result_lst.setStove(rs.getInt("stove"));
				result_lst.setDishwasher(rs.getInt("dishwasher"));
				result_lst.setTableware(rs.getInt("tableware"));
				result_lst.setCookware(rs.getInt("cookware"));
				result_lst.setBasics(rs.getInt("basics"));
				result_lst.setWifi(rs.getInt("wifi"));
				result_lst.setTelevision(rs.getInt("television"));
				result_lst.setSatellite(rs.getInt("satellite"));
				result_lst.setStreaming(rs.getInt("streaming"));
				result_lst.setDvdPlayer(rs.getInt("dvdPlayer"));
				result_lst.setBoardGames(rs.getInt("boardGames"));
				result_lst.setHeating(rs.getInt("heating"));
				result_lst.setWashingMachine(rs.getInt("washingMachine"));
				result_lst.setDryer(rs.getInt("dryer"));
				result_lst.setFireExting(rs.getInt("fireExting"));
				result_lst.setSmokeAlarm(rs.getInt("smokeAlarm"));
				result_lst.setFirstAidKit(rs.getInt("firstAidKit"));
				result_lst.setFreeParking(rs.getInt("freeParking"));
				result_lst.setRoadParking(rs.getInt("roadParking"));
				result_lst.setPaidParking(rs.getInt("paidParking"));
				result_lst.setPatio(rs.getInt("patio"));
				result_lst.setBarbeque(rs.getInt("barbeque"));
				result_lst.setHostID(rs.getInt("hostID"));
				
				lists.add(result_lst);
			}
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return lists;
	}
	
	
	
	public ArrayList<Property> findAllHostsProperties(int hostID){
		
		ArrayList<Property> lists = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = "SELECT * FROM team022.property WHERE hostID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hostID);

			rs = pstmt.executeQuery();
			
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				Property result_lst= new Property();
				result_lst.setAddrPostcode(rs.getString("addrPostcode"));
				result_lst.setAddrHouse(rs.getString("addrHouse"));
				result_lst.setAddrStreet(rs.getString("addrStreet"));
				result_lst.setAddrCity(rs.getString("addrCity"));
				result_lst.setPropName(rs.getString("propName"));
				result_lst.setLongDesc(rs.getString("longDesc"));
				result_lst.setGenbLocal(rs.getString("genLocal"));
				result_lst.setBreakfast(rs.getInt("breakfast"));
				result_lst.setHairDryer(rs.getInt("hairDryer"));
				result_lst.setShampoo(rs.getInt("shampoo"));
				result_lst.setToiletPaper(rs.getInt("toiletPaper"));
				result_lst.setBedLinin(rs.getInt("bedLinin"));
				result_lst.setTowels(rs.getInt("towels"));
				result_lst.setFridge(rs.getInt("fridge"));
				result_lst.setMicrowave(rs.getInt("microwave"));
				result_lst.setOven(rs.getInt("oven"));
				result_lst.setStove(rs.getInt("stove"));
				result_lst.setDishwasher(rs.getInt("dishwasher"));
				result_lst.setTableware(rs.getInt("tableware"));
				result_lst.setCookware(rs.getInt("cookware"));
				result_lst.setBasics(rs.getInt("basics"));
				result_lst.setWifi(rs.getInt("wifi"));
				result_lst.setTelevision(rs.getInt("television"));
				result_lst.setSatellite(rs.getInt("satellite"));
				result_lst.setStreaming(rs.getInt("streaming"));
				result_lst.setDvdPlayer(rs.getInt("dvdPlayer"));
				result_lst.setBoardGames(rs.getInt("boardGames"));
				result_lst.setHeating(rs.getInt("heating"));
				result_lst.setWashingMachine(rs.getInt("washingMachine"));
				result_lst.setDryer(rs.getInt("dryer"));
				result_lst.setFireExting(rs.getInt("fireExting"));
				result_lst.setSmokeAlarm(rs.getInt("smokeAlarm"));
				result_lst.setFirstAidKit(rs.getInt("firstAidKit"));
				result_lst.setFreeParking(rs.getInt("freeParking"));
				result_lst.setRoadParking(rs.getInt("roadParking"));
				result_lst.setPaidParking(rs.getInt("paidParking"));
				result_lst.setPatio(rs.getInt("patio"));
				result_lst.setBarbeque(rs.getInt("barbeque"));
				result_lst.setHostID(rs.getInt("hostID"));
				
				lists.add(result_lst);
			}
		
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return lists;
	}




	public ArrayList<ProBooking> findAllProBooking (){
		
		ArrayList<ProBooking> lists = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			//TODO
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = "SELECT * FROM team022.proBooking";
			pstmt = con.prepareStatement(sql);
			//pstmt.setNString(1, pc);

			rs = pstmt.executeQuery();
			
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				ProBooking result = new ProBooking ();
				result.setPkProBookNo(rs.getInt("proBookingNo"));
				result.setFstNightDate(rs.getDate("firstNight"));
				result.setLstNightDate(rs.getDate("lastNight"));
				result.setBookingCon(rs.getInt("comfirmed"));
				result.setFkPostcode(rs.getString("addrPostcode"));
				result.setFkHouse(rs.getString("addrHouse"));
				result.setFkGuestID(rs.getInt("guestID"));
				
				lists.add(result);
				
			}
			
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return lists;

	}

	public ArrayList<Person> findallpersonInDB() {
		
		ArrayList<Person> lists = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			//TODO
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = "SELECT * FROM team022.person";
			pstmt = con.prepareStatement(sql);
			//pstmt.setNString(1, pc);

			rs = pstmt.executeQuery();
			
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				Person p = new Person();
				p.setPkEmail(rs.getString("email"));
				p.setTitle(rs.getString("title"));
				p.setForename(rs.getString("forename"));
				p.setSurname(rs.getString("surname"));
				p.setPhoneNum(rs.getInt("phoneNo"));
				p.setPsw(rs.getString("password"));
				lists.add(p);
			
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
				
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
//		for (int i =0; i<lists.size(); i++) {
//			
//			if (lists.get(i).getPsw() == password) {
//				//System.out.println("-1 ------"+lists.get(i).getPsw() );
//				//System.out.println("0------");
//				return true;
//			}
//			else
//				//System.out.println("1------");
//				return false;

		return lists;
	}


	public void deleteProBookingByGuestID(int guestID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, psw);
			//TODO
			if (con == null ) {
				System.err.println("didn't connect to the database! ");
			}
			else {
				System.out.println("connect the database successfully! ");
			}
			String sql = "DELETE FROM team022.proBooking WHERE guestID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, guestID);
			pstmt.executeUpdate();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {

			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();  
				
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
		
	}
	
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
//	public ArrayList<Property> getPropertiesList() {
//		return propertiesList;
//	}
//
//	public ArrayList<Guest> getGuestList() {
//		return guestList;
//	}
//
//	public ArrayList<Person> getPersonList() {
//		return personList;
//	}
//
//	public ArrayList<ProBooking> getProBookingList() {
//		return proBookingList;
//	}

	public static void main(String[] args) throws Exception {
		
//		Person tracy = new Person();
//		tracy.setPhoneNum(7093921);
//		tracy.setPsw("sheknowsnothing");
//		tracy.setSurname("Tracy");
//		tracy.setForename("Liu");
//		tracy.setTitle("Dr");
//		tracy.setPkEmail("2543573381@qq.com");
//		
//		Guest tracy2 = new Guest();
//		tracy2.setEmail("2543573381@qq.com");
//		tracy2.setGuestID(1);
//		tracy2.setPublicGName("Tracy Liu");
		
		
//		SQL_Connecting test = new SQL_Connecting();
//		test.addToPersonTable(tracy);
//		test.addToGuestTable(tracy2);
//		System.out.println(test.findGuestByEmail("2543573381@qq.com").getGuestID());
//		System.out.println(test.findGuestByEmail("2543573381@qq.com").getPublicGName());
//		System.out.println(test.findGuestByEmail("2543573381@qq.com").getEmail());
//		SQL_Connecting test = new SQL_Connecting();
//		System.out.println(test.findPropertyByPostCode("S14DX").getLongDesc());
		
	}
	
	
}
