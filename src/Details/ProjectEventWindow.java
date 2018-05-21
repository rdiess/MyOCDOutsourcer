package Details;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 
 * @author Ray Diess, Jingxiu Hu
 *
 *This class is responsible for building the GUI for 
 *a single event and for writing the information entered
 *by the user to the output file "Save Events.txt"
 */
public class ProjectEventWindow extends JFrame
{

	
	private JLabel durationLabel, from, to;
	private JLabel detailLabel;
	private JLabel titleLabel;
	private JLabel locationLabel;
	private JLabel notification;
	private JLabel selectedDate, day, month, year;
	
	private JPanel titleLine;
	private JPanel durationLine;
	private JPanel locationLine;
	private JPanel detailLine;
	private JComboBox fromhour = new JComboBox();
	private JComboBox tohour = new JComboBox();
	private JPanel buttonPanel;
	private JPanel topLine;
	private JButton submit;
	private JButton cancel;
	private JPanel cancelPanel;
	private JPanel notificationPanel;
	private JTextField titleField;

	private JTextField locationField;
	private JTextField detailField;
	private Writer writer;
	DateObject DO;
	DateObject[] save;

	public ProjectEventWindow()
	{
		
		super();
		setSize(500,400);
		setTitle("Project Event Window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new GridLayout(8,1));

		titleField = new JTextField(25);
		locationField = new JTextField(25);
		detailField = new JTextField(25);

		

		
		
		selectedDate = new JLabel("Selected Date: ");
		day = new JLabel("Day: " + Calendar.MainCalendar.returnDate);
		month = new JLabel("Month: " + Calendar.MainCalendar.month);
		year = new JLabel("Year: " + Calendar.MainCalendar.year);	
		topLine = new JPanel();
		topLine.setLayout(new GridLayout(1, 4));
		topLine.add(selectedDate);
		topLine.add(day);
		topLine.add(month);
		topLine.add(year);
		add(topLine);
		
		
		titleLabel = new JLabel("TITLE: ");
		titleLine = new JPanel();
		
		titleLine.add(titleLabel);
		titleField.setText("No title");
		titleLine.add(titleField);
		add(titleLine);
		

		

		durationLabel = new JLabel("Duration: ");
		durationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		from = new JLabel("From: ");
		from.setHorizontalAlignment(SwingConstants.CENTER);
		to = new JLabel("to: ");
		to.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0; i < 24; i++)
		{
			fromhour.addItem(i + "");
		}
		for(int i = 0; i < 24; i++)
		{
			tohour.addItem(i + "");
		}
		durationLine = new JPanel();
		durationLine.setLayout(new GridLayout(1, 5));
		durationLine.add(durationLabel);
		durationLine.add(from);
		durationLine.add(fromhour);
		durationLine.add(to);
		durationLine.add(tohour);
		add(durationLine);

		
		
		locationLabel = new JLabel("Participants: ");
		locationLine = new JPanel();
		locationLine.add(locationLabel);
		locationField.setText("No location");
		locationLine.add(locationField);
		add(locationLine);
		detailLine = new JPanel();
		detailLabel = new JLabel("Description: ");
		detailLine.add(detailLabel);
		detailField.setText("No detail");
		detailLine.add(detailField);
		add(detailLine);
		
		submit = new JButton("Submit");
		cancel = new JButton("Exit");

		submit.addActionListener(new myButtonListener());
		cancel.addActionListener(new myButtonListener());
		
		add(submit);
		add(cancel);
		
		
		buttonPanel=new JPanel();
		buttonPanel.add(submit);
		cancelPanel=new JPanel();
		cancelPanel.add(cancel);
		notification=new JLabel("");
		notificationPanel=new JPanel();
		add(buttonPanel);
		add(cancelPanel);
		add(notification);
		notificationPanel.add(notification);
		add(notificationPanel);
		
		save = new DateObject[100000];
		
		
	}
	
	public void closeFrame()
	{
	    super.dispose();
	}
	/**
	 * 
	 * This inner class is responsible for saving the information entered
	 * by the user into an output file. The date of the event
	 * is also saved
	 *
	 */
	private class myButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			switch(e.getActionCommand())
			{
			case "Submit":
				
				try {
				    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SaveEvents.txt", true)));
				    writer.write(Calendar.MainCalendar.returnDate + "," + Calendar.MainCalendar.month + "," + Calendar.MainCalendar.year + "," + titleField.getText() + "," + locationField.getText() + "," + detailField.getText() + "," + (fromhour.getSelectedIndex()+8) + "," + (tohour.getSelectedIndex()+8) + "\n");;
				} 
				catch (IOException ex) 
				{
				  // report
				}
				finally 
				{
				   try 
				   {
					   writer.close();
				   } 
				   catch (Exception ex) 
				   {
					   /*ignore*/
				   }
				}
				
				titleField.setText("Save successful");
				locationField.setText("Sava successful");
				detailField.setText("Save successfull");

				break;
				
			case "Exit":
				
				closeFrame();
				
				break;
			}
			
		}
		
	}
}