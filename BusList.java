import java.util.ArrayList;

public class BusList
{
   private ArrayList<Bus> buses;
   
   
   /**
    * the constructor initializes a new arrayList of buses
    */
   public BusList(){
      this.buses = new ArrayList<Bus>();
   }
   

   /**
    * @param type
    * @return a list of appropriate buses depending on the bus type
    */
   public ArrayList<Bus> getAppropriateBuses(String type){
      ArrayList<Bus> appropriateBuses = new ArrayList<Bus>();
      for(int i =0;i<buses.size();i++){
         if(buses.get(i).getType().equals(type)){
            appropriateBuses.add(buses.get(i));
         }
      }
      return appropriateBuses;
   }
   
   
   /**
    * @param number of passengers
    * @return a list of appropriate buses depending on the available seats
    */
   public ArrayList<Bus> getAppropriateBuses(int numberOfPassengers){
      ArrayList<Bus> appropriateBuses = new ArrayList<Bus>();
      for(int i =0;i<buses.size();i++){
         if(buses.get(i).getCapacity() > numberOfPassengers){
            appropriateBuses.add(buses.get(i));
         }
      }
      return appropriateBuses;
   }
   
   
   /**
    * look for a bus by id(plate number)
    * @param id
    * @return the bus with the matching id
    */
   public Bus getBus(int id){
      for(int i =0;i<buses.size();i++){
         if(buses.get(i).getId() == id){
            return buses.get(i);
         }
      }
      return null;
   }
   
   /**
    * adds a bus to the ArrayList.
    * @param bus
    */
   public void addBus(Bus bus){
      buses.add(bus);
   }
   
   /**
    * removes a bus from the ArrayList.
    * @param 
    */
   public void removeBus(int id){
      for(int i = 0; i< buses.size();i++){
         if(buses.get(i).getId() == id){
            buses.remove(buses.get(i));
         }
      }
   }
   
   /**
    * @return a string with bus' information
    */
   public String toString(){
      String message ="";
      for(int i =0;i<buses.size();i++){
        message += "\n" + buses.get(i).toString() + "\n";
      }
      return  "Buses:\n" + message;
   }

}
