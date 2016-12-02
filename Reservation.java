
public class Reservation
{
      private int numberOfPassengers;
      private double price;
      private boolean isPaid;
      static private int numberOfReservation = 0;
      private int resNum;
      private DateInterval dateInterval;
      private Service service;
      private Customer customer;
      private Bus bus;
      
      public Reservation(int numberOfPassengers, double price, int resNum){
         numberOfReservation++;
         resNum = numberOfReservation;  
         this.numberOfPassengers = numberOfPassengers;
         this.price = price;
         this.resNum = resNum;
         
      }
      public void setNumberOfPassengers(int numberOfPassengers)
      {
         this.numberOfPassengers = numberOfPassengers;
      }


      public void setPrice(double price)
      {
         this.price = price;
      }
      
      public void setDateInterval(DateInterval dateInterval){
         this.dateInterval = dateInterval;
      }
      
      public DateInterval getDateInterval(){
         return dateInterval;
      }
      
      public int getNumberOfPassengers(){
         return numberOfPassengers;
      }
      
      public void payForReservation(){
         this.isPaid = true;
      }
      
      public boolean checkIfServiceIsAvailable(int period){
         if(period < Double.parseDouble(service.getArrivalTime()) && period > Double.parseDouble(service.getDepartureTime())){
            return false;
         } else{
            return true;
         }
      }
      
      public Customer getCustomer(){
         return customer;
      }
      
      public Bus getBus(){
         return bus;
      }
      
      public Chauffeur getChauffeur(){
         return chauffeur;
      }
      
      public Service getService(){
         return service;
      }
      
      public static void setNumberOfReservation(int numberOfReservation)
      {
         Reservation.numberOfReservation = numberOfReservation;
      }


      public void setResNum(int resNum)
      {
         this.resNum = resNum;
      }
      
      public String toString(){
         return "Number of passengers: " + numberOfPassengers + "\nPrice: " + price + "\nIs the reservation paid? " + isPaid + "\nReservation number: " + resNum;
      }

}
