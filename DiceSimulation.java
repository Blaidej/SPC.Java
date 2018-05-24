import java.util.Random;   // Needed for the Random class

/**
   This class simulates rolling a pair of dice 10,000 times
   and counts the number of times doubles of are rolled for
   each different pair of doubles.
*/

public class DiceSimulation
{
   public static void main(String[] args)
   {
        final int NUMBER = 10000;  // Number of dice rolls

        // A random number generator used in
        // simulating the rolling of dice
        Random generator = new Random();

        int die1Value;       // Value of the first die
        int die2Value;       // Value of the second die
        int count = 0;       // Total number of dice rolls
        int snakeEyes = 0;   // Number of snake eyes rolls
        int twos = 0;        // Number of double two rolls
        int threes = 0;      // Number of double three rolls
        int fours = 0;       // Number of double four rolls
        int fives = 0;       // Number of double five rolls
        int sixes = 0;       // Number of double six rolls

        // TASK #1 Enter your code for the algorithm here
		
		//While loop header
        System.out.println("@@@@@@@@@ while loop @@@@@@@@@@");
		
		//boolean condition for this running as long count is less than NUMBER.
		while (count < NUMBER) 
		{
			//randomly rolls "dice" for die 1&2
			die1Value = generator.nextInt(6) + 1;
			die2Value = generator.nextInt(6) + 1;
			/*
				These if else statements observe if die 1&2 both are the same
				value for every value that a dice can roll and counts its as
				many times as you set NUMBER to.
			*/
			if ((die1Value == 1) & (die2Value == 1))
			{
				snakeEyes += 1;
			}
			else if ((die1Value == 2) & (die2Value == 2))
			{
				twos += 1;
			}
			else if ((die1Value == 3) & (die2Value == 3))
			{
				threes += 1;
			}
			else if ((die1Value == 4) & (die2Value == 4))
			{
				fours += 1;
			}
			else if ((die1Value == 5) & (die2Value == 5))
			{
				fives += 1;
			}
			else if ((die1Value == 6) & (die2Value == 6))
			{
				sixes += 1;
			} 
			else 
			{
				
			}
			++ count; //iterates the count for each cycle of the loop
		}
		//Prints out resulting count of each double die for the "while loop"
		System.out.println ("You rolled snake eyes " +
                          snakeEyes + " out of " +
                          count + " rolls.");
        System.out.println ("You rolled double twos " +
                          twos + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double threes " +
                          threes + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double fours " +
                          fours + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double fives " +
                          fives + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double sixes " +
                          sixes + " out of " + count +
                          " rolls.");
						  
		//Do-While loop header				  
		System.out.println("@@@@@@@@@ do-while loop @@@@@@@@@@");
		
		//Need to re-initialize the numbers, for the next loop.
		count = 0;       
        snakeEyes = 0;  
        twos = 0;        
        threes = 0;      
        fours = 0;      
        fives = 0;      
        sixes = 0;  
		do
		{
			//randomly rolls "dice" for die 1&2
			die1Value = generator.nextInt(6) + 1;
			die2Value = generator.nextInt(6) + 1;
			
			/*
				These if else statements observe if die 1&2 both are the same
				value for every value that a dice can roll and counts its as
				many times as you set NUMBER to.
			*/
			
			if ((die1Value == 1) & (die2Value == 1))
			{
				snakeEyes += 1;
			}
			else if ((die1Value == 2) & (die2Value == 2))
			{
				twos += 1;
			}
			else if ((die1Value == 3) & (die2Value == 3))
			{
				threes += 1;
			}
			else if ((die1Value == 4) & (die2Value == 4))
			{
				fours += 1;
			}
			else if ((die1Value == 5) & (die2Value == 5))
			{
				fives += 1;
			}
			else if ((die1Value == 6) & (die2Value == 6))
			{
				sixes += 1;
			} 
			else 
			{
				
			}
			count ++;
		} while (count < NUMBER);
			
		//Prints out resulting count of each double die for the "do-while loop"
        System.out.println ("You rolled snake eyes " +
                          snakeEyes + " out of " +
                          count + " rolls.");
        System.out.println ("You rolled double twos " +
                          twos + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double threes " +
                          threes + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double fours " +
                          fours + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double fives " +
                          fives + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double sixes " +
                          sixes + " out of " + count +
                          " rolls.");
		//Need to re-initialize the numbers, for the next loop.				  
		count = 0;       
        snakeEyes = 0;  
        twos = 0;        
        threes = 0;      
        fours = 0;      
        fives = 0;      
        sixes = 0;
		//for loop header
		System.out.println("@@@@@@@@@ for loop @@@@@@@@@@");
		for (; count < NUMBER; ++ count)
		{	
			//randomly rolls "dice" for die 1&2
			die1Value = generator.nextInt(6) + 1;
			die2Value = generator.nextInt(6) + 1;
			
			/*
				These if else statements observe if die 1&2 both are the same
				value for every value that a dice can roll and counts its as
				many times as you set NUMBER to.
			*/
	
			if ((die1Value == 1) & (die2Value == 1))
			{
				snakeEyes += 1;
			}
			else if ((die1Value == 2) & (die2Value == 2))
			{
				twos += 1;
			}
			else if ((die1Value == 3) & (die2Value == 3))
			{
				threes += 1;
			}
			else if ((die1Value == 4) & (die2Value == 4))
			{
				fours += 1;
			}
			else if ((die1Value == 5) & (die2Value == 5))
			{
				fives += 1;
			}
			else if ((die1Value == 6) & (die2Value == 6))
			{
				sixes += 1;
			} 
			else 
			{
				
			}
		}
		
		//Prints out resulting count of each double die for the "for loop"
        System.out.println ("You rolled snake eyes " +
                          snakeEyes + " out of " +
                          count + " rolls.");
        System.out.println ("You rolled double twos " +
                          twos + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double threes " +
                          threes + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double fours " +
                          fours + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double fives " +
                          fives + " out of " + count +
                          " rolls.");
        System.out.println ("You rolled double sixes " +
                          sixes + " out of " + count +
                          " rolls.");
						  
	
   }
}