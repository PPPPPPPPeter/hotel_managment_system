package guest_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import javax.swing.JTextField;

import initUI.GetguestID;
import initUI.Init_UI;
import property.ProBooking;
import property.Property;
import sql.SQL_Connecting;

public class SelectDate_Controller implements ActionListener{
	
	private String firstDate, lastDate;
	
	private JTextField fstdate, lstdate ;
	
	private SQL_Connecting getDBInfo;
	
	private Property pptClicked;
	
	public SelectDate_Controller(JTextField fstdate, JTextField lstdate,
			SQL_Connecting getDBInfo, Property pptClicked) {
		
		this.fstdate = fstdate;
		
		this.lstdate = lstdate;
		
		this.getDBInfo = getDBInfo;
		
		this.pptClicked = pptClicked;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.firstDate = this.fstdate.getText();
		this.lastDate = this.lstdate.getText();
		
		ProBooking appointment = new ProBooking();
		appointment.setPkProBookNo(this.pptClicked.hashCode());
		
		try {
			appointment.setFstNightDate(this.stringTodate(firstDate));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			appointment.setLstNightDate(this.stringTodate(lastDate));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		appointment.setBookingCon(0);
		appointment.setFkPostcode(this.pptClicked.getAddrPostcode());
		appointment.setFkHouse(this.pptClicked.getAddrHouse());
		appointment.setFkGuestID(GetguestID.getGuestID());
		
		this.getDBInfo.addToProBookingTable(appointment);
		
		new Init_UI().startUI();
		
		
	}
	
	private java.sql.Date stringTodate(String strDate) throws ParseException {
		
		String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;

		
	}

}
