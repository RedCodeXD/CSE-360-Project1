import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiPanel extends JPanel {
	
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
	
public	GuiPanel () {
	

	
	nameLabel = new JLabel("ENTER DATA:");
	
	activityLabel = new JLabel("Activity Name");
	
	durationLabel = new JLabel("Duration");
	
	dependencyLabel = new JLabel("Dependencies");
	
	warningLabel = new JLabel("Click 'OK' once all activities have been added.");
	
	activityTextField = new JTextField(10);
	
	durationTextField = new JTextField(3);
	
	dependencyTextField = new JTextField(10);
	
	
	addButton = new JButton ("Add");

	
	commandButton = new JButton ("OK");

	
	add(nameLabel);
	add(activityLabel);
	add(activityTextField);
	add(durationLabel);
	add(durationTextField);
	add(dependencyLabel);
	add(dependencyTextField);
	add(addButton);
	add(warningLabel);
	add(commandButton);
	
	setBackground (Color.LIGHT_GRAY);
	setPreferredSize (new Dimension(150, 250));
	addButton.addActionListener(new ButtonListener());
	commandButton.addActionListener(new ButtonListener());	
}
private class ButtonListener implements ActionListener
{
 public void actionPerformed (ActionEvent event)
 	{
	 if(event.getSource() == commandButton) {
		  JFrame frame = new JFrame ("Network Diagram Analyzer");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	     ResultsPanel panel = new ResultsPanel();
	   
	      frame.getContentPane().add(panel);

	      frame.pack();
	      frame.setVisible(true);
	 }
	 
	 else if (event.getSource() == addButton) {
			String activity = activityTextField.getText();
			String duration = durationTextField.getText();
			int intDuration = Integer.parseInt(duration);

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
