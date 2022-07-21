package initUI;
import java.awt.Color;
import guest_UI.*;
import java.awt.Graphics;
import java.awt.GridLayout;
//import java.awt.Stroke;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import property.Property;
import sql.SQL_Connecting;



public class Init_UI extends JFrame{


	private static final long serialVersionUID = 1L;
	

	private JLabel selectedLst;
	private JScrollPane jscrollPane_selectedLst;
	private JScrollPane jscrollPane_selectingLst;
	
	private SQL_Connecting getDBInfo = new SQL_Connecting ();

	//private Init_UI_Controller initUIListnner = new Init_UI_Controller ();
	private ArrayList <Property> pptsUsedToSelectingArea;
	private ArrayList <Property> pptsHadbeenselected = new ArrayList<>();
	private ArrayList <JButton> btnsShowLongDesri = new ArrayList<JButton> ();
	private Init_UI_Controller initUIListnner;
	
	
	


	public void startUI() {
		
		this.setTitle("Select Interface");
		this.setBounds(400, 100, 800, 640);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.ui.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		this.setLayout(null);
		
		
		//TODO实例化JPanel类：
        JPanel nameStr = new JPanel();
        nameStr.setLayout(new GridLayout(5, 5));
        this.pptsUsedToSelectingArea = this.getDBInfo.findAllProperties();
        for (int i = 0; i< this.pptsUsedToSelectingArea.size(); i++) {
        	JButton nameStrbtn = new JButton(this.pptsUsedToSelectingArea.get(i).getLongDesc());
    	    nameStrbtn.setBounds(10, 20+i*100, 350, 100);
    	    nameStrbtn.setHorizontalTextPosition(JButton.CENTER);
    	    nameStr.add(nameStrbtn);
    	    this.btnsShowLongDesri.add(nameStrbtn);
        }
        
        
        
        this.selectedLst = new JLabel ();
		this.selectedLst.setLayout(new GridLayout(5,5));
	
		for (int i =0; i<this.getDBInfo.findAllProBooking().size(); i++) {
			//System.out.println("------"+this.pptsHadbeenselected.get(i));
			if (this.getDBInfo.findAllProBooking().get(i).getFkGuestID() == GetguestID.getGuestID()) {
				JButton btn = new JButton (this.getDBInfo.findAllProBooking().get(i).getFkPostcode());
				btn.setHorizontalTextPosition(JButton.CENTER);
				this.selectedLst.add(btn);
			}
//			JButton btn = new JButton (this.getDBInfo.findAllProBooking().get(i).getFkPostcode());
//			btn.setHorizontalTextPosition(JButton.CENTER);
//			this.selectedLst.add(btn);
		}
        
//        this.selectedLst = new JLabel ();
//        this.selectedLst.setLayout(new GridLayout(5,5));
//        for (int i =0; i<30; i++) {
//        	System.out.println("------");
//        	JButton btn = new JButton("sdsd");
//        	btn.setHorizontalTextPosition(JButton.CENTER);
//        	this.selectedLst.add(btn);
//        }
        
        
		
		
		
		
		this.jscrollPane_selectedLst = new JScrollPane(this.selectedLst);
		this.jscrollPane_selectedLst.setBounds(520, 10, 250, 570);
        
	
		this.jscrollPane_selectingLst = new JScrollPane(nameStr);
		this.jscrollPane_selectingLst.setBounds(50, 10, 420, 570);
		this.jscrollPane_selectingLst.setBackground(Color.GRAY);

		this.add(jscrollPane_selectingLst);
		this.add(this.jscrollPane_selectedLst);
		
		JFrame thisUI = this;
		this.setVisible(true);
		
		this.initUIListnner = new Init_UI_Controller(this.pptsUsedToSelectingArea, 
				this.pptsHadbeenselected, thisUI);
		
		for (int i =0 ; i< this.btnsShowLongDesri.size(); i++) {
			JButton btn = this.btnsShowLongDesri.get(i);
			btn.addActionListener(this.initUIListnner);
		}
		
	}
	
//	public void repaint(Graphics g){
//		
//	}
	


	public JScrollPane getJscrollPane_selectedLst() {
		return jscrollPane_selectedLst;
	}

	public void setJscrollPane_selectedLst(JScrollPane jscrollPane_selectedLst) {
		this.jscrollPane_selectedLst = jscrollPane_selectedLst;
	}

	public JScrollPane getJscrollPane_selectingLst() {
		return jscrollPane_selectingLst;
	}

	public void setJscrollPane_selectingLst(JScrollPane jscrollPane_selectingLst) {
		this.jscrollPane_selectingLst = jscrollPane_selectingLst;
	}

	public ArrayList<Property> getPptsUsedToSelectingArea() {
		return pptsUsedToSelectingArea;
	}

	public void setPptsUsedToSelectingArea(ArrayList<Property> pptsUsedToSelectingArea) {
		this.pptsUsedToSelectingArea = pptsUsedToSelectingArea;
	}

	public ArrayList<Property> getPptsHadbeenselected() {
		return pptsHadbeenselected;
	}

	public void setPptsHadbeenselected(ArrayList<Property> pptsHadbeenselected) {
		this.pptsHadbeenselected = pptsHadbeenselected;
	}
	
	public SQL_Connecting getGetDBInfo() {
		return getDBInfo;
	}

	public void setGetDBInfo(SQL_Connecting getDBInfo) {
		this.getDBInfo = getDBInfo;
	}
	
	
	public ArrayList<JButton> getBtnsShowLongDesri() {
		return btnsShowLongDesri;
	}

	public void setBtnsShowLongDesri(ArrayList<JButton> btnsShowLongDesri) {
		this.btnsShowLongDesri = btnsShowLongDesri;
	}
	
	public static void main(String[] args) {
		// new Init_UI().startUI();
	}
}
