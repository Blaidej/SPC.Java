import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This applet displays a timed traffic signal.
*/

public class TrafficApplet extends JApplet
{
	// Constants for the traffic signal
	public final int WIDTH = 300;
	public final int HEIGHT = 400;
	public final int X_TRAFFICLIGHT = WIDTH / 3;
	public final int Y_TRAFFICLIGHT = HEIGHT / 7;
	public final int TRAFFICLIGHT_WIDTH = WIDTH / 2;
	public final int TRAFFICLIGHT_HEIGHT = HEIGHT * 3 / 5;
	public final int LIGHT_DIAMETER =
					TRAFFICLIGHT_HEIGHT / 5;
	public final int HOOD_START_ANGLE = 20;
	public final int HOOD_ANGLE_SWEPT = 140;
	public final int X_LIGHTS =
					TRAFFICLIGHT_WIDTH /
					3 + X_TRAFFICLIGHT;
	public final int Y_REDLIGHT =
					TRAFFICLIGHT_HEIGHT /
					10 + Y_TRAFFICLIGHT;
	public final int Y_ORANGELIGHT =
					TRAFFICLIGHT_HEIGHT * 4 /
					10 + Y_TRAFFICLIGHT;
	public final int Y_GREENLIGHT =
					TRAFFICLIGHT_HEIGHT * 7 /
					10 + Y_TRAFFICLIGHT;
	public final int TIME_DELAY = 1000;

   private String status = "green"; // Signal status
   private Timer timer;             // Timer object
   
   /**
		init initialized the timer, and timer listener which keeps our 
		traffic light cycling through it's colors
	*/
    public void init()
    {
		
	   timer = new Timer(TIME_DELAY, new TimerListener());
	   timer.start();
	  
    }
	/**
		paint takes the graphics object enabling the drawing of shapes
		@param g The applet's Graphics object
	*/
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//makes a filled yellow rectangle
		g.setColor(Color.yellow);
		g.fillRect(X_TRAFFICLIGHT, Y_TRAFFICLIGHT, 
		TRAFFICLIGHT_WIDTH, TRAFFICLIGHT_HEIGHT);
		
		//sets the color according to the status set by the timeListener
		//and the repaint, getting the corresponding light to be lit
		if(status == "green" )
		{
		g.setColor(Color.green);
		g.fillOval(X_LIGHTS, Y_GREENLIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER);
		}
		else if(status == "red")
		{
		g.setColor(Color.red);
		g.fillOval(X_LIGHTS, Y_REDLIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER);
		}
		else if(status == "orange")
		{
		g.setColor(Color.orange);
		g.fillOval(X_LIGHTS, Y_ORANGELIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER);
		}
		
		
		/****This is ONE WAY to get the green, red, and orange circle****
		
		g.setColor(Color.green);
		g.drawOval(X_LIGHTS, Y_GREENLIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER);
		
		g.setColor(Color.red);
		g.drawOval(X_LIGHTS, Y_REDLIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER);
		
		g.setColor(Color.orange);
		g.drawOval(X_LIGHTS, Y_ORANGELIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER); */
		
		
		/*This is ANOTHER WAY to get the green, red, and orange circle
		seems like it gets the same results*/
		g.setColor(Color.green);
		g.drawArc(X_LIGHTS, Y_GREENLIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER, 160, 220);
		
		g.setColor(Color.red);
		g.drawArc(X_LIGHTS, Y_REDLIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER, 160, 220);
		
		g.setColor(Color.orange);
		g.drawArc(X_LIGHTS, Y_ORANGELIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER, 160, 220);
		
		
		//This puts the black hoods at the top of the stop light
		g.setColor(Color.black);
		g.drawArc(X_LIGHTS, Y_GREENLIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER, 
		HOOD_START_ANGLE, HOOD_ANGLE_SWEPT);
		
		g.setColor(Color.black);
		g.drawArc(X_LIGHTS, Y_REDLIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER, 
		HOOD_START_ANGLE, HOOD_ANGLE_SWEPT);
		
		g.setColor(Color.black);
		g.drawArc(X_LIGHTS, Y_ORANGELIGHT, LIGHT_DIAMETER, LIGHT_DIAMETER, 
		HOOD_START_ANGLE, HOOD_ANGLE_SWEPT);
		
		
	}
   /**
		Pirvate inner class that handles the Timer object's action events
		setting the status to a specified string.
	*/
	private class TimerListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			
				
			if(status == "red")
			{
				//if status equals red, we want the light to become green
				status = "green";
				repaint();
			}
			else if(status == "green")
			{
				//if status equals green, we want the light to become yellow
				status = "orange";
				repaint();
				
			}
			else if(status == "orange")
			{
				//if status equals yellow, we want the light to become red
				status = "red";
				repaint();
			}
			
			
			
		}
		
		
	}
   
   
}

