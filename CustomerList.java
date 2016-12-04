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
   
   public void removeCustomer(Customer customer){
      customers.add(customer);
   }
   
   public int getNumberOfCustomers(){
      return customers.size();
   }
   
   public ArrayList<Customer> getCustomer(String customerName){
      ArrayList<Customer> customersByName = new ArrayList<Customer>();
      for(int i =0;i<customers.size();i++){
         if(customers.get(i).getName().equals(customerName)){
            customersByName.add(customers.get(i));
         }
      }
      return customersByName;
   }
   public boolean isRegular(String customer){
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
