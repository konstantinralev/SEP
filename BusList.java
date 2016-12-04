import java.util.ArrayList;

public class BusList
{
   private ArrayList<Bus> buses;
   
   public BusList(){
      this.buses = new ArrayList<Bus>();
   }
   
   public ArrayList<Bus> getAvailableBuses(DateInterval dateInterval){
      ArrayList<Bus> availableBuses = new ArrayList<Bus>();
      for(int i =0;i<buses.size();i++){
         if(buses.get(i).isAvailable(dateInterval)){
            availableBuses.add(buses.get(i));
         }
      }
      return availableBuses;
    }
   
   public ArrayList<Bus> getAppropriateBuses(String type){
      ArrayList<Bus> appropriateBuses = new ArrayList<Bus>();
      for(int i =0;i<buses.size();i++){
         if(buses.get(i).getType().equals(type)){
            appropriateBuses.add(buses.get(i));
         }
      }
      return appropriateBuses;
   }
   
   public Bus getBus(int id){
      for(int i =0;i<buses.size();i++){
         if(buses.get(i).getId() == id){
            return buses.get(i);
         }
      }
      return null;
   }
   
   public String toString(){
      String message ="";
      String b = "\n";
      
      for(int i =0;i<buses.size();i++){
        message += b + buses.toString() + b;
      }
      return  b + "Buses: " + message;
   
   }

}
