import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import net.sourceforge.jdatepicker.impl.*;

public class GUI extends JFrame {

   private DefaultListModel<Bus> busListModel = new DefaultListModel<Bus>();
   private JList<Bus> busJList = new JList<Bus>(busListModel);
   private BusList buses = new BusList();
   private JPanel contentPane = new JPanel();;
   CardLayout cl = new CardLayout();
   private ChauffeurList chauffeurs = new ChauffeurList();
   private DefaultListModel<Chauffeur> chauffeurListModel = new DefaultListModel<Chauffeur>();
   private JList<Chauffeur> chauffeurJList = new JList<Chauffeur>(
         chauffeurListModel);
   
   private ServiceList services = new ServiceList();
   private DefaultListModel<Service> serviceListModel = new DefaultListModel<Service>();
   private JList<Service> tripsAndTravelsList = new JList<Service>(serviceListModel);

   /**
    * Create the frame.
    */
   public GUI() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      contentPane.setLayout(cl);
      setTitle("VIA Bus");

      /**
       * clicking on the cancel button should take the user to the home page
       */
      ActionListener goHome = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            cl.show(contentPane, "home");
         }
      };

      /**
       * create home panel
       */
      JPanel homePanel = homePanel();

      /**
       * create the reservation panel
       */
      JPanel makeReservation = new JPanel(new BorderLayout());
      TitledBorder reservationTitle = new TitledBorder(
            "Make a new reservation");
      makeReservation.setBorder(reservationTitle);
      JPanel general = new JPanel(cl);
      JRadioButton bac = new JRadioButton("Bus-and-chauffeur");
      bac.setSelected(false);
      bac.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(general, "2");
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
            cl.show(general, "1");
         }
      });
      ButtonGroup radioButtonsTypeOfService = new ButtonGroup();
      radioButtonsTypeOfService.add(bac);
      radioButtonsTypeOfService.add(tripButton);
      radioButtonsTypeOfService.add(travelButton);
      JPanel buttonGroup = new JPanel(new FlowLayout());
      JPanel reservationButtonsSouth = new JPanel(new FlowLayout());
      JButton buttonNext = new JButton("Next");
      buttonNext.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(contentPane, "makeReservationNext");
         }
      });
      JButton cancel = new JButton("Cancel");
      cancel.addActionListener(goHome);
      JButton buttonBack = new JButton("Back");
      buttonBack.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(contentPane, "changeOrRemoveReservation");
         }
      });
      buttonGroup.add(tripButton);
      buttonGroup.add(travelButton);
      buttonGroup.add(bac);
      reservationButtonsSouth.add(buttonBack);
      reservationButtonsSouth.add(buttonNext);
      reservationButtonsSouth.add(cancel);
      /**
       * panel for making a reservation for trips or travels 1
       */
      JPanel tripOrTravel = new JPanel();
      general.add(tripOrTravel, "1");
      tripOrTravel.setLayout(new BorderLayout(0, 0));
      JList listCenter = new JList();
      JScrollPane centerList = new JScrollPane(listCenter);
      JPanel panelNorth = new JPanel();
      JLabel labelDepDate = new JLabel("Departure date:");
      /*UtilDateModel model3 = new UtilDateModel();
      JDatePanelImpl datePanel3 = new JDatePanelImpl(model3);
      JDatePickerImpl depDate3 = new JDatePickerImpl(datePanel3);*/
      JLabel labelNumberOfPassengers = new JLabel("Number of passengers: ");
      JTextField numberOfPassengersField = new JTextField();
      numberOfPassengersField.setColumns(5);
      JButton checkButtonTrip = new JButton(
            "Check for available trips/travels");
      panelNorth.add(labelDepDate);
      //panelNorth.add(depDate3);
      panelNorth.add(labelNumberOfPassengers);
      panelNorth.add(numberOfPassengersField);
      panelNorth.add(checkButtonTrip);
      tripOrTravel.add(centerList, BorderLayout.CENTER);
      tripOrTravel.add(panelNorth, BorderLayout.NORTH);
      /**
       * panel for adding a bus and chauffeur service 2
       */
      JPanel busAndChauffeur = new JPanel();
      general.add(busAndChauffeur, "2");
      busAndChauffeur.setLayout(new BorderLayout(0, 0));
      JPanel panelCenterBAC = new JPanel();
      panelCenterBAC.setBorder(new EmptyBorder(5, 5, 5, 5));
      panelCenterBAC
            .setLayout(new BoxLayout(panelCenterBAC, BoxLayout.Y_AXIS));
      JLabel labelDepDateBAC = new JLabel("Departure date:");
      /*UtilDateModel model4 = new UtilDateModel();
      JDatePanelImpl datePanel4 = new JDatePanelImpl(model4);
      JDatePickerImpl depDate4 = new JDatePickerImpl(datePanel4);*/
      JLabel labelArrivalDate = new JLabel("Arrival date:");
      /*UtilDateModel model5 = new UtilDateModel();
      JDatePanelImpl datePanel5 = new JDatePanelImpl(model5);
      JDatePickerImpl arrDate5 = new JDatePickerImpl(datePanel5);*/
      JLabel labelDestination = new JLabel("Destination: ");
      JTextField destinationField = new JTextField();
      destinationField.setColumns(10);
      JLabel labelType = new JLabel("Preferred type of vehicle: ");
      JComboBox preferredBusTypeComboBox = new JComboBox();
      preferredBusTypeComboBox.setModel(new DefaultComboBoxModel(
            new String[] { "", "Mini bus", "Luxury bus", "Party bus" }));
      preferredBusTypeComboBox.setSelectedIndex(0);
      JLabel labelExtraServices = new JLabel("Extra services: ");
      JTextField extraServicesField = new JTextField();
      extraServicesField
            .setText("Please, separate the extra services with a \";\"");
      extraServicesField.setColumns(10);
      extraServicesField.addFocusListener(new FocusAdapter() {
         @Override
         public void focusGained(FocusEvent e) {
            extraServicesField.setText("");
         }
      });
      JLabel labelNumberOfPassengersBAC = new JLabel("Number of passengers: ");
      JTextField numberOfPassengersBAC = new JTextField();
      numberOfPassengersBAC.setColumns(5);
      JPanel panelWestBAC = new JPanel();
      panelWestBAC.setBorder(new TitledBorder("Chauffeur"));
      panelWestBAC.setLayout(new BorderLayout(0, 0));
      JList listOfAvailableChauffeurs = new JList();
      JScrollPane scrollListOfAvailableChauffeurs = new JScrollPane(
            listOfAvailableChauffeurs);
      JTextArea insideAvailableChauffeurPanel = new JTextArea();
      insideAvailableChauffeurPanel.setEditable(false);
      insideAvailableChauffeurPanel.setLineWrap(true);
      insideAvailableChauffeurPanel.setColumns(20);
      insideAvailableChauffeurPanel.setRows(6);
      insideAvailableChauffeurPanel.setBorder(new TitledBorder(
            "Chauffeur's information"));
      JButton checkForAvailableChauffeurs = new JButton(
            "Check for available chauffeurs");
      JPanel panelEastBAC = new JPanel();
      panelEastBAC.setBorder(new TitledBorder("Bus"));
      panelEastBAC.setLayout(new BorderLayout(0, 0));
      JList listOfAvailableBuses = new JList();
      JScrollPane scrollListOfAvailableBuses = new JScrollPane(
            listOfAvailableBuses);
      JTextArea insideAvailableBusesPanel = new JTextArea();
      insideAvailableBusesPanel.setEditable(false);
      insideAvailableBusesPanel.setLineWrap(true);
      insideAvailableBusesPanel.setColumns(20);
      insideAvailableBusesPanel.setRows(6);
      insideAvailableBusesPanel
            .setBorder(new TitledBorder("Bus' information"));
      listOfAvailableBuses.setVisibleRowCount(10);
      JButton checkForAvailableBuses = new JButton(
            "Check for available buses");
      panelCenterBAC.add(labelDepDateBAC);
      //panelCenterBAC.add(depDate4);
      panelCenterBAC.add(labelArrivalDate);
      //panelCenterBAC.add(arrDate5);
      panelCenterBAC.add(labelDestination);
      panelCenterBAC.add(destinationField);
      panelCenterBAC.add(labelType);
      panelCenterBAC.add(preferredBusTypeComboBox);
      panelCenterBAC.add(labelNumberOfPassengersBAC);
      panelCenterBAC.add(numberOfPassengersBAC);
      panelCenterBAC.add(labelExtraServices);
      panelCenterBAC.add(extraServicesField);
      panelWestBAC.add(scrollListOfAvailableChauffeurs, BorderLayout.CENTER);
      panelWestBAC.add(insideAvailableChauffeurPanel, BorderLayout.NORTH);
      panelWestBAC.add(checkForAvailableChauffeurs, BorderLayout.SOUTH);
      panelEastBAC.add(scrollListOfAvailableBuses, BorderLayout.CENTER);
      panelEastBAC.add(insideAvailableBusesPanel, BorderLayout.NORTH);
      panelEastBAC.add(checkForAvailableBuses, BorderLayout.SOUTH);
      busAndChauffeur.add(panelCenterBAC, BorderLayout.CENTER);
      busAndChauffeur.add(panelWestBAC, BorderLayout.WEST);
      busAndChauffeur.add(panelEastBAC, BorderLayout.EAST);

      makeReservation.add(buttonGroup, BorderLayout.NORTH);
      makeReservation.add(general, BorderLayout.CENTER);
      makeReservation.add(reservationButtonsSouth, BorderLayout.SOUTH);

      /**
       * create panel for continue making a reservation
       */
      JPanel makeReservationNext = new JPanel(new BorderLayout());
      makeReservationNext.setBorder(new EmptyBorder(5, 5, 5, 5));
      JPanel makeReservationNextNorth = new JPanel();
      makeReservationNextNorth.setLayout(new BoxLayout(
            makeReservationNextNorth, BoxLayout.X_AXIS));
      makeReservationNextNorth.setBorder(new TitledBorder(
            "Reservation information"));
      JLabel priceLabel = new JLabel("Price: ");
      JTextField priceField = new JTextField(10);
      JCheckBox paid = new JCheckBox("Paid");
      JPanel makeReservationNextCenter = new JPanel(new GridLayout(0, 1));
      makeReservationNextCenter.setBorder(new TitledBorder(
            "Customer's Information"));
      JLabel labelNameCustomer = new JLabel("Name: ");
      JTextField customerNameField = new JTextField("");
      JLabel customerAddressLabel = new JLabel("Address:");
      JTextField customerAddressField = new JTextField("");
      JLabel customerPhoneLabel = new JLabel("Phone number:");
      JTextField customerPhoneField = new JTextField("");
      JLabel customerEmailLabel = new JLabel("E-mail:");
      JTextField customerEmailField = new JTextField("");
      JLabel birthdayLabel = new JLabel("Birthday:");
      /*UtilDateModel model7 = new UtilDateModel();
      JDatePanelImpl datePanel7 = new JDatePanelImpl(model7);
      JDatePickerImpl birthDate7 = new JDatePickerImpl(datePanel7);*/
      /*birthDate7
            .setToolTipText("Only available if the selected type of service is trip/travel");*/
      JRadioButton newsletterYes = new JRadioButton(
            "The customer wants to recieve a newsletter");
      newsletterYes.setSelected(false);
      JRadioButton newsletterNo = new JRadioButton(
            "The customer does not want to recieve newsletter");
      newsletterNo.setSelected(false);
      ButtonGroup newsletterButtons = new ButtonGroup();
      newsletterButtons.add(newsletterYes);
      JPanel makeReservationNextSouth = new JPanel(new GridLayout(1, 0));
      JButton saveReservationButton = new JButton("Save reservation");
      JButton updateReservation = new JButton("Update reservation");
      JButton cancelButtonReservation = new JButton("Cancel");
      cancelButtonReservation.addActionListener(goHome);
      JButton back = new JButton("Back");
      back.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(contentPane, "makeReservation");
         }
      });
      makeReservationNextNorth.add(priceLabel);
      makeReservationNextNorth.add(priceField);
      makeReservationNextNorth.add(paid);
      newsletterButtons.add(newsletterNo);
      makeReservationNextCenter.add(labelNameCustomer);
      makeReservationNextCenter.add(customerNameField);
      makeReservationNextCenter.add(customerAddressLabel);
      makeReservationNextCenter.add(customerAddressField);
      makeReservationNextCenter.add(customerPhoneLabel);
      makeReservationNextCenter.add(customerPhoneField);
      makeReservationNextCenter.add(birthdayLabel);
      //makeReservationNextCenter.add(birthDate7);
      makeReservationNextCenter.add(newsletterYes);
      makeReservationNextCenter.add(newsletterNo);
      makeReservationNextCenter.add(customerEmailLabel);
      makeReservationNextCenter.add(customerEmailField);
      makeReservationNextSouth.add(back);
      makeReservationNextSouth.add(cancelButtonReservation);
      makeReservationNext.add(makeReservationNextNorth, BorderLayout.NORTH);
      makeReservationNext.add(makeReservationNextCenter, BorderLayout.CENTER);
      makeReservationNext.add(makeReservationNextSouth, BorderLayout.SOUTH);

      /**
       * create panel for changing and removing reservations
       */
      JPanel changeRemoveReservation = new JPanel(new BorderLayout());
      changeRemoveReservation.setBorder(new TitledBorder(
            "Change/Remove reservation"));
      JPanel panelChangeRemoveReservationNorth = new JPanel();
      panelChangeRemoveReservationNorth.setLayout(new FlowLayout(
            FlowLayout.CENTER, 5, 5));
      JLabel labelNameSearch = new JLabel("Customer name:  ");
      JTextField customerNameSearchField = new JTextField(20);
      JButton findCustomerButton = new JButton("Search by customer name");
      JList reservationListChangeRemove = new JList();
      JScrollPane scrollReservations = new JScrollPane(
            reservationListChangeRemove);
      JPanel panelChangeRemoveReservationEast = new JPanel();
      panelChangeRemoveReservationEast.setLayout(new BorderLayout());
      panelChangeRemoveReservationEast.setBorder(new TitledBorder(
            "Reservation's information"));
      JTextArea insideEastReservationPanel = new JTextArea();
      insideEastReservationPanel.setEditable(false);
      insideEastReservationPanel.setLineWrap(true);
      insideEastReservationPanel.setColumns(20);
      JPanel panelChangeRemoveReservationSouth = new JPanel(new FlowLayout());
      JButton saveReservation = new JButton("Save reservation");
      saveReservation.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D://"));
            int returnValue = fileChooser.showOpenDialog(null);
            if( returnValue == JFileChooser.APPROVE_OPTION){
               try{
                  FileWriter fw = new FileWriter(fileChooser.getSelectedFile() + ".txt");
                  fw.write(reservation.toString());// we have to change this
                  fw.close();
               }catch(Exception e3){
                  e3.printStackTrace();
               }
            }
         }
      });
      
      JButton changeReservation = new JButton("Change reservation");
      changeReservation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            reservationTitle.setTitle("Change reservation");
            buttonBack.setVisible(true);
            makeReservationNextSouth.add(updateReservation);
            makeReservationNextSouth.remove(saveReservationButton);
            cl.show(contentPane, "makeReservation");
         }
      });
      JButton removeReservation = new JButton("Remove reservation");
      removeReservation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // remove chauffeur method
            JOptionPane.showMessageDialog(contentPane,
                  "Reservation removed from the system");
            cl.show(contentPane, "home");
         }
      });
      JButton cancelButton7 = new JButton("Cancel");
      cancelButton7.addActionListener(goHome);
      panelChangeRemoveReservationEast.add(insideEastReservationPanel,
            BorderLayout.CENTER);
      panelChangeRemoveReservationNorth.add(labelNameSearch);
      panelChangeRemoveReservationNorth.add(customerNameSearchField);
      panelChangeRemoveReservationNorth.add(findCustomerButton);
      panelChangeRemoveReservationSouth.add(changeReservation);
      panelChangeRemoveReservationSouth.add(removeReservation);
      panelChangeRemoveReservationSouth.add(cancelButton7);
      panelChangeRemoveReservationSouth.add(saveReservation);

      changeRemoveReservation.add(scrollReservations, BorderLayout.CENTER);
      changeRemoveReservation.add(panelChangeRemoveReservationNorth,
            BorderLayout.NORTH);
      changeRemoveReservation.add(panelChangeRemoveReservationSouth,
            BorderLayout.SOUTH);
      changeRemoveReservation.add(panelChangeRemoveReservationEast,
            BorderLayout.EAST);

      /**
       * add a chauffeur to the system
       */
      JPanel addChauffeur = new JPanel(new BorderLayout());
      TitledBorder chauffeurBorder = new TitledBorder("Add chauffeur");
      addChauffeur.setBorder(chauffeurBorder);
      JPanel addChauffeurCenter = new JPanel(new GridLayout(0, 1));
      JLabel nameLabel = new JLabel("Name: ");
      JTextField nameText = new JTextField("");
      JLabel addressLabel = new JLabel("Address: ");
      JTextField addressText = new JTextField("");
