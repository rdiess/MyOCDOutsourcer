package Details;

import java.io.Serializable;
/**
 * 
 * @author Ray Diess, Jingxiu Hu
 * 
 * This class represents a particular day in a particular month
 * in a particular year and holds the values that are entered into
 * the "date detail setup" and "event" windows. 
 */
public class DateObject implements Serializable
{
	private int y;
	private int m;
	private int d;
	private String t;
	private int fhour;
	private int tohour;
	private String l;
	private String de;
	
	public DateObject(int year, int month, int day, String title, int from, int to, String location, String detail)
	{
		y = year;
		m = month;
		d = day;
		t = title;
		fhour = from;
		tohour= to;
		l = location;
		de = detail;
		
	}

	public int getY() {
		return y;
	}

	public int getM() {
		return m;
	}

	public int getD() {
		return d;
	}

	public String getT() {
		return t;
	}

	public int getFhour() {
		return fhour;
	}

	public int getTohour() {
		return tohour;
	}

	public String getL() {
		return l;
	}

	public String getDe() {
		return de;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setM(int m) {
		this.m = m;
	}

	public void setD(int d) {
		this.d = d;
	}

	public void setT(String t) {
		this.t = t;
	}

	public void setFhour(int fhour) {
		this.fhour = fhour;
	}

	public void setTohour(int tohour) {
		this.tohour = tohour;
	}

	public void setL(String l) {
		this.l = l;
	}

	public void setDe(String de) {
		this.de = de;
	}
	
	


}
