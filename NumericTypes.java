// TASK #2(Alternate)
import javax.swing.JOptionPane;
// Add an import statement for the JOptionPane class
import java.util.Scanner;
// TASK #2 Add an import statement for the Scanner class
/**
   This program demonstrates how numeric types and
   operators behave in Java.
*/

public class NumericTypes
{
   public static void main (String [] args)
   {
      // TASK #2 Create a Scanner object here 
	  Scanner keyboard = new Scanner(System.in);
      // (not used for alternate)

      // Identifier declarations
      final int NUMBER = 2 ;        // Number of scores
      final float SCORE1 = 100;       // First test score
      final float SCORE2 = 95;        // Second test score
      final float BOILING_IN_F = 212; // Boiling temperature
      float fToC;                     // Temperature Celsius
      double average;              // Arithmetic average
	  // TASK #2 declare variables used here
	  String firstName;				//Holder for firstname
	  String lastName;				// Holder for Lastname
	  String fullName;				//Holder for fullname
      String output;                // Line of output
	  // TASK #3 declare variables used here
	  char firstInitial;			//Holds the char for firstInitial
	  int stringSize;				//Holds the value for counting of length
	  // TASK #4 declare variables used here
	  double diameter;				//Holds the value for diameter of a sphere
	  double radius;				//Holds the value for radius of a sphere
	  double volume;				//Holds the value for volume of a sphere

      // Find an arithmetic average.
      average = (SCORE1 + SCORE2) / NUMBER; //calculates average
      output = SCORE1 + " and " + SCORE2 +   
               " have an average of " + average; //builds print statement
      System.out.println(output); //prints the output

      fToC = ((BOILING_IN_F - 32)*5)/9;
	  // Convert Fahrenheit temperature to Celsius.
      output = BOILING_IN_F + " in Fahrenheit is " +
               fToC + " in Celsius."; //builds the print statement
      System.out.println(output); //prints the output statement
      System.out.println();      // To leave a blank line

      // ADD LINES FOR TASK #2 HERE
      firstName = JOptionPane.showInputDialog("Your First Name:  ");
	  // Prompts the user for their first name
      lastName = JOptionPane.showInputDialog("Your Last Name:  ");
	  // Prompt the user for last name
	  fullName = firstName+" "+lastName;
	  // Concatenate the user's first and last names
	  JOptionPane.showMessageDialog(null, " Your fullName is: " + fullName);
	  // Print out the user's full name
      //System.out.println();      // To leave a blank line

      // ADD LINES FOR TASK #3 HERE
	  firstInitial = firstName.charAt(0);
	  // Get the first character from the user's first name
	  System.out.println(firstInitial);
	  // Prints out the user's first initial
	  fullName = fullName.toUpperCase();
	  // Convert the user's full name to uppercase
	  System.out.println(fullName);
	  // Prints out the user's full name in uppercase
	  stringSize = fullName.length();
	  // Counts the length of your full name including spaces
	  System.out.println(stringSize);
	  // Prints the result of the length of your fullName
      System.out.println();      // To leave a blank line

      // ADD LINES FOR TASK #4 HERE
	  System.out.print("Enter the diameter of a sphere:  ");
	  // Prompt the user for a diameter of a sphere
      diameter = keyboard.nextDouble();// Read the entered diameter
	  radius = (diameter / 2); // Calculate the radius
	  volume = (4.0 / 3) * Math.PI * Math.pow(radius, 3); 
	  // Calculate the volume
	  System.out.print("The volume of the sphere is: " + " ");
	  System.out.println(volume);
      // Print out the volume
   }
}