package postcode;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPostcode {

	@Test
	public void testHerstelPostcode(){
				
		//3333AA is correct
		assertEquals("3333AA", Postcode.herstelPostcode("3333AA"));
		
		//3333 AA can be repaired
		assertEquals("3333AA", Postcode.herstelPostcode("3333 AA"));
		
		//3333 Aa can be repaired
		assertEquals("3333AA", Postcode.herstelPostcode("3333Aa"));	
		
		//3333 Aa can be repaired
		assertEquals("3333AA", Postcode.herstelPostcode("3333 Aa"));	
		
		//0333AA cannot be repaired
		assertEquals(null, Postcode.herstelPostcode("0333AA"));
		
    //333AA cannot be repaired 
		assertEquals(null, Postcode.herstelPostcode("333AA"));
		
		//33333AA cannot be repaired
		assertEquals(null, Postcode.herstelPostcode("33333AA"));
		
		//3333AAA cannot be repaired
		assertEquals(null, Postcode.herstelPostcode("3333AAA"));
		
		//null returns null
		assertEquals(null, Postcode.herstelPostcode(null));



		
	}
}
