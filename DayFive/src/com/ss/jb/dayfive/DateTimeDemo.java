package com.ss.jb.dayfive;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTimeDemo
{

	public static void main(String[] args)
	{
		DateTimeDemo dtd = new DateTimeDemo();
		
		//dtd.countMonthlyDays(1999);
		dtd.listMondays(7);
	}
	
	/***
	 * Lists the number of days in each month of the specified year
	 * @param year
	 */
	public void countMonthlyDays(int year)
	{
		YearMonth month;
		int daysInMonth;
		String monthName;
		
		for (int i = 1; i < 13; i++)
		{
			month = YearMonth.of(year, i);
			daysInMonth = month.lengthOfMonth();
			monthName = Month.of(i).getDisplayName(TextStyle.FULL, Locale.US);
			System.out.printf("In the year %d, the month of %s has %d days\n", year, monthName, daysInMonth);
		}
	}
	
	/***
	 * Returns the date of the Thursday immediately before the date represented by year, month, dayOfMonth
	 * @param year The year of the date
	 * @param month The month of the date
	 * @param dayOfMonth The DayOfMonth of the date
	 * @return Date of the thursday preceding the specified date
	 */
	public LocalDate getPreviousThursday(int year, int month, int dayOfMonth)
	{
		LocalDate ld = LocalDate.of(year, month, dayOfMonth);
		
		DayOfWeek dw = ld.getDayOfWeek();
		int toSub = dw == DayOfWeek.THURSDAY ? 7 : 
			(7 + (dw.getValue() - DayOfWeek.THURSDAY.getValue())) % 7;
		
		LocalDate prevThurs = ld.minusDays(toSub);
		
		return prevThurs;
	}
	
	/***
	 * Gets the date of the monday immediately following d
	 * @param d The date from which to locate the next monday
	 * @return Date of the following monday
	 */
	public LocalDate getNextMonday(LocalDate d)
	{
		LocalDate nextMonday;
		DayOfWeek dw = d.getDayOfWeek();
		int toAdd = dw == DayOfWeek.MONDAY ? 7 : 7 - (dw.getValue() - DayOfWeek.MONDAY.getValue());
		
		nextMonday = d.plusDays(toAdd);
		
		return nextMonday;
	}
	
	public boolean isFridayTheThirteenth(LocalDate d)
	{
		return d.getDayOfWeek() == DayOfWeek.FRIDAY && d.getDayOfMonth() == 13;
	}
	
	/***
	 * lists all the mondays occurring in month of the curent year
	 * @param month The month to be scanned for mondays
	 */
	public void listMondays(int month)
	{
		//Get the first day of the month and get the month itself so we can iterate over days
		LocalDate date = YearMonth.now().atDay(1);
		Month cm = date.getMonth();
		
		//Move to the next monday, if not already on a monday
		if (date.getDayOfWeek() != DayOfWeek.MONDAY)
			date = getNextMonday(date);
		
		//Keep moving to the next monday as long as we are still in the same month
		while (cm == date.getMonth())
		{
			System.out.println(date.toString());
			date = getNextMonday(date);
			
		}
	}

}
