/** 
	This LinkedBagTester tests the different conditions of the LinkedBag add 
	function and Prints it out to the screen. It ensures you can add to each
	part of the list without problems. It tests strings of numbers and letters.
*/
public class LinkedBagTester
{
	public static void main(String[] args) 
	{
		
		//Testing how the add method works on numbers.
		//**********************************************************************
        // Tests on a bag that is empty
        System.out.println("Creating an empty bag.");
        BagInterface<String> aBag = new LinkedBag<>();
        displayBag(aBag);
        
        // Adding strings to bag
        String[] contentsOfBag = {"2", "3", "5", "7", "8"};
		testAdd(aBag, contentsOfBag);
		System.out.println();
		System.out.println("What's in the bag before testing?");
		displayBag(aBag);//calls the 
		
		//linebreak for legibility @ command line
		System.out.println("-------------------------------------------");
		System.out.println("Making sure an entry can be added to the end of "
		+"the list");
		System.out.println("Adding 9 to the list");
		aBag.add("9",true);//passing values to add method
		displayBag(aBag);
		
		//linebreak for legibility @ command line
		System.out.println("-------------------------------------------");
		System.out.println("Making sure an entry can be added the beginning of "
		+"the list");
		System.out.println("Adding 1 to the list");
		aBag.add("1",true);//passing values to add method
		displayBag(aBag);
		
		//linebreak for legibility @ command line
		System.out.println("-------------------------------------------");
		System.out.println("Making sure an entry can be added to the middle of "
		+"the list");
		System.out.println("Adding 6 to the list");
		aBag.add("6",true);//passing values to add method
		displayBag(aBag);
		
		
		System.out.println();
		//Testing how the add method works on letters.
		//**********************************************************************
		//linebreak for legibility and for letters testing
		System.out.println("Now for safe measure we are going to test Letters");
		System.out.println("*************************************************");
		System.out.println("Creating an empty bag for Letters.");
		//create a bag
        BagInterface<String> aLetterBag = new LinkedBag<>();
        displayBag(aLetterBag);
        
        // Adding strings
        String[] contentsOfaLetterBag = {"b", "d", "f", "h", "j"};
		testAdd(aLetterBag, contentsOfaLetterBag);
		System.out.println();
		System.out.println("What's in the bag before testing?");
		displayBag(aLetterBag);
		
		//linebreak for legibility @ command line
		System.out.println("-------------------------------------------");
		System.out.println("Making sure an entry can be added to the end of "
		+"the list");
		System.out.println("Adding a 'k' to the list");
		aLetterBag.add("k",true);//passing values to add method
		displayBag(aLetterBag);
		
		//linebreak for legibility @ command line
		System.out.println("-------------------------------------------");
		System.out.println("Making sure an entry can be added the beginning of "
		+"the list");
		System.out.println("Adding an 'a' to the list");
		aLetterBag.add("a",true);//passing values to add method
		displayBag(aLetterBag);
		
		//linebreak for legibility @ command line
		System.out.println("-------------------------------------------");
		System.out.println("Making sure an entry can be added to the middle of "
		+"the list");
		System.out.println("Adding an 'e' to the list");
		aLetterBag.add("e",true);//passing values to add method
		displayBag(aLetterBag);
		
		
	} // end main

   // Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index], true);
            System.out.print(content[index] + " ");
		} // end for
        System.out.println();
      
		//displayBag(aBag);
	} // end testAdd
	
	/** 
	This LinkedBagTester tests the different conditions of the LinkedBag add 
	function and Prints it out to the screen. It ensures you can add to each
	part of the list without problems.
	*/


    // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
} // end LinkedBagDemo

/*

 Creating an empty bag.
 The bag contains 0 string(s), as follows:
 
 Testing isEmpty with an empty bag:
 isEmpty finds the bag empty: OK.
 
 
 Testing the method getFrequencyOf:
 In this bag, the count of  is 0
 In this bag, the count of B is 0
 
 Testing the method contains:
 Does this bag contain ? false
 Does this bag contain B? false
 
 Removing a string from the bag:
 remove() returns null
 The bag contains 0 string(s), as follows:
 
 
 Removing "B" from the bag:
 remove("B") returns false
 The bag contains 0 string(s), as follows:
 
 Adding to the bag: A D B A C A D
 The bag contains 7 string(s), as follows:
 D A C A B D A
 Testing isEmpty with a bag that is not empty:
 isEmpty finds the bag not empty: OK.
 
 
 Testing the method getFrequencyOf:
 In this bag, the count of A is 3
 In this bag, the count of B is 1
 In this bag, the count of C is 1
 In this bag, the count of D is 2
 In this bag, the count of Z is 0
 
 Testing the method contains:
 Does this bag contain A? true
 Does this bag contain B? true
 Does this bag contain C? true
 Does this bag contain D? true
 Does this bag contain Z? false
 
 Removing a string from the bag:
 remove() returns D
 The bag contains 6 string(s), as follows:
 A C A B D A
 
 Removing "B" from the bag:
 remove("B") returns true
 The bag contains 5 string(s), as follows:
 C A A D A
 
 Removing "A" from the bag:
 remove("A") returns true
 The bag contains 4 string(s), as follows:
 C A D A
 
 Removing "C" from the bag:
 remove("C") returns true
 The bag contains 3 string(s), as follows:
 A D A
 
 Removing "Z" from the bag:
 remove("Z") returns false
 The bag contains 3 string(s), as follows:
 A D A 
 
 Clearing the bag:
 Testing isEmpty with an empty bag:
 isEmpty finds the bag empty: OK.
 
 The bag contains 0 string(s), as follows:
 

*/
