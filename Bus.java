
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

   public int getCapacity()
   {
      return capacity;
   }

   public int getId()
   {
      return id;
   }

   public String getType()
   {
      return type;
   }

   public void setCapacity(int capacity)
   {
      this.capacity = capacity;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public void setType(String type)
   {
      this.type = type;
   }
   
   public int getFreeSeats(){
      return capacity - reservation.getNumberOfPassengers();
   }
   
   public boolean isAvailable(DateInterval dateInterval){
      if(reservation.getDateInterval()<= dateInterval){
        return true; 
      }else{
      return false;
      }
   }
   
   public String toString(){
      return "Capacity: " + capacity + "\n" + "Id: " + id + "\n" + "Type: " + type;
   }

}
