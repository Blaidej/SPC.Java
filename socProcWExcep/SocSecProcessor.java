import java.util.Scanner;
/**
   This program 
*/


public class SocSecProcessor
{
   public static void main(String[] args)throws Exception
   {
	   
	    String ssn;
	    String name;
		String input;  // To hold a line of input
        char choice;   // To hold a single character
		
		
		Scanner keyboard = new Scanner(System.in);
		
	do
	{	
		try
		{
			
			do
			{ 
				
				System.out.print("Name? ");
				name = keyboard.nextLine();
				System.out.print("SSN? ");
				isValid(ssn = keyboard.nextLine());
				System.out.print("Continue? ");
				input = keyboard.nextLine();
				choice = input.charAt(0);
				 
			} while (Character.toUpperCase(choice) == 'Y');
		}
		catch(SocSecException e)
		{
			
		//System.out.println("ERROR");
		System.out.println(e.getMessage());
		
		}
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
      String is a valid customer number. If so, it
      returns true.
      @param custNumber The String to test.
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
	  
	  
	  
	  
	  
	  
	  
