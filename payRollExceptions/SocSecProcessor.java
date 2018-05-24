import java.util.Scanner;//importing scanner for keyboard input
/**
   This program takes a user's name and their social sercurity number. 
   It throws an exception corresponding to the why they entered their social 
   sercurity number wrong. 
*/


public class SocSecProcessor
{
   public static void main(String[] args)throws Exception
   {
	   
	    String ssn; //hold the user's social sercurity number
	    String name; //holds the user's name.
		String input; // To hold a line of input
        char choice; // To hold a single character
		boolean isValid = true; //sets isValid to true if input is valid.
		//scanner for keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		
	//This outer do while loop keeps prompting the user if they would 
	//like to continue entering in names and social sercurity numbers.
	//even if it throws an exception because of invalid input.
	do  
	{	
		//this trys the user's input, and if entered wrong, the catch
		// throwws the exception calling the appriopiate message.
		try 
		{
			//This inner do while loop keeps prompting the user if they would 
			//like to continue entering in names and social sercurity numbers.
			do
			{ 
				
				System.out.print("Name? ");
				name = keyboard.nextLine();
				System.out.print("SSN? ");
				isValid(ssn = keyboard.nextLine());
				if (isValid == true)
					System.out.println(name + " " + ssn + " is valid.");
				System.out.print("Continue? ");
				input = keyboard.nextLine();
				choice = input.charAt(0);
				 
			} while (Character.toUpperCase(choice) == 'Y');
		}
		
		catch(SocSecException e)
		{
			
			System.out.println(e.getMessage());
		
		}
		
		//finally makes sure the program continues to run, working with the 
		//do while loop do get the user's Yes to run, or any key to exit.
		finally
		{
			System.out.print("Continue? ");
			input = keyboard.nextLine();
			choice = input.charAt(0);
				 
		}
	}while (Character.toUpperCase(choice) == 'Y');	

		
		
   }
	/**
      The isValid method determines whether a
      String is a valid social sercurity number. If so, it
      returns true. If not true it throws an error with the appriopiate
	  message corresponding to the input error.
      @param ssn the Social Sercurity Number to test.
      @return true if valid, otherwise false.
   */
   
   public static boolean isValid(String ssn)throws SocSecException
   {
        boolean isValid = true;  	// Flag
        int i = 0;                 // Control variable

        // Test the length.
		if (ssn.length() == 11)
		{
			isValid = true;
		}
		else 
		{
			throw new SocSecException(", wrong number of characters");
		}
		
        // Test the first three characters for digits.
        while (isValid && i < 3)
        {
            if (Character.isDigit(ssn.charAt(i)))
			{
				isValid = true;
				i++;
			}
        
			else 
			{
				throw new SocSecException(", contains a "
				+ "character that is not a digit");
			}
		}
		
		i = 4;//to skip over the dash
        // Test the middle characters for digits.
        while (isValid && i < 6)
        {
            if (Character.isDigit(ssn.charAt(i)))
			{
				isValid = true;
				i++;
			}
			else 
			{
				throw new SocSecException(", contains a "
				+ "character that is not a digit");
			}
		}
		
		i = 7;//to skip over the dash
		// Test the middle characters for digits.
        while (isValid && i < 11)
        {
            if (Character.isDigit(ssn.charAt(i)))
			{
				isValid = true;
				i++;
			}
			else 
			{
				throw new SocSecException(", contains a "
				+ "character that is not a digit");
			}
		}
		// Test if the dashes are in the correct positions.
		if (ssn.charAt(3) == '-' && ssn.charAt(6) == '-')
		{
            isValid = true;
		}
		else 
		{
            throw new SocSecException(", dashes at wrong positions");
		}

        return isValid;
   }
		}
	}
	}
}	
	  
	  
	  
	  
	  
	  
	  
