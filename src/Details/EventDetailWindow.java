package Details;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Calendar.CalendarBean;
import Calendar.MainCalendar;

/**
 * 
 * @author Jingxiu Hu, Ray Diess
 * 
 * This class is responsible for creating the GUI for the "Date Detail"
 * setup window.
 *
 */
public class EventDetailWindow extends JFrame
{

	public static String time;
	private JTextField timeField, titleField;
	private JTextField locationField;
	private JTextField detailField;
	private JLabel head, timeLabel, titleLabel;
	private JLabel locationLabel, detailLabel;
	private JPanel cPanel, sPanel;
	private JButton editButton;
	DateObject myDO;
	

	public EventDetailWindow()
	{
		super();
		setSize(400,300);
		setTitle("Event Detail Setup Window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);	
		titleLabel = new JLabel();
		timeLabel = new JLabel();
		locationLabel = new JLabel();
		detailLabel = new JLabel();
		head = new JLabel();
		Font myFont = new Font("Serif", Font.BOLD, 24);
		head.setFont(myFont);		
		titleField = new JTextField();
		timeField = new JTextField();
		locationField = new JTextField();
		detailField = new JTextField();
		head.setText("Date Detail Setup");
		head.setHorizontalAlignment(SwingConstants.CENTER);
		add(head, BorderLayout.NORTH);
		cPanel = new JPanel();
		cPanel.setLayout(new GridLayout(4, 2));
		timeLabel.setText("Time: ");
		timeLabel.setFont(myFont);	
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cPanel.add(timeLabel);
		cPanel.add(timeField);
		timeField.setEditable(false);
		
		time = ""+ Calendar.MainCalendar.year +"-" + Calendar.MainCalendar.month + "-" + Calendar.MainCalendar.returnDate;
		timeField.setText(time);
		
		titleLabel.setText("Event: ");
		titleLabel.setFont(myFont);	
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cPanel.add(titleLabel);
		cPanel.add(titleField);	
		locationLabel.setText("Location: ");
		locationLabel.setFont(myFont);
		locationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cPanel.add(locationLabel);
		cPanel.add(locationField);
		detailLabel.setText("Detail: ");
		detailLabel.setFont(myFont);	
		detailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cPanel.add(detailLabel);
		cPanel.add(detailField);
		add(cPanel, BorderLayout.CENTER);
		sPanel = new JPanel();
		editButton = new JButton("Edit");
		editButton.addActionListener(new editListener());
		add(editButton, BorderLayout.SOUTH);
		sPanel.add(editButton);
		add(sPanel, BorderLayout.SOUTH);
		
		
		
	
		
	}	
	/**
	 * 
	 * This inner class creates a new project event window
	 * when the user clicks on "edit".
	 *
	 */
	private class editListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			new ProjectEventWindow().setVisible(true);
			
		}
		
	}
		
}
	
	

