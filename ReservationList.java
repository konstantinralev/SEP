import java.util.ArrayList;

public class ReservationList
{
   private ArrayList<Reservation> reservations;
   
   
   /**
    * the constructor initializes an ArrayList of reservations
    */
   public ReservationList(){
      this.reservations = new ArrayList<Reservation>();
   }
   
   
   /**
    * 
    * @return a list with all reservations
    */
   public ArrayList<Reservation> getAllReservations(){
	   return reservations;
   }
   
   
   /**
    * add a reservation to the ArrayList
    * @param reservation
    */
   public void addReservation(Reservation reservation){
      reservations.add(reservation);
   }
   
   
   /**
    * remove a reservation from the ArrayList
    * @param reservation
    */
   public void removeReservation(Reservation reservation){
      reservations.remove(reservation);
   }
   
   
   public ArrayList<Reservation> getOverlappingReservations(DateInterval date){
	   ArrayList<Reservation> overlappingReservations = new ArrayList<Reservation>();
	   for (int i = 0; i < reservations.size(); i++) {
		if (reservations.get(i).getService().getDateInterval().checkOverlap(date)) {
			overlappingReservations.add(reservations.get(i));
		}
	}
	   return overlappingReservations;
   }
   
   
   public ArrayList<Reservation> getNotOverlappingReservations(DateInterval date){
	   ArrayList<Reservation> notOverlappingReservations = new ArrayList<Reservation>();
	   for (int i = 0; i < reservations.size(); i++) {
		if (!reservations.get(i).getService().getDateInterval().checkOverlap(date)) {
			notOverlappingReservations.add(reservations.get(i));
		}
	}
	   return notOverlappingReservations;
   }
   
   
   /**
    * @param customerName
    * @return
    */
   public ArrayList<Reservation> getReservation(String customerName){
      ArrayList<Reservation> customerReservations = new ArrayList<Reservation>();
      for(int i = 0; i < reservations.size(); i++){
         if(reservations.get(i).getCustomer().getName().equals(customerName)){
            customerReservations.add(reservations.get(i));
         }
      }
      return customerReservations;
   }
   
   
   /**
    * @return an ArrayList with the paid reservations
    */
   public ArrayList<Reservation> getPaidReservations(){
      ArrayList<Reservation> paidReservations = new ArrayList<Reservation>();
      for(int i = 0; i < reservations.size(); i++){
         if(reservations.get(i).isPaid() == true){
            paidReservations.add(reservations.get(i));
         }
      }
      return paidReservations;
   }
   
   
   /**
    * @return an ArrayList with the unpaid reservations
    */
   public ArrayList<Reservation> getUnpaidReservations(){
      ArrayList<Reservation> unpaidReservations = new ArrayList<Reservation>();
      for(int i =0; i<reservations.size(); i++){
         if(reservations.get(i).isPaid() == false){
            unpaidReservations.add(reservations.get(i));
         }
      }
      return unpaidReservations;
   }
   
   
   /**
    * @return all the reservations information
    */
   public String toString(){
      String text = "Reservation:\n";   
      for(int i = 0; i < reservations.size(); i++){
         text += "\n"+ reservations.toString() + "\n";
      }
      return text;
      }
}
