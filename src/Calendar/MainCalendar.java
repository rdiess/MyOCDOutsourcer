
package Calendar;

import java.awt.BorderLayout; 
import java.awt.Color;  
import java.awt.GridLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.SwingConstants;

import Details.EventDetailWindow;

/**
 * 
 * @author RAy Diess, Jingxiu Hu
 * 
 * This class is responsible for building the GUI
 * of the "main calendar." 
 *
 */
public class MainCalendar extends JFrame {

	public static int returnDate = 0;
	private JButton[] dateButton;
	private JLabel[] dayMark;
	private CalendarBean calendar; 
	private String[] day = {"Sun.","Mon.","Tue.","Wed.", "Thu.","Fri.","Sat."};
	private JButton nextMonth;
	private JButton previousMonth;
	public static int year;
    public static int month;
    public static int date;
	private JLabel mon, years, monChange, yearChange;

	

	public MainCalendar()
	{
		super();
		dayMark = new JLabel[7];
		month = 11;
		year = 2015;
		dateButton = new JButton[42];
		setSize(450,300);
		setTitle("Calendar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(7,7));
		DateButtonListener D =new DateButtonListener();
		for(int i = 0; i < 7; i++)
		{   
			dayMark[i] = new JLabel(day[i]);
			if(i == 0 || i == 6)
			{
				dayMark[i].setForeground(Color.RED);
			}
			dayMark[i].setHorizontalAlignment(SwingConstants.CENTER);
			pCenter.add(dayMark[i]);
		}  
		for(int i = 0;i < 42; i++)   
		{   
			dateButton[i]= new JButton("");  
			if( i % 7 == 0 || i % 7 == 6)
			{
				dateButton[i].setForeground(Color.RED);
			}
			else
			{
				dateButton[i].setForeground(Color.BLUE);
			}

			
			pCenter.add(dateButton[i]); 
		
			
			
			
		}
		add(pCenter,BorderLayout.CENTER);
		calendar = new CalendarBean(); 
		calendar.setYear(year);   
		calendar.setMonth(month);
		String day[] = calendar.getCalendar();
		
		for(int i = 0; i < 42; i++)   
		{   
			
			dateButton[i].setText(day[i]);	
		}
		for(int i = 0; i < dateButton.length; i++)
		{
			dateButton[i].addActionListener(new DateButtonListener());
		}
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new GridLayout(1,6));
		nextMonth = new JButton("Next Month");
		myActionListener myL = new myActionListener();
		nextMonth.addActionListener(myL);
		previousMonth = new JButton("Previous Month");
		previousMonth.addActionListener(myL);
		mon = new JLabel("Month: ");
		years = new JLabel("Year: ");
		monChange = new JLabel();
		monChange.setText("" + month);
		yearChange = new JLabel();
		yearChange.setText("" + year);
		pNorth.add(previousMonth);
		pNorth.add(mon);
		pNorth.add(monChange);
		pNorth.add(years);
		pNorth.add(yearChange);
		pNorth.add(nextMonth);
		add(pNorth, BorderLayout.NORTH);

	}
	

/**
 * this inner class allows the user to cycle through each month
 * and year
 * 
 *
 */
	private class myActionListener implements ActionListener
	{


		public void actionPerformed(ActionEvent e) 
		{
			String command = e.getActionCommand();
			switch(command)
			{
			case "Next Month":
				if(month == 12)
				{
					year = year + 1;
					month = 1;
					calendar.setMonth(month);
					calendar.setYear(year);
				}
				else
				{
					month = month + 1;
					calendar.setMonth(month);
				}
				String day[] = calendar.getCalendar();
				for(int i = 0; i < 42; i++)   
				{   
					dateButton[i].setText(day[i]);   
				}
				monChange.setText("" + calendar.getMonth());
				yearChange.setText("" + calendar.getYear());
				break;

			case "Previous Month":
				if(month == 1)
				{
					year = year - 1;
					month = 12;
					calendar.setMonth(month);
					calendar.setYear(year);
				}
				else
				{
					month = month - 1;
					calendar.setMonth(month);
				}
				String day1[] = calendar.getCalendar();
				for(int i = 0; i < 42; i++)   
				{   
					dateButton[i].setText(day1[i]);   
				}
				monChange.setText("" + calendar.getMonth());
				yearChange.setText("" + calendar.getYear());
				break;

			}
		}
		

		
		
	}
	/**
	 * 
	 * This inner class opens up an Event detail window once
	 * a particular date is clicked
	 *
	 */
	private class DateButtonListener implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e)
		{
			
			if(e.getActionCommand() != null)
			{
				returnDate = Integer.parseInt(e.getActionCommand());
				new EventDetailWindow().setVisible(true);
			}
			else
			{
				returnDate = 0;
				new EventDetailWindow().setVisible(false);
			}
		}
		
	}

	
	
	

	
	
}






