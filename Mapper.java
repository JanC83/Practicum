package practicum;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {
	
	Connection con;
	private PreparedStatement pinsertklant = null;
	private PreparedStatement pinsertbezoek = null;
	private PreparedStatement pinsertlandbezoek = null;
	private PreparedStatement pinsertvaccinatie = null;
	
	private PreparedStatement pselectklant = null;
	
	
	public Mapper() throws Prik2GoException{
		maakVerbinding();
		initialiseerPrepStatements();
	}
	
	public void sluitVerbinding(){
		if(con != null){
			try {
				con.close();
			}
			catch (SQLException e){}
		}
	}
	
	public void insertKlant(int nr, String postcode) throws Prik2GoException{
		try{
          pinsertklant.setInt(1, nr);
          pinsertklant.setString(2, postcode);
          pinsertklant.executeUpdate();
	}
		catch (SQLException e){
			throw new Prik2GoException ("Fout bij schrijven.");
		}
	}
	
	public boolean bevatKlant(int nr) throws Prik2GoException{
		ResultSet res = null;
		Boolean b = false;
		try{
			pselectklant.setInt(1, nr);
			res = pselectklant.executeQuery();
			int i = 0;
			while (res.next()){
				i++;
			}
			if (i>0){
				b = true;
			}
			return b;		
		}
		catch (SQLException e){
				throw new Prik2GoException("Fout bij het lezen.");
			}
		}
	
	private void maakVerbinding() throws Prik2GoException{
		try {
			DriverManager.setLogWriter(new PrintWriter(System.out));
			Class.forName(DBConst.DRIVERNAAM);
			con = DriverManager.getConnection(DBConst.URL, DBConst.GEBRUIKERSNAAM, DBConst.WACHTWOORD);
		 
		}
		catch (ClassNotFoundException e){
			throw new Prik2GoException ("Driver niet geladen.");
		}
		catch (SQLException e){
			throw new Prik2GoException ("Verbinding maken is mislukt.");
		}	
	}
	
	private void initialiseerPrepStatements() throws Prik2GoException{
		try {
			pinsertklant = con.prepareStatement("INSERT INTO Klant VALUES (?, ?)");
			pselectklant = con.prepareStatement("SELECT nr FROM Klant WHERE nr = ? ");
	}
		catch (SQLException e){}
}
}
