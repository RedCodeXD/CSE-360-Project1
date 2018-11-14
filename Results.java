package Project;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class Results {

	public static void main(String[] args) {
		
		  JFrame frame = new JFrame ("Network Diagram Analyzer");
	      frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

	      ResultsPanel panel = new ResultsPanel(false);

	      frame.getContentPane().add(panel);

	      frame.pack();
	      frame.setVisible(true);
	   
	}
	
	

}