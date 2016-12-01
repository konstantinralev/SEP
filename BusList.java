import java.util.ArrayList;

public class BusList
{
   private ArrayList<Bus> buses;
   
   public BusList(){
      this.buses = new ArrayList<Bus>();
   }
   
   public Bus[] getAvailableBuses(DateInterval dateInterval){
      int size = 0;
      Bus[] AvailableBuses = new Bus[size];
      for(int i =0;i<buses.size();i++){
         if(buses.get(i).isAvailable(dateInterval)){
         AvailableBuses[i] = buses.get(i);
         i++;
         }
      }
      return AvailableBuses;
    }
   
   public Bus[] getAppropateBuses(String type){
      int size = 0;
      Bus[] AppropiateBuses = new Bus[size];
      for(int i =0;i<buses.size();i++){
         if(buses.get(i).getType().equals(type)){
         AppropiateBuses[i] = buses.get(i);
         i++;
         }
      }
      return AppropiateBuses;
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
