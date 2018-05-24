import java.util.Scanner;
/**
	This Average class works with the Average Driver and does the 
	primary processes to an array to take the user input of 5 numbers. Then
	it takes the values given to calculate the average of them and to sort 
	them in descending order. It then will print those results to the screen.
*/
public class Average
{
	private int[] data; //array to contain the scores
	private double mean; //initiates the mean 
	
	
	/**
	This Average method creates an array object to store the user input 
	and calls the preceding methods to calculate the mean of the array
	sort it in descending order. It then takes and prints out the results
	using the to the screen.
	*/
	
	public Average()
	{	
		Scanner keyboard = new Scanner(System.in);//User input
		
		data = new int[5];//creates an array holding 5 socres
		
		//loops and retrieves user input values to fill array
		for (int i = 0; i < data.length; i++)
		{
			//Prompts the user for input
			System.out.print("Enter score number" + (i + 1) + ":");
			//puts the suer input into the data array
			data[i] = keyboard.nextInt();
			
		}
		selectionSort(data);//passes the array to get sorted
		//calls the calculateMean method to calculate the average
		calculateMean(); 
		//prints out the toString method for the user to see the sorted
		//list of numbers in descending order and the mean
		System.out.print(toString());
	}
	/**
		The calculateMean method takes the array, totals and then 
		calculates the mean for the numbers given by the user.
		
	*/
	public void calculateMean()
	{
		double total = 0; //variable to hold the total of the user input
		//loop to add the user input
		for (int i = 0; i < data.length; i++)
		{	
			//iterates through the array and adds it to the total
			total += data[i]; 
			
		}
		//gets the mean by dividing the total of the user inputed numbers
		//divide's it by the array's length.
		mean = total/data.length;
		
	}
	/**
		The toString sets the results from the different methods to be strings
		and returns them to be printed. 
		@return The string for explaining the data array in descending order 
		and for explaining and printing the mean.
		
	*/
	
	public String toString()
	{
		String strData = ""; //creates an empty string to hold the data array.
		//A string to hold the test score descending print statement.
		String str1 ="The test scores in descending order are:\n";
		//loops through the array and stores it into the empty string strData.
		for (int i = 0; i < data.length; i++)
			strData = strData + (data[i] + "    ");
		
		//meanStr holds the print to screen statement for the mean
		String meanStr = "\nThe average is: " + mean;
		
		//returns the strings for output to the screen by the Average class.
		return str1 + strData + meanStr;
	}
	/**
      The selectionSort method performs a selection sort on data
	  array that is given by the user. The array is then sorted
	  in descending order.
      @param array is the array to sort in descending order.
   */
	
	public void selectionSort(int[] array)
   {
	   //creates the variables to sort the array
        int startScan, index, minIndex, minValue;
		//the loop to sort the array
        for (startScan = 0; startScan < (array.length-1); startScan++)
        {
           minIndex = startScan;
           minValue = array[startScan];
		   //the loop to continue sorting the array
           for(index = startScan + 1; index < array.length; index++)
           {
				//setting the array's value at each index to be larger or 
				//smaller than the next.
                if (array[index] > minValue)
                {
                   minValue = array[index];
                   minIndex = index;
                }
           }
           array[minIndex] = array[startScan];
           array[startScan] = minValue;
        }
   }
}