package Project;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class GuiPanel extends JPanel {
	
	public int intDuration;
	public boolean durationFlag;
	public boolean flag1;
	public int count1 = 0, count2 = 0;
	
	private JLabel nameLabel;
	private JLabel activityLabel;
	private JLabel durationLabel;
	private JLabel dependencyLabel;
	private JLabel warningLabel;
	
	private JTextField activityTextField;
	private JTextField durationTextField;
	private JTextField dependencyTextField;
	
	private JButton addButton;
	private JButton commandButton;
	private JButton helpButton;
	private JButton aboutButton;
	private JButton resetButton;
	
public	GuiPanel () {
	
	JPanel flow1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel flow2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel flow3Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel flow4Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel flow5Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	JPanel gridPanel1 = new JPanel (new GridLayout(1,1));
	JPanel gridPanel2 = new JPanel (new GridLayout(1,1));
	JPanel gridPanel3 = new JPanel (new GridLayout(1,1));
	JPanel gridPanel3n = new JPanel (new GridLayout(1,1));
	JPanel gridPanel3c = new JPanel (new GridLayout(1,1));
	JPanel gridPanel3s = new JPanel (new GridLayout(1,1));
	
	Font font = new Font(null, Font.PLAIN, 18);
	
	nameLabel = new JLabel("NETWORK DIAGRAM ANALYZER");
	nameLabel.setFont(new Font(null, Font.PLAIN, 30));
	
	activityLabel = new JLabel("Activity Name:");
	activityLabel.setFont(font);
	
	durationLabel = new JLabel("Duration:");
	durationLabel.setFont(font);
	
	dependencyLabel = new JLabel("Dependencies:");
	dependencyLabel.setFont(font);
	
	warningLabel = new JLabel("Click 'Process' once all activities have been added.");
	warningLabel.setFont(new Font(null, Font.PLAIN, 25));
	
	activityTextField = new JTextField(10);
	activityTextField.setFont(font);
	
	durationTextField = new JTextField(3);
	durationTextField.setFont(font);
	
	dependencyTextField = new JTextField(10);
	dependencyTextField.setFont(font);
	
	helpButton = new JButton("Help");
	helpButton.setFont(font);

	aboutButton = new JButton("About");
	aboutButton.setFont(font);
	
	addButton = new JButton ("Add");
	addButton.setFont(font);
	
	resetButton = new JButton("Reset");
	resetButton.setFont(font);
	
	commandButton = new JButton ("Process");
	commandButton.setFont(font);
	
	flow1Panel.add(nameLabel);
	
	flow2Panel.add(activityLabel);
	flow2Panel.add(activityTextField);
	flow2Panel.add(durationLabel);
	flow2Panel.add(durationTextField);
	flow2Panel.add(dependencyLabel);
	flow2Panel.add(dependencyTextField);
	
	flow3Panel.add(addButton);
	flow3Panel.add(commandButton);
	flow3Panel.add(resetButton);
	
	flow4Panel.add(warningLabel);
	
	flow5Panel.add(helpButton);
	flow5Panel.add(aboutButton);
	
	gridPanel1.add(flow1Panel);
	gridPanel2.add(flow2Panel);
	
	gridPanel3.add(gridPanel3n);
	gridPanel3.add(gridPanel3c);
	gridPanel3.add(gridPanel3s);
	
	add(gridPanel1, BorderLayout.NORTH);
	add(gridPanel2, BorderLayout.CENTER);
	
	add(flow3Panel, BorderLayout.NORTH);
	add(flow4Panel, BorderLayout.CENTER);
	add(flow5Panel, BorderLayout.SOUTH);
	
	add(gridPanel3, BorderLayout.SOUTH);
	
	
	setBackground (Color.LIGHT_GRAY);
	setPreferredSize (new Dimension(700, 300));
	addButton.addActionListener(new ButtonListener());
	commandButton.addActionListener(new ButtonListener());	
	helpButton.addActionListener(new ButtonListener());
	aboutButton.addActionListener(new ButtonListener());
	resetButton.addActionListener(new ButtonListener());

}

private class ButtonListener implements ActionListener
{
	
public void actionPerformed (ActionEvent event)
 	{
     
	 ArrayList<Occurrence> list = Functionality.getArrayList();//List for Cycle path check
	 ArrayList<String> parents = new ArrayList<String>();//List of current Activities
	 ArrayList<String> children = new ArrayList<String>();//List of current Dependencies.
	 
	 
	 if(event.getSource() == helpButton) {
		 JOptionPane.showMessageDialog(null, "Help: The Program is Designed to Create a PERT chart. \nFill in the boxes for your activity's name, the duration, and its dependences if applicable. Click 'Add' to add your activity to the path. Click 'Process' once you have input every activity. Your output will be displayed in a separate screen. \nClick 'About' to learn more about the team and purpose of this application. \nMake sure that the Input for Activity name is a String. \nMake sure that the Input for Duration is an Integer. \nMake sure that the dependency for the others matches the cases and string that you entered before. Use commas to seperate each dependency (do not use spaces). \nThank you for using the Network Diagram Analyzer!");
	 }
	 if(event.getSource() == aboutButton) {
		 JOptionPane.showMessageDialog(null, "About: The program is Designed to Create a PERT chart. \nThe project is designed to display a finished activity where it finds the base activity and all its predecessors.\nTeam Members are: Travis L, Nhut T, Harrison B, and Samdeet K. Travis and Harrison are in charge of Functionality code. Nhut and Samdeet are in charge of GUI and its connection to functionality.");
	 }
	 if(event.getSource() == commandButton) {
		 if(list.size() == 0) {
			 JOptionPane.showMessageDialog(null, "Error: No Nodes in the List.");
		 }
		 else {
		 for(int i=0;i<list.size();i++){
				parents.add(list.get(i).getName());
				if(list.get(i).getParents() != null) {
				for(int j=0;j<list.get(i).getParents().length;j++) {
					children.add(list.get(i).getParents()[j]);
				}
				}

			}
		 int j =0;
		 for(int i = 0;i<parents.size();i++) {
			 
			 for(j =0;j<children.size();j++) {
				 if(parents.get(i).equalsIgnoreCase(children.get(j)))
					 break;
			 }
				 if(j==children.size()) {
					 count2++;
				 }
			 }

		 if(count2>=2||parents.size()==1) {
			 JOptionPane.showMessageDialog(null, "There are floating nodes in the graph. Please click 'Reset'!");
		 }
		 else {
		 
		  JFrame frame1 = new JFrame ("Network Diagram Analyzer");
	      frame1.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	      Functionality.setArrayList(list);
	      ResultsPanel panel1 = new ResultsPanel(false);
	      frame1.getContentPane().add(panel1);
	      frame1.pack();
	      frame1.setVisible(true);
	 }
		 }}
	 
	 if (event.getSource() == resetButton) {
		 activityTextField.setText("");
		 durationTextField.setText("");
		 dependencyTextField.setText("");
		 parents.clear();
		 children.clear();
		 count2 = 0;
		 
		 Functionality.clearArrays();
		 
	 }
	 
	 
	 else if (event.getSource() == addButton) {
		 
		 	durationFlag = false;
			String duration = durationTextField.getText();
			
			try { intDuration = Integer.parseInt(duration); }
			catch (NumberFormatException ex){ 
				durationFlag = true;
				JOptionPane.showMessageDialog(null, "Please enter an integer value for duration.");
			}
			
			if (durationFlag == false) {
				String activity = activityTextField.getText();
				String dependencies = dependencyTextField.getText();
				String[] splitDependencies = dependencies.split(",");


			Functionality.makeOccurrence(activity, intDuration, splitDependencies);

			
			activityTextField.setText("");
			durationTextField.setText("");
			dependencyTextField.setText("");
						
 	}
}
}
}
}