//    JLabel iDLabel = new JLabel("Employee ID: ");
//    JTextField iDText = new JTextField("");
      JLabel phoneLabel = new JLabel("Phone number: ");
      JTextField phoneText = new JTextField("");
      JLabel emailLabel = new JLabel("E-mail: ");
      JTextField emailText = new JTextField("");
      JLabel wishesLabel = new JLabel("Wishes:");
      JTextField wishesText = new JTextField(
            "(please, separate the chauffeurs wishes with a \";\")");
      wishesText.addFocusListener(new FocusAdapter() {
         @Override
         public void focusGained(FocusEvent e) {
            wishesText.setText("");
         }
      });
      JPanel addChauffeurSouth = new JPanel(new GridLayout(1, 0));
      JButton addChauffeurButton = new JButton("Add chauffeur");
      addChauffeurButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
               if (nameText.getText().equals("")
//                   || iDText.getText().equals("")
//                   || iDText.getText().length() != 5) 
                     || addressText.getText().equals("")
                     || emailText.getText().equals("")
                     || phoneText.getText().equals("")){
                  JOptionPane.showMessageDialog(addChauffeur,"Please fill in all of the fields");
               } else {
                  Chauffeur chauffeur = new Chauffeur(nameText.getText(),
                        addressText.getText(), emailText.getText(),phoneText.getText());
                  if (!wishesText.getText().equals("")&& !wishesText.getText().equals("(please, separate the chauffeurs wishes with a \";\")")) {
                     chauffeur.setWishes(wishesText.getText());
                  }
                  chauffeurs.addChauffeur(chauffeur);
                  chauffeurListModel.addElement(chauffeur);
               }
            } catch (Exception e4) {
               JOptionPane.showMessageDialog(addChauffeur,
                     "Please enter valid arguments", "Invalid values",
                     JOptionPane.ERROR_MESSAGE);
            }
            nameText.setText("");
            addressText.setText("");
