
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main1 {
	public static void main(String[] args) {
		
		JFrame myFrame = new JFrame("MineSweeper");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(400, 425);
		myFrame.setLayout(new BorderLayout());
		
		
		MyPanel1 myPanel = new MyPanel1();
		myFrame.add(myPanel);

		MyMouseAdapter1 myMouseAdapter = new MyMouseAdapter1();
		myFrame.addMouseListener(myMouseAdapter);
		
		myFrame.setVisible(true);
	}
}