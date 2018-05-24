import java.util.Scanner;
import java.util.Random;   // Needed for the Random class

/**
   This class simulates rolling a pair of dice.
*/

public class RollDice
{
   public static void main(String[] args)
   {
     String again = "y";
	 int die1;
	 int die2;
	 
	 Scanner keyboard = new Scanner(System.in);
	 
	 Random rand = new Random();
	 
	 while (again.equalsIgnoreCase("y"));
	 {
		 System.out.println("Rolling the dice....");
		 die1 = rand.nextInt(6) + 1;
		 die2 = rand.nextInt(6) + 1;
		 System.out.println("Their values are:");
		 System.out.println(die1 +" " + die2);
		 
		 
		 System.out.print("Roll them again (y = yes)? ");
		 again = keyboard.nextLine();
		 
	 }
   }
}