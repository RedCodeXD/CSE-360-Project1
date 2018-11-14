package Project;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DurationChangingPanel extends JPanel {

	private boolean durationFlag;
	private int intDuration;
	
	private JLabel activityLabel;
	private JLabel durationLabel;
	
	private JTextField activityTextField;
	private JTextField durationTextField;
	
	private JButton changeButton;
	private JButton doneButton;
	
	public DurationChangingPanel() {
		
		activityLabel = new JLabel("Activity Name");
		
		durationLabel = new JLabel("Duration");
		
		activityTextField = new JTextField(10);
		
		durationTextField = new JTextField(3);
		
		changeButton = new JButton("Change");

		doneButton = new JButton("Done");
		
		add(activityLabel);
		add(activityTextField);
		add(durationLabel);
		add(durationTextField);
		add(changeButton);
		add(doneButton);
		
		setBackground (Color.LIGHT_GRAY);
		setPreferredSize (new Dimension(500, 100));
		changeButton.addActionListener(new ButtonListener());
		doneButton.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener
	{
	public void actionPerformed (ActionEvent event)
	 	{
		 ArrayList<Occurrence> list = Functionality.getArrayList();
		 String activity = activityTextField.getText();
		 String duration = durationTextField.getText();
		 if(event.getSource() == changeButton) {
			 
			 try { intDuration = Integer.parseInt(duration); }
				catch (NumberFormatException ex){ 
					durationFlag = true;
					JOptionPane.showMessageDialog(null, "Please enter an integer value for duration.");
				}
			 for(int i = 0; i<list.size();i++) {
				 if(activity.equalsIgnoreCase(list.get(i).getName())) {
					 list.get(i).setDuration(intDuration);
					 break;
				 }
				 if(i == list.size()-1) {
					 JOptionPane.showMessageDialog(null, "Cannot find activity!");
				 }
			 }
				activityTextField.setText("");
				durationTextField.setText("");
		 }
		 
		 if(event.getSource() == doneButton) {
			  Functionality.setArrayList(list);
			  JFrame frame = new JFrame ("Network Diagram Analyzer");
		      frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		      ResultsPanel panel = new ResultsPanel(true);
		   
		      frame.getContentPane().add(panel);
		      frame.pack();
		      frame.setVisible(true);
		      

		 }
	 	}
	
}

	}

