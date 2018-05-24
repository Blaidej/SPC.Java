import javax.swing.*;    // Needed for Swing classes
import java.awt.event.*; // Needed for ActionListener Interface
import java.text.DecimalFormat; //Needed for the dollar formater
import java.awt.*; //Needed for the border class
/**
   The TheaterRevenue class displays a JFrame that
   lets the user enter gallons used and miles driven. When
   the Calculate button is clicked, a dialog box is
   displayed with the mpg.
*/

public class TheaterRevenue extends JFrame
{
   private JPanel panel;             // To reference a panel
   private JLabel adultTktPriceLabel;      // To reference a label
   private JLabel childTktPriceLabel;      // To reference a label
   private JLabel adultNmbrSoldLabel;      // To reference a label
   private JLabel childNmbrSoldLabel;      // To reference a label
   private JTextField adultTktPriceField; // To reference a text field
   private JTextField childTktPriceField; // To reference a text field
   private JTextField adultNmbrSoldField; // To reference a text field
   private JTextField childNmbrSoldField; // To reference a text field
   private JButton resetButton;       // To reference a button
   private JPanel buttonPanel;    // To hold the buttons
   private JPanel inputPanel;    // To hold the buttons
   //private JButton addmoreButton;       // To reference a button
   private JButton calcRevenueButton;       // To reference a button
   private final int WINDOW_WIDTH = 400;  // Window width
   private final int WINDOW_HEIGHT = 400; // Window height
   /* 
		The theaters keeps 20 percent of its box office reciepts.
		The constant AFTER_BOX_OFFICE is set .8 since that times any of the 
		gross revenue will give you the net revenue. Adjust the constant as
		needed subtracting the percentage the box office keeps from 100%.
	*/
	private final double AFTER_BOX_OFFICE = 0.20; 
   
   /**
      Constructor for TheaterRevenue  creating the window and populating it.
	  
   */

   public TheaterRevenue()
   {
		// Set the window title.
		setTitle("Theater Revenue");

		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	
		// Specify what happens when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Setting layout to BorderLayout giving it some gaps for elements
		setLayout(new BorderLayout(10,10));
	
		// Build the panel and add it to the frame.
		userInputPanel();
		buildButtonPanel();
	
		// Add the panels to the frame's content pane.
		add(inputPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	  
	  
		// Display the window.
		pack();
		setVisible(true);
		
   }

   /**
      The userInputPanel method adds a label, text field, and
       to a panel.
	  
   */

    private void userInputPanel()
   {
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 2));
		
        //Asking Getting user input to populate the panels.
        adultTktPriceLabel = new JLabel("Enter the adult ticket price:");
		//Field to accept user input.
	    adultTktPriceField = new JTextField(10);
		//Asking Getting user input to populate the panels.
	    adultNmbrSoldLabel = new JLabel("Enter the number of"+
		" adult tickets sold:"); 
	    //Field to accept user input.
	    adultNmbrSoldField = new JTextField(10);
	    
