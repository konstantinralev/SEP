import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.sourceforge.jdatepicker.impl.*;

public class CompanyGUI extends JFrame {

	private JPanel contentPane = new JPanel();;
	CardLayout cl = new CardLayout();
	private JTextField departureDateField;
	private JTextField numberOfPassengersField;
	private JTextField numberOfPassengersTravel;
	private JTextField destinationField;
	private JTextField arrivalDateField;
	private JTextField typeOfVehicleField;
	private JTextField extraServicesField;

	/**
	 * Service service = new Service(placeOfDeparture,placeOfArrival,departureDate,arrivalDate);
	 */
	
	/**
	 * Create the frame.
	 */
	public CompanyGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 450);
		createMenu();
		contentPane.setLayout(cl);
		
		/**
		 * home panel
		 */
		JPanel insideHomePanel = new JPanel();
		insideHomePanel.setLayout(new BorderLayout(0, 0));
		JLabel label1 = new JLabel("Welcome to");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Calibri", Font.BOLD, 30));
		insideHomePanel.add(label1, BorderLayout.NORTH);
		JLabel label2 = new JLabel("VIA Bus");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Calibri", Font.BOLD, 30));
		insideHomePanel.add(label2, BorderLayout.CENTER);
		JLabel label3 = new JLabel("Please, select an an action\r\n");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Calibri", Font.BOLD, 30));
		insideHomePanel.add(label3, BorderLayout.SOUTH);
		JPanel homePanel = new JPanel(new BorderLayout());
		homePanel.add(insideHomePanel, BorderLayout.CENTER);
		cl.show(contentPane, "home");
		
		JPanel makeReservation = new JPanel(new BorderLayout());
		JPanel general = new JPanel(cl);
		
		
		/**
		 * create radio buttons for selecting the type of service
		 */
		JRadioButton bac = new JRadioButton("Bus-and-chauffeur");
		bac.setSelected(false);
		bac.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(general, "3");
			}
		});
		JRadioButton tripButton = new JRadioButton("Trip");
		tripButton.setSelected(true);
		tripButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(general, "1");
			}
		});
		JRadioButton travelButton = new JRadioButton("Travel");
		travelButton.setSelected(false);
		travelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(general, "2");
			}
		});
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(bac);
		radioButtons.add(tripButton);
		radioButtons.add(travelButton);
		JPanel buttonGroup = new JPanel(new FlowLayout());
		buttonGroup.add(tripButton);
		buttonGroup.add(travelButton);
		buttonGroup.add(bac);
		makeReservation.add(buttonGroup, BorderLayout.NORTH);

		
		
		/**
		 * panel for trips 1
		 */
		JPanel trip = new JPanel();
		general.add(trip, "1");
		trip.setLayout(new BorderLayout(0, 0));
		JList listCenter = new JList();
		listCenter.setVisibleRowCount(8);
		trip.add(listCenter);
		JPanel panelNorth = new JPanel();
		trip.add(panelNorth, BorderLayout.NORTH);
		JLabel labelDepDate = new JLabel("Departure date:");
		panelNorth.add(labelDepDate);
		UtilDateModel model3 = new UtilDateModel();
		JDatePanelImpl datePanel3 = new JDatePanelImpl(model3);
		JDatePickerImpl depDate3 = new JDatePickerImpl(datePanel3);
		panelNorth.add(depDate3);
		JLabel labelNumberOfPassengers = new JLabel("Number of passengers: ");
		panelNorth.add(labelNumberOfPassengers);
		numberOfPassengersField = new JTextField();
		panelNorth.add(numberOfPassengersField);
		numberOfPassengersField.setColumns(5);
		JButton checkButtonTrip = new JButton("Check for available trips");
		checkButtonTrip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panelNorth.add(checkButtonTrip);
		JPanel panelSouth = new JPanel();
		trip.add(panelSouth, BorderLayout.SOUTH);
		JButton next = new JButton("Next >");
		panelSouth.add(next);
		JButton cancel2 = new JButton("Cancel");
		cancel2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "home");
			}
		});
		panelSouth.add(cancel2);

		/**
		 * panel for travels(almost the same as for trips) 2
		 */
		JPanel travel = new JPanel();
		general.add(travel, "2");
		travel.setLayout(new BorderLayout(0, 0));
		JPanel panelSouthTravel = new JPanel();
		travel.add(panelSouthTravel, BorderLayout.SOUTH);
		JButton button = new JButton("Next >");
		panelSouthTravel.add(button);
		JButton cancel3 = new JButton("Cancel");
		cancel3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "home");
			}
		});
		panelSouthTravel.add(cancel3);
		JPanel panelNorthTravel = new JPanel();
		travel.add(panelNorthTravel, BorderLayout.NORTH);
		JLabel labelDepDateTravel = new JLabel("Departure date:");
		panelNorthTravel.add(labelDepDateTravel);
		UtilDateModel model6 = new UtilDateModel();
		JDatePanelImpl datePanel6 = new JDatePanelImpl(model6);
		JDatePickerImpl depDate6 = new JDatePickerImpl(datePanel6);
		panelNorthTravel.add(depDate6);
		JLabel labelNumberOfPassengersTravel = new JLabel("Number of passengers: ");
		panelNorthTravel.add(labelNumberOfPassengersTravel);
		numberOfPassengersTravel = new JTextField();
		numberOfPassengersTravel.setColumns(5);
		panelNorthTravel.add(numberOfPassengersTravel);
		JButton checkButtonTravel = new JButton("Check for available travels");
		panelNorthTravel.add(checkButtonTravel);
		JList listCenterTravel = new JList();
		listCenterTravel.setVisibleRowCount(8);
		travel.add(listCenterTravel);

		/**
		 * panel for bus and chauffeur services 3
		 */
		JPanel busAndChauffeur = new JPanel();
		general.add(busAndChauffeur, "3");
		busAndChauffeur.setLayout(new BorderLayout(0, 0));
		JPanel panelBAC = new JPanel();
		busAndChauffeur.add(panelBAC, BorderLayout.CENTER);
		JLabel labelDepDateBAC = new JLabel("Departure date:");
		panelBAC.add(labelDepDateBAC);
		UtilDateModel model4 = new UtilDateModel();
		JDatePanelImpl datePanel4 = new JDatePanelImpl(model4);
		JDatePickerImpl depDate4 = new JDatePickerImpl(datePanel4);
		panelBAC.add(depDate4);
		JLabel labelArrivalDate = new JLabel("Arrival date:");
		UtilDateModel model5 = new UtilDateModel();
		JDatePanelImpl datePanel5 = new JDatePanelImpl(model5);
		JDatePickerImpl arrDate5 = new JDatePickerImpl(datePanel5);
		JLabel labelDestination = new JLabel("Destination: ");
		destinationField = new JTextField();
		destinationField.setColumns(10);
		JLabel labelType = new JLabel("Preferred type of vehicle: ");
		typeOfVehicleField = new JTextField();
		typeOfVehicleField.setColumns(10);
		JLabel labelExtraServices = new JLabel("Extra services: ");
		extraServicesField = new JTextField();
		extraServicesField.setColumns(10);
		JLabel labelWarning = new JLabel("(please, separate the extra services by \";\")");
		JLabel labelNumberOfPassengersBAC = new JLabel("Number of passengers: ");
		JTextField numberOfPassengersBAC = new JTextField();
		numberOfPassengersBAC.setColumns(5);
		panelBAC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBAC.add(labelArrivalDate);
		panelBAC.add(arrDate5);
		panelBAC.add(labelDestination);
		panelBAC.add(destinationField);
		panelBAC.add(labelType);
		panelBAC.add(typeOfVehicleField);
		panelBAC.add(labelNumberOfPassengersBAC);
		panelBAC.add(numberOfPassengersBAC);
		panelBAC.add(labelExtraServices);
		panelBAC.add(extraServicesField);
		panelBAC.add(labelWarning);
		JPanel panelSouthBAC = new JPanel();
		busAndChauffeur.add(panelSouthBAC, BorderLayout.SOUTH);
		JButton buttonNext = new JButton("Next >");
		panelSouthBAC.add(buttonNext);
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "home");
			}
		});
		panelSouthBAC.add(cancel);
		

		/**
		 * panel for adding a new trip or travel to the system
		 */
		JPanel addTripsOrTravels = new JPanel();
		ButtonGroup buttons = new ButtonGroup();
		addTripsOrTravels.setLayout(new BorderLayout(0, 0));
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add a trip/travel", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addTripsOrTravels.add(panelCenter);
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		JRadioButton tripRadioButton = new JRadioButton("Trip");
		tripRadioButton.setSelected(false);
		panelCenter.add(tripRadioButton);
		JRadioButton travelRadioButton = new JRadioButton("Travel");
		travelRadioButton.setSelected(false);
		panelCenter.add(travelRadioButton);
		buttons.add(travelRadioButton);
		buttons.add(tripRadioButton);
		JLabel labelFrom2 = new JLabel("From: ");
		panelCenter.add(labelFrom2);
		JTextField fromField2 = new JTextField(10);
		panelCenter.add(fromField2);
		JLabel labelTo2 = new JLabel("To: ");
		panelCenter.add(labelTo2);
		JTextField toField2 = new JTextField(10);
		panelCenter.add(toField2);
		JLabel labelDepDate2 = new JLabel("Departure date: ");
		panelCenter.add(labelDepDate2);
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model);
		JDatePickerImpl depDate2 = new JDatePickerImpl(datePanel1);
		panelCenter.add(depDate2);
		JLabel labelDepTime2 = new JLabel("Departure time: ");
		panelCenter.add(labelDepTime2);
		JTextField depTime2 = new JTextField(10);
		depTime2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				depTime2.setText("");
			}
		});
		depTime2.setText("hh:mm");
		panelCenter.add(depTime2);
		JLabel labelArrDate2 = new JLabel("Arrival date: ");
		panelCenter.add(labelArrDate2);
		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
		JDatePickerImpl arrDate2 = new JDatePickerImpl(datePanel2);
		panelCenter.add(arrDate2);
		JLabel labelArrTime2 = new JLabel("Arrival time: ");
		panelCenter.add(labelArrTime2);
		JTextField arrTime2 = new JTextField(10);
		arrTime2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			arrTime2.setText("");
			}
		});
		arrTime2.setText("hh:mm");
		panelCenter.add(arrTime2);
		JButton saveTripOrTravel = new JButton("Save trip/travel");
		panelCenter.add(saveTripOrTravel);
		JButton cancel1 = new JButton("Cancel");
		cancel1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(contentPane, "home");	
			}
		});
		panelCenter.add(cancel1);
		JPanel panelWest = new JPanel();
		panelWest.setBorder(new TitledBorder(null, "Chauffeur", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		addTripsOrTravels.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new BorderLayout(0, 0));
		JList listOfAvailbaleChauffeurs = new JList();
		panelWest.add(listOfAvailbaleChauffeurs);
		JButton checkForAvailableChauffeurs = new JButton("Check for available chauffeurs");
		panelWest.add(checkForAvailableChauffeurs, BorderLayout.SOUTH);
		JPanel panelEast = new JPanel();
		panelEast.setBorder(new TitledBorder(null, "Bus", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		addTripsOrTravels.add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new BorderLayout(0, 0));
		JList listOfAvailableBuses = new JList();
		panelEast.add(listOfAvailableBuses, BorderLayout.CENTER);
		JButton checkForAvailableBuses = new JButton("Check for available buses");
		panelEast.add(checkForAvailableBuses, BorderLayout.SOUTH);
		
		
		
		getContentPane().add(contentPane, BorderLayout.CENTER);
		makeReservation.add(general, BorderLayout.CENTER);
		
		/**
		 * add all panels in the outermost panel and give them indexes
		 */
		contentPane.add(homePanel, "home");
		contentPane.add(makeReservation, "makeReservation");
		contentPane.add(addTripsOrTravels, "addTorT");

	}

	public void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuManageReservations = new JMenu("Manage reservations");
		menuBar.add(menuManageReservations);

		JMenuItem makeNewReservation = new JMenuItem("Make a new reservation");
		menuManageReservations.add(makeNewReservation);
		makeNewReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(contentPane, "makeReservation");	
			}
		});

		JMenuItem changeReservation = new JMenuItem("Change a reservation");
		menuManageReservations.add(changeReservation);

		JMenuItem removeReservation = new JMenuItem("Remove a reservation");
		menuManageReservations.add(removeReservation);

		JMenu menuManageChauffeurs = new JMenu("Manage chauffeurs");
		menuBar.add(menuManageChauffeurs);

		JMenuItem addChauffeur = new JMenuItem("Add a chauffeur");
		menuManageChauffeurs.add(addChauffeur);

		JMenuItem changeChauffeur = new JMenuItem("Change a chauffeur's information");
		menuManageChauffeurs.add(changeChauffeur);

		JMenuItem removeChauffeur = new JMenuItem("Remove a chauffeur");
		menuManageChauffeurs.add(removeChauffeur);

		JMenu menuManageBuses = new JMenu("Manage buses");
		menuBar.add(menuManageBuses);

		JMenuItem addABus = new JMenuItem("Add a bus");
		menuManageBuses.add(addABus);

		JMenuItem changeBusInformation = new JMenuItem("Change a bus' information");
		menuManageBuses.add(changeBusInformation);

		JMenuItem removeBus = new JMenuItem("Remove a bus");
		menuManageBuses.add(removeBus);

		JMenu manageTripsAnd = new JMenu("Manage trips and travels");
		menuBar.add(manageTripsAnd);

		JMenuItem addATriptravel = new JMenuItem("Add a trip/travel");
		manageTripsAnd.add(addATriptravel);
		addATriptravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(contentPane, "addTorT");	
			}
		});

		JMenuItem removeATriptravel = new JMenuItem("Remove a trip/travel");
		manageTripsAnd.add(removeATriptravel);

		JMenuItem manageCustomer = new JMenuItem("Manage customer information");
		menuBar.add(manageCustomer);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		CompanyGUI frame = new CompanyGUI();
		frame.setVisible(true);
	}

}
