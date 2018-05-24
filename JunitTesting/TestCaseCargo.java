/**
   Test Class for Cargo ship testing the different methods of a Cargo ship.
*/
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCaseCargo
{	
	int tonnage;//tonnage field
  
	//making a CargoShip ship object
    CargoShip cShip = new CargoShip("Black Pearl", "1800", 50000);
    
	//testing the get Tonnage method
    @Test
	public void testTonnage() {
		
	    tonnage = 50000;
        assertEquals(tonnage, cShip.getTonnage());
    }
	//testing the toString CargoShip method
    @Test
	public void testToString() {
		
		tonnage = 50000;
		assertEquals("Name: " + cShip.getName() + "\nCargo capacity: " +
             tonnage + " tons", cShip.toString());
    }
   
}

