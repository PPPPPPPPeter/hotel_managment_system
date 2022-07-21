package host_UI;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import property.*;
import sql.SQL_Connecting;

/**
 * 
 * @author Evan Quinn & Tom Stuart
 *
 */
public class Host_UI_Properties extends JPanel {
	final int HOSTID = 12345;
	/*
	 * HOW TO GET TO PAGE
	 * button on home page of user takes to host page
	 */
	
	/*
	 * WHAT DOES THE PAGE DO
	 * gui for a page with all the current properties owned
	 * button to click and takes to provisional/bookings for the property (Tom to do)
	 * button to edit properties of the property
	 * possibly a button to take to reviews page for the property
	 * button in corner or something that allows to create a new property
	 */
	
	/*
	 * WHAT DOES NEXT PAGE DO
	 * gui page for creating/editing new property list all the db shit
	 * a save button takes back to properties page
	 */
	
	
	
	
	private ArrayList<Property> propities = findProperties();
	private int amountOfProps = propities.size();
	private JButton[] btnProperties;
	private JButton[] btnBookings;
	private JButton[] btnDeleteProperty;
	private JButton btnNewProp = new JButton("New Property");
	private JPanel[] property;
	private JPanel props = new JPanel();	
	private JScrollPane mainScrollPane = new JScrollPane(props);
	
	//this will eventualy go just made a new class for the time being 
	public Host_UI_Properties() {
		Host_UI_P();
	}
	
	public ArrayList<Property> findProperties() {
		SQL_Connecting sqlConnection = new SQL_Connecting();
		return sqlConnection.findAllHostsProperties(HOSTID);
	}
	
	public void Host_UI_P(){
		propities = findProperties();
		amountOfProps = propities.size();
		
		btnProperties = new JButton[amountOfProps];
		btnBookings = new JButton[amountOfProps];
		btnDeleteProperty = new JButton[amountOfProps];
		property = new JPanel[amountOfProps];
		
		props.setLayout(new GridLayout(0,1));
		props.add(btnNewProp);
		//loops over array to create panels with corrosopnding buttons
        for (int i=0; i<amountOfProps; i++) { 
        	btnProperties[i] = new JButton("Properties");
        	btnBookings[i] = new JButton("Bookings");
        	btnDeleteProperty[i] = new JButton("Delete property");
        	property[i] = new JPanel();
        	property[i].setLayout(new FlowLayout());
        	property[i].add(new JLabel(propities.get(i).getAddrHouse()));
        	property[i].add(new JLabel(propities.get(i).getAddrStreet()));
        	property[i].add(btnBookings[i]);
        	property[i].add(btnProperties[i]);
        	property[i].add(btnDeleteProperty[i]);
        	
        
        	props.add(property[i]);
        }
        addListeners();
        mainScrollPane.setPreferredSize(new Dimension(1000, 1000));
        this.add(mainScrollPane);
	}
	
	//create button
	private JButton btnCreateProp = new JButton("Create Property");
	private JPanel btnCreatePanel = new JPanel();
	
	//optional booleans
	private JCheckBox cbBreakfast = new JCheckBox("Is breakfast provided?");
	private JCheckBox cbHairDryer = new JCheckBox("Is a hair dryer provided?");
	private JCheckBox cbShampoo = new JCheckBox("Is shampoo provided?");
	private JCheckBox cbToiletPaper = new JCheckBox("Is toilet paper provided?");
	private JCheckBox cbBedLinin = new JCheckBox("Is bed linin provided?");
	private JCheckBox cbTowels = new JCheckBox("Are towels provided?");
	private JCheckBox cbFridge = new JCheckBox("Is a fridge provided?");
	private JCheckBox cbMicrowave = new JCheckBox("Is a microwave provided?");
	private JCheckBox cbOven = new JCheckBox("Is a oven provided?");
	private JCheckBox cbStove = new JCheckBox("Is a stove provided?");
	private JCheckBox cbDishwasher = new JCheckBox("Is a dishwasher provided?");
	private JCheckBox cbTableware = new JCheckBox("Is tableware provided?");
	private JCheckBox cbCookware = new JCheckBox("Is cookware provided?");
	private JCheckBox cbBasics = new JCheckBox("Are basic provisions provided?");
	private JCheckBox cbWifi = new JCheckBox("Is wifi provided?");
	private JCheckBox cbTelevision = new JCheckBox("Is a TV provided?");
	private JCheckBox cbSatellite = new JCheckBox("Is satallite provided?");
	private JCheckBox cbStreaming = new JCheckBox("Is streaming provided?");
	private JCheckBox cbDvdPlayer = new JCheckBox("Is a DVD player provided?");
	private JCheckBox cbBoardGames = new JCheckBox("Are board games provided?");
	private JCheckBox cbHeating = new JCheckBox("Is central heating provided?");
	private JCheckBox cbWashingMachine = new JCheckBox("Is a washing machine provided?");
	private JCheckBox cbDryer = new JCheckBox("Is a drying machine provided?");
	private JCheckBox cbFireExting = new JCheckBox("Is a fire extingisher provided?");
	private JCheckBox cbSmokeAlarm = new JCheckBox("Is a smoke alarm provided?");
	private JCheckBox cbFirstAidKit = new JCheckBox("Is a first aid kit provided?");
	private JCheckBox cbFreeParking = new JCheckBox("Is there free on site parking?");
	private JCheckBox cbRoadParking = new JCheckBox("Is there on road parking?");
	private JCheckBox cbPaidParking = new JCheckBox("Is there a paid car park?");
	private JCheckBox cbPatio = new JCheckBox("Is there a patio?");
	private JCheckBox cbBarbeque = new JCheckBox("Is there a barbeque?");
	private JPanel optionalsPanel = new JPanel();
	
