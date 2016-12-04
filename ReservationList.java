import java.util.ArrayList;


public class ReservationList
{
   private ArrayList<Reservation> reservations;
   
   /**
    * the constructor initializes the ArrayList of reservations.
    */
   public ReservationList(){
      this.reservations = new ArrayList<Reservation>();
   }
   
   
   /**
    * add a reservation to the ArrayList
    * @param reservation
    */
   public void addReservation(Reservation reservation){
      reservations.add(reservation);
   }
   
   
   /**
    * removes a reservation from the ArrayList
    * @param reservation
    */
   public void removeReservation(Reservation reservation){
      reservations.remove(reservation);
   }
   
   
   /**
    * @param customerName
    * @return
    */
   public Reservation getReservation(String customerName){
      for(int i =0;i<reservations.size();i++){
         if(reservations.get(i).getCustomer().getName().equals(customerName)){
            return reservations.get(i);
         }
      }
      return null;
   }
   
   
   /**
    * @return an ArrayList with the paid reservations
    */
   public ArrayList<Reservation> getPaidReservations(){
      ArrayList<Reservation> paidReservations = new ArrayList<Reservation>();
      for(int i =0; i<reservations.size(); i++){
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
      String message ="";
      
      for(int i =0;i<reservations.size();i++){
         message += "\n"+ reservations.toString() + "\n";
      }
      return "Reservation:\n" + message;
      }
   
}
