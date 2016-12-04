
import java.util.ArrayList;

public class ServiceList
{
   private ArrayList<Service> services;
   
   /**
    * the constructor initializes the ArrayList of services.
    */
   public ServiceList(){
      this.services = new ArrayList<Service>();
   }
   
   
   /**
    * adds a service to the ArrayList
    * @param service
    */
   public void addService (Service service){
      services.add(service);
   }
   
   
   /**
    * removes a service from the ArrayList
    * @param service
    */
   public void removeService (Service service){
      services.remove(service);
   }
   
   
   /** 
    * @param type
    * @return the services whose type coincides with the parameter.
    */
   public ArrayList<Service> getServiceByType(String type){
      ArrayList<Service> servicesByType = new ArrayList<Service>();
      for(int i =0;i<services.size();i++){
         if(services.get(i).getType().equals(type)){
            servicesByType.add(services.get(i));
         }
      }
      return servicesByType;
   }
   
   
   /**
    * 
    * @param type
    * @param dateinterval
    * @return the available services whose type coincides with the parameter.
    */
   public ArrayList<Service> getAvailableServices(String type, DateInterval dateinterval){
      ArrayList<Service> availableServicesByType = new ArrayList<Service>();
      for(int i =0;i<services.size();i++){
         if(services.get(i).getType().equals(type) ){//check the availability 
            availableServicesByType.add(services.get(i));
         }
      }
      return availableServicesByType;
   }
   
   
   /**
   * @return all the services information
    */
   public String toString(){
      String message ="";
      
      for(int i =0;i<services.size();i++){
         message +=  "\n" + services.toString() + "\n";
      }
      return   "Services:\n " + message;
    }
 }
