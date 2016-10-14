import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMouseAdapter1 extends MouseAdapter {
<<<<<<< HEAD
    int numbFlags = 0;
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
                  System.out.println(myPanel.mouseDownGridX+" "+myPanel.mouseDownGridY);
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
                            		numbFlags = numbFlags - 1;
                            	 }
                            	 else
                            	 { 
                            		 if (numbFlags > 9)
                            		 {
                            			 newColor = Color.WHITE;
                            		 }
                            		 else
                            		 {
                            			 newColor = Color.RED;
                            			 numbFlags = numbFlags + 1;
                            		 }
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
=======
	
	    static public MinesPosition Mines = new MinesPosition(10);
	 
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
	            MyPanel1 Panel = (MyPanel1) myFrame.getContentPane().getComponent(0);
	            Insets myInsets = myFrame.getInsets();
	            int x1 = myInsets.left;
	            int y1 = myInsets.top;
	            e.translatePoint(-x1, -y1);
	            int x = e.getX();
	            int y = e.getY();
	            Panel.x = x;
	            Panel.y = y;
	            Panel.mouseDownGridX = Panel.getGridX(x, y);
	            Panel.mouseDownGridY = Panel.getGridY(x, y);

	            Panel.repaint();
	            
	            break;
	            
	        case 3:        //Right mouse button
	        	
	            Component c2 = e.getComponent();
	            while (!(c2 instanceof JFrame)) {
	                c2 = c2.getParent();
	                if (c2 == null) {
	                    return;
	                }
	            }
	        	
	            JFrame myFrame2 = (JFrame) c2;
	            MyPanel1 Panel2 = (MyPanel1) myFrame2.getContentPane().getComponent(0);
	            Insets myInsets2 = myFrame2.getInsets();
	            int x3 = myInsets2.left;
	            int y3 = myInsets2.top;
	            e.translatePoint(-x3, -y3);
	            int x2 = e.getX();
	            int y2 = e.getY();
	            Panel2.x = x2;
	            Panel2.y = y2;
	            Panel2.mouseDownGridX = Panel2.getGridX(x2, y2);
	            Panel2.mouseDownGridY = Panel2.getGridY(x2, y2);

	            Panel2.repaint();
	        	
	            break;
	            
	        default:    //Some other button (2 = Middle mouse button, etc.)
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
	            MyPanel1 Panel = (MyPanel1) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
	            Insets myInsets = myFrame.getInsets();
	            int x1 = myInsets.left;
	            int y1 = myInsets.top;
	            e.translatePoint(-x1, -y1);
	            int x = e.getX();
	            int y = e.getY();
	            Panel.x = x;
	            Panel.y = y;
	            int gridX = Panel.getGridX(x, y);
	            int gridY = Panel.getGridY(x, y);
	            
	            if(gridX >= 0 && gridX <= 8 && gridY >= 0 && gridY <= 8){
	            	
	            	
	            	
	            	 if(Mines.neighboringMines(gridX, gridY)){
	            		
	            		// Count number of mines around click.
	            		 
	            		int counter = Mines.minesNearbyCounter(gridX, gridY);
	            		
	            		
	            		for(int i = 0; i < 10; i++){
	            			
	            			
	            			
	            		}
	            		 
	            		Color newColor = Color.GRAY;
	            		Panel.colorArray[gridX][gridY] = newColor;
	            		Panel.minesAround[gridX][gridY] = counter;
		            	Panel.repaint();
		            	
		            	// Numbers should be shown here.
	            		
	            	} 
	            	
	            	// Paints grid as gray when clicked on an empty spot.
	            	
	            	 else if(!Mines.compareSelec(gridX, gridY)){
		        		
	            		 Panel.revealAdjacent(gridX, gridY);
		        			
	            	 }

	            	
	            	// Paints grid as black when clicked on a mine.
	            	
	            	if(Mines.compareSelec(gridX, gridY)){
	            		
	            		Color newColor = Color.BLACK;
	            		Panel.colorArray[gridX][gridY] = newColor;
		            	Panel.repaint();
		            	///
		            	JOptionPane.showMessageDialog(myFrame,
		            		    "Sorry, but you clicked on a mine.",
		            		    "You lost!",
		            		    JOptionPane.ERROR_MESSAGE);
		            	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            		
	            	}
	            	
	            	
	            }
	              
	            break; 
	            
	        case 3:        //Right mouse button
	        	
	        	 Component c2 = e.getComponent();
		            while (!(c2 instanceof JFrame)) {
		                c2 = c2.getParent();
		                if (c2 == null) {
		                    return;
		                }
		            }
		        	
		            JFrame myFrame2 = (JFrame) c2;
		            MyPanel1 Panel2 = (MyPanel1) myFrame2.getContentPane().getComponent(0);
		            Insets myInsets2 = myFrame2.getInsets();
		            int x3 = myInsets2.left;
		            int y3 = myInsets2.top;
		            e.translatePoint(-x3, -y3);
		            int x2 = e.getX();
		            int y2 = e.getY();
		            Panel2.x = x2;
		            Panel2.y = y2;
		            Panel2.mouseDownGridX = Panel2.getGridX(x2, y2);
		            Panel2.mouseDownGridY = Panel2.getGridY(x2, y2);
		            int gridX2 = Panel2.getGridX(x2, y2);
		            int gridY2 = Panel2.getGridY(x2, y2);

		            Panel2.repaint();
		            
		            // Toggles red flag.          
		            
		            if(gridX2 >= 0 && gridX2 <= 8 && gridY2 >= 0 && gridY2 <= 8) {
		            		
		            		if(Panel2.colorArray[gridX2][gridY2].equals(Color.WHITE)){
		            	
			            		Panel2.colorArray[gridX2][gridY2] = Color.RED;
				            	Panel2.repaint();
			            	
		            			}
		            		
		            		else if(Panel2.colorArray[gridX2][gridY2].equals(Color.BLACK) || Panel2.colorArray[gridX2][gridY2].equals(Color.GRAY) || Panel2.colorArray[gridX2][gridY2].equals(Color.YELLOW)){
			            			
			            			// Do nothing.
				            	
			            			}
		            		
				            		else {
							            	
						            		Panel2.colorArray[gridX2][gridY2] = Color.WHITE;
							            	Panel2.repaint();
						            	
					            			}
			            	
		            		}
		            		
		            
	        	
	            break;
	            
	        default:    //Some other button (2 = Middle mouse button, etc.)
	            break;
	            
	        }
	    }
	    
	   //Method to put the array in the main class
	    
	    public void MinesArray(){
	    	
			Mines.ScatterMineCoord();
	    	
	    }

		public MinesPosition getMines() {
			return Mines;
		}

		public void setMines(MinesPosition mines) {
			Mines = mines;
		}
	    
	    

>>>>>>> origin/master
}