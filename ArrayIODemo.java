import java.util.Scanner; // Needed for the Scanner class
import java.io.*; //Add the file I/O import statement here

/**
   This program opens a file named numbers.txt, creates a 100 element array, 
   then reads the file, and converts the numbers that are strings in the text
   file into real numbers and puts them into that array. It only loops through
   as long as there are more elements to grab from the file to store into the 
   array.
   
*/

public class ArrayIODemo
{
   public static void main(String[] args) throws IOException
	   {
		 
		String strNum; //holds the string number from the text file.
		int number; // holdes then converted text number that is now a number
		int i= 0; // creates an index variable for counting
		int count = 0; // creates a variable for counting how many times 
					   // it stored a value in the array.
		int array[] = new int [100];//creates an array of 100.
		
	
		
		File file = new File("numbers.txt");//opens the file numbers.txt
		
		//creates a scanner object to read the file, passes the file object
		Scanner fileread = new Scanner (file);

		//while statement reads file as long as it has a next line to read
		while(fileread.hasNext())
		{
			//stores the read lines in the strNum variable
			strNum = fileread.next(); 
			
			//stores the conversion of strNum into an integer into number
			number = Integer.parseInt(strNum);
			
			array[i] = number;//adds the numbers to the array
			i++; //iterates the counter for the array
			count++; //counts the amount of elements to put into the array
		}
		fileread.close();//closes the file
		
		//this for loop iterates the printing of the numbers to the array
		//for as many elements there are in the array.
		for (i =0; i < count; i++)
		{	
		
		System.out.println(array[i]);//prints number to the array
		
		}
	}
}
