/**
   This program is connected with the SocSecProcessor file and catches the 
   exception thrown if the user puts in some of the information wrong when
   entering their social security number. It will also explain
   the specific error the user made.
*/

public class SocSecException extends Exception
{
	
   public SocSecException(String error)
   {
	    //This prints the appropiate statement thrown by the SocSecProcessor.
		super("Invalid social Security Number" + error);
	   
   }
   
}