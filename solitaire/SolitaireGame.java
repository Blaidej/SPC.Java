import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
/**
   A solitaire matching game in which you have a list of random
   integer values between 10 and 99. You remove from the list any
   pair of consecutive integers whose first or second digits match.
   If all values are removed, you win.

   @author Blaine Jacques
   @version 4.1
 */
public class SolitaireGame
{
    private static List<Integer> theNumbers;

    public static void main(String args[])
    {
        theNumbers = new ArrayList<>();
        initializeList(theNumbers);
        System.out.println("The list is originally: " + theNumbers);

        while (scanAndRemovePairs(theNumbers))
            System.out.println("The list is now: " + theNumbers);
        System.out.println("No more pairs to remove.");
    } // end main


    /** 
       Initializes the list with 40 random 2 digit numbers. 
     */
    public static void initializeList(List<Integer> theList)
    {
		Random randNum = new Random();//random number generator
		
		//creates 40 randomly generated numbers that are all 2 digits long
		for (int i = 0; i < 40; i++)
		{
			
			int num = randNum.nextInt(89)+ 10;
			theNumbers.add(num);
			
		}	
		
		
    } // end initializeList


    /** Sees whether two numbers are removable.
        @param x  The first 2 digit integer value.
        @param y  The second 2 digit integer value.
        @return  True if x and y match in the first or second digit. 
     */
    public static boolean removable(Integer x, Integer y)
    {
		/*break down the individual values into their individual digits to 
		to be able to compare pairs of digits*/
		Integer  x1 = x/10;
		Integer  x2 = x%10;
		Integer  y1 = y/10;
		Integer  y2 = y%10;
		
		if (x1 == y1 || x1 == y2 || x2 == y1 || x2 == y2)
		{
			//if any of the digits are the same, return true
			return true;
		}
		else
		{
			//if none of the digits are the same return false
			return false;
		}
		
	
		 
    } // end removable


    /** Scans over the list and removes any pairs of values that are removable.
        @param theList  The list of 2 digit integers to scan over.
        @return  True if any pair of integers was removed. 
     */
    public static boolean scanAndRemovePairs(List<Integer> theList)
    {
		int intCount = 0;//counting if there are any pairs made
		boolean morePairs = true;//return true if there are more pairs
		
		//makes a list iterator
		ListIterator<Integer> currentInt = theList.listIterator();
		
		Integer currNum;//holds the current number
		Integer nextNum;//holds the next number
		
		//while the currentInt has next and does not have a previous value
		//it initiates the beginning of the iteration
		while (currentInt.hasNext() && !currentInt.hasPrevious())
		{
			currNum = currentInt.next();

			//keeps the itateration going through the list
			while (currentInt.hasNext())
			{
				nextNum = currentInt.next();
				
				//will remove the number if any digits match by calling removable
				if (removable(currNum, nextNum))
				{
					//prints out the removed numbers
					System.out.println("Removed: " + currNum + " " + nextNum);
					
					currentInt.remove();//removes the current
					currentInt.previous();//shifts to the previous number
					currentInt.remove();//thus making the removal of this digit
					 //counter to evalute if there are digits removed
					intCount++; 
					//will iterate to the next number
					if(currentInt.hasNext())
					{
						currNum = currentInt.next();
					}
				}
				//will keep iterating through the list if removable conditions
				//weren't met
				else
				{
					currNum = nextNum;
					
				}
			}//end inner while
			
		}//end outer while
		
		// if the intCount is 0 then there are no more pairs to remove
		if (intCount == 0)
		{
			morePairs = false;
		} 
		return morePairs;
		
		/* make two iterators to scan and send to removable to see if they can
		be removed*/
		
    } // end scanAndRemovePairs
} // end SolitaireGame

/*
The list is originally: [81, 50, 11, 61, 42, 74, 16, 65, 49, 49, 11, 19, 67, 79, 33, 95, 85, 52, 59, 67, 46, 81, 62, 30, 60, 66, 80, 96, 30, 81, 37, 30, 34, 30, 15, 80, 11, 61, 55, 46]
   Removed: 11  61
   Removed: 49  49
   Removed: 11  19
   Removed: 95  85
   Removed: 52  59
   Removed: 30  60
   Removed: 37  30
   Removed: 34  30
   Removed: 11  61
The list is now: [81, 50, 42, 74, 16, 65, 67, 79, 33, 67, 46, 81, 62, 66, 80, 96, 30, 81, 15, 80, 55, 46]
   Removed: 65  67
   Removed: 62  66
The list is now: [81, 50, 42, 74, 16, 79, 33, 67, 46, 81, 80, 96, 30, 81, 15, 80, 55, 46]
   Removed: 81  80
The list is now: [81, 50, 42, 74, 16, 79, 33, 67, 46, 96, 30, 81, 15, 80, 55, 46]
   Removed: 46  96
The list is now: [81, 50, 42, 74, 16, 79, 33, 67, 30, 81, 15, 80, 55, 46]
No more pairs to remove.

 */
