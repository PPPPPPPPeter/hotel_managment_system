package initUI;

import property.Property;
import sql.SQL_Connecting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import guest_UI.ShowPPtDetails_UI;


public class Init_UI_Controller implements ActionListener {
	
	private String btnCommand;
	
	private ArrayList <Property> pptsUsedToSelectingArea, pptsHadbeenselected;
	
	private Property pptClicked;
	
	private JFrame Init_UI;
	
	private ShowPPtDetails_UI ShowPPtDetails_UI;
	
	//private SQL_Connecting getDBInfo;
	
	public Init_UI_Controller(ArrayList <Property> pptsUsedToSelectingArea, 
			ArrayList <Property> pptsHadbeenselected, JFrame Init_UI) {
		
		this.pptsHadbeenselected = pptsHadbeenselected;
		
		this.pptsUsedToSelectingArea = pptsUsedToSelectingArea;
		
		this.Init_UI = Init_UI;
		
		//this.getDBInfo = getDBInfo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Controller installed successfully!!!");
		
		this.btnCommand = e.getActionCommand();
		
		
		
		for (int i=0; i<this.pptsUsedToSelectingArea.size(); i++) {
			
			if (this.pptsUsedToSelectingArea.get(i).getLongDesc()==this.btnCommand) {
				
//				System.out.println("-----"+this.pptsUsedToSelectingArea
//						.get(i).getLongDesc());
				
				this.pptClicked = this.pptsUsedToSelectingArea.get(i);
			}
			
		}
		
		this.ShowPPtDetails_UI = new ShowPPtDetails_UI(this.pptsHadbeenselected,
				this.pptClicked, this.Init_UI);
		 
		this.ShowPPtDetails_UI.startUI();
		
	}
	
}