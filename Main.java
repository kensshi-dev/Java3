import java.util.*;


class Date implements Comparable<Date>{
	int day, month, year;
	private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
	String[] allMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
	
	Date(int day, int month, int 	year){
		if (!isValidDate(day, month, year)) {
            		System.out.println("Invalid date");
        	}
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	boolean isValidDate(int day, int month, int year) {
		if (month < 1 || month > 12 || day < 1) {
		    return false;
		}
		int maxDays = DAYS_IN_MONTH[month - 1];
		if (month == 2 && isLeapYear(year)) {
		    maxDays = 29;
		}
		return day <= maxDays;
    	}
	
	void updateDate(int day, int month, int year){
		if (isValidDate(day, month, year)){
			this.day = day;
			this.month = month;
			this.year = year;
		}else {
			System.out.println("Invalid date");
		}
	}
	
	String getDayOfWeek() {
		int month = this.month;
		int year = this.year;
		if (month == 1 || month == 2) {
		    month += 12;
		    year -= 1;
		}
		int k = year % 100;
		int j = year / 100;
		int dayOfWeek = (day + (13 * (month + 1) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
		return days[dayOfWeek];
	}
	
	void printDate(){
		System.out.println(allMonths[this.month-1]+" "+this.day+", "+this.year);
	}
	
	@Override
	public int compareTo(Date other){
		if (this.year == other.year){
			if (this.month == other.month){
				return this.day - other.day;
			}
			return this.month - other.month;
		}
		return this.year - other.year;
	}
	
	int toDays() {
		int days = day;
		for (int i = 1; i < month; i++) {
		    days += DAYS_IN_MONTH[i - 1];
		    if (i == 2 && isLeapYear(year)) {
		        days += 1;
		    }
		}
		days += (year - 1) * 365 + countLeapYears(year);
		return days;
    	}
    	
    	int calculateDifference(Date otherDate) {
        	return Math.abs(toDays() - otherDate.toDays());
    	}
    	
    	int countLeapYears(int year) {
        	return (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
    	}
    	
    	boolean isLeapYear(int year) {
        	return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
   	}

}

public class Main{
	public static void main (String[] args){
		List<Date> dates = new ArrayList<>();
		dates.add(new Date(15, 5, 2022));
		dates.add(new Date(10, 3, 2021));
		dates.add(new Date(1, 1, 2023));

		Collections.sort(dates);
		for (Date d : dates) {
		    d.printDate();
		}

		Date d1 = new Date(1, 1, 2020);
		Date d2 = new Date(1, 1, 2024);
		System.out.println("Difference: " + d1.calculateDifference(d2) + " days");
		
		Date d3 = new Date(1, 1, 2020);
		d3.updateDate(12, 3, 2023);
		d3.printDate();
		d3.updateDate(12,13,2023);
		
	}
}

