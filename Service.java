import java.util.Date;

public class Service
{
   private String type;
   private String departureTime;
   private String arrivalTime;
   private Route route;
   private DateInterval date;
   private Date arrivalDate;
   private Date departureDate;
   private Chauffeur chauffeur;
   private Bus bus;
   
   
  /**
   * sets the route, arrivalDate and departureDate for each service.
   * @param route
   * @param departureDate
   * @param arrivalDate
   */
   public Service (String placeOfDeparture, String placeOfArrival, Date departureDate, Date arrivalDate){
      this.route = new Route(placeOfDeparture, placeOfArrival);
      this.date = new DateInterval(departureDate, arrivalDate);
   }
   
   
   /**
    * set the place of departure of service
    * @param place of departure
    */
   public void setDeparturePlace(String placeOfDeparture){
      this.route.setPlaceOfDeparture(placeOfDeparture);
   }
   
   
   /**
    * set the place of arrival of service
    * @param place of arrival
    */
   public void setArrivalPlace(String placeOfArrival){
      this.route.setPlaceOfArrival(placeOfArrival);
   }
   
   
   /**
    * @param route
    */
   public void setRoute(Route route){
      this.route = route;
   }
   
   

   /** 
    * @return route;
    */
   public Route getRoute(){
      return route;
   }
      
   
  /**
   * 
   * @param departureDate
   * @param arrivalDate
   */
   public void setDateInterval(Date departureDate, Date arrivalDate){
      this.departureDate = departureDate;
      this.arrivalDate = arrivalDate;
   }
   
   
   /**
    * set the departure date of a service
    * @param departureDate
    */
    public void setDepartureDate(Date departureDate){
       this.date.setDepartureDate(departureDate);
    }    
   
   
    /**
     * set the arrival date of a service
     * @param arrivalDate
     */
    public void setArrivalDate(Date arrivalDate){
    	this.date.setArrivalDate(arrivalDate);
    }

    
    /**
    * 
    * @return the date interval of a service
    */
   public DateInterval getDateInterval(){
      return date;
   } 
    
   
   /**
    * 
    * @return departureDate
    */
   public Date getDepartureDate(){
	   return departureDate;
   }

   
   /**
    * 
    * @return arrivalDate
    */
   public Date getArrivalDate(){
      return arrivalDate;
   }    
    
   
   /**
    * @param type to set the type of the service
    */
   public void setTypeToBusAndChauffeur()
   {
      this.type = "Bus-and-chauffeur";
   }
   
   
   /**
    * sets the type of a service depending on its time interval
    * trips are one-day long and travels are seven-day long
    * bus-and-chauffeur services duration is unknown and for this type of service,
    * setting of type with the previous method should be used
    */
   public void setType()
   {
      if(date.durationOfService() == 1){
    	  this.type = "Trip";
      }
      if(date.durationOfService() == 7){
    	  this.type = "Travel";
      }
   }

   
   /**
    * @return type of service
    * @return type
    */
   public String getType(){
      return this.type;
   }
   
   
   /**
    * set the departure time of a service
    * @param departureTime
    */
   public void setDepartureTime(String departureTime)
   {
      this.departureTime = departureTime;
   }
   
   
   /**
    * @return the departure time of a service
    * @return departureTime
    */
   public String getDepartureTime()
   {
      return departureTime;
   }

   
   
   /**
    * @param arrivalTime to set the arrival time
    */
   public void setArrivalTime(String arrivalTime)
   {
	   this.arrivalTime = arrivalTime;
   }
   
   
   /**
    * 
    * @return the arrivalTime of a service
    */
   public String getArrivalTime()
   {
	   return arrivalTime;
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
    * @return the information about each service.
    */
   public String toString(){
      return "Type of Service: " + type + "\n" + route.toString() + "\n" + date.toString() + "\nDeparture Time: " + departureTime +
    		  "\nArrival Time: " + arrivalTime;
   }
}