//          iDText.setText("");
            wishesText
                  .setText("(please, separate the chauffeurs wishes with a \";\")");
            emailText.setText("");
            phoneText.setText("");
         }
      });
      JButton backChauffeur = new JButton("Back");
      backChauffeur.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(contentPane, "changeRemoveChauffeur");
         }
      });
      JButton updateChauffeurInfo = new JButton("Update chauffeur's data");
      updateChauffeurInfo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               Chauffeur selected = chauffeurJList.getSelectedValue();
               if (!nameText.getText().equals("")
//                   || !iDText.getText().equals("")
                     || !addressText.getText().equals("")
                     || !emailText.getText().equals("")
                     || !phoneText.getText().equals("")){
//                   || iDText.getText().length() == 5) 
                  selected.setName(nameText.getText());
//                selected.setId(Integer.parseInt(iDText.getText()));
                  selected.setAddress(addressText.getText());
                  selected.setPhoneNumber(phoneText.getText());
                  selected.setEmail(emailText.getText());
                  if (!wishesText.getText().equals("") && !wishesText.getText().equals("(please, separate the chauffeurs wishes with a \";\")")) {
                     selected.setWishes(wishesText.getText());
                  }
                  updateChauffeurList();
                  cl.show(contentPane, "changeRemoveChauffeur");
               } else {
                  JOptionPane.showMessageDialog(addChauffeur,"Please fill in all of the "
                        + "fields and make sure that the emplyee ID has 5 digits");             }
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(contentPane,
                     "smth went wrong");
            }
         }
      });
      JButton cancelButton2 = new JButton("Cancel");
   
      cancelButton2.addActionListener(goHome);
      addChauffeurCenter.add(nameLabel);
      addChauffeurCenter.add(nameText);
