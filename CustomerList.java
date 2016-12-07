import java.util.ArrayList;

public class CustomerList
{
   private ArrayList<Customer> customers;
   
   /**
    * the constructor initializes an ArrayList of customers
    */
   public CustomerList(){
      this.customers = new ArrayList<Customer>();
   }
   
   
   /**
    * adds a customer to the ArrayList
    * @param customer
    */
   public void addCustomer(Customer customer){
      customers.add(customer);
   }
   
   
   /**
    * removes a customer from the ArrayList
    * @param customer
    */
   public void removeCustomer(String name){
      for (int i = 0; i < customers.size(); i++) {
		if (customers.get(i).getName().equalsIgnoreCase(name)) {
			customers.remove(i);
		}
	}
   }
   
   
   /**
    * 
    * @return the number of customers in the ArrayList
    */
   public int getNumberOfCustomers(){
      return customers.size();
   }
   
   
   /**
    * 
    * @param customerName
    * @return the customers whose name coincides with one stated in the parameter 
    */
   public ArrayList<Customer> getCustomer(String customerName){
      ArrayList<Customer> customersByName = new ArrayList<Customer>();
      for(int i =0;i<customers.size();i++){
         if(customers.get(i).getName().equals(customerName)){
            customersByName.add(customers.get(i));
         }
      }
      return customersByName;
   }
   
   
   /**
    * 
    * @param customer
    * @return if a customer is regular
    */
   public boolean isRegular(String customerName){
      for(int i = 0; i < customers.size(); i++){
         if(customers.get(i).getName().equals(customerName)){
            return true;
         }
      }
      return false;
   }
   
   
   /**
    * @return a list with the customer's information
    */
   public String toString(){
      String text = "Customers:\n";   
     for(int i = 0; i < customers.size(); i++){
        text +=  "\n" + customers.get(i).toString() + "\n";
     }
     return text;
   }
}
