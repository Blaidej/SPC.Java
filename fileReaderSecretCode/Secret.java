import java.io.*;
import java.util.Scanner;
/**
	This program opens a file for reading, and then processes the file to 
	decifer a secrect message.
*/

public class Secret// Not sure that you tell us what the file name should be?
{
    
   public static void main(String[] args)throws IOException
   {
        //Creates a string builder so that we can read the file and 
	    //creates a mutable sequence of characters.
        StringBuilder str1 = new StringBuilder();
       
	    //Make a scanner and read the file secret.txt
        Scanner scanner = new Scanner( new File("secret.txt") );
       
	    //Append text while it has a next line to append to str1
        while (scanner.hasNextLine()) {
            str1.append(scanner.nextLine());
        }
        
		//calls the toString method for str1
        String str2 = str1.toString();
       
        // Create a string builder to hold the secret
        StringBuilder secrBuilder1 = new StringBuilder();
 
 
        // Get the tokens, using a space delimiter.
		String[] tokens = str2.split(" ");
      
        // loop through and grab the first letter of every 5th word to 
		// read the secret message.
        for (int i = 0; i < tokens.length; i += 5)
        {
            secrBuilder1.append(tokens[i].charAt(0));   
        }
        
		//call the toString method for the secrBuilder
        String secrBuilder2 = secrBuilder1.toString();
        //print the secret in upper case
        System.out.println(secrBuilder2.toUpperCase());
		// close the file scanner
        scanner.close();
         
   }
}