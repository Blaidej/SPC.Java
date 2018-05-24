
/**
* The airplane class gives the blueprint of our airplane object, we give
* it the ability to hold the arrival time that it enters the queue and give it 
* a unique identifier.
* @author Blaine Jacques
*/
public class Airplane 
{
    
    private int arrivalTime;// time that airplane enters the queue
    private int airplaneNumber;//unique number assigned to airplane
	
    /**
     * Constructor for the airplane
     * @param arrivalTime This airplanes unique arrival time into the queue
     * @param airplaneNumber This airplane's unique number identifier
     */
    
    public Airplane(int arrivalTime,  int airplaneNumber) 
    {
        this.arrivalTime = arrivalTime;
        this.airplaneNumber = airplaneNumber;
    }

    /**
     * An accessor for the Arrival time 
     * @return The airplanes arrival time into the queue
     */
    public int getArrivalTime()
    {
        return arrivalTime;
    }
	
    /**
     * An accessor for the Airplane's number
     * @return The airplane's specific number identifer. Note:Landing planes 
     * and planes taking off each get their own separate number counter
     */
    public int getAirplaneNumber() 
    {
        return airplaneNumber;
    }
  
}
