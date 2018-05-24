	import java.util.Scanner;

/**
   This program demonstrates a solution to the
   Payroll Class programming challenge.
   
*/

public class PayrollDemo
{
   public static void main(String[] args)
   {
      // Variables for input
      String name;         // An employee's name
      String id;              // An employee's ID number
      double payRate;      // An employee's pay rate
      double hoursWorked;  // The number of hours worked
      boolean isValid = true;  	// Flag
	  
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
		
        try
		{
			do{
				
				// Get the employee's name.
				System.out.print("Enter the employee's name: ");
				name = keyboard.nextLine();
				checkIfEmpty(name);
				// Get the employee's ID number
				System.out.print("Enter the employee's ID number: ");
				id = keyboard.nextLine();
				checkID(id);
				// Get the employee's pay rate.
				System.out.print("Enter the employee's hourly pay rate: ");
				payRate = keyboard.nextDouble();
				checkPay(payRate);
				// Get the number of hours worked by the employee.
				System.out.print("Enter the number of hours worked " +
						   " by the employee: ");
				hoursWorked = keyboard.nextDouble();
				checkHours(hoursWorked);
				
				  // Create a Payroll object and store the data in it.
				Payroll worker = new Payroll(name, id);
	  
				worker.setPayRate(payRate);
				worker.setHoursWorked(hoursWorked);
	  
      
				// Display the employee's payroll data.
				System.out.println("\nEmployee Payroll Data");
				  
				System.out.println("Name: " + worker.getName());
				System.out.println("ID Number: " + worker.getIdNumber());
				System.out.println("Hourly pay rate: " + worker.getPayRate());
				System.out.println("Hours worked: " + worker.getHoursWorked());
				System.out.println("Gross pay: $" + worker.getGrossPay());
			}while(isValid == true);
	  
		}catch(InvalidPayrollException e)
		{
			System.out.println(e.getMessage());
		}
      
    }
	/**
      The checkIfEmpty class makes sure the user didn't just use spaces for 
	  their name or if they left it empty
      @param name the name the user enters for payroll
	  @return isValid returns and breaks the loop if the user doesn't provide 
	  the correct input.
	  @exception InvalidPayrollException when the user doesn't enter anything or
	  inputs spaces.
   */
	
	public static boolean checkIfEmpty(String name)throws InvalidPayrollException
    {
		boolean isValid = true; // Flag
		
		
	    if(name == null || name.isEmpty())
	   {
		   isValid = false;
		   throw new InvalidPayrollException(", you entered an empty string.");
		   
	   }
	   else
	   {
		   isValid = true;
	   }
	   return isValid;
	}
	/**
      The checkID class makes sure the id is not left empty or filled with empty
	  spaces.
      @param id is the user's id number stored as a string
	  @return isValid returns and breaks the loop if the user doesn't provide 
	  the correct input.
	  @exception InvalidPayrollException when the id is left empty or with 
	  blank spaces
   */
	
	public static boolean checkID(String id)throws InvalidPayrollException
    {
		boolean isValid = true; // Flag
		
		
	   if(id == null || id.isEmpty())
	   {
		   isValid = false;
		   throw new InvalidPayrollException(", you entered your ID wrong.");
		   
	   }
	   else
	   {
		   isValid = true;
	   }
	   return isValid;
	}
	/**
      The checkPay class checks if the user put too little or to much money
	  for pay rate.
      @param payRate the pay rate the user enters
	  @return isValid returns and breaks the loop if the user doesn't provide 
	  the correct input.
	  @exception InvalidPayrollException when the payRate is more than 0 and 
	  less than 25
   */
	
	 public static boolean checkPay(double payRate)throws InvalidPayrollException
    {
		boolean isValid = true; // Flag
		
	   if ((payRate < 0) || (payRate > 25))
	   {
		   isValid = false;
		   throw new 
		   InvalidPayrollException(", you entered your pay rate wrong.");
		   
	   }
	   else
	   {
		   isValid = true;
	   }
	   return isValid;
	} 
	/**
      The checkHours class checks to see if the hours entered is more than
	  0 and less than 84.
      @param hours the hours the employ enters
	  @return isValid returns and breaks the loop if the user doesn't provide 
	  the correct input.
	  @exception InvalidPayrollException when the hours is more than 0 and 
	  less than 84.
   */
	
	public static boolean checkHours(double hours)throws InvalidPayrollException
    {
		boolean isValid = true; // Flag
		
	   if ((hours < 0) || (hours > 84))
	   {
		   isValid = false;
		   throw new InvalidPayrollException(", you entered your ID wrong.");
		   
	   }
	   else
	   {
		   isValid = true;
	   }
	   return isValid;
	}  
	   
}
	

