
public class DateInterval
{
   private Date departureDate;
   private Date arrivalDate;

   public DateInterval(Date departureDate, Date arrivalDate){
      this.departureDate = departureDate;
      this.arrivalDate = arrivalDate;
   }

   public void setDepartureDate(Date departureDate)
   {
      this.departureDate = departureDate;
   }

   public void setArrivalDate(Date arrivalDate)
   {
      this.arrivalDate = arrivalDate;
   }

   public Date getDepartureDate()
   {
      return departureDate;
   }

   public Date getArrivalDate()
   {
      return arrivalDate;
   }
   
}
