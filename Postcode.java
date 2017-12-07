package postcode;

public class Postcode {
	
  public static String regex = "[1-9][0-9]{3}[A-Z]{2}";
  
  /**
  * Herstelt zo mogelijk een postcode
  * @param postcode de postcode
  * @return de correcte of correct gemaakte postcode,
  * null indien de postcode niet gecorrigeerd kan worden
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
