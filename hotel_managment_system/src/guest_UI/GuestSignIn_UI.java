package guest_UI;


import java.awt.Graphics;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import property.Property;
/**
 * 
 * @author peterwong
 *
 */
//TODO 

public class GuestSignIn_UI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Graphics g;
	
	private JButton btnSignUp, btnSignIn;
	
	private JFrame ui =  new JFrame();
	
	private JFrame Init_UI;
	
	private JTextField userName;
	
	private JPasswordField pwd;
	
	private Property pptClicked;
	
	private ActionListener btnController ;
	
	private String textFieldString, pwdString;
	
	public GuestSignIn_UI( Property pptClicked, JFrame Init_UI) {
		
		this.pptClicked = pptClicked;
		
		this.Init_UI = Init_UI;
	}
	
	@SuppressWarnings("deprecation")
	public void startUI() {
	
		this.ui.setTitle("SIGN IN/ SIGN UP");
		this.ui.setBounds(450, 150, 600, 480);
		//this.ui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.ui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.ui.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		this.ui.setLayout(null);
		
        JLabel nameStr = new JLabel("UserID:");
        nameStr.setBounds(220, 200, 100, 25);
        this.ui.add(nameStr);
        
        JLabel passwordStr = new JLabel("Password:");
        passwordStr.setBounds(220, 250, 100, 25);
        this.ui.add(passwordStr);  
        
        this.userName = new JTextField();
        this.userName.setBounds(320, 200, 120, 25);
        //this.userName.setText("sdsdsdsd");
        this.ui.add(userName);
        //this.textFieldString = this.userName.getText();
        //this.userName.getText();
        
        this.pwd = new JPasswordField();
        this.pwd.setBounds(320, 250, 120, 25);
        this.ui.add(pwd);
//        this.pwdString = this.pwd.getText();

        this.btnSignIn = new JButton("Sign in");
        this.btnSignIn.setBounds(300, 300, 80, 25);
        this.ui.add(btnSignIn);
        
        this.btnSignUp = new JButton("Sign up");
        this.btnSignUp.setBounds(400, 300, 80, 25);
        this.ui.add(btnSignUp);
        
        

//		this.userName = new JTextField(12);
//		this.pwd = new JPasswordField(12);
//		this.ui.add(userName);
//		this.ui.add(pwd);
//		this.ui.add(btnSignIn);
//		this.ui.add(btnSignUp);
        
		this.ui.setVisible(true);
		this.g = this.ui.getGraphics();
		this.btnController =  new GuestSignIn_Controller(this.ui, this.textFieldString,
				this.pwdString, this.userName, this.pwd);
		this.btnSignIn.addActionListener(btnController);
		this.btnSignUp.addActionListener(btnController);
		
	}
	

	public Graphics getG() {
		return g;
	}


	public void setG(Graphics g) {
		this.g = g;
	}


	public JTextField getUserName() {
		return userName;
	}

	
	public void setUserName(JTextField userName) {
		this.userName = userName;
	}


	public JPasswordField getPwd() {
		return pwd;
	}


	public void setPwd(JPasswordField pwd) {
		this.pwd = pwd;
	}


	public static void main(String[] args) {
//		new GuestSignIn_UI().startUI();
	}
}
