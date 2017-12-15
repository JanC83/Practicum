package practicum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
* Schrijft regels met correcte of correct gemaakte
* postcodes uit bronbestand naar doelbestand.
* @param bronbestand het bronbestand
* @param doelbestand het doelbestand
* @throws Prik2GoException bij IOException
*/
public class Bezoekinfo {
	  public static void schoonPostcodesOp(String bronbestand, String doelbestand) throws Prik2GoException {
	   BufferedReader lezer = null;
	   PrintWriter schrijver = null;
	   try{
	    lezer = new BufferedReader(new FileReader(bronbestand));
	    schrijver = new PrintWriter(new BufferedWriter(new FileWriter(doelbestand)));
	    schrijver.println("Bezoeknr,Datum,Vestiging,Klant,Postcode,Land,Infectie,Vaccinatiedatum");
	    String regel = lezer.readLine();
	    while (regel != null){
	    String[] ar = regel.split(",");
	    if (Postcode.herstelPostcode(ar[4]) != null){
	    	String nieuweRegel = ar[0];
	    	ar[4] = Postcode.herstelPostcode(ar[4]);
	    	int i;
	    	for(i = 1; i < 8; i++){
	    		nieuweRegel = nieuweRegel + "," + ar[i];		
	    	}
	    	System.out.println(nieuweRegel);
	    	schrijver.println(nieuweRegel);
	    }
	    regel = lezer.readLine();
	    }
	   }
	   catch (IOException e){
	    throw new Prik2GoException ("Fout bij het opschonen");
	    }
	   finally{
		   if (schrijver !=null){
			    schrijver.close();
		   }
		   if (lezer !=null){
			   try{
			    lezer.close();
		       }
			   catch (IOException e){
				   System.out.println("Fout bij het sluiten van lezer");
			   }
	   }
	 }
	}
}
