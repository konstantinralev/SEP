import java.util.ArrayList;


public class Company
{
   private CustomerList customers;
   private ReservationList reservations;
   private BusList busses;
   private ChauffeurList chauffeurs;
   private ServiceList services;
   
   
   /**
    * the constructor initializes 
    */
   public Company(){
	   customers = new CustomerList();
	   reservations = new ReservationList();
	   busses = new BusList();
	   chauffeurs = new ChauffeurList();
	   services = new ServiceList();
   }
   
   
   /**
    * 
    * @return a list with the suggested buses depending on availability of a bus in a certain date interval
    * and if there are enough free seats
    */
   public ArrayList<Bus> suggestBuses(DateInterval dateInterval, int numberOfPassengers){
	   ArrayList<Bus> suggestedBuses = new ArrayList<Bus>();
	      for(int i =0;i<reservations.getNotOverlappingReservations(dateInterval).size();i++){
	         if(reservations.getNotOverlappingReservations(dateInterval).get(i).getFreeSeats() > numberOfPassengers){
	            suggestedBuses.add(reservations.getNotOverlappingReservations(dateInterval).get(i).getService().getBus());
	         }
	      }
	      return suggestedBuses;
   }
   
   
   /** 
    * applies discount if the customer is regular
    */
   public void applyDiscount(String customerName){
      //put method for applying discount
   }
   
   
   /**
    * 
    * @return a list with the suggested chauffeurs depending on the date.
    */
   public ArrayList<Chauffeur> suggestChauffeurs(DateInterval date){
	   ArrayList<Chauffeur> availableChauffeurs = new ArrayList<Chauffeur>();
	   for (int i = 0; i < reservations.getNotOverlappingReservations(date).size(); i++) {
		   availableChauffeurs.add(reservations.getNotOverlappingReservations(date).get(i).getService().getChauffeur());
	   }
	   return availableChauffeurs;
   }

   
   /**
    * @param date interval
    * @param chauffeur
    * @return if a chauffeur is available in a certain date interval
    */
   public boolean isChauffeurAvailable(DateInterval date, Chauffeur chauffeur){
	   for (int i = 0; i < reservations.getOverlappingReservations(date).size(); i++) {
		if(reservations.getOverlappingReservations(date).get(i).getService().getChauffeur().equals(chauffeur)){
			return false;
		}
	}
	   return true;
   }
   
   
   /**
    * @param type of service
    * @param dateInterval
    * @return a list with the suggested services depending on the date 
    */
   public ArrayList<Service> suggestService(String type, DateInterval date){
	   ArrayList<Service> suggestedServices = new ArrayList<Service>();
	      for(int i =0;i<services.getOverlappingServices(date).size();i++){
	         if(services.getAllServices().get(i).getType().equals(type)){ 
	            suggestedServices.add(services.getAllServices().get(i));
	         }
	      }
		return suggestedServices;
   }
   
   
   /**
    * @param type of service
    * @return a list with the suggested services depending on the date 
    */
   public ArrayList<Service> suggestService(String type){
	   ArrayList<Service> suggestedServices = new ArrayList<Service>();
	      for(int i =0;i<services.getAllServices().size();i++){
	         if(services.getAllServices().get(i).getType().equals(type)){ 
	            suggestedServices.add(services.getAllServices().get(i));
	         }
	      }
		return suggestedServices;
   }
}
