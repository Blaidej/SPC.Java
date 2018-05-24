// An import statement for the Scanner class
import java.util.Scanner;
import java.io.*;
/**
   This program reads dataa from a file. pg241-242
*/

public class FileReadDemo
{
   public static void main (String [] args) throws IOException
   {	
		
		Scanner keyboard = new Scanner(System.in);
		
		//Get the filename
		System.out.print("Enter the filename: ");
		String filename = keyboard.nextLine();
		
		//Open the file
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		//Read lines from the file until no more are left.
		while (inputFile.hasNext())
		{
			//Read the next name.
			String friendName = inputFile.nextLine();
			
			//Display the last name read.
			System.out.println(friendName);
		}
		
		inputFile.close();
		
		
	}
}