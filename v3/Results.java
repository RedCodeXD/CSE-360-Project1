package Project;
import javax.swing.JFrame;


public class Results {

	public static void main(String[] args) {
		
		  JFrame frame = new JFrame ("Network Diagram Analyzer");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	      ResultsPanel panel = new ResultsPanel();

	      frame.getContentPane().add(panel);

	      frame.pack();
	      frame.setVisible(true);
	      
	    
	
	}

}