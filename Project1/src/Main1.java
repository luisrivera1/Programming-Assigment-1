
import javax.swing.JFrame;

public class Main1 {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Color Grid");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(400, 400);
 // 
		MyPanel1 myPanel = new MyPanel1();
		myFrame.add(myPanel);

		MyMouseAdapter1 myMouseAdapter = new MyMouseAdapter1();
		myFrame.addMouseListener(myMouseAdapter);

		myFrame.setVisible(true);
	}
}