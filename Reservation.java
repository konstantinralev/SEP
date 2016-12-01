public class Reservation
{
   private int numberOfPassengers;
   private double price;
   private boolean isPaid;
   static private int numberOfReservation = 0;
   private int resNum;
   
   
   public Reservation(){
      numberOfReservation++;
      resNum = numberOfReservation;
      
   }
}
