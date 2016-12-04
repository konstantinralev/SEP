<<<<<<< HEAD
import java.util.Date;

=======
>>>>>>> 0585cdbc4cb3ca27a82655915b912e5dea6d6086
public class Service
{
   private String type;
   private String departureTime;
   private String arrivalTime;
   private Route route;
<<<<<<< HEAD
   private DateInterval date;
   
   
  /**
   * sets the route, arrivalDate and departureDate for each service
=======
   private DateInterval arrivalDate;
   private DateInterval departureDate;
   
  /**
   * sets the route, arrivalDate and departureDate for each service.
>>>>>>> 0585cdbc4cb3ca27a82655915b912e5dea6d6086
   * @param route
   * @param departureDate
   * @param arrivalDate
   */
<<<<<<< HEAD
   public Service (String placeOfDeparture, String placeOfArrival, Date departureDate, Date arrivalDate){
      this.route = new Route(placeOfDeparture, placeOfArrival);
      this.date = new DateInterval(departureDate, arrivalDate);
=======
   public Service (Route route, DateInterval departureDate, DateInterval arrivalDate){
      this.route = route;
      this.departureDate = departureDate;
      this.arrivalDate = arrivalDate;
>>>>>>> 0585cdbc4cb3ca27a82655915b912e5dea6d6086
   }
   
   
   /**
<<<<<<< HEAD
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
    * @return route;
    */
   public Route getRoute(){
      return route;
=======
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
   public void setDateInterval(DateInterval departureDate, DateInterval arrivalDate){
      this.departureDate = departureDate;
      this.arrivalDate = arrivalDate;
>>>>>>> 0585cdbc4cb3ca27a82655915b912e5dea6d6086
   }
   
   
   /**
<<<<<<< HEAD
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
    * @param type of service
=======
    * 
    * @return arrivalDate
    */
   public DateInterval getArrivalDate(){
      return arrivalDate;
   }    
    
    /**
     * 
     * @return departureDate
     */
    public DateInterval getDepartureDate(){
       return departureDate;
    }
    
   
   /**
    * @param type
>>>>>>> 0585cdbc4cb3ca27a82655915b912e5dea6d6086
    */
   public void setType(String type)
   {
      this.type = type;
   }

   
   /**
<<<<<<< HEAD
    * @return type of service
=======
    * @return type
>>>>>>> 0585cdbc4cb3ca27a82655915b912e5dea6d6086
    */
   public String getType(){
      return this.type;
   }
   
<<<<<<< HEAD
   
   /**
    * set the departure time of a service
=======
   /**
    * 
>>>>>>> 0585cdbc4cb3ca27a82655915b912e5dea6d6086
    * @param departureTime
    */
   public void setDepartureTime(String departureTime)
   {
      this.departureTime = departureTime;
   }
   
   
   /**
    * 
<<<<<<< HEAD
    * @return the departure time of a service
=======
    * @return departureTime
>>>>>>> 0585cdbc4cb3ca27a82655915b912e5dea6d6086
    */
   public String getDepartureTime()
   {
      return departureTime;
   }

<<<<<<< HEAD
   
   /**
    * set the arrival time of a service
    * @param arrivalTime
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
   
   
=======
   /**
    * 
    * @return arrivalTime
    */
   public String getArrivalTime()
   {
      return arrivalTime;
   }
   
   /**
    * @param arrivalTime
    */
   public void setArrivalTime(String arrivalTime)
   {
      this.arrivalTime = arrivalTime;
   }
   
>>>>>>> 0585cdbc4cb3ca27a82655915b912e5dea6d6086
   /**
    * @return the information about each service.
    */
   public String toString(){
<<<<<<< HEAD
      return "Type of Service: " + type + "\n" + route.toString() 
    		  + "\n" + date.toString() + "\nDeparture Time: " + departureTime +
    		  "\nArrival Time: " + arrivalTime;
=======
      return "Type of Service: " + type + "Departure Time: " + departureTime + "Arrival Time: " + arrivalTime;
>>>>>>> 0585cdbc4cb3ca27a82655915b912e5dea6d6086
   }
}
