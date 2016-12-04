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
    * @param dateInterval
    * @returna list of available buses depending on a certain dateInterval
    */
   public ArrayList<Bus> getAvailableBuses(DateInterval dateInterval){
      ArrayList<Bus> availableBuses = new ArrayList<Bus>();
      for(int i =0;i<buses.size();i++){
         if(buses.get(i).isAvailable(dateInterval)){
            availableBuses.add(buses.get(i));
         }
      }
      return availableBuses;
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
    * @return a string with bus' information
    */
   public String toString(){
      String message ="";
      for(int i =0;i<buses.size();i++){
        message += "\n" + buses.get(i) + "\n";
      }
      return  "Buses:\n" + message;
   }

}
