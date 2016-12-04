import java.util.Date;

public class DateInterval
{
   private Date departureDate;
   private Date arrivalDate;
   
   public DateInterval(Date departureDate, Date arrivalDate){
      this.departureDate = departureDate;
      this.arrivalDate = arrivalDate;
   }
   
   /**
    * @return the departureDate
    */
   public Date getDepartureDate()
   {
      return departureDate;
   }

   /**
    * @param departureDate the departureDate to set
    */
   public void setDepartureDate(Date departureDate)
   {
      this.departureDate = departureDate;
   }

   /**
    * @return the arrivalDate
    */
   public Date getArrivalDate()
   {
      return arrivalDate;
   }

   /**
    * @param arrivalDate the arrivalDate to set
    */
   public void setArrivalDate(Date arrivalDate)
   {
      this.arrivalDate = arrivalDate;
   }
   
   /**
    * 
    * @param other date
    * @return if two dates are overlapping
    */
   public boolean checkOverlap(DateInterval other){
      return (this.departureDate.before(other.departureDate)&&this.arrivalDate.after(other.departureDate)) ||
            (other.departureDate.before(this.departureDate)&&other.arrivalDate.after(this.departureDate));
      }
   }

