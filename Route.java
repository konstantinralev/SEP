
public class Route
{
   private String placeOfDeparture;
   private String placeOfArrival;
   
   /**
    * sets the placeOfArrival and the placeOfDeparture of each route
    * @param placeOfArrival
    * @param placeOfDeparture
    */
   public Route(String placeOfArrival,String placeOfDeparture){
      this.placeOfArrival = placeOfArrival;
      this.placeOfDeparture = placeOfDeparture;
   }
   
   
   /**
    * @param placeofDeparture
    */
   public void setPlaceOfDeparture(String placeofDeparture){
      this.placeOfDeparture = placeofDeparture;
   }
   
   /**
    * @return placeOfDeparture
    */
   public String getPlaceOfDeparture(){
      return placeOfDeparture;
   }
   
   
   /**
    * @param placeofArrival
    */
   public void setPlaceOfArrival(String placeofArrival){
      this.placeOfArrival = placeofArrival;
   }
   
   /**
    * @return placeOfArrival
    */
   public String getPlaceOfArrival(){
      return placeOfArrival;
   }
   
   
   /**
    * @return information about each route
    */
   public String toString(){
      return "From: " + placeOfDeparture + "\nTo: " + placeOfArrival;
   }
}
