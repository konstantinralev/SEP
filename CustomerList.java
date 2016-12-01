import java.util.ArrayList;

public class CustomerList
{
   private ArrayList<Customer> customers;

   public CustomerList(){
      this.customers = new ArrayList<Customer>();
   }
   
   public void addCustomer(Customer customer){
      customers.add(customer);
   }
   
   public void RemoveCustomer(Customer customer){
      customers.add(customer);
   }
   
   public int getNumberOfCustomers(){
      return customers.size();
   }
   
   public Customer getCustomer(String customerName){
      for(int i =0;i<customers.size();i++){
         if(customers.get(i).getName().equals(customerName)){
            return customers.get(i);
         }
      }
      return null;
   }
   public boolean isRegular(Customer customer){
      for(int i =0;i<customers.size();i++){
         if(customers.get(i).getName().equals(customer)){
            return true;
         }
      }
      return false;
   }
   
   public String toString(){
      String message ="";
      String b = "\n";
     for(int i =0;i<customers.size();i++){
        message += b + customers.toString() + b;
     }
     return  b + "Customers: " + message;
   }
}
