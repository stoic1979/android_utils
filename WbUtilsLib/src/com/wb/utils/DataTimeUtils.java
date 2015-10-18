package com.wb.utils;

import java.util.Calendar;
import java.util.Locale;

import android.text.format.DateFormat;

/**
 * 
 * @author Navjot singh
 * @version 1.0
 * @since   2015-06-26
 */
public class DataTimeUtils {

	/**
	 * 
	 * @param date date in long
	 * @return return date in dd-MM-yyyy format
	 */
	public static String getDate(long date) {
		Calendar cal = Calendar.getInstance(Locale.ENGLISH);
		cal.setTimeInMillis(date);
		return DateFormat.format("dd-MM-yyyy", cal).toString();
	}

	/**
	 * 
	 * @param time time in long
	 * @return time in hh:mm a format
	 */
	public static String getTime(long time) {
		Calendar cal = Calendar.getInstance(Locale.ENGLISH);
		cal.setTimeInMillis(time);
		return DateFormat.format("hh:mm a", cal).toString();
	}
	
	/**
	 * 
	 * @param birthdate
	 * @return return the current age from birth date to now
	 */
	public static String getAge(long birthdate){
		Calendar birth = Calendar.getInstance();
		birth.setTimeInMillis( birthdate);
		int year = birth.get(Calendar.YEAR);
		int month = birth.get(Calendar.MONTH);
		int day =birth.get(Calendar.DAY_OF_MONTH);

		Calendar now = Calendar.getInstance();
		int year1 = now.get(Calendar.YEAR);
		int month1 = now.get(Calendar.MONTH);
		int day1 = now.get(Calendar.DAY_OF_MONTH);

		int yearBirth  = year1-year;
		int monthBirth = month1-month;
		int dayBirth   = day1-day;

		return  Integer.toString(yearBirth) + " Years, " + Integer.toString(monthBirth) + " Months, " + Integer.toString(dayBirth)+" Days";
	}
	
	/**
	 * 
	 * @return return current timestamp
	 */
	public static long getTimeInMillis(){
		Calendar calendar_date = Calendar.getInstance();
		int year   = calendar_date.get(Calendar.YEAR);
		int month  = calendar_date.get(Calendar.MONTH);
		int day    = calendar_date.get(Calendar.DAY_OF_MONTH);
		int hour   = calendar_date.get(Calendar.HOUR_OF_DAY);
		int minute = calendar_date.get(Calendar.MINUTE);

		calendar_date.set(year, month, day, hour, minute, 0);
		return  calendar_date.getTimeInMillis();
	}
	
	/**
	 * 
	 * @param hours
	 * @param mins
	 * @return return time in hh:mm:a format
	 */
	public static String getTime(int hours, int mins){
		String timeSet = "";
		if (hours > 12) {
			hours -= 12;
			timeSet = "PM";
		} else if (hours == 0) {
			hours += 12;
			timeSet = "AM";
		} else if (hours == 12)
			timeSet = "PM";
		else
			timeSet = "AM";

		String minutes = "";
		if (mins < 10)
			minutes = "0" + mins;
		else
			minutes = String.valueOf(mins);

		// Append in a StringBuilder
		String aTime = new StringBuilder().append(hours).append(':')
				.append(minutes).append(" ").append(timeSet).toString();

		return aTime;
	}
	
}// DataTimeUtils
