package com.ss.jb.dayfive;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateTimeDemo
{
	
	/***
	 * Lists the number of days in each month of the specified year
	 * @param year
	 */
	public List<Integer> countMonthlyDays(int year)
	{	
		return IntStream.rangeClosed(1, 12).map(i -> YearMonth.of(year, i).lengthOfMonth())
				.boxed().collect(Collectors.toList());
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
	private LocalDate getNextMonday(LocalDate d)
	{
		LocalDate nextMonday;
		DayOfWeek dw = d.getDayOfWeek();
		int toAdd = dw == DayOfWeek.MONDAY ? 7 : 7 - (dw.getValue() - DayOfWeek.MONDAY.getValue());
		
		nextMonday = d.plusDays(toAdd);
		
		return nextMonday;
	}
	
	/***
	 * Determines whether the LocalDate d represents a friday the 13th
	 * @param d LocalDate to check
	 * @return boolean
	 */
	public boolean isFridayTheThirteenth(LocalDate d)
	{
		return d.getDayOfWeek() == DayOfWeek.FRIDAY && d.getDayOfMonth() == 13;
	}
	
	/***
	 * lists all the mondays occurring in month of the curent year
	 * @param month The month to be scanned for mondays
	 */
	public List<LocalDate> listMondays(int month)
	{
		List<LocalDate> mondays = new ArrayList<LocalDate>();
		
		
		//Get the first day of the month and get the month itself so we can iterate over days
		LocalDate date = YearMonth.of(LocalDate.now().getYear(), month).atDay(1);
		Month cm = date.getMonth();
		
		//Move to the next monday, if not already on a monday
		if (date.getDayOfWeek() != DayOfWeek.MONDAY)
			date = getNextMonday(date);
				
		//Keep moving to the next monday as long as we are still in the same month
		while (cm == date.getMonth())
		{
			mondays.add(date);	
			date = this.getNextMonday(date);	
		}
		
		return mondays;
	}

}
