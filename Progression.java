import java.util.Scanner;

/**
   This program calculates the geometric and
   harmonic progression for a number entered
   by the user.
*/

public class Progression
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner (System.in);

      System.out.println("This program will calculate " +
                         "the geometric and harmonic " +
                         "progression for the number " +
                         "you enter.");
                         
      System.out.print("Enter an integer that is " +
                       "greater than or equal to 1: ");
                       
      int input = keyboard.nextInt();

      // Match the method calls with the methods you write
      int geomAnswer = geometricRecursive(input);
      double harmAnswer = harmonicRecursive(input);

      System.out.println("Using recursion:");
      
      System.out.println("The geometric progression of " +
                         input + " is " + geomAnswer);
                         
      System.out.println("The harmonic progression of " +
                         input + " is " + harmAnswer);

      // Match the method calls with the methods you write
      geomAnswer = geometricIterative(input);
      harmAnswer = harmonicIterative(input);

      System.out.println("Using iteration:");
      System.out.println("The geometric progression of " +
                         input + " is " + geomAnswer);
                         
      System.out.println("The harmonic progression of " +
                         input + " is " + harmAnswer);
   }

   // ADD LINES FOR TASK #2 HERE
   /**
		The geom
	*/
   // Write the geometricRecursive method
    public static int geometricRecursive(int input)
   {
	    
		int temp;
	    
        if (input == 0)
        {
           return 1;
        }
        else
        {
            temp = geometricRecursive(input-1);
		    
		    return (temp * input);
        }
		
   }
   
   /**
		
	*/
   // Write the geometricIterative method
    public static int geometricIterative(int input)
   {
	    int answer = 0;
		int j = 1;
		for (int i = 2; i <= input; i++)
		{
			answer = (j * i);
			j = answer;
			
		}
		return answer;
   }
   
   /**
		
	*/
   // Write the harmonicRecursive method
   public static double harmonicRecursive(double input)
   {
	    
	   double temp;
	    
        if (input == 0)
        {
           return 1;
        }
        else
        {
            temp = harmonicRecursive(input-1.0);
		    
		    return (temp * (1/input));
        }
   } 
   /**
		
	*/
   // Write the harmonicIterative method
   public static double harmonicIterative(int input)
   {
	    double answer = 0;
		double j = 1;
		for (double i = 2; i <= input; i++)
		{
			
			answer = (j * (1/i));
			j = answer;
			
			
		}
		return answer;
   }
}