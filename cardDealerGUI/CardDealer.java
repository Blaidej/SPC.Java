import java.awt.*; //necessary for graphics
import java.awt.event.*;////necessary for events- buttons
import javax.swing.*; //necessary for graphics
import java.util.ArrayList;//for arraylist to be used
import java.util.Scanner;// for file opens and
import java.util.Random; //for generating  random numbers
import java.io.File; //needed for creating a file object

/**
   This class demonstrates demonastrates a deck of cards that is created 
   from a list of card images and picked from randomly showing the entire deck
   until the deck is gone through.
   
*/

public class CardDealer extends JFrame
{
    private JPanel imagePanel;     // To hold the label
    private JPanel buttonPanel;    // To hold a button
    private JPanel westCardPanel;    // To hold the Dealers deck of cards
    private JPanel eastCardPanel;    // To hold the spot for the card
    private JLabel imageLabelWest;     // To show an image of the dealer deck
    private JLabel imageLabelEast;     // To show an image
    private JButton button;        // To get an image
	//Holds the arraylist of the card's file names with easy removal
	private ArrayList<String> cardFileNames;
	//Holds the string names of the file names in an array via .list method.
	private String[] cardFileArray;
	//creates a file object so we can grab the file names from the directory
	private File cardDirectory;
	//newCard gives us a place to display the image of the cards we are getting.
	private ImageIcon newCard;
	//settings for the height and width of the window
	private final int WIDTH = 372;
	private final int HEIGHT =323;
	
   /**
      Constructor for the CardDealer window, sets the dimensions,and adds the 
	  necessary card panels/
   */

   public CardDealer()
    {
        // Set the title.
        setTitle("Card Dealer");
		setSize(WIDTH, HEIGHT);
        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager.
        setLayout(new BorderLayout());
		
		//builds the card deck from a file object, puts into a string array
		//and then 
	    buildDeck();
	
	
        // Build the panels.
        buildWestCardPanel();
        buildEastCardPanel();
	  
        buildButtonPanel();
        //buildImagePanel();

        // Add the panels to the content panes.
        add(westCardPanel, BorderLayout.WEST);
        add(eastCardPanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);
        

        //display the window.
        setVisible(true);
    }
   //buildDeck builds the arraylist of cards from a the directory with all
   //of the card images.
	private void buildDeck()
	{
   
		//make a file object to read the cards directory and make an array
		cardDirectory = new File("cards");
		//make the card array from the cardDirectory 
		cardFileArray = cardDirectory.list();
		//declare a string array to hold the cardDirectories array
		cardFileNames = new ArrayList<String>();
		//take the card Directory array and add to the just made arraylist
		for (String filenames : cardFileArray)
			cardFileNames.add(filenames);
		//need to remove the card backs from the array
		//otherwise it will pop up as a card in the deck
		cardFileNames.remove("cards/Backface_Red");
		cardFileNames.remove("cards/Backface_Blue");
   
	}
   
	/**
      The buildWestCardPanel method builds the panel for the left stack of 
	  cards to be placed
   */
	
   private void buildWestCardPanel()
   {
	    // Create a panel.
		westCardPanel = new JPanel();
		
		//making imageIcon for the card
		ImageIcon card = new ImageIcon("cards/Backface_Blue.jpg");
		
		//making a label for the image to get set in
		imageLabelWest = new JLabel(card);		
		
		// Add the label to the panel.
		westCardPanel.add(imageLabelWest);
   }
   /**
      The buildImagePanel method adds a label to a panel.
   */
   private void buildEastCardPanel()
   {
		// Create a panel.
		eastCardPanel = new JPanel();
		
		//making a label for the image to get set in
		imageLabelEast = new JLabel();
		
		// Add the label to the panel.
		eastCardPanel.add(imageLabelEast);
   }
   /**
      The buildButtonPanel method adds a button
      to a panel for the dealer to deals the cards.
   */

   private void buildButtonPanel()
   {

      // Create a panel.
      buttonPanel = new JPanel();

      // Create a button.
      button = new JButton("Deal a Card");
      

      // Register an action listener with the button.
      button.addActionListener(new ButtonListener());

      // Add the button to the panel.
      buttonPanel.add(button);
   }
   

   /**
      Private inner class that handles the event when
      the user clicks the button.
	  This chapter's source code folder contains images for a complete deck of
	  poker cards. Write a GUI application, similiar to fig.13-34, that randomly
	  selects a card from the deck and displays it each time the user clicks the
	  button. When a card has been selected, it is removed from the deck and 
	  cannot be selected again. Display a message when no more cards are left in 
	  the deck.
   */

   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {	
		
		
		//making a random number generator
		Random rand = new Random();
		
		//first 'if' for the card arraylist size making sure it doesn't go
		// off the end of the array. 
		if (cardFileNames.size() > 1)
		{
			// randomNum gets an int according to the decks current size
			//-1 so it doesn't go off the end of the array
			int randomNum = rand.nextInt(cardFileNames.size()-1);
			// string to hold the name of the index from randomNum
			String randomDealCard = cardFileNames.get(randomNum);
			//assigning the card to the image icon held within newCard
			newCard = new ImageIcon("cards/"+ randomDealCard);
			//setting the image into the label
			imageLabelEast.setIcon(newCard);
			//removing the just used card
			cardFileNames.remove(randomDealCard);
			
		//else for the last card pulled from the array 
		}else if (cardFileNames.size() > 0)
		{
			// randomNum gets an int according to the decks current size
			int randomNum = rand.nextInt(cardFileNames.size());
			// string to hold the name of the index from randomNum
			String randomDealCard = cardFileNames.get(randomNum);
			//assigning the card to the image icon held within newCard
			newCard = new ImageIcon("cards/"+ randomDealCard);
			//setting the image into the label
			imageLabelEast.setIcon(newCard);
			//removing the just used card
			cardFileNames.remove(randomDealCard);

		}else{
			//when the last card is played there is no more cards in the deck
			// so we empyt the west label location, setting it to null
			imageLabelWest.setIcon(null);
			//display a message to the user
			JOptionPane.showMessageDialog(null, "You have went through the "+
											"entire deck");
		}
		
        
      }
   }
   
   /**
      The main method creates an instance of the
      CardDealer class which causes it to display
      its window.
   */
   public static void main(String[] args)
   {
      new CardDealer();
   }
}
