import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
/**
   This applet demonstrates how the mouse adapter
   classes can be used.
*/

public class PolygonDrawer extends JApplet
{
  
   private int[] xCoords = new int[6];
   private int[] yCoords = new int[6];
   private int clicks = 0;
   
            
   /**
      init method
   */
   
   public void init()
   {
      // Add a mouse listener and a mouse motion listener.
      addMouseListener(new MyMouseListener());
      //addMouseMotionListener(new MyMouseMotionListener());
	  getContentPane().setBackground(Color.red);
   }
   
   /**
      paint method
      @param g The applet's Graphics object.
   */

   public void paint(Graphics g)
   {
	  
      // Call the superclass paint method.
      super.paint(g);
      
      // Set the drawing color.
      g.setColor(Color.black);
      
      // Draw the polygon.
      g.drawPolygon(xCoords, yCoords, 6);
   }
   
   /**
      Mouse listener class
   */

   private class MyMouseListener extends MouseAdapter
   {
      public void mousePressed(MouseEvent e)
      {
         // Get the coordinates of the mouse cursor.
		
        if(clicks < 6)
		{
			xCoords[clicks] = e.getX();
			yCoords[clicks] = e.getY();
			clicks++;
		}
		else{
			repaint();
		}
      }
   }
   
   /**
      Mouse Motion listener class
   */

   
}