import java.util.ArrayList;


public class ReservationList
{
   private ArrayList<Reservation> reservations;

   public ReservationList(){
      this.reservationss = new ArrayList<Reservation>();
   }
   
   public void addReservation(Reservation reservation){
      reservations.add(reservation);
   }
   
   public void removeReservation(Reservation reservation){
      reservations.remove(reservation);
   }
   
   public Reservation getReservation(String customerName){
      for(int i =0;i<reservations.size();i++){
         if(reservations.get(i).getCustomer().getName().equals(customerName)){
            return reservations.get(i);
         }
      }
      return null;
   }
   
   public Reservation getReservationByNumber(int number){
      for(int i =0;i<reservations.size();i++){
         if(reservations.get(i).getResNum() == number){
            return reservations.get(i);
         }
      }
      return null;
   }
   
   public ArrayList<Reservation> getPaidReservations(){
      ArrayList<Reservation> paidReservations = new ArrayList<Reservation>();
      for(int i =0; i<reservations.size(); i++){
         if(reservations.get(i).isPaid() == true){
            paidReservations.add(reservations.get(i));
         }
      }
      return paidReservations;
   }
   
   public ArrayList<Reservation> getUnpaidReservations(){
      ArrayList<Reservation> unpaidReservations = new ArrayList<Reservation>();
      for(int i =0; i<reservations.size(); i++){
         if(reservations.get(i).isPaid() == false){
            unpaidReservations.add(reservations.get(i));
         }
      }
      return unpaidReservations;
   }
   
   public String toString(){
      String message ="";
      String b = "\n";
      
      for(int i =0;i<reservations.size();i++){
         message += b + reservations.toString() + b;
      }
      return  b + "Reservation: " + message;
      }
   
}
