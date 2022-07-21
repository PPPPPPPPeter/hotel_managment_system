package guest_UI;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import initUI.GetguestID;
import initUI.Init_UI;
import property.ProBooking;
import property.Property;
import sql.SQL_Connecting;

public class ShowPPt_UIController extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList <Property> pptsHadbeenselected;
	
	private String btnCommand;
	
	private JFrame Init_UI, ShowPPtDetails_UI;
	
	private Property pptClicked;
	
	
	private SQL_Connecting getDBInfo = new SQL_Connecting ();
	
	public ShowPPt_UIController(ArrayList <Property> pptsHadbeenselected, 
			JFrame Init_UI, Property pptClicked, JFrame ShowPPtDetails_UI) {
		
		this.pptsHadbeenselected = pptsHadbeenselected;
		
		this.Init_UI = Init_UI;
		
		this.pptClicked = pptClicked;
		
		this.ShowPPtDetails_UI = ShowPPtDetails_UI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		this.btnCommand = e.getActionCommand();
		
		if (this.btnCommand == "Book it!" && GetguestID.isHaveSignedIn() ==true) {
			
			startSelectDateUI ();
			//this.pptsHadbeenselected.add(this.pptClicked);
//			StoreGuestID.setGuestID(1);
//			GetguestID.setGuestID(1);
			
//			ProBooking appointment = new ProBooking();
//			appointment.setPkProBookNo(this.pptClicked.hashCode());
//			appointment.setFstNightDate(null);
//			appointment.setLstNightDate(null);
//			appointment.setBookingCon(0);
//			appointment.setFkPostcode(this.pptClicked.getAddrPostcode());
//			appointment.setFkHouse(this.pptClicked.getAddrHouse());
//			appointment.setFkGuestID(GetguestID.getGuestID());
//			
//			this.getDBInfo.addToProBookingTable(appointment);
//			
			this.Init_UI.dispose();
//			
			this.ShowPPtDetails_UI.dispose();
//			
//			new Init_UI().startUI();
			
		}
		
		else if (this.btnCommand == "Book it!" && GetguestID.isHaveSignedIn() == false) {
			
//			startSelectDateUI ();
			
			new GuestSignIn_UI(this.pptClicked, this.Init_UI).startUI();
			
			this.Init_UI.dispose();
			
			this.ShowPPtDetails_UI.dispose();
		
		}
	}
	
	public void startSelectDateUI () {
		
		this.setTitle("Select the date!!");
		this.setBounds(450, 150, 600, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		JButton btn = new JButton("OK");
		
		JLabel for_firstNight = new JLabel("First night:");
		for_firstNight.setBounds(220, 200, 100, 25);
		this.add(for_firstNight);
		
		JLabel for_lastNight = new JLabel("Last night:");
		for_lastNight.setBounds(220, 250, 100, 25);
		this.add(for_lastNight);
		
		JTextField firstNight = new JTextField();
		firstNight.setBounds(320, 200, 120, 25);
		firstNight.setText("yyyy-MM-dd");
		this.add(firstNight);
		
		JTextField lastNight = new JTextField();
		lastNight.setBounds(320, 250, 120, 25);
		lastNight.setText("yyyy-MM-dd");
		this.add(lastNight);
		
		btn.setBounds(250, 300, 100, 30);
		this.add(btn);
		
		this.setVisible(true);
		
		SelectDate_Controller listener= new SelectDate_Controller(firstNight, 
				lastNight, this.getDBInfo, this.pptClicked); 
		
		btn.addActionListener(listener);
		
		
		
		
		
		
		
		
		
		
		
	}

}