		//Asking Getting user input to populate the panels.
        childTktPriceLabel = new JLabel("Enter the child ticket price:");
		//Field to accept user input.
      	childTktPriceField = new JTextField(10);
		//Asking Getting user input to populate the panels.
	    childNmbrSoldLabel = new JLabel("Enter the number of child"+
		"tickets sold:"); 
         //Field to accept user input.
		childNmbrSoldField = new JTextField(10);             
		
		
		inputPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		// components to the panel.
		inputPanel.add(adultTktPriceLabel);
		inputPanel.add(adultTktPriceField);
		inputPanel.add(adultNmbrSoldLabel);
		inputPanel.add(adultNmbrSoldField);
		inputPanel.add(childTktPriceLabel);
		inputPanel.add(childTktPriceField);
		inputPanel.add(childNmbrSoldLabel);
		inputPanel.add(childNmbrSoldField);
	  
	  
    }
	/**
		Building a button panel for the calculate revenue and reset button.
	*/
	private void buildButtonPanel()
    {
		
        // Create a panel for the buttons.
        buttonPanel = new JPanel();
		
		// Create the buttons.
		resetButton = new JButton("Reset");
        calcRevenueButton = new JButton("Calculate Revenue");
		
		// Register the action listeners.
        calcRevenueButton.addActionListener(new CalcButtonListener());
        resetButton.addActionListener(new resetButtonListener());
		
		// Add the buttons to the button panel.
        buttonPanel.add(resetButton);
        buttonPanel.add(calcRevenueButton);
		
		
		
    }
    /**
        CalcButtonListener is an action listener class for
        the Calculate button.
    */

   private class CalcButtonListener implements ActionListener
   {
        /**
            The actionPerformed method executes when the user
            clicks on the Calculate button.
            @param e The event object.
        */

      public void actionPerformed(ActionEvent e)
      {
			 
			String inputTktPriceAdult;  // To hold the user's input
			String inputTktSoldAdult;  // To hold the user's input
			
			String inputTktPriceChild;  // To hold the user's input
			String inputTktSoldChild;  // To hold the user's input
			
			double adultTktRevenue; //to hold the Adults ticket Revenue
			double netAdultTktRevenue; //to hold the Adults net ticket Revenue
			
			double childTktRevenue;//to hold the child ticket Revenue
			double netChildTktRevenue;//to hold the child net ticket revenue
			
			double grossRevenue = 0;// The grossRevenue
			// The netRevenue after 20 percent taken off the top
			double netRevenue = 0;
			
			 
			// Create a DecimalFormat object to format output.
			 DecimalFormat dollar = new DecimalFormat("0.00");
			 
			 
			// Get the text entered by the user into the
			// text field.
			inputTktPriceAdult = adultTktPriceField.getText();
			inputTktSoldAdult = adultNmbrSoldField.getText();
			
			inputTktPriceChild = childTktPriceField.getText();
			inputTktSoldChild = childNmbrSoldField.getText();
			
			// For debugging, display the text entered, and
			// its value converted to a double.
			System.out.println("Reading " + inputTktPriceAdult + ""
								+ inputTktSoldAdult +
								inputTktPriceChild + "" + inputTktSoldChild +
								" from the text field.");
			System.out.println("Converted value: " +
								Double.parseDouble(inputTktPriceAdult));

			// parse the input for adults multiplying the input to get revenue 
			adultTktRevenue = Double.parseDouble(inputTktSoldAdult) *
								Double.parseDouble(inputTktPriceAdult);
			
			// getting the net revenue by giving the box office their cut.
			netAdultTktRevenue = adultTktRevenue * AFTER_BOX_OFFICE;
			
			// parse the input for adults multiplying the input to get revenue 
			childTktRevenue = Double.parseDouble(inputTktSoldChild) *
								Double.parseDouble(inputTktPriceChild);
			
			// getting the child net revenue by giving the box office their cut.
			netChildTktRevenue = childTktRevenue * AFTER_BOX_OFFICE;
			
			// getting the grossRevenue by adding adult and child ticket revenue.
			grossRevenue = adultTktRevenue + childTktRevenue;
			
			// getting the child net revenue by giving the box office their cut.
			netRevenue = (childTktRevenue + adultTktRevenue)* AFTER_BOX_OFFICE;
			
			// Display the adult ticket gross revenue.
			JOptionPane.showMessageDialog(null, "Gross revenue for adult tickets" 
				+ " sold: $"+ dollar.format(adultTktRevenue) + "\n"
				+"Net revenue for adult tickets " 
				+ "sold: $"+ dollar.format(netAdultTktRevenue) + "\n"
				+"Gross revenue for child tickets " 
				+ "sold: $"+ dollar.format(childTktRevenue) + "\n"
				+"Net revenue for child tickets " 
				+ "sold: $"+ dollar.format(netChildTktRevenue) + "\n"
				+"Total gross revenue: $" 
				+ dollar.format(grossRevenue) + "\n"
				+"Total net revenue: $" 
				+ dollar.format(netRevenue));

			
			// For debugging, display a message indicating
			// the application is ready for more input.
			System.out.println("Ready for the next input.");
        }
    } 
    
	// resetButtonListener sets the text fields to an empty string when called.
    private class resetButtonListener implements ActionListener
    {
        /**
           The actionPerformed method executes when the user
           clicks on the reset button.
           @param e The event object.
        */
        public void actionPerformed(ActionEvent e)
        {
			//reseting the text in all the fields to an empty string
		    adultTktPriceField.setText("");
			adultNmbrSoldField.setText("");
		
			childTktPriceField.setText("");
			childNmbrSoldField.setText("");
			
		}
		
		
		
   }
   /**
      The main method creates an instance of the
      TheaterRevenue class, which displays
      its window on the screen.
   */

   public static void main(String[] args)
   {
      new TheaterRevenue();
   }
}