import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.Arrays;

/**
   Trying to read the directory for Cards and get an Arraylist of the 
   names so I can implement it within
*/
public class CardFileReader
{

   public static void main(String[] args)
   {
	    //
		
		File cardDirectory = new File("cards");
		
		String[] cardFileArray = cardDirectory.list();
		
		ArrayList<String> cardFileNames = new ArrayList<String>();
		
		for (String filenames : cardFileArray)
			cardFileNames.add(filenames);
		
		for (String listNames : cardFileNames) 
				System.out.println(listNames); 
		
		
		
		String dirPath = "cards";
		File dir = new File(dirPath);
		String[] files = dir.list();
		if (files.length == 0) {
			System.out.println("The directory is empty");
		} else {
			for (String aFile : files) {
				System.out.println(aFile);
			}
		}
		
		
	}
}
