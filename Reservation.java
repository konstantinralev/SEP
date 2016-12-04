public class Reservation
{
   private int numberOfPassengers;
   private double price;
   private boolean isPaid;
   private Customer customer;
   
   
    /**
    * sets the number of passengers and price of each reservation
    * the reservation is set to "not paid"(isPaid=false) by default
    * @param numOfPassengers
    * @param price
    */
   public Reservation(int numOfPassengers, double price){
      this.numberOfPassengers = numOfPassengers;
      this.price = price;
      isPaid = false;
   }
   
   
   /**
    * @param numberOfPassengers to set the numberOfPassengers
    */
   public void setNumberOfPassengers(int numberOfPassengers)
   {
      this.numberOfPassengers = numberOfPassengers;
   }


   /**
    * @return the numberOfPassengers
    */
   public int getNumberOfPassengers()
   {
      return numberOfPassengers;
   }


   /**
    * @param price to set the price
    */
   public void setPrice(double price)
   {
      this.price = price;
   }


   /**
    * @return the price
    */
   public double getPrice()
   {
      return price;
   }


   /**
    * @return if the reservation is paid
    */
   public boolean isPaid()
   {
      return isPaid;
   }


   /**
    * when a customer pays for his reservation, isPaid is set to true
    */
   public void setPaid()
   {
      this.isPaid = true;
   }
   
   
   /**
    * @return a customer who made the reservation
    */
   public Customer getCustomer(){
      return customer;
   }

   
   /**
    * @return information about each reservation
    */
   public String toString()
   {
      return "NumberOfPassengers:" + numberOfPassengers
            + "\nPrice=" + price + "\nPaid=" + isPaid + "\nCustomer: "
            + customer + "\n";
   }   
}
