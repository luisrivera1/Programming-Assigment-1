import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter1 extends MouseAdapter {
    private Random generator = new Random();
 //  Coordinates b = new Coordinates(3,2);
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
        case 1:        //Left mouse button
            Component c = e.getComponent();
            while (!(c instanceof JFrame)) {
                c = c.getParent();
                if (c == null) {
                    return;
                }
            }
            JFrame myFrame = (JFrame) c;
            MyPanel1 myPanel = (MyPanel1) myFrame.getContentPane().getComponent(0);
            Insets myInsets = myFrame.getInsets();
            int x1 = myInsets.left;
            int y1 = myInsets.top;
            e.translatePoint(-x1, -y1);
            int x = e.getX();
            int y = e.getY();
            myPanel.x = x;
            myPanel.y = y;
            myPanel.mouseDownGridX = myPanel.getGridX(x, y);
            myPanel.mouseDownGridY = myPanel.getGridY(x, y);
            myPanel.repaint();
            break;
        case 3:        //Right mouse button
        	Component d = e.getComponent();
            while (!(d instanceof JFrame)) {
                d = d.getParent();
                if (d == null) {
                    return;
                }
            }
            JFrame myFrame2 = (JFrame) d;
            MyPanel1 myPanel2 = (MyPanel1) myFrame2.getContentPane().getComponent(0);
            Insets myInsets2 = myFrame2.getInsets();
            int x_1 = myInsets2.left;
            int y_1 = myInsets2.top;
            e.translatePoint(-x_1, -y_1);
            int x_mi = e.getX();
            int y_mi = e.getY();
            myPanel2.x = x_mi;
            myPanel2.y = y_mi;
            myPanel2.mouseDownGridX = myPanel2.getGridX(x_mi, y_mi);
            myPanel2.mouseDownGridY = myPanel2.getGridY(x_mi, y_mi);
            myPanel2.repaint();
            break;
        default:    //Some other button (2 = Middle mouse button, etc.)
            //Do nothing
            break;
        }
    }
    public void mouseReleased(MouseEvent e) {
        switch (e.getButton()) {
        case 1:        //Left mouse button
            Component c = e.getComponent();
            while (!(c instanceof JFrame)) {
                c = c.getParent();
                if (c == null) {
                    return;
                }
            }
            JFrame myFrame = (JFrame)c;
            MyPanel1 myPanel = (MyPanel1) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
            Insets myInsets = myFrame.getInsets();
            int x1 = myInsets.left;
            int y1 = myInsets.top;
            e.translatePoint(-x1, -y1);
            int x = e.getX();
            int y = e.getY();
            myPanel.x = x;
            myPanel.y = y;
            int gridX = myPanel.getGridX(x, y);
            int gridY = myPanel.getGridY(x, y);
            if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
                //Had pressed outside
                //Do nothing
            } else {
                if ((gridX == -1) || (gridY == -1)) {
                    //Is releasing outside
                    //Do nothing
                } else {
                            //On the grid other than on the left column and on the top row:
                            Color newColor = null;
                            switch (generator.nextInt(1)) {
                            case 0:
                                newColor = Color.LIGHT_GRAY;
                                if (myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.RED)){
                            		newColor = Color.RED;}
                                break;
                  
                            }
                            myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
                            myPanel.repaint();
               
                }
                    }
                
            
            myPanel.repaint();
            break;
        case 3:        //Right mouse button
        	 Component d = e.getComponent();
             while (!(d instanceof JFrame)) {
                 d = d.getParent();
                 if (d == null) {
                     return;
                 }
             }
             JFrame myFrame2 = (JFrame)d;
             MyPanel1 myPanel2 = (MyPanel1) myFrame2.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
             Insets myInsets2 = myFrame2.getInsets();
             int x_1 = myInsets2.left;
             int y_1 = myInsets2.top;
             e.translatePoint(-x_1, -y_1);
             int x_mi = e.getX();
             int y_mi = e.getY();
             myPanel2.x = x_mi;
             myPanel2.y = y_mi;
             int grid_X = myPanel2.getGridX(x_mi, y_mi);
             int grid_Y = myPanel2.getGridY(x_mi, y_mi);
             if ((myPanel2.mouseDownGridX == -1) || (myPanel2.mouseDownGridY == -1)) {
                 //Had pressed outside
                 //Do nothing
             } else {
                 if ((grid_X == -1) || (grid_Y == -1)) {
                     //Is releasing outside
                     //Do nothing
                 } else { 
                             Color newColor = null;
                             switch (generator.nextInt(1)) {
                             case 0:
                            	 if (myPanel2.colorArray[myPanel2.mouseDownGridX][myPanel2.mouseDownGridY].equals(Color.RED)){
                            		newColor = Color.WHITE; 
                            	 }
                            	 else
                            	 { 
                                 newColor = Color.RED;
                            	 }
                                 if (myPanel2.colorArray[myPanel2.mouseDownGridX][myPanel2.mouseDownGridY].equals(Color.LIGHT_GRAY)){
                             		newColor = Color.LIGHT_GRAY;}
                                 break;
 
                             }
                             myPanel2.colorArray[myPanel2.mouseDownGridX][myPanel2.mouseDownGridY] = newColor;
                             myPanel2.repaint();
                
                 }
                     }
                 
             
             myPanel2.repaint();
        	
        	
            break;
        default:    //Some other button (2 = Middle mouse button, etc.)
            //Do nothing
            break;
        }
    }
}
