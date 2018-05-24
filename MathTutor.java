// An import statement for the Scanner class
import java.util.Scanner;
import java.util.Random;
/**
   pg 250 This prgram demonstrates the Random class.
*/

public class MathTutor
{
   public static void main (String [] args)
   {
	   int number1;
	   int number2;
	   int sum;
	   int userAnswer = -1;
	   
	   Scanner keyboard = new Scanner(System.in);
	   
	   //Creat a Random class object.
	   Random randomNumbers = new Random();
	   
	   while (userAnswer != 0)
	   {
		    //Get two random numbers.
		    number1 = randomNumbers.nextInt(100)+1;
		    number2 = randomNumbers.nextInt(100)+1;
	   
	   
		   //Display an addition problem.
			System.out.println("What is the answer to the " +
								"following problem?");
			System.out.print(number1 + " + " +
							 number2 + " = ? ");
							 
			//Calculate the answer
			sum  = (number1) + (number2);
			
			//Get the user's answer.
			userAnswer = keyboard.nextInt();
			
			//Display the user's results.
			if (userAnswer == sum)
				System.out.println("Correct!");
			else
			{
				System.out.println("Sorry, wrong answer. " +
									"The correct answer is  " +
									sum);
			}
	   }
   }

}