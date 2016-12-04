
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
    * @param capacity to set the capacity
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
    * @param id to set the id
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
    * @param type to set the type of the bus
    */
   public void setType(String type)
   {
      this.type = type;
   }

   
   /**
    * @return the type of the bus
    */
   public String getType()
   {
      return type;
   }

   
   /**
    * 
    * @param dateInterval
    * @return if the bus is available for the specified date interval
    */
   public boolean isAvailable(DateInterval dateInterval){
      //put code checking for availability here
   }
   
   
   /**
   *
   * @return the number of free seats in bus
   */
   public int getFreeSeats(){
      return capacity - reservation.getNumberOfPassengers();
   }
   
   /**
   *
   *@return a string with information about a bus
   */
   public String toString(){
      return "Capacity: " + capacity + "\nPlate Number: " + id + "\nType: " + type;
   }
}
