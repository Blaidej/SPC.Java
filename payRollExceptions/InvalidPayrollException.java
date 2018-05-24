/**
   Prgrammming Challenge 5 of Chaper 6 requireed you to write a Payroll class 
   that calculates an employee's payroll. Write exception classes for the 
   following error conditions:
   #An empty string is given for the employee's name.
   # An invalid is given for the employee's ID number. if you implemented this 
   field as a string, then an empty string would be invalid. If you implemented 
   this field as a numeric variable, then a negative number or zero would be invalid.
   #An invalid number is given for the number of hours worked. This would be a 
   negative number or a number greater than 84.
   #An invalid number is given for the hourly pay rate. This would be a negative 
   number greater than 25
    
	Modify the Payroll class so that it throws the appropiate exception when any
	of these errors occurs. Demonstrate the exception classes in a program.
   
*/

public class InvalidPayrollException extends Exception
{
	
   public InvalidPayrollException(String error)
   {
	    //This prints the appropiate statement thrown by 
		super("You made an error" + error);
	   
   }
   
}
