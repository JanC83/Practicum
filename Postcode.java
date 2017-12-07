package postcode;

public class Postcode {
	
  public static String regex = "[1-9][0-9]{3}[A-Z]{2}";
  
  /**
  * Repairs postal code (Netherlands) as much as possible
  * @param postcode the postal code
  * @return the correct or repaired postal code,
  * null if the postal code cannot be repaired
  */
  public static String herstelPostcode(String postcode){
	  if (postcode == null){
		  return null;
	  }
	  if (postcode.matches(regex)){
		  return postcode;
	  }
	  String postcodeCorr = postcode.toUpperCase();
	  postcodeCorr = postcodeCorr.replaceAll("\\s","");
	  if (postcodeCorr.matches(regex)){
		  return postcodeCorr;
	  }
	  else {
		  return null;
	  }
  }
  
 

}
