import java.util.ArrayList;


public class Company
{
   private CustomerList customers;
   private Reservation reservation;
   
   /**
    * 
    * @return a list with the suggested buses depending on its availability
    */
   public ArrayList<Bus> suggestBuses(){
      ArrayList<Bus> suggestedBuses = new ArrayList<Bus>();
      for(int i = 0; i< suggestedBuses.size();i++){
         
      }
   }
   /** 
    * applies discount if the customer is regular
    */
   public void applyDiscount(String customerName){
      if(customers.isRegular(customerName)){
         double discount = (reservation.getPrice() - (reservation.getPrice()*0.2));
         reservation.setPrice(discount); 
      }
   }
   /**
    * 
    * @return a list with the suggested Chauffeurs depending on the dates and the Chauffeurs' wishes.
    */
   public Chauffeur[] suggestChauffeurs(){
      
   }
   /**
    * 
    * @return a lis with the suggested Services depending on the dates. 
    */
   public Service[] suggestService(){
      
   }
   
 
}
