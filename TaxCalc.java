import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
   This class displays a window with a slider component.
   The user can convert the Celsius temperatures from
   0 through 100 to Fahrenheit by moving the slider.
*/

public class TaxCalc extends JFrame
{
   private JLabel purchaseLabel, taxLabel, taxSlide;     // Message labels
   private JTextField purchaseAmountField; // temp
   private JTextField taxField; //  temp
   private JPanel purchasePanel;          // panel
   private JPanel taxPanel;          //  panel
   private JPanel sliderPanel;     // Slider panel
    private JPanel buildSliderPanel;
   private JSlider slider;         // Temperature adjuster
	private final int WIDTH = 372;
	private final int HEIGHT = 200;
   /**
      Constructor
   */

   
   public TaxCalc()
   {
      // Set the title.
      setTitle("Tax Calculator");
		setSize(WIDTH, HEIGHT);
      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create the message labels.
      purchaseLabel = new JLabel("Enter the amount of the purchase: ");   
	  
	  purchaseAmountField = new JTextField(10);
      purchaseAmountField.setEditable(true);
	  
      taxLabel = new JLabel("Sales Tax: ");
	  taxField = new JTextField("0.0", 10);
      taxField.setEditable(false);
 
      buildSliderPanel();

      // Create panels and place the components in them.
      purchasePanel = new JPanel();
      purchasePanel.add(purchaseLabel);
      purchasePanel.add(purchaseAmountField);
      taxPanel = new JPanel();
      taxPanel.add(taxLabel);
      taxPanel.add(taxField);
      

      // Create a GridLayout manager.
      setLayout(new GridLayout(3, 1));

      // Add the panels to the content pane.
      add(purchasePanel);
	  add(sliderPanel);
      add(taxPanel);
      

      // Pack and display the frame.
      //pack();
      setVisible(true);
   }
	private void buildSliderPanel()
   {
	   // Create the slider.
      slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
      slider.setMajorTickSpacing(1); // Major tick every 1
      slider.setMinorTickSpacing(1);  // Minor tick every 5
      slider.setPaintTicks(true);     // Display tick marks
      slider.setPaintLabels(true);    // Display numbers
      slider.addChangeListener(new SliderListener());
	  
	  taxSlide = new JLabel("Sales Tax Slider:");
	  
	  sliderPanel = new JPanel();
      
	  sliderPanel.add(taxSlide);
	  sliderPanel.add(slider);
	  
	  
   }
   
   
   /**
      Private inner class to handle the change events
      that are generated when the slider is moved.
   */

   private class SliderListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent e)
      {
         String purchaseInput;
		 double salesTax, percent;
         DecimalFormat dollarfmt = new DecimalFormat("$0.00");
		
		 purchaseInput = purchaseAmountField.getText();
         // Get the slider value.
         percent = slider.getValue();

         // get the sales tax percentage
         salesTax = ((Double.parseDouble(purchaseInput) * percent)/100);
		 
         // Store the Fahrenheit temp in its display field.
         taxField.setText(dollarfmt.format(salesTax));
      }
   }

   /*
      The main method creates an instance of the
      class, which displays a window with a slider.
   */

   public static void main(String[] args)
   {
      new TaxCalc();
   }
}