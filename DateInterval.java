import java.util.Date;

public class DateInterval
{
   private Date departureDate;
   private Date arrivalDate;
   
   
   /**
    * sets the departure date and the arrival date of the date interval
    * @param departureDate
    * @param arrivalDate
    */
   public DateInterval(Date departureDate, Date arrivalDate){
      this.departureDate = departureDate;
      this.arrivalDate = arrivalDate;
   }
   

   /**
    * @param departureDate to set the departureDate
    */
   public void setDepartureDate(Date departureDate)
   {
      this.departureDate = departureDate;
   }

   
   /**
    * @return the departureDate
    */
   public Date getDepartureDate()
   {
	   return departureDate;
   }

   
   /**
    * @param arrivalDate to set the arrivalDate
    */
   public void setArrivalDate(Date arrivalDate)
   {
      this.arrivalDate = arrivalDate;
   }
   

   /**
    * @return the arrivalDate
    */
   public Date getArrivalDate()
   {
	   return arrivalDate;
   }
   
   
   /**
    * 
    * @param other date
    * @return if two dates are overlapping
    */
   public boolean checkOverlap(DateInterval other){
      return (this.departureDate.before(other.arrivalDate)&&this.arrivalDate.after(other.departureDate));
   }
   
   
   /**
    * @return the duration of a service in days
    */
   public int durationOfService(){
	   int duration = (int)((arrivalDate.getTime() - departureDate.getTime()) 
               / (1000 * 60 * 60 * 24));
	   return duration;
   }
   
   
   /**
    * @return a string with the departure and arrival date
    */
   public String toString(){
	   return "Departure date: " + departureDate + "\nArrival date: " + arrivalDate;
   }
}