package practicum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VulDatabase {
	private Mapper mapper = null;
	
	public VulDatabase() throws Prik2GoException{
		mapper = new Mapper();
	}
   
	
   public void Vul() throws Prik2GoException{
	   String bronbestand = "bezoekinfoOpgeschoond.csv";
	   BufferedReader lezer = null;
	   try{
		    lezer = new BufferedReader(new FileReader(bronbestand));
		    String regel = lezer.readLine();
		    regel = lezer.readLine();
		    while (regel != null){
		    String[] ar = regel.split(",");
		    int nr = Integer.parseInt(ar[3]);
		    schrijfKlant(nr, ar[4]);
		    regel = lezer.readLine();
        }
	   }
	   catch (IOException e){
		    throw new Prik2GoException ("Fout bij het opschonen");
		    }
	   
	   finally{
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

	private void schrijfKlant(int nr,String postcode) throws Prik2GoException{
		if (mapper.bevatKlant(nr) == false){
			mapper.insertKlant(nr, postcode);
		}
}
}
