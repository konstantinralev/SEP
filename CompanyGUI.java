
	import java.awt.*;
	import java.awt.event.*;

	import javax.swing.*;


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
		
		
		private Company company;


		/**
		 * Create the frame.
		 */
		public CompanyGUI() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(707,400);
			contentPane.setLayout(cl);
			JPanel makeReservation = new JPanel(new BorderLayout());
			contentPane.add(makeReservation,"1");
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
			makeReservation.add(buttonGroup,BorderLayout.NORTH);
			
			/**
			 * panel for trips
			 * 1
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
			departureDateField = new JTextField();
			panelNorth.add(departureDateField);
			departureDateField.setText("dd/mm/yy");
			departureDateField.setColumns(10);
			JLabel labelNumberOfPassengers = new JLabel("Number of passengers: ");
			panelNorth.add(labelNumberOfPassengers);
			numberOfPassengersField = new JTextField();
			panelNorth.add(numberOfPassengersField);
			numberOfPassengersField.setColumns(5);
			JButton checkButtonTrip = new JButton("Check for available trips");
			panelNorth.add(checkButtonTrip);
			JPanel panelSouth = new JPanel();
			trip.add(panelSouth, BorderLayout.SOUTH);
			JButton next = new JButton("Next >");
			panelSouth.add(next);
			
			/**
			 * panel for travels(almost the same as for trips)
			 * 2
			 */
			JPanel travel = new JPanel();
			general.add(travel, "2");
			travel.setLayout(new BorderLayout(0, 0));
			JPanel panelSouthTravel = new JPanel();
			travel.add(panelSouthTravel, BorderLayout.SOUTH);
			JButton button = new JButton("Next >");
			panelSouthTravel.add(button);
			JPanel panelNorthTravel = new JPanel();
			travel.add(panelNorthTravel, BorderLayout.NORTH);
			JLabel labelDepDateTravel = new JLabel("Departure date:");
			panelNorthTravel.add(labelDepDateTravel);
			JTextField departureDateFieldTravel = new JTextField();
			panelNorthTravel.add(departureDateFieldTravel);
			departureDateFieldTravel.setText("dd/mm/yy");
			departureDateFieldTravel.setColumns(10);
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
			 * panel for bus and chauffeur services
			 * 3
			 */
			JPanel busAndChauffeur = new JPanel();
			general.add(busAndChauffeur,"3");
			busAndChauffeur.setLayout(new BorderLayout(0, 0));
			JPanel panelBAC = new JPanel();
			busAndChauffeur.add(panelBAC, BorderLayout.CENTER);
			JLabel labelArrivalDate = new JLabel("Arrival date:");
			arrivalDateField = new JTextField();
			arrivalDateField.setColumns(10);
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
			panelBAC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelBAC.add(labelArrivalDate);
			panelBAC.add(arrivalDateField);
			panelBAC.add(labelDestination);
			panelBAC.add(destinationField);
			panelBAC.add(labelType);
			panelBAC.add(typeOfVehicleField);
			panelBAC.add(labelExtraServices);
			panelBAC.add(extraServicesField);
			panelBAC.add(labelWarning);
			JPanel panelSouthBAC = new JPanel();
			busAndChauffeur.add(panelSouthBAC, BorderLayout.SOUTH);
			JButton buttonNext = new JButton("Next >");
			panelSouthBAC.add(buttonNext);
			
			
			getContentPane().add(contentPane, BorderLayout.CENTER);
			makeReservation.add(general, BorderLayout.CENTER);
			createMenu();
		}
		
		public void createMenu(){
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu menuManageReservations = new JMenu("Manage reservations");
			menuBar.add(menuManageReservations);
			
			JMenuItem makeNewReservation = new JMenuItem("Make a new reservation");
			menuManageReservations.add(makeNewReservation);
			
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
