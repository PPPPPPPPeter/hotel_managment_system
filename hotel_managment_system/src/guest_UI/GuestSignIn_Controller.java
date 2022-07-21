package guest_UI;


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import guest.Guest;
import initUI.GetguestID;
import initUI.Init_UI;
import person.Person;
import sql.SQL_Connecting;

/**
 * 
 * @author peterwong
 *
 */

public class GuestSignIn_Controller extends JFrame implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String btnCommand;
	
	
	private JFrame signIn_UI;
	
	private SQL_Connecting DBInfor = new SQL_Connecting();
	
	private String textFieldString, pwdString;
	
	private JTextField userName;
	
	private JPasswordField pwd;

	public GuestSignIn_Controller (JFrame signIn_UI, String textFieldString, String pwdString,  
			JTextField userName, JPasswordField pwd) {
		
		this.signIn_UI = signIn_UI;
		
		this.textFieldString =  textFieldString;
		
		this.pwdString = pwdString;
		
		this.userName = userName;
		
		this.pwd = pwd;
		
	}

	//@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.btnCommand = e.getActionCommand();
		
		if (this.btnCommand == "Sign in") {
//			System.out.println("1------"+this.pwdString);
			
			this.textFieldString = this.userName.getText();
			
			this.pwdString = this.pwd.getText();
			
			ArrayList<Person> allPerson = this.DBInfor.findallpersonInDB();
			
			Guest guestInDB = this.DBInfor.findGuestByEmail(this.textFieldString);
			
			boolean isPersonInDB = false;
			
			for (int i=0 ; i<allPerson.size(); i++) {
			
				if (allPerson.get(i).getPsw().equals(this.pwdString)) {
					//System.out.println("2------"+isPersonInDB );
					isPersonInDB = true;
					//System.out.println("3------"+isPersonInDB );
				}
			}
			
			//System.out.println("2------"+isPersonInDB);
			//System.out.println("3------"+guestInDB);
			
			if (guestInDB!=null && isPersonInDB == true) {
				
				GetguestID.setHaveSignedIn(true);
				GetguestID.setGuestID(guestInDB.getGuestID());
				
			
				this.signIn_UI.dispose();
				
				new Init_UI().startUI();
			}
			else {
				showUISignInfail();
			}
		}
		
		else {
			//TODO
		}
		
		
	}
	private void showUISignInfail() {
		

		this.setTitle("Can't Sign in!");
		this.setBounds(450, 150, 600, 480);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		JLabel stringLa = new JLabel("Please try it again!");
		stringLa.setBounds(100, 100, 400, 300);
		JButton okbtn = new JButton("OK");
		okbtn.setBounds(250, 420, 50, 25);
		this.add(stringLa);
		this.add(okbtn);
		JFrame a = this;
		this.setVisible(true);
		okbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a.dispose();
			}
			
		});
		
		
	}
	
	public String getBtnCommand() {
		return btnCommand;
	}

	public void setBtnCommand(String btnCommand) {
		this.btnCommand = btnCommand;
	}
	


}