//    addChauffeurCenter.add(iDLabel);
//    addChauffeurCenter.add(iDText);
      addChauffeurCenter.add(addressLabel);
      addChauffeurCenter.add(addressText);
      addChauffeurCenter.add(phoneLabel);
      addChauffeurCenter.add(phoneText);
      addChauffeurCenter.add(emailLabel);
      addChauffeurCenter.add(emailText);
      addChauffeurCenter.add(wishesLabel);
      addChauffeurCenter.add(wishesText);
      addChauffeurSouth.add(cancelButton2);
      addChauffeurSouth.add(backChauffeur);
      addChauffeur.add(addChauffeurCenter, BorderLayout.CENTER);
      addChauffeur.add(addChauffeurSouth, BorderLayout.SOUTH);

      /**
       * panel change or remove chauffeur
       */
      JPanel changeRemoveChauffeur = new JPanel(new BorderLayout());
      changeRemoveChauffeur.setBorder(new TitledBorder(
            "Change/Remove chauffeur's data"));
      JPanel panelChangeRemoveChauffeurEast = new JPanel(new BorderLayout());
      panelChangeRemoveChauffeurEast.setBorder(new TitledBorder(
            "Chauffeur's data"));
      JTextArea insideEastPanel = new JTextArea();
      chauffeurJList.addListSelectionListener(new ListSelectionListener() {   
         @Override
         public void valueChanged(ListSelectionEvent arg0) {
            try {
               String info = chauffeurJList.getSelectedValue().toString();
               insideEastPanel.setText(info);
            } catch (Exception e) {
               System.err.println(e.getCause());
            }
         }
      });
      insideEastPanel.setEditable(true);
      insideEastPanel.setLineWrap(true);
      insideEastPanel.setColumns(20);
      JPanel panelChangeRemoveChauffeurNorth = new JPanel();
      panelChangeRemoveChauffeurNorth.setLayout(new FlowLayout(
            FlowLayout.CENTER, 5, 5));
      JLabel labelChauffeurID = new JLabel("Employee ID:  ");
      JTextField chauffeurIDField1 = new JTextField(20);
      chauffeurIDField1.addFocusListener(new FocusAdapter() {
         @Override
         public void focusGained(FocusEvent e) {
            chauffeurIDField1.setText("");
         }
      });
      JButton findChauffeurButton = new JButton("Search by ID");
      JLabel nameLabelSearch = new JLabel("Name: ");
      JTextField chauffeurNameField1 = new JTextField(20);
      chauffeurNameField1.addFocusListener(new FocusAdapter() {
         @Override
         public void focusGained(FocusEvent e) {
            chauffeurNameField1.setText("");
         }
      });
      JButton findChauffeurByNameButton = new JButton("Search by name");
      findChauffeurByNameButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               chauffeurListModel.removeAllElements();
               for (int i = 0; i < chauffeurs.getChauffeur(
                     chauffeurNameField1.getText()).size(); i++) {
                  chauffeurListModel.addElement(chauffeurs.getChauffeur(
                        chauffeurNameField1.getText()).get(i));
               }
               if(chauffeurListModel.isEmpty()){
                  JOptionPane.showMessageDialog(contentPane, "Chauffeur not found");
                  updateChauffeurList();
               }
               chauffeurNameField1.setText("");
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(contentPane, "Something went wrong");
               System.out.println(chauffeurs.getChauffeur(
                     chauffeurNameField1.getText()).toString());
               System.err.println(e2.getCause());

            }
         }
      });
      findChauffeurButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               chauffeurListModel.removeAllElements();
               if(chauffeurs.getChauffeur(Integer.parseInt(chauffeurIDField1.getText()))!=null){
               chauffeurListModel.addElement(chauffeurs.getChauffeur(Integer.parseInt(chauffeurIDField1.getText())));
               }else{
                  JOptionPane.showMessageDialog(contentPane, "Chauffeur not found");
                  updateChauffeurList();
               }
               insideEastPanel.setText("");
               chauffeurIDField1.setText("");
            } catch (Exception e2) {
               System.out.println(chauffeurs.getChauffeur(Integer.parseInt(chauffeurIDField1.getText())).toString());
               System.err.println(e2.getCause());
            }
         }
      });
      JScrollPane scrollChauffeursCenter = new JScrollPane(chauffeurJList);
      JPanel panelChangeRemoveChauffeurSouth = new JPanel(new FlowLayout());
      JButton showAllChauffeurs = new JButton("Show all chauffeurs");
      showAllChauffeurs.addActionListener(new ActionListener() {  
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               updateChauffeurList();
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(contentPane, "smth's wrong");
            }
         }
      });
      JButton changeChauffeursInformation = new JButton("Change chauffeur's data");
      changeChauffeursInformation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               chauffeurBorder.setTitle("Change chauffeur's data");
               backChauffeur.setVisible(true);
               addChauffeurButton.setVisible(false);
               addChauffeurSouth.remove(addChauffeurButton);
               addChauffeurSouth.add(updateChauffeurInfo);
               updateChauffeurInfo.setVisible(true);
               Chauffeur selected = chauffeurJList.getSelectedValue();
               nameText.setText(selected.getName());
               //          iDText.setText(String.valueOf(selected.getId()));
               addressText.setText(selected.getAddress());
               phoneText.setText(selected.getPhoneNumber());
               emailText.setText(selected.getEmail());
               wishesText.setText(selected.getWishes());
               cl.show(contentPane, "addChauffeur");
            } catch (Exception e) {
               JOptionPane.showMessageDialog(contentPane,"smth went wrong");
               System.err.println(e);
            }
         }
      });
      
      JButton saveChauffeurInformationButton = new JButton("Save");
      saveChauffeurInformationButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D://"));
            int returnValue = fileChooser.showOpenDialog(null);
            if( returnValue == JFileChooser.APPROVE_OPTION){
               try{
                  FileWriter fw = new FileWriter(fileChooser.getSelectedFile() + ".txt");
                  for(int i =0;i< chauffeurs.getAllChauffeurs().size();i++){
                  fw.write(chauffeurs.getAllChauffeurs().get(i).getChauffeurInfo());
                  fw.close();
                  }
               }catch(Exception e3){
                  e3.printStackTrace();
               }
            }
         }
      });
      
      
      JButton removeChauffeur = new JButton("Remove chauffeur");
      removeChauffeur.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               int selectedIndex = chauffeurJList.getSelectedIndex();
               Chauffeur selectedChauffeur = chauffeurJList.getSelectedValue();
               chauffeurs.removeChauffeur(selectedChauffeur);
               chauffeurListModel.removeElementAt(selectedIndex);
               updateChauffeurList();
               insideEastPanel.setText("");
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(contentPane,"fu");
            }

         }
      });
      JButton cancelButton3 = new JButton("Cancel");
      cancelButton3.addActionListener(goHome);
      
      panelChangeRemoveChauffeurEast.add(insideEastPanel, BorderLayout.CENTER);
      panelChangeRemoveChauffeurSouth.add(showAllChauffeurs);
      panelChangeRemoveChauffeurSouth.add(changeChauffeursInformation);
      panelChangeRemoveChauffeurSouth.add(removeChauffeur);
      panelChangeRemoveChauffeurSouth.add(cancelButton3);
      panelChangeRemoveChauffeurSouth.add(saveChauffeurInformationButton);

      panelChangeRemoveChauffeurNorth.add(labelChauffeurID);
      panelChangeRemoveChauffeurNorth.add(chauffeurIDField1);
      panelChangeRemoveChauffeurNorth.add(findChauffeurButton);
      panelChangeRemoveChauffeurNorth.add(nameLabelSearch);
      panelChangeRemoveChauffeurNorth.add(chauffeurNameField1);
      panelChangeRemoveChauffeurNorth.add(findChauffeurByNameButton);

      changeRemoveChauffeur.add(scrollChauffeursCenter, BorderLayout.CENTER);
      changeRemoveChauffeur.add(panelChangeRemoveChauffeurNorth,
            BorderLayout.NORTH);
      changeRemoveChauffeur.add(panelChangeRemoveChauffeurSouth,
            BorderLayout.SOUTH);
      changeRemoveChauffeur.add(panelChangeRemoveChauffeurEast,
            BorderLayout.EAST);

      /**
       * add a new bus to the system
       */
      JPanel addBus = new JPanel(new BorderLayout());
      TitledBorder busBorder = new TitledBorder("Add bus");
      addBus.setBorder(busBorder);
      JPanel addBusNorth = new JPanel();
      addBusNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      JLabel capacityLabel = new JLabel("Capacity: ");
      JTextField capacityField = new JTextField(10);
      JLabel plateNumberLabel = new JLabel("Plate number: ");
      JTextField plateNumberField = new JTextField(10);
      JLabel labelTypeOfBus = new JLabel("Type: ");
      JComboBox busTypeComboBox = new JComboBox();
      busTypeComboBox.setModel(new DefaultComboBoxModel(new String[] { "",
            "Mini bus", "Luxury bus", "Party bus" }));
      busTypeComboBox.setSelectedIndex(0);
      JPanel addBusSouth = new JPanel(new GridLayout(1, 0));
      JButton addBusButton = new JButton("Add bus");
      addBusButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               if (String.valueOf(busTypeComboBox.getSelectedItem())
                     .equals("")
                     || capacityField.getText().equals("")
                     || plateNumberField.getText().equals("")) {
                  JOptionPane.showMessageDialog(addBus,
                        "Please fill in all of the fields");
               } else {
                  Bus bus = new Bus(Integer.parseInt(capacityField
                        .getText()), Integer.parseInt(plateNumberField
                        .getText()), String.valueOf(busTypeComboBox
                        .getSelectedItem()));
                  buses.addBus(bus);
                  busListModel.addElement(bus);
               }
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(addBus,
                     "Please enter valid values", "Invalid values",
                     JOptionPane.ERROR_MESSAGE);
            }
            capacityField.setText("");
            plateNumberField.setText("");
            busTypeComboBox.setSelectedIndex(0);
         }
      });
      
      JButton backBus = new JButton("Back");
      backBus.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(contentPane, "changeRemoveBus");
         }
      });
      JButton updateBusInfo = new JButton("Update bus' data");
      updateBusInfo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               Bus selected = busJList.getSelectedValue();
               if (!capacityField.getText().equals("")
                     || !plateNumberField.getText().equals("")
                     || String.valueOf(busTypeComboBox
                           .getSelectedItem()).equals("")){
                  selected.setCapacity(Integer.parseInt(capacityField.getText()));
                  selected.setId(Integer.parseInt(plateNumberField.getText()));
                  selected.setType(String.valueOf(busTypeComboBox.getSelectedItem()));
                  updateBusList();
                  cl.show(contentPane, "changeRemoveBus");
               } else {
                  JOptionPane.showMessageDialog(addBus,"Please fill in all of the fields");             }
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(contentPane,
                     "Something went wrong");
            }
         }
      });
      JButton cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(goHome);
      addBusNorth.add(capacityLabel);
      addBusNorth.add(capacityField);
      addBusNorth.add(plateNumberLabel);
      addBusNorth.add(plateNumberField);
      addBusNorth.add(labelTypeOfBus);
      addBusNorth.add(busTypeComboBox);
      addBusSouth.add(cancelButton);
      addBusSouth.add(backBus);
      addBus.add(addBusNorth, BorderLayout.CENTER);
      addBus.add(addBusSouth, BorderLayout.SOUTH);

      /**
       * panel change or remove bus
       */
      JPanel changeRemoveBus = new JPanel(new BorderLayout());
      changeRemoveBus.setBorder(new TitledBorder("Change/Remove bus' data"));
      JPanel panelChangeRemoveBusNorth = new JPanel();
      panelChangeRemoveBusNorth.setLayout(new FlowLayout(FlowLayout.CENTER,
            5, 5));
      JLabel labelBusID = new JLabel("Bus plate number:  ");
      JTextField busIDField1 = new JTextField(20);
      JButton findBusButton = new JButton("Search by ID");
      findBusButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               busListModel.removeAllElements();
              if(buses.getBus(Integer.parseInt(plateNumberField.getText()))!=null){
                 busListModel.removeAllElements();
                 busListModel.addElement(buses.getBus(Integer.parseInt(plateNumberField.getText())));
               }
              else{
                 JOptionPane.showMessageDialog(contentPane, "Bus not found");
                 updateBusList();
               }
              //insideEastBusPanel.setText("");
              plateNumberField.setText("");
            } catch (Exception e2) {
               System.out.println(buses.getBus(Integer.parseInt(plateNumberField.getText())).toString());
               System.err.println(e2.getCause());
               
            }
         }
      });
   
      JPanel panelChangeRemoveBusEast = new JPanel(new BorderLayout());
      panelChangeRemoveBusEast.setBorder(new TitledBorder("Bus' information"));
      JTextArea insideEastBusPanel = new JTextArea();
      busJList.addListSelectionListener(new ListSelectionListener() {   
         @Override
         public void valueChanged(ListSelectionEvent arg0) {
            try {
               String info = busJList.getSelectedValue().getBusInfo();
               insideEastBusPanel.setText(info);
            } catch (Exception e1) {
               System.err.println(e1.getCause());
            }
         }
      });
      insideEastBusPanel.setEditable(false);
      insideEastBusPanel.setLineWrap(true);
      insideEastBusPanel.setColumns(20);
      
      
      JScrollPane scrollBusesCenter = new JScrollPane(busJList);
      JPanel panelChangeRemoveBusSouth = new JPanel(new FlowLayout());
      
      JButton changeBusInformation = new JButton("Change bus' data");
      
      changeBusInformation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            busBorder.setTitle("Change bus' data");
            addBusSouth.remove(addBusButton);
            addBusButton.setVisible(false);
            backBus.setVisible(true);
            addBusSouth.add(updateBusInfo);
            updateBusInfo.setVisible(true);
            cl.show(contentPane, "addBus");
         }
      });
      JButton removeBus = new JButton("Remove bus");
      
      removeBus.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               int selectedIndex = busJList.getSelectedIndex();
               Bus selectedBus = busJList.getSelectedValue();
               buses.removeBus(selectedBus);
               busListModel.removeElementAt(selectedIndex);
               updateBusList();
               insideEastBusPanel.setText("");
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(contentPane,"fu");
            }

         }
      });
   
      JButton saveBusInformationButton = new JButton("Save");
      saveBusInformationButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D://"));
            int returnValue = fileChooser.showOpenDialog(null);
            if( returnValue == JFileChooser.APPROVE_OPTION){
               try{
                  FileWriter fw = new FileWriter(fileChooser.getSelectedFile() + ".txt");
                  for(int i =0;i< buses.getAllBuses().size();i++){
                  fw.write(buses.getAllBuses().get(i).getBusInfo());
                  fw.close();
                  }
               }catch(Exception e3){
                  e3.printStackTrace();
               }
            }
         }
      });
      
      JButton cancelButtonBus = new JButton("Cancel");
      cancelButtonBus.addActionListener(goHome);
      panelChangeRemoveBusEast.add(insideEastBusPanel, BorderLayout.CENTER);
      panelChangeRemoveBusSouth.add(changeBusInformation);
      panelChangeRemoveBusSouth.add(removeBus);
      panelChangeRemoveBusSouth.add(cancelButtonBus);
      panelChangeRemoveBusSouth.add(saveBusInformationButton);
      panelChangeRemoveBusNorth.add(labelBusID);
      panelChangeRemoveBusNorth.add(busIDField1);
      panelChangeRemoveBusNorth.add(findBusButton);
      changeRemoveBus.add(scrollBusesCenter, BorderLayout.CENTER);
      changeRemoveBus.add(panelChangeRemoveBusNorth, BorderLayout.NORTH);
      changeRemoveBus.add(panelChangeRemoveBusSouth, BorderLayout.SOUTH);
      changeRemoveBus.add(panelChangeRemoveBusEast, BorderLayout.EAST);

      /**
       * panel for adding a new trip or travel to the system
       */
      JPanel addTripOrTravel = new JPanel(new BorderLayout());
      TitledBorder tripsAndTravelsTitle = new TitledBorder("Add trip/travel");
      JPanel panelCenter = new JPanel();
      panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
      panelCenter.setBorder(tripsAndTravelsTitle);
      ButtonGroup buttons = new ButtonGroup();
      JRadioButton tripRadioButton = new JRadioButton("Trip");
      tripRadioButton.setSelected(false);
      JRadioButton travelRadioButton = new JRadioButton("Travel");
      travelRadioButton.setSelected(false);
      buttons.add(travelRadioButton);
      buttons.add(tripRadioButton);
      JLabel labelFrom2 = new JLabel("From: ");
      JTextField fromField2 = new JTextField(10);
      JLabel labelTo2 = new JLabel("To: ");
      JTextField toField2 = new JTextField(10);
      JLabel labelDepDate2 = new JLabel("Departure date: ");
      /*UtilDateModel model = new UtilDateModel();
      JDatePanelImpl datePanel1 = new JDatePanelImpl(model);
      JDatePickerImpl depDate2 = new JDatePickerImpl(datePanel1);*/
      JLabel labelDepTime2 = new JLabel("Departure time: ");
      JTextField depTime2 = new JTextField(10);
      depTime2.addFocusListener(new FocusAdapter() {
         @Override
         public void focusGained(FocusEvent e) {
            depTime2.setText("");
         }
      });
      depTime2.setText("hh:mm");
      JLabel labelArrDate2 = new JLabel("Arrival date: ");
      /*UtilDateModel model2 = new UtilDateModel();
      JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
      JDatePickerImpl arrDate2 = new JDatePickerImpl(datePanel2);*/
      JLabel labelArrTime2 = new JLabel("Arrival time: ");
      JTextField arrTime2 = new JTextField(10);
      arrTime2.addFocusListener(new FocusAdapter() {
         @Override
         public void focusGained(FocusEvent arg0) {
            arrTime2.setText("");
         }
      });
      arrTime2.setText("hh:mm");
      JLabel priceLabelTripOrTravel = new JLabel("Price: ");
      JTextField priceFieldTripOrTravel = new JTextField();
      JButton saveTripOrTravel = new JButton("Save trip/travel");
      
      saveTripOrTravel.addActionListener(new ActionListener(){

         public void actionPerformed(ActionEvent e){
            try{

               if(String.valueOf(fromField2.getText()).equals("") || toField2.getText().equals("")|| 
                depDate2.getText().equals("") || 
                arrDate2.getText().equals("") || 
                arrTime2.getText().equals("") || 
                depTime2.getText().equals("") ||  String.valueOf(buttons.getSelection()).equals("")){
             JOptionPane.showMessageDialog(addTripOrTravel, "Please fill in all of the fields");
            }
            else{
               Service service = new Service(fromField2.getText(),toField2.getText(),
                new Date(Integer.parseInt(depDate2.getText())), 
                new Date(Integer.parseInt(arrDate2.getText())),
                String.valueOf(buttons.getSelection()));
               services.addService(service);
               serviceListModel.addElement(service);
            }

            } catch(Exception e3){
               JOptionPane.showMessageDialog(addTripOrTravel,"Invalid values","Please enter valid arguments",JOptionPane.ERROR_MESSAGE);

            }
         }
          });
      JButton backChangeTrip = new JButton("Back");
      backChangeTrip.setVisible(false);
      backChangeTrip.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(contentPane, "changeTripOrTravel");
         }
      });
      JButton updateTripOrTravel = new JButton("Update trip/travel");
      
      updateTripOrTravel.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               Service selected = tripsAndTravelsList.getSelectedValue();
               if (!depDate2.getText().equals("")
                     || !arrDate2.getText().equals("")
                     || !arrTime2.getText().equals("")
                     || !depTime2.getText().equals("")){
                  selected.setDepartureDate(depDate2.getText());
                  selected.setArrivalDate(arrDate2.getText());
                  selected.setArrivalTime(arrTime2.getText());
                  selected.setDepartureTime(depTime2.getText());
                  
                  updateTripsAndTravelList();
                  cl.show(contentPane, "changeTripOrTravel");
               } else {
                  JOptionPane.showMessageDialog(addChauffeur,"Please fill in all of the fields");       
               }
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(contentPane,
                     "Something went wrong");
            }
         }
      });
      
      
      JButton cancel1 = new JButton("Cancel");
      cancel1.addActionListener(goHome);
      JPanel panelWest = new JPanel(new BorderLayout());
      panelWest.setBorder(new TitledBorder("Chauffeur"));
      JList listOfAvailableChauffeur = new JList();
      listOfAvailableChauffeur.addListSelectionListener(new ListSelectionListener() {   
         @Override
         public void valueChanged(ListSelectionEvent arg0) {
            try {
               
               String info = chauffeurJList.getSelectedValue().toString();
               insideEastPanel.setText(info);
            } catch (Exception e) {
               System.err.println(e.getCause());
            }
         }
      });
      JScrollPane scrollAvailableChauffeurs = new JScrollPane(
            listOfAvailableChauffeur);
      JTextArea insideAvailableChauffeursPanel = new JTextArea();
      insideAvailableChauffeursPanel.setEditable(false);
      insideAvailableChauffeursPanel.setLineWrap(true);
      insideAvailableChauffeursPanel.setColumns(20);
      insideAvailableChauffeursPanel.setRows(6);
      insideAvailableChauffeursPanel.setBorder(new TitledBorder(
            "Chauffeur's information"));
      listOfAvailableChauffeur.setVisibleRowCount(10);
      JButton checkForAvailableChauffeurs2 = new JButton(
            "Check for available chauffeurs");
      JPanel panelEast = new JPanel(new BorderLayout());
      panelEast.setBorder(new TitledBorder("Bus"));
      JList listOfAvailableBuses2 = new JList();
      listOfAvailableBuses2.addListSelectionListener(new ListSelectionListener() {   
         @Override
         public void valueChanged(ListSelectionEvent arg0) {
            try {
               
               String info = busJList.getSelectedValue().toString();
               insideEastPanel.setText(info);
            } catch (Exception e) {
               System.err.println(e.getCause());
            }
         }
      });
      JScrollPane scrollAvailableBuses = new JScrollPane(
            listOfAvailableBuses2);
      JTextArea insideAvailableBusPanel = new JTextArea();
      insideAvailableBusPanel.setEditable(false);
      insideAvailableBusPanel.setLineWrap(true);
      insideAvailableBusPanel.setColumns(20);
      insideAvailableBusPanel.setRows(6);
      insideAvailableBusPanel.setBorder(new TitledBorder("Bus' information"));
      listOfAvailableBuses2.setVisibleRowCount(10);
      JButton checkForAvailableBuses2 = new JButton("Check for available buses");
      panelCenter.add(tripRadioButton);
      panelCenter.add(travelRadioButton);
      panelCenter.add(labelFrom2);
      panelCenter.add(fromField2);
      panelCenter.add(labelTo2);
      panelCenter.add(toField2);
      panelCenter.add(labelDepDate2);
      //panelCenter.add(depDate2);
      panelCenter.add(labelDepTime2);
      panelCenter.add(depTime2);
      panelCenter.add(labelArrDate2);
      //panelCenter.add(arrDate2);
      panelCenter.add(labelArrTime2);
      panelCenter.add(arrTime2);
      panelCenter.add(priceLabelTripOrTravel);
      panelCenter.add(priceFieldTripOrTravel);
      panelCenter.add(cancel1);
      panelCenter.add(backChangeTrip);
      panelWest.add(scrollAvailableChauffeurs, BorderLayout.CENTER);
      panelWest.add(insideAvailableChauffeursPanel, BorderLayout.NORTH);
      panelWest.add(checkForAvailableChauffeurs2, BorderLayout.SOUTH);
      panelEast.add(scrollAvailableBuses, BorderLayout.CENTER);
      panelEast.add(insideAvailableBusPanel, BorderLayout.NORTH);
      panelEast.add(checkForAvailableBuses2, BorderLayout.SOUTH);
      addTripOrTravel.add(panelCenter, BorderLayout.CENTER);
      addTripOrTravel.add(panelEast, BorderLayout.EAST);
      addTripOrTravel.add(panelWest, BorderLayout.WEST);

      /**
       * change trip's or travel's information
       */
      JPanel changeTripOrTravel = new JPanel();
      changeTripOrTravel.setLayout(new BorderLayout(0, 0));
      changeTripOrTravel.setBorder(new TitledBorder(
            "Change/remove trip or travel"));
      JPanel changeTripTravelNorth = new JPanel(new FlowLayout(
            FlowLayout.CENTER));
      JLabel serviceDestinationLabel = new JLabel("Destination:");
      JTextField serviceDestinationField = new JTextField(7);
      JButton findServiceByDestination = new JButton("Search by destination");
      /*findServiceByDestination.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               serviceListModel.removeAllElements();
               for (int i = 0; i < services.getService();i++){
                     
               }
               if(serviceListModel.isEmpty()){
                  JOptionPane.showMessageDialog(contentPane, "Service not found");
                  updateTripsAndTravelsList();
               }
            } catch (Exception e2) {
               JOptionPane.showMessageDialog(contentPane, "Something went wrong");
               System.err.println(e2.getCause());

            }
         }
      });*/
      findServiceByDestination.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               busListModel.removeAllElements();
              if(buses.getBus(Integer.parseInt(plateNumberField.getText()))!=null){
                 busListModel.removeAllElements();
                 busListModel.addElement(buses.getBus(Integer.parseInt(plateNumberField.getText())));
               }
              else{
                 JOptionPane.showMessageDialog(contentPane, "Bus not found");
                 updateBusList();
               }
              //insideEastBusPanel.setText("");
              plateNumberField.setText("");
            } catch (Exception e2) {
               System.out.println(buses.getBus(Integer.parseInt(plateNumberField.getText())).toString());
               System.err.println(e2.getCause());
               
            }
         }
      });
   
      
      JLabel depDateLabel = new JLabel("Departure date: ");
      /*UtilDateModel model6 = new UtilDateModel();
      JDatePanelImpl datePanel6 = new JDatePanelImpl(model6);
      JDatePickerImpl depDate6 = new JDatePickerImpl(datePanel6);*/
      JButton findServiceByDepDate = new JButton("Search by departure date");
      JList tripsAndTravelsList = new JList();
      JScrollPane scrollPanelCenter = new JScrollPane(tripsAndTravelsList);
      JPanel changeTripTravelEast = new JPanel(new BorderLayout());
      changeTripTravelEast.setBorder(new TitledBorder("Trip/Travel data"));
      JTextArea insideEastPanelTorT = new JTextArea();
      insideEastPanelTorT.setEditable(false);
      insideEastPanelTorT.setLineWrap(true);
      insideEastPanelTorT.setColumns(20);
      JPanel changeTripTravelSouth = new JPanel(new FlowLayout(
            FlowLayout.CENTER));
      JButton changeServiceButton = new JButton("Change trip/travel");
      changeServiceButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            backChangeTrip.setVisible(true);
            panelCenter.add(updateTripOrTravel);
            updateTripOrTravel.setVisible(true);
            panelCenter.remove(saveTripOrTravel);
            saveTripOrTravel.setVisible(false);
            tripsAndTravelsTitle.setTitle("Change trip/travel");
            cl.show(contentPane, "addTripOrTravel");
         }
      });
      JButton removeServiceButton = new JButton("Remove trip/travel");
      removeServiceButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // remove chauffeur method
            JOptionPane.showMessageDialog(contentPane,
                  "Trip/travel removed from the system");
            cl.show(contentPane, "home");
         }
      });
      JButton saveServicesInformationButton = new JButton("Save");
      saveServicesInformationButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D://"));
            int returnValue = fileChooser.showOpenDialog(null);
            if( returnValue == JFileChooser.APPROVE_OPTION){
               try{
                  FileWriter fw = new FileWriter(fileChooser.getSelectedFile() + ".txt");
                  for(int i =0;i< services.getAllServices().size();i++){
                  fw.write(services.getAllServices().get(i).getServiceInfo());
                  fw.close();
                  }
               }catch(Exception e3){
                  e3.printStackTrace();
               }
            }
         }
      });
      
      JButton cancelButton5 = new JButton("Cancel");
      cancelButton5.addActionListener(goHome);
      changeTripTravelNorth.add(serviceDestinationLabel);
      changeTripTravelNorth.add(serviceDestinationField);
      changeTripTravelNorth.add(findServiceByDestination);
      changeTripTravelNorth.add(depDateLabel);
      //changeTripTravelNorth.add(depDate6);
      changeTripTravelNorth.add(findServiceByDepDate);
      changeTripTravelEast.add(insideEastPanelTorT, BorderLayout.CENTER);
      changeTripTravelSouth.add(changeServiceButton);
      changeTripTravelSouth.add(removeServiceButton);
      changeTripTravelSouth.add(cancelButton5);
      changeTripTravelSouth.add(saveServicesInformationButton);
      changeTripOrTravel.add(scrollPanelCenter, BorderLayout.CENTER);
      changeTripOrTravel.add(changeTripTravelNorth, BorderLayout.NORTH);
      changeTripOrTravel.add(changeTripTravelSouth, BorderLayout.SOUTH);
      changeTripOrTravel.add(changeTripTravelEast, BorderLayout.EAST);

      /**
       * add all panels in the outermost panel and give them indexes
       */
      contentPane.add(homePanel, "home");
      contentPane.add(makeReservation, "makeReservation");
      contentPane.add(makeReservationNext, "makeReservationNext");
      contentPane.add(changeRemoveReservation, "changeOrRemoveReservation");
      contentPane.add(addChauffeur, "addChauffeur");
      contentPane.add(changeRemoveChauffeur, "changeRemoveChauffeur");
      contentPane.add(addBus, "addBus");
      contentPane.add(changeRemoveBus, "changeRemoveBus");
      contentPane.add(addTripOrTravel, "addTripOrTravel");
      contentPane.add(changeTripOrTravel, "changeTripOrTravel");

      /**
       * add everything into the JFrame
       */
      add(contentPane, BorderLayout.CENTER);

      /**
       * create menu
       */
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      JMenu menuManageReservations = new JMenu("Manage reservations");
      menuBar.add(menuManageReservations);

      JMenuItem makeNewReservation = new JMenuItem("Make a new reservation");
      menuManageReservations.add(makeNewReservation);
      makeNewReservation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            reservationTitle.setTitle("Make reservation");
            buttonBack.setVisible(false);
            makeReservationNextSouth.add(saveReservationButton);
            makeReservationNextSouth.remove(updateReservation);
            cl.show(contentPane, "makeReservation");
         }
      });

      JMenuItem removeChangeReservation = new JMenuItem(
            "Change/Remove reservation");
      menuManageReservations.add(removeChangeReservation);
      removeChangeReservation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(contentPane, "changeOrRemoveReservation");
         }
      });

      JMenu menuManageChauffeurs = new JMenu("Manage chauffeurs");
      menuBar.add(menuManageChauffeurs);

      JMenuItem addChauffeurMenu = new JMenuItem("Add a chauffeur");
      menuManageChauffeurs.add(addChauffeurMenu);
      addChauffeurMenu.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            backChauffeur.setVisible(false);
            chauffeurBorder.setTitle("Add chauffeur");// to clear the
                                             // previous title
            addChauffeur.setBorder(null);
            addChauffeur.setBorder(chauffeurBorder);
            addChauffeurSouth.add(addChauffeurButton);
            addChauffeurButton.setVisible(true);
            updateChauffeurInfo.setVisible(false);
            addChauffeurSouth.remove(updateChauffeurInfo);
            cl.show(contentPane, "addChauffeur");
         }
      });

      JMenuItem changeOrRemoveChauffeur = new JMenuItem(
            "Change a chauffeur's information/Remove a chauffeur");
      menuManageChauffeurs.add(changeOrRemoveChauffeur);
      changeOrRemoveChauffeur.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(contentPane, "changeRemoveChauffeur");
         }
      });

      JMenu menuManageBuses = new JMenu("Manage buses");
      menuBar.add(menuManageBuses);

      JMenuItem addABus = new JMenuItem("Add a bus");
      menuManageBuses.add(addABus);
      addABus.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            addBus.setBorder(null);
            busBorder.setTitle("Add bus");
            addBus.setBorder(busBorder);
            addBusSouth.add(addBusButton);
            addBusButton.setVisible(true);
            updateBusInfo.setVisible(false);
            backBus.setVisible(false);
            addBusSouth.remove(updateBusInfo);
            cl.show(contentPane, "addBus");
         }
      });

      JMenuItem changeRemoveBusInformation = new JMenuItem(
            "Change a bus' information/Remove a bus");
      menuManageBuses.add(changeRemoveBusInformation);
      changeRemoveBusInformation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(contentPane, "changeRemoveBus");
         }
      });

      JMenu manageTripsAndTravels = new JMenu("Manage trips and travels");
      menuBar.add(manageTripsAndTravels);

      JMenuItem addATripTravel = new JMenuItem("Add a trip/travel");
      manageTripsAndTravels.add(addATripTravel);
      addATripTravel.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            backChangeTrip.setVisible(false);
            panelCenter.remove(updateTripOrTravel);
            updateTripOrTravel.setVisible(false);
            panelCenter.add(saveTripOrTravel);
            saveTripOrTravel.setVisible(true);
            panelCenter.setBorder(null);
            tripsAndTravelsTitle.setTitle("Add trip/travel");
            panelCenter.setBorder(tripsAndTravelsTitle);
            cl.show(contentPane, "addTripOrTravel");
         }
      });

      JMenuItem changeRemoveATriptravel = new JMenuItem(
            "Change/Remove a trip/travel");
      manageTripsAndTravels.add(changeRemoveATriptravel);
      changeRemoveATriptravel.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.show(contentPane, "changeTripOrTravel");
         }
      });

   }

   /**
    * create home panel
    */
   public JPanel homePanel() {
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
      return homePanel;
   }
   
   /**
    * update chauffeurList
    */
   public void updateChauffeurList(){
      chauffeurListModel.removeAllElements();
      for (int i = 0; i < chauffeurs.getAllChauffeurs().size(); i++) {
         chauffeurListModel.addElement(chauffeurs.getAllChauffeurs().get(i));
      }
   }
   
   /**
    * update buslist
    */
   public void updateBusList(){
      busListModel.removeAllElements();
      for (int i = 0; i < buses.getAllBuses().size(); i++) {
         busListModel.addElement(buses.getAllBuses().get(i));
      }
   }
   /**
    * update the servicelist
    */
   public void updateTripsAndTravelList(){
      serviceListModel.removeAllElements();
      for (int i = 0; i < services.getAllServices().size(); i++) {
         serviceListModel.addElement(services.getAllServices().get(i));
      }
   }

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      GUI frame = new GUI();
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setVisible(true);
   }
}
