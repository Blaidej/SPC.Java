/**
   Test Class for Cruise ship testing the different methods of a Cruise ship.
*/
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCaseCruise
{	
	int passengers;//passenger field
	
	//making a CruiseShip ship object
    CruiseShip cruShip = new CruiseShip("Disney Magic", "1998", 2400);
    
	//testing the get Passengers method
    @Test
	public void testPassengers() {
		passengers = 2400;
		assertEquals(passengers, cruShip.getPassengers());
    }
    //testing the toString CruiseShip method
    @Test
	public void testToString() {
		passengers = 2400;
		
		assertEquals("Name: " + cruShip.getName() + "\nMaximum passengers: " +
                      passengers, cruShip.toString());
    }
   
}
