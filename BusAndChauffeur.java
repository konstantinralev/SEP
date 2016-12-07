import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class BusAndChauffeur extends Service
{ 
	private String[] extraServices;
	
	/**
	 * 
	 * @param placeOfDeparture
	 * @param placeOfArrival
	 * @param departureDate
	 * @param arrivalDate
	 * the constructor sets the super class' fields and initializes an arrayList of strings which represent 
	 * the extra services that the customer has asked for
	 */
	public BusAndChauffeur(String placeOfDeparture, String placeOfArrival, Date departureDate, Date arrivalDate) {
		super(placeOfDeparture, placeOfArrival, departureDate, arrivalDate);
	} 
	
	public void setExtraServices(String extraServices){
		String[] str = extraServices.split(";");
	}
	
	public String[] getExtraServices(){
		return extraServices;
	}
	
	@Override
	public String toString(){
		return super.toString() + "\nExtra services: " + extraServices.toString(); 
	}
}
