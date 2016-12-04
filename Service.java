public class Service
{
   private String type;
   private String departureTime;
   private String arrivalTime;
   private Route route;
   private DateInterval arrivalDate;
   private DateInterval departureDate;
   
  /**
   * sets the route, arrivalDate and departureDate for each service.
   * @param route
   * @param departureDate
   * @param arrivalDate
   */
   public Service (Route route, DateInterval departureDate, DateInterval arrivalDate){
      this.route = route;
      this.departureDate = departureDate;
      this.arrivalDate = arrivalDate;
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
   public void setDateInterval(DateInterval departureDate, DateInterval arrivalDate){
      this.departureDate = departureDate;
      this.arrivalDate = arrivalDate;
   }
   
   
   /**
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
    */
   public void setType(String type)
   {
      this.type = type;
   }

   
   /**
    * @return type
    */
   public String getType(){
      return this.type;
   }
   
   /**
    * 
    * @param departureTime
    */
   public void setDepartureTime(String departureTime)
   {
      this.departureTime = departureTime;
   }
   
   
   /**
    * 
    * @return departureTime
    */
   public String getDepartureTime()
   {
      return departureTime;
   }

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
   
   /**
    * @return the information about each service.
    */
   public String toString(){
      return "Type of Service: " + type + "Departure Time: " + departureTime + "Arrival Time: " + arrivalTime;
   }
  
   
}
