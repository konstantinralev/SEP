
public class Bus
{
   private int capacity;
   private int id;
   private String type;
   private Reservation reservation;
   
   public Bus(String type, int capacity, int id){
      this.type= type;
      this.capacity = capacity;
      this.id = id;
   }

   /**
    * @return the capacity
    */
   public int getCapacity()
   {
      return capacity;
   }



   /**
    * @param capacity the capacity to set
    */
   public void setCapacity(int capacity)
   {
      this.capacity = capacity;
   }



   /**
    * @return the id
    */
   public int getId()
   {
      return id;
   }



   /**
    * @param id the id to set
    */
   public void setId(int id)
   {
      this.id = id;
   }



   /**
    * @return the type
    */
   public String getType()
   {
      return type;
   }



   /**
    * @param type the type to set
    */
   public void setType(String type)
   {
      this.type = type;
   }



   /**
    * @return the reservation
    */
   public Reservation getReservation()
   {
      return reservation;
   }



   /**
    * @param reservation the reservation to set
    */
   public void setReservation(Reservation reservation)
   {
      this.reservation = reservation;
   }

   
   public int getFreeSeats(){
      return capacity - reservation.getNumberOfPassengers();
   }
   
   public boolean isAvailable(DateInterval dateInterval){
      //put code checking for availability here
   }
   
   public String toString(){
      return "Capacity: " + capacity + "\nPlate Number: " + id + "\nType: " + type;
   }

}
