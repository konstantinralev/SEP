public class Reservation
{
   private int numberOfPassengers;
   private double price;
   private boolean isPaid;
   private Customer customer;
   
    /**
    * sets the number of passengers and price of each reservation
    * @param numOfPassengers
    * @param price
    */
   public Reservation(int numOfPassengers, double price){
      this.numberOfPassengers = numOfPassengers;
      this.price = price;
      isPaid = false;
   }
   
   /**
    * @return the numberOfPassengers
    */
   public int getNumberOfPassengers()
   {
      return numberOfPassengers;
   }


   /**
    * @param numberOfPassengers the numberOfPassengers to set
    */
   public void setNumberOfPassengers(int numberOfPassengers)
   {
      this.numberOfPassengers = numberOfPassengers;
   }


   /**
    * @return the price
    */
   public double getPrice()
   {
      return price;
   }


   /**
    * @param price the price to set
    */
   public void setPrice(double price)
   {
      this.price = price;
   }


   /**
    * @return the isPaid
    */
   public boolean isPaid()
   {
      return isPaid;
   }


   /**
    * @param isPaid the isPaid to set
    */
   public void setPaid()
   {
      this.isPaid = true;
   }

   /**
    * @param customer
    */
   public void setCustomer(Customer customer)
   {
      this.customer = customer;
   }
   
   /**
    * @return a customer
    */
   public Customer getCustomer(){
      return customer;

   }

   /**
    * @return the information about each reservation
    */
   public String toString()
   {
      return "NumberOfPassengers:" + numberOfPassengers
            + "\nprice=" + price + "\nisPaid=" + isPaid + "\ncustomer: "
            + customer;
   }
   
}
