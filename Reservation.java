public class Reservation
{
   private int numberOfPassengers;
   private double price;
   private boolean isPaid;
   
   
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


}
