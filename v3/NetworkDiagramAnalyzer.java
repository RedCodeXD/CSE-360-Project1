package Project;
import javax.swing.JFrame;


public class NetworkDiagramAnalyzer {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame ("Network Diagram Analyzer");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	      
	
	     GuiPanel panel =new GuiPanel();
	   
	      frame.getContentPane().add(panel);
	   

	      frame.pack();
	      frame.setVisible(true);
	
	}

}
