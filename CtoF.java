import javax.swing.*;    // Needed for Swing classes
import java.awt.event.*; // Needed for ActionListener Interface

/**
   The CtoF class displays a JFrame that
   lets the user enter a distance in kilometers. When
   the Calculate button is clicked, a dialog box is
   displayed with the distance converted to cToF.
*/

public class CtoF extends JFrame
{
   private JPanel panel;             // To reference a panel
   private JLabel messageLabel;      // To reference a label
   private JTextField celciusField; // To reference a text field
   private JButton calcButton;       // To reference a button
   private final int WINDOW_WIDTH = 310;  // Window width
   private final int WINDOW_HEIGHT = 100; // Window height

   /**
      Constructor
   */

   public CtoF()
   {
      // Set the window title.
      setTitle("Celcius to Fahrenheit");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Build the panel and add it to the frame.
      buildPanel();

      // Add the panel to the frame's content pane.
      add(panel);

      // Display the window.
      setVisible(true);
   }

   /**
      The buildPanel method adds a label, text field, and
      and a button to a panel.
   */

   private void buildPanel()
   {
      // Create a label to display instructions.
      messageLabel = new JLabel("Enter the Celius temperature:");
        // Create a label to display instructions.
                             

      // Create a text field 10 characters wide.
      celciusField = new JTextField(10);
		// Create a text field 10 characters wide.
      
	  
      // Create a button with the caption "Calculate".
      calcButton = new JButton("Calculate");

      // Add an action listener to the button.
      calcButton.addActionListener(new CalcButtonListener());

      // Create a JPanel object and let the panel
      // field reference it.
      panel = new JPanel();

      // Add the label, text field, and button
      // components to the panel.
      panel.add(messageLabel);
      panel.add(celciusField);
      panel.add(calcButton);
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
         
         String inputCelsius;  // To hold the user's input
         final double CONVERSION = 1.8;
         final double ADDITION = 32;
		 double celciusTemp = 0;
		 
         double cToF;  // The number of cToF

         // Get the text entered by the user into the
         // text field.
         inputCelsius = celciusField.getText();
         
         
         // For debugging, display the text entered, and
         // its value converted to a double.
         System.out.println("Reading " + inputCelsius + "" +
                            " from the text field.");
         System.out.println("Converted value: " +
                            Double.parseDouble(inputCelsius));

         // Convert the input to cToF.
         celciusTemp = Double.parseDouble(inputCelsius);
		 cToF =((celciusTemp*CONVERSION) + ADDITION);
         // Display the result.
         JOptionPane.showMessageDialog(null, inputCelsius + " degrees celsius " 
		 + " is equal to " + cToF + " degrees fahrenheit.");

         // For debugging, display a message indicating
         // the application is ready for more input.
         System.out.println("Ready for the next input.");
      }
   } // End of CalcButtonListener class

   /**
      The main method creates an instance of the
      CtoF class, which displays
      its window on the screen.
   */

   public static void main(String[] args)
   {
      new CtoF();
   }
}