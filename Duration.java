package Project;
import javax.swing.JFrame;

public class Duration {

public static void main(String[] args) {
		
		  JFrame frame = new JFrame ("Network Diagram Analyzer");
	      frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
	      DurationChangingPanel panel =new DurationChangingPanel();
	      frame.getContentPane().add(panel);
	      frame.pack();
	      frame.setVisible(true);
	      
	}
}
