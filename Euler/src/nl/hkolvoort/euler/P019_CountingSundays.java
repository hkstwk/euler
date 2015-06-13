package nl.hkolvoort.euler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Harm
 * @date 13-June-2015
 * 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 */
public class P019_CountingSundays {

	public static final String getDayOfWeek(String dateString){
		SimpleDateFormat format1=new SimpleDateFormat("d/M/yyyy");
		Date dt1 = null;
		try {
			dt1 = format1.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateFormat format2=new SimpleDateFormat("EEEE"); 
		return format2.format(dt1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(P019_CountingSundays.getDayOfWeek("1/1/1900"));
		
		Integer sundays = 0;
		for (int year = 1901; year < 2001; year++){
			for (int month = 1; month <=12; month++){
				String date = "1/" + month + "/" + year;
				System.out.println(P019_CountingSundays.getDayOfWeek(date));
				if (P019_CountingSundays.getDayOfWeek(date).equals("zondag")){
					sundays += 1;
				}
			}
		}
		System.out.println("Number of Sundays on first day of month in 20th Century is " + sundays);
	}

}
