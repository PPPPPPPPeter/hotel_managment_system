package host_UI;

import javax.swing.JFrame;



public class Host_UI extends JFrame {
	public Host_UI(Host_UI_Properties panel) {
		setTitle("Properties");
		add(panel);
		// maximises the JFrame
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
