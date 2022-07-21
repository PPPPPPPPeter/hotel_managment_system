package guest_UI;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import property.Property;

public class ShowPPtDetails_UI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton Bookbtn;
	
	private JTextArea showDetails ;
	
	private JScrollPane detailScrollPanel;
	
	private ArrayList <Property> pptsHadbeenselected;
	
	private Property pptClicked;
	
	private JFrame Init_UI;
	
	private ShowPPt_UIController uiController;

	public ShowPPtDetails_UI(ArrayList <Property> pptsHadbeenselected,
			Property pptClicked, JFrame Init_UI) {
		
		this.pptsHadbeenselected = pptsHadbeenselected;
		
		this.pptClicked = pptClicked;
		 
		this.Init_UI = Init_UI;
		
	}
	
	public void startUI() {
		
		this.setTitle("About the property details");
		this.setBounds(500, 200, 600, 440);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setLayout(null);
		this.Bookbtn = new JButton("Book it!"); 
		this.Bookbtn.setBounds(250, 350, 100, 30);
		
		this.showDetails = new JTextArea();
		this.showDetails.setBounds(50, 50, 500, 270);
		this.showDetails.setBackground(Color.GRAY);
		this.showDetails.setEditable(false);
		//let the text area show the details of the property:
		this.showDetails.setLineWrap(true);
		this.showDetails.setWrapStyleWord(true);;
		this.showDetails.append(
				this.pptClicked.getAddrCity()+",  "
				+this.pptClicked.getAddrHouse()+",  "
				+this.pptClicked.getAddrPostcode()+",  "
				+this.pptClicked.getAddrStreet()+",  "
				+this.pptClicked.getBarbeque()+",  "
				+this.pptClicked.getBasics()+",  "
				+this.pptClicked.getBedLinin()+",  "
				+this.pptClicked.getBoardGames()+",  "
				+this.pptClicked.getBreakfast()+",  "
				+this.pptClicked.getCookware()+",  "
				+this.pptClicked.getDishwasher()+",  "
				+this.pptClicked.getDryer()+",  "
				+this.pptClicked.getDvdPlayer()+",  "
				+this.pptClicked.getFireExting()+",  "
				+this.pptClicked.getFirstAidKit()+",  "
				+this.pptClicked.getFreeParking()+",  "
				+this.pptClicked.getFridge()+",  "
				+this.pptClicked.getGenbLocal()+",  "
				+this.pptClicked.getHairDryer()+",  "
				+this.pptClicked.getHeating()+",  "
				+this.pptClicked.getHostID()+", "
				+this.pptClicked.getMicrowave()+",  "
				+this.pptClicked.getOven()+",  "
				+this.pptClicked.getPaidParking()+",  "
				+this.pptClicked.getPatio()+"  "
				+this.pptClicked.getPropName()+",  "
				+this.pptClicked.getRoadParking()+",  "
				+this.pptClicked.getSatellite()+",  "
				+this.pptClicked.getShampoo()+",  "
				+this.pptClicked.getSmokeAlarm()+",  "
				+this.pptClicked.getStove()+",  "
				+this.pptClicked.getStreaming()+",  "
				+this.pptClicked.getTableware()+",  "
				+this.pptClicked.getTelevision()+",  "
				+this.pptClicked.getToiletPaper()+",  "
				+this.pptClicked.getTowels()+",  "
				+this.pptClicked.getWashingMachine()+",  "
				+this.pptClicked.getWifi()+".");
		
		
		
		this.detailScrollPanel = new JScrollPane(this.showDetails);
		this.detailScrollPanel.setBounds(50, 50, 500, 270);
		
		this.add(detailScrollPanel);
		this.add(Bookbtn);
		this.setVisible(true);
		JFrame a = this;
		
		this.uiController = new ShowPPt_UIController(this.pptsHadbeenselected,
				this.Init_UI, this.pptClicked, a);
		this.Bookbtn.addActionListener(uiController);
	}
	
//	public static void main(String[] args) {
//		new ShowPPtDetails_UI().startUI();
//	}
//	

}
