public class Reservation
{
   private int numberOfPassengers;
   private double price;
   private boolean isPaid;
   private Service service;
   private Customer customer;
   private Chauffeur chauffeur;
   private Bus bus;
   
   
    /**
    * sets the number of passengers and price of each reservation
    * the reservation is set to "not paid"(isPaid=false) by default
    * @param numOfPassengers
    * @param price
    */
   public Reservation(int numOfPassengers, Customer customer){
      this.numberOfPassengers = numOfPassengers;
	   this.customer= customer;
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
   *
   * @return the number of free seats in bus
   */
   public int getFreeSeats(){
      return bus.getCapacity() - numberOfPassengers;
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
    * @return the customer who made the reservation
    */
   public Customer getCustomer(){
      return customer;
   }
   
   
   /**
	 * @param chauffeur to set the chauffeur
	 */
	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}
	
   
   /**
	 * @return the chauffeur
	 */
	public Chauffeur getChauffeur() {
		return chauffeur;
	}
	
	
	/**
	 * @param bus to set the bus
	 */
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	

	/**
	 * @return the bus
	 */
	public Bus getBus() {
		return bus;
	}


	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}


	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
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
