import java.util.Scanner;

/**
	This program takes and makes a conversion of one measurement to another
*/


public class ConversionProgram
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner (System.in);
		
		
		int choice = 1;
		double meters;
		
		
		
		System.out.print("Enter a distance in meters: ");
		meters = keyboard.nextInt();
		
		System.out.println("Enter your choice");
		menu();
		choice = keyboard.nextInt();
		// This loop controls what method you go to
		while ((choice <= 4) & (choice > 0))
		{
			
			if (choice == 1)
			{
				showKilometers(meters);
			}
			else if (choice == 2)
			{
				showInches(meters);	
			}
			else if (choice == 3)
			{
				showFeet(meters);
			}
			System.out.println("");
			System.out.println("Enter your choice");
			menu();
			choice = keyboard.nextInt();
			
		}
		//This will display the menu unless the choice is 4
		menu();
			
		if (choice == 4)
		{
			System.out.println("Bye");
		}
		else
		{
				System.out.println("Error, you made an invalid choice");
		}
	}
	/**
	
	@param menu method displays a menu for the user to select what converion
			to display.
	
	*/
	public static void menu ()
	{	
		System.out.println("1.Convert to kilometers");
		System.out.println("2.Convert to inches");
		System.out.println("3.Convert to feet");
		System.out.println("4.Quit the program");	
	
	}	
	/**
	
	@param showKilometers performs the calculation on meters into kilometers.
	
	*/		
	public static void showKilometers (double meters)
	{	
		double result;
		result = meters * 0.001;
		System.out.println(meters + " meters is " + result + "kilometers.");
	}
	/**
	
	@param showInches performs the calculation on meters into inches.
	
	*/
	public static void showInches (double meters)
	{
		double result;
		result = meters * 39.37;
		System.out.println(meters + " meters is " + result + "inches.");
	}
	/**
	
	@param showFeet performs the calculation on meters into feet.
	
	*/
	public static void showFeet (double meters)
	{
		double result;
		result = meters * 3.281;
		System.out.println(meters + " meters is " + result + "feet.");
	}
			
			
}


