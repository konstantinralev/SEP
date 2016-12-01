
public class Route
{
   private String placeOfDeparture;
   private String placeOfArrival;
   
   public Route(String placeOfArrival,String placeOfDeparture){
      this.placeOfArrival = placeOfArrival;
      this.placeOfDeparture = placeOfDeparture;
   }
   
   public void setPlaceOfArrival(String placeofArrival){
      this.placeOfArrival = placeofArrival;
   }
   
   public void setPlaceOfDeparture(String placeofDeparture){
      this.placeOfDeparture = placeofDeparture;
   }
   
   public String getPlaceOfArrival(){
      return placeOfArrival;
   }
   
   public String getPlaceOfDeparture(){
      return placeOfDeparture;
   }
   
   public String toString(){
      return "From: " + placeOfDeparture + "\nTo: " + placeOfArrival;
   }
}
