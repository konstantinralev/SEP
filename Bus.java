
public class Bus
{
   private int capacity;
   private int id;
   private String type;
   private Reservation reservation;
   
   /**
    * sets the type, capacity and plate number of each bus
    * @param type
    * @param capacity
    * @param id
    */
   public Bus(String type, int capacity, int id){
      this.type= type;
      this.capacity = capacity;
      this.id = id;
   }

   
   /**
    * @param capacity the capacity to set
    */
   public void setCapacity(int capacity)
   {
      this.capacity = capacity;
   }

   
   /**
    * @return the capacity
    */
   public int getCapacity()
   {
      return capacity;
   }
   
   
   /**
    * @param id the id to set
    */
   public void setId(int id)
   {
      this.id = id;
   }


   /**
    * @return the id
    */
   public int getId()
   {
      return id;
   }


   /**
    * @param type the type to set
    */
   public void setType(String type)
   {
      this.type = type;
   }

   
   /**
    * @return the type
    */
   public String getType()
   {
      return type;
   }

   
   /**
    * 
    * @param dateInterval
    * @return if the bus is available
    */
   public boolean isAvailable(DateInterval dateInterval){
      //put code checking for availability here
   }
   
   
   public int getFreeSeats(){
      return capacity - reservation.getNumberOfPassengers();
   }
   
   
   public String toString(){
      return "Capacity: " + capacity + "\nPlate Number: " + id + "\nType: " + type;
   }

}
