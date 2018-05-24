/**
   Test Class for a ship testing the different methods of a ship.
*/
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCaseShip
{	
	String name;//name field
	String yearBuilt;//yearBuilt field
	
	//making a ship object
    Ship ship = new Ship("Lolipop", "1960");
    
	// testing the get name ship method	
    @Test
	public void testName() {
	  name = "Lolipop";
      assertEquals(name, ship.getName());
   }
   //testing the get yearBuilt ship method
   @Test
	public void testYearBuilt() {
	  yearBuilt = "1960";
      assertEquals(yearBuilt, ship.getYearBuilt());
   }
   //testing the toString ship method
   @Test
	public void testToString() {
		name = "Lolipop";
		yearBuilt = "1960";
		assertEquals("Name: " + name + "\nYear built: " + 
					yearBuilt, ship.toString());
   }
   
}