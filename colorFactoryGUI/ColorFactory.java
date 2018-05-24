import javax.swing.*;    // Needed for Swing classes
import java.awt.*;       // Needed for Color class
import java.awt.event.*; // Needed for event listener interface

/**
   This class demonstrates how to set the background color of
   a panel and the foreground color of a label.
*/

public class ColorFactory extends JFrame
{
   private JLabel messageLabel;    // To display a message
   private JButton redButton;      // Changes center panel color to red
   private JButton orangeButton;     // Changes center panel color to orange
   private JButton yellowButton;   // Changes center panel color to yellow
   private JRadioButton greenRadio; //Changes text in cPanel to green
   private JRadioButton blueRadio; //Changes text in cPanel to blue
   private JRadioButton cyanRadio; //Changes text in cPanel to cyan
   private ButtonGroup radioButtonGroup; //Radio button group
   private JPanel cPanel;           // A panel to hold components
   private JPanel topPanel;           // A panel to hold components
   private JPanel bottomPanel;           // A panel to hold components
   private final int WINDOW_WIDTH = 500; // Window width
   private final int WINDOW_HEIGHT = 300; // Window height

   /**
      Constructor for ColorFactory window and add components to it
	  sets width, and sets the blueRadio button as clicked.
   */

   public ColorFactory()
   {
        // Set the title bar text.
        setTitle("Color Factory");

        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        // Create a BorderLayout manager.
        setLayout(new BorderLayout());
		
		//message for center panel
		messageLabel = new JLabel("Top buttons change the panel color " +
                                "and bottom radio buttons change the text " +
								"color.");
		
		
		//Build top panel with background color selection buttons
		buildTopPanel();
		//Build bottom panel with text color selection radio buttons
		buildBottomPanel();
		
		//making a center panel messageLabel
		cPanel = new JPanel();
		//setting center panel to Border Layout
		cPanel.setLayout(new BorderLayout());
        // Add the message to the center of the center panel.
		cPanel.add(messageLabel, BorderLayout.CENTER);
		
		//adding the different panels to their specific regions
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
		add(cPanel, BorderLayout.CENTER);
		//setting the click of the blue radio button to set the color of text.
		blueRadio.doClick();
		
		
   }
	
	
   /**
      Private inner class that builds the top button panel which changes the
	  center panels background colors.
   */
	private void buildTopPanel()
	{
		
		// Create the three buttons.
		redButton = new JButton("Red");
		orangeButton = new JButton("Orange");
		yellowButton = new JButton("Yellow");
		
		//setting the background colors of the buttons
		redButton.setBackground(Color.RED);
		orangeButton.setBackground(Color.ORANGE);
		yellowButton.setBackground(Color.YELLOW);
		
		// Register an event listener with all 3 buttons.
		redButton.addActionListener(new ButtonListener());
		orangeButton.addActionListener(new ButtonListener());
		yellowButton.addActionListener(new ButtonListener());
		
		
		//setting action commmands to the first letter of the color name
		redButton.setActionCommand("r");
		orangeButton.setActionCommand("o");
		yellowButton.setActionCommand("y");
		
		// Create a panel and add the components to it.
		topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		topPanel.add(redButton);
		topPanel.add(orangeButton);
		topPanel.add(yellowButton);
	}
	/**
      Private inner class that builds the bottom radio panel which changes the
	  center panels message/text color.
   */
	
	private void buildBottomPanel()
	{
		//create radio buttons
		greenRadio = new JRadioButton("Green");
		blueRadio = new JRadioButton("Blue", true);//pre-selected button
		cyanRadio = new JRadioButton("Cyan");
		
		//set color of radio buttons to the same color they set
		greenRadio.setForeground(Color.GREEN);
		blueRadio.setForeground(Color.BLUE);
		cyanRadio.setForeground(Color.CYAN);
		
		// Group the radio buttons.
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(greenRadio);
		radioButtonGroup.add(blueRadio);
		radioButtonGroup.add(cyanRadio);
		
		// Register an event listener with all 3 buttons
		greenRadio.addActionListener(new RadioButtonListener());
		blueRadio.addActionListener(new RadioButtonListener());
		cyanRadio.addActionListener(new RadioButtonListener());
		
		// Create a panel and add the components to it.
		bottomPanel = new JPanel();
		//set background of panel to white
		bottomPanel.setBackground(Color.WHITE);
		bottomPanel.add(greenRadio);
		bottomPanel.add(blueRadio);
		bottomPanel.add(cyanRadio);
		
		
	}
	/**
	  Private inner class that handles the event when
	  the user clicks the Buttons to change color
	*/
	private class ButtonListener implements ActionListener
	{
		
	    public void actionPerformed(ActionEvent e)
	    {
			//Get the action command
			String actionCommand = e.getActionCommand();
			
			//Set the panel's background to different colors.
			//from the actionCommand text to set the panel to the right color
			if (actionCommand.equals("r"))
			{
				cPanel.setBackground(Color.RED);
			}
			else if (actionCommand.equals("o"))
			{	
				cPanel.setBackground(Color.ORANGE);
			}
			else if (actionCommand.equals("y"))
			{
				cPanel.setBackground(Color.YELLOW);
			}
		}
	}

   /**
	  Private inner class that handles the event when
	  the user clicks the radio buttons to change text color
	*/

	private class RadioButtonListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
	   {
			
			//compares what event is selected for the radios and sets text color
			if (blueRadio.isSelected())
			{
				messageLabel.setForeground(Color.BLUE);
			}
			if (greenRadio.isSelected())
			{
				messageLabel.setForeground(Color.GREEN);
			}
			if (cyanRadio.isSelected())
			{
				messageLabel.setForeground(Color.CYAN);
			}
			
			
	   }	
	}
	
    /**
        The main method creates an instance of the ColorFactory class, 
		display it's window
    */
   
    public static void main(String[] args)
    {
        // create an instance of the window and set visible
		new ColorFactory().setVisible(true);
		
        
    }
}