	//property's postcode
	private JLabel addrPostcodeLabel = new JLabel("Property's postcode");
	private JTextField tfAddrPostcode = new JTextField(5);
	private JPanel addrPostcodePanel = new JPanel();
	
	//property's house
	private JLabel addrHouseLabel = new JLabel("Property's name or number");
	private JTextField tfAddrHouse = new JTextField(15);
	private JPanel addrHousePanel = new JPanel();
	
	//property's street
	private JLabel addrStreetLabel = new JLabel("Property's street");
	private JTextField tfAddrStreet = new JTextField(20);
	private JPanel addrStreetPanel = new JPanel();
	
	//property's city
	private JLabel addrCityLabel = new JLabel("Property's city");
	private JTextField tfAddrCity = new JTextField(20);
	private JPanel addrCityPanel = new JPanel();
	
	//property name
	private JLabel propNameLabel = new JLabel("A general name");
	private JTextField tfPropName = new JTextField(20);
	private JPanel propNamePanel = new JPanel();
	
	//General location
	private JLabel genLoacalLabel = new JLabel("A general loacation");
	private JTextField tfGenLocal = new JTextField(50);
	private JPanel genLoacalPanel = new JPanel();
	
	//Longer description
	private JLabel longDescLabel = new JLabel("A long description:");
	private JTextArea tfLongDesc = new JTextArea(3, 50);
	private JScrollPane longDescScroll = new JScrollPane(tfLongDesc);
	private JPanel longDescPanel = new JPanel();
	
	private JPanel areasPanel = new JPanel();
	
	
	//takes to create property page
	public void Host_UI_Create() {
		
		areasPanel.setLayout(new GridLayout(0,1));
		//property's postcode
		addrPostcodePanel.add(addrPostcodeLabel);
		addrPostcodePanel.add(tfAddrPostcode);
		areasPanel.add(addrPostcodePanel);
		
		//property's house
		addrHousePanel.add(addrHouseLabel);
		addrHousePanel.add(tfAddrHouse);
		areasPanel.add(addrHousePanel);
		
		//property's street
		addrStreetPanel.add(addrStreetLabel);
		addrStreetPanel.add(tfAddrStreet);
		areasPanel.add(addrStreetPanel);
		
		//property's city
		addrCityPanel.add(addrCityLabel);
		addrCityPanel.add(tfAddrCity);
		areasPanel.add(addrCityPanel);
		
		//property name
		propNamePanel.add(propNameLabel);
		propNamePanel.add(tfPropName);
		areasPanel.add(propNamePanel);
		
		//General location
		genLoacalPanel.add(genLoacalLabel);
		genLoacalPanel.add(tfGenLocal);
		areasPanel.add(genLoacalPanel);		
		
		//Longer Description
		longDescPanel.add(longDescLabel);
		longDescPanel.add(longDescScroll);
		areasPanel.add(longDescPanel);
		
		props.add(areasPanel);
		
		//booleans
		optionalsPanel.setLayout(new GridLayout(0,1));
		optionalsPanel.add(cbBreakfast);
		optionalsPanel.add(cbHairDryer);
		optionalsPanel.add(cbShampoo);
		optionalsPanel.add(cbToiletPaper);
		optionalsPanel.add(cbBedLinin);
		optionalsPanel.add(cbTowels);
		optionalsPanel.add(cbFridge);
		optionalsPanel.add(cbMicrowave);
		optionalsPanel.add(cbOven);
		optionalsPanel.add(cbStove);
		optionalsPanel.add(cbDishwasher);
		optionalsPanel.add(cbTableware);
		optionalsPanel.add(cbCookware);
		optionalsPanel.add(cbBasics);
		optionalsPanel.add(cbWifi);
		optionalsPanel.add(cbTelevision);
		optionalsPanel.add(cbSatellite);
		optionalsPanel.add(cbStreaming);
		optionalsPanel.add(cbDvdPlayer);
		optionalsPanel.add(cbBoardGames);
		optionalsPanel.add(cbHeating);
		optionalsPanel.add(cbWashingMachine);
		optionalsPanel.add(cbDryer);
		optionalsPanel.add(cbFireExting);
		optionalsPanel.add(cbSmokeAlarm);
		optionalsPanel.add(cbFirstAidKit);
		optionalsPanel.add(cbFreeParking);
		optionalsPanel.add(cbRoadParking);
		optionalsPanel.add(cbPaidParking);
		optionalsPanel.add(cbPatio);
		optionalsPanel.add(cbBarbeque);
		optionalsPanel.add(btnCreateProp);
		props.add(optionalsPanel);
		
		btnCreatePanel.add(btnCreateProp);
		props.add(btnCreatePanel);
		
	}
	
	
	private JCheckBox cbToilet = new JCheckBox("Is there a toilet?");
	private JCheckBox cbBath = new JCheckBox("Is there a bath?");
	private JCheckBox cbShared = new JCheckBox("Is the bathroom shared with host?");
	private JCheckBox cbShower = new JCheckBox("Is there a shower?");
	
	//buttons
	private JButton btnAnotherBathroom = new JButton("Add another bathroom after this");
	private JButton btnLastBathroom = new JButton("This is the last bathroom");
	private JButton btnNoBathroom = new JButton("Theres no bathroom");
	private JPanel bathPanel = new JPanel();
	public void Host_UI_Bathroom() {
		bathPanel.add(cbToilet);
		bathPanel.add(cbBath);
		bathPanel.add(cbShared);
		bathPanel.add(cbShower);
		
		//buttons
		bathPanel.add(btnNoBathroom);
		bathPanel.add(btnAnotherBathroom);
		bathPanel.add(btnLastBathroom);
		
		props.add(bathPanel);
	}
	
	
	
	private String[] beds1 = {"single", "double", "kingsize", "bunk"};
	private String[] beds2 = {"single", "double", "kingsize", "bunk", "no bed"};
	private JComboBox<String> comboBed1 = new JComboBox<>(beds1);
	private JComboBox<String> comboBed2 = new JComboBox<>(beds2);
	
	//buttons
	private JButton btnAnotherBedroom = new JButton("Add another bathroom after this");
	private JButton btnLastBedroom = new JButton("This is the last bathroom");
	private JButton btnNoBedroom = new JButton("Theres no bathroom");
	private JPanel bedPanel = new JPanel();
	public void Host_UI_Bedroom() {
		bedPanel.add(comboBed1);
		bedPanel.add(comboBed2);
		
		//buttons
		bedPanel.add(btnNoBedroom);
		bedPanel.add(btnAnotherBedroom);
		bedPanel.add(btnLastBedroom);
		
		props.add(bedPanel);
	}
	
	
	
	
	
	
	private JButton btnSaveProp = new JButton("Save changes");
	//takes to edit property page
	public void Host_UI_Edit() {
		props.add(btnSaveProp);
	}
	
	private JButton btnBack = new JButton("Back");
	//takes to bookings page
	public void Host_UI_Bookings() {
		//TODO Tom put your code here
		//Tom this will eventualy need to take a parmater of the address or something maybe for now just do ui and listeners
		props.add(btnBack);
	}
	
	//adds listeners to the buttons 
	public void addListeners() {
		//loops over the length of array to make listeners 
		for (int i = 0; i<amountOfProps; i++) {
			final int  index = i;
			btnProperties[i].addActionListener(e -> {
				//removes the panels contents and adds new contents (takes to properties page)
				props.removeAll();
				props.revalidate();
				Host_UI_Edit();
				props.repaint();
				//can use index to check which property was chosen maybe make array list or something
				System.out.println(index);
			});
		}
		for (int i = 0; i<amountOfProps; i++) {
			final int  index = i;
			btnBookings[i].addActionListener(e -> {
				//removes the panels contents and adds new contents (takes to bookings page)
				props.removeAll();
				props.revalidate();
				Host_UI_Bookings();
				props.repaint();
				//can use index to check which property was chosen maybe make array list or something
				System.out.println(index);
			});
		}
		for (int i = 0; i<amountOfProps; i++) {
			final int  index = i;
			btnDeleteProperty[i].addActionListener(e -> {
				//removes the panels contents and adds new contents (takes to bookings page)
				
				SQL_Connecting sqlConnection = new SQL_Connecting();
				
				sqlConnection.deleteFromProperty(propities.get(index));
				
				props.removeAll();
				props.revalidate();
				Host_UI_P();
				props.repaint();
				//can use index to check which property was chosen maybe make array list or something
				System.out.println(index);
			});
		}
		btnNewProp.addActionListener(e -> {
			//removes the panels contents and adds new contents (takes to new property page)
			props.removeAll();
			props.revalidate();
			Host_UI_Create();
			props.repaint();
		});
		btnCreateProp.addActionListener(e -> {
			//removes the panels contents and adds new contents (takes to previous page)
			Property newProperty = new Property();
			newProperty.setBreakfast(boolConvert(cbBreakfast.isSelected()));
			newProperty.setHairDryer(boolConvert(cbHairDryer.isSelected()));
			newProperty.setShampoo(boolConvert(cbShampoo.isSelected()));
			newProperty.setToiletPaper(boolConvert(cbToiletPaper.isSelected()));
			newProperty.setBedLinin(boolConvert(cbBedLinin.isSelected()));
			newProperty.setTowels(boolConvert(cbTowels.isSelected()));
			newProperty.setFridge(boolConvert(cbFridge.isSelected()));
			newProperty.setMicrowave(boolConvert(cbMicrowave.isSelected()));
			newProperty.setOven(boolConvert(cbOven.isSelected()));
			newProperty.setStove(boolConvert(cbStove.isSelected()));
			newProperty.setDishwasher(boolConvert(cbDishwasher.isSelected()));
			newProperty.setTableware(boolConvert(cbTableware.isSelected()));
			newProperty.setCookware(boolConvert(cbCookware.isSelected()));
			newProperty.setBasics(boolConvert(cbBasics.isSelected()));
			newProperty.setWifi(boolConvert(cbWifi.isSelected()));
			newProperty.setTelevision(boolConvert(cbTelevision.isSelected()));
			newProperty.setSatellite(boolConvert(cbSatellite.isSelected()));
			newProperty.setStreaming(boolConvert(cbStreaming.isSelected()));
			newProperty.setDvdPlayer(boolConvert(cbDvdPlayer.isSelected()));
			newProperty.setBoardGames(boolConvert(cbBoardGames.isSelected()));
			newProperty.setHeating(boolConvert(cbHeating.isSelected()));
			newProperty.setWashingMachine(boolConvert(cbWashingMachine.isSelected()));
			newProperty.setDryer(boolConvert(cbDryer.isSelected()));
			newProperty.setFireExting(boolConvert(cbFireExting.isSelected()));
			newProperty.setSmokeAlarm(boolConvert(cbSmokeAlarm.isSelected()));
			newProperty.setFirstAidKit(boolConvert(cbFirstAidKit.isSelected()));
			newProperty.setFreeParking(boolConvert(cbFreeParking.isSelected()));
			newProperty.setRoadParking(boolConvert(cbRoadParking.isSelected()));
			newProperty.setPaidParking(boolConvert(cbPaidParking.isSelected()));
			newProperty.setPatio(boolConvert(cbPatio.isSelected()));
			newProperty.setBarbeque(boolConvert(cbBarbeque.isSelected()));
			newProperty.setHostID(HOSTID); //////////////////////change to the current host id
			newProperty.setAddrPostcode(tfAddrPostcode.getText());
			newProperty.setAddrHouse(tfAddrHouse.getText());
			newProperty.setAddrStreet(tfAddrStreet.getText());
			newProperty.setAddrCity(tfAddrCity.getText());
			newProperty.setPropName(tfPropName.getText());
			newProperty.setLongDesc(tfLongDesc.getText());
			newProperty.setGenbLocal(tfGenLocal.getText());
			
			SQL_Connecting sqlConnection = new SQL_Connecting();
			
			sqlConnection.addToProperty(newProperty);
			
			////////////////////////////////////////////////////////TODO need to add bed and bath rooms and change db to not null and some vals and shit and charge bands and edit
			props.removeAll();
			props.revalidate();
			Host_UI_Bathroom();
			props.repaint();
		});
		btnAnotherBathroom.addActionListener(e -> {
			
			Bathroom newBathroom = new Bathroom();
			
			SQL_Connecting sqlConnection = new SQL_Connecting();
			
			newBathroom.setBathID(sqlConnection.findNextBathroomID());
			newBathroom.setToilet(boolConvert(cbToilet.isSelected()));
			newBathroom.setBath(boolConvert(cbBath.isSelected()));
			newBathroom.setShared(boolConvert(cbShared.isSelected()));
			newBathroom.setShower(boolConvert(cbShower.isSelected()));
			newBathroom.setAddrPostcode(tfAddrPostcode.getText());
			newBathroom.setAddrHouse(tfAddrHouse.getText());
			
			sqlConnection.addToBathroom(newBathroom);
			
			props.removeAll();
			props.revalidate();
			Host_UI_Bathroom();
			props.repaint();
		});
		btnLastBathroom.addActionListener(e -> {
			
			Bathroom newBathroom = new Bathroom();
			
			SQL_Connecting sqlConnection = new SQL_Connecting();
			
			newBathroom.setBathID(sqlConnection.findNextBathroomID());
			newBathroom.setToilet(boolConvert(cbToilet.isSelected()));
			newBathroom.setBath(boolConvert(cbBath.isSelected()));
			newBathroom.setShared(boolConvert(cbShared.isSelected()));
			newBathroom.setShower(boolConvert(cbShower.isSelected()));
			newBathroom.setAddrPostcode(tfAddrPostcode.getText());
			newBathroom.setAddrHouse(tfAddrHouse.getText());
			
			sqlConnection.addToBathroom(newBathroom);
			
			props.removeAll();
			props.revalidate();
			Host_UI_Bedroom();
			props.repaint();
		});
		btnNoBathroom.addActionListener(e -> {
			props.removeAll();
			props.revalidate();
			Host_UI_Bedroom();
			props.repaint();
		});
		btnAnotherBedroom.addActionListener(e -> {
			
			Bedroom newBedroom = new Bedroom();
			
			SQL_Connecting sqlConnection = new SQL_Connecting();
			
			newBedroom.setBedID(sqlConnection.findNextBedroomID());
			newBedroom.setBed1((String)comboBed1.getSelectedItem());
			newBedroom.setBed2((String)comboBed2.getSelectedItem());
			newBedroom.setAddrPostcode(tfAddrPostcode.getText());
			newBedroom.setAddrHouse(tfAddrHouse.getText());
			
			sqlConnection.addToBedroom(newBedroom);
			
			props.removeAll();
			props.revalidate();
			Host_UI_Bedroom();
			props.repaint();
		});
		btnLastBedroom.addActionListener(e -> {
			
			Bedroom newBedroom = new Bedroom();
			
			SQL_Connecting sqlConnection = new SQL_Connecting();
			
			newBedroom.setBedID(sqlConnection.findNextBedroomID());
			newBedroom.setBed1((String)comboBed1.getSelectedItem());
			newBedroom.setBed2((String)comboBed2.getSelectedItem());
			newBedroom.setAddrPostcode(tfAddrPostcode.getText());
			newBedroom.setAddrHouse(tfAddrHouse.getText());
			
			sqlConnection.addToBedroom(newBedroom);
			
			props.removeAll();
			props.revalidate();
			Host_UI_P();
			props.repaint();
		});
		btnNoBedroom.addActionListener(e -> {
			props.removeAll();
			props.revalidate();
			Host_UI_P();
			props.repaint();
		});
		btnSaveProp.addActionListener(e -> {
			//removes the panels contents and adds new contents (takes to previous page)
			//will later add to the database
			props.removeAll();
			props.revalidate();
			Host_UI_P();
			props.repaint();
		});
		btnBack.addActionListener(e -> {
			//removes the panels contents and adds new contents (takes to previous page)
			props.removeAll();
			props.revalidate();
			Host_UI_P();
			props.repaint();
		});
    }
	
	public int boolConvert(boolean val) {
		int num = 0;
		if (val) {
			num = 1;
		}
		return num;
	}
	
	//starts the gui
	public static void startGUI() {
		// Start GUI
		Host_UI_Properties browserPanel = new Host_UI_Properties();
		@SuppressWarnings("unused") Host_UI host_UI = new Host_UI(browserPanel);
	}
	
	public static void main(String[] args) {
		Host_UI_Properties.startGUI();
	}
}
