package Project;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;   

import javax.swing.*;



public class ResultsPanel extends JPanel  {
	
	String criticalPaths;
	String pathsListString;
	ArrayList<Occurrence> list;
	ArrayList<pathNode> pathList  ;
	
	private int count;
	
	private JLabel nameLabel2;
	private JLabel activityLabel;
	private JLabel durationLabel;
	private JLabel textFileLabel;

	private JTextArea results;
	private JTextArea activityTextField;
	private JTextArea durationTextField;
	
	private JTextField textFileTextField;
	
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane2;
	private JScrollPane scrollPane3;
	
	private JButton criticalButton;
	private JButton resetButton;
	private JButton exitButton;
	private JButton changeDurationButton;
	private JButton printButton;
	
	
	
	
public	ResultsPanel (boolean isDurationChange) {
	if(isDurationChange == true) { Functionality.clearPaths(); }
	criticalPaths = "Critical Path(s):";
	count = 0;
	list = Functionality.getArrayList();
	
	
	JPanel flow1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel flow2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel flow3Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	JPanel gridPanel1 = new JPanel (new GridLayout(1,1));
	JPanel gridPanel2 = new JPanel (new GridLayout(1,1));
	JPanel gridPanel3 = new JPanel (new GridLayout(1,1));
	

	results = new JTextArea(null,10,40);
	results.setFont(new Font(null, Font.PLAIN, 14));
	scrollPane1 = new JScrollPane(results);
	scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	results.setEditable(false);
	
	
	Functionality.getPaths(list, null, "");
	pathList = Functionality.getPathList();

	
	int maxDuration = pathList.get(0).duration;
	
    pathsListString = "List of All Paths: ";
    
	if(pathList.isEmpty()) {
		JOptionPane.showMessageDialog(null, "There are cycle paths in the graph! Please click Reset!");
		results.setText("There are cycle paths in the graph! Please Click Reset!");
	}
	else{for(int i=0; i<pathList.size(); i++) {
		boolean flagCheck = false;
		if(maxDuration <= pathList.get(i).duration) {
			maxDuration = pathList.get(i).duration;
			criticalPaths = criticalPaths + "\n" + pathList.get(i).path + " " + maxDuration ;
		}

	
	if(flagCheck == false) {
	pathsListString = pathsListString +"\n" + pathList.get(i).path + "  " + pathList.get(i).duration+ "\t";
	}
	}
	results.setText(pathsListString);// + "\n\n" + criticalPaths);
	}
	

	nameLabel2 = new JLabel("USER INPUT(S)");

	activityLabel = new JLabel("Activity Name");

	durationLabel = new JLabel("Duration");

	textFileLabel = new JLabel("Output Name");
	
	activityTextField = new JTextArea(5,5);
	scrollPane2 = new JScrollPane(activityTextField);
	scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	activityTextField.setText(Functionality.listOfNames(list));
	activityTextField.setEditable(false);
	
	
	durationTextField = new JTextArea(5,5);
	scrollPane3 = new JScrollPane(durationTextField);
	scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	durationTextField.setText(Functionality.listOfDurations(list));
	durationTextField.setEditable(false);
	
	textFileTextField = new JTextField(10);
	
	criticalButton = new JButton ("Critical/All Path(s)");

	changeDurationButton = new JButton ("Change Duration");
	
	resetButton = new JButton ("Reset");

	exitButton = new JButton ("Exit");
	
	printButton = new JButton ("Print");

	
	flow1Panel.add(scrollPane1);
	flow2Panel.add(nameLabel2);
	flow2Panel.add(activityLabel);
	flow2Panel.add(scrollPane2);
	flow2Panel.add(durationLabel);
	flow2Panel.add(scrollPane3);
	flow2Panel.add(textFileLabel);
	flow2Panel.add(textFileTextField);
	flow3Panel.add(criticalButton);
	flow3Panel.add(changeDurationButton);
	flow3Panel.add(resetButton);
	flow3Panel.add(exitButton);
	flow3Panel.add(printButton);
	
	gridPanel1.add(flow1Panel);
	gridPanel2.add(flow2Panel);
	gridPanel3.add(flow3Panel);
	
	
	add(gridPanel1, BorderLayout.NORTH);
	add(gridPanel2, BorderLayout.CENTER);
	add(gridPanel3, BorderLayout.SOUTH);
	
	setBackground (Color.LIGHT_GRAY);
	setPreferredSize (new Dimension(600, 350));
	criticalButton.addActionListener(new ButtonListener());
	resetButton.addActionListener(new ButtonListener());
	exitButton.addActionListener(new ButtonListener());	
	changeDurationButton.addActionListener(new ButtonListener());
	printButton.addActionListener(new ButtonListener());
	
}
private class ButtonListener implements ActionListener
{
 public void actionPerformed (ActionEvent event)
 	{

	 
	 JFrame frame = new JFrame ("Network Diagram Analyzer");
     frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
     GuiPanel panel = new GuiPanel();
     frame.getContentPane().add(panel);
     frame.pack();
      
      JFrame frame2 = new JFrame ("Network Diagram Analyzer");
      frame2.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
      DurationChangingPanel panel2 =new DurationChangingPanel();
      frame2.getContentPane().add(panel2);
      frame2.pack();
     
	 if(event.getSource() == criticalButton) {
		 count++;
		 if((count%2)==0) {
			 results.setText(pathsListString);

		 }
		 else {
			 results.setText(criticalPaths);
		 }   
		 }
	 
	 if(event.getSource() == resetButton) {
		 activityTextField.setText("");
		 durationTextField.setText("");
		 results.setText("");
		 Functionality.clearArrays();

	     frame.setVisible(true);

	 }
	 
	 if(event.getSource() == changeDurationButton) {

	      frame2.setVisible(true);
	      frame.dispose();
	      results.setText(" ");
	      Functionality.clearPaths();
	      
	 }
	 
	 if(event.getSource() == printButton) {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date date = new Date();  
		 try {
			PrintWriter outputfile = new PrintWriter(textFileTextField.getText()+ ".txt");
			 outputfile.println("Title: " + textFileTextField.getText() );
			 outputfile.println("Date and Time of Creation: " + formatter.format(date)+ "\n");
			 outputfile.println("List of All Activities and Durations: ");
			 outputfile.println(Functionality.listOfNames(list));
			 outputfile.println(Functionality.listOfDurations(list)+ "\n");
			 outputfile.println(pathsListString);
			 outputfile.close();
			 textFileTextField.setText("");
			 JOptionPane.showMessageDialog(null, "Printing has been completed!");
		 } catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot print! Please try again!");
		}
		 
	 }
	 
	 if(event.getSource() == exitButton) {System.exit(0);}

 	}
 
}

}




