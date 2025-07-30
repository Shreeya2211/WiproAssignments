package myjavademos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

/*
 * Key Features of Java 8 Date-Time API::::::::::::::::
Immutable and thread-safe classes

Fluent and chainable methods

Clear separation of date, time, datetime, and zones

ISO and custom formatting support
 */
/*
 * | Class               | Description                              | Example                         |
| ------------------- | ---------------------------------------- | ------------------------------- |
| `LocalDate`         | Represents a date (no time, no timezone) | `LocalDate.now()`               |
| `LocalTime`         | Represents a time (no date, no timezone) | `LocalTime.now()`               |
| `LocalDateTime`     | Date and time (no timezone)              | `LocalDateTime.now()`           |
| `ZonedDateTime`     | Date, time, and timezone                 | `ZonedDateTime.now()`           |
| `OffsetDateTime`    | Date and time with offset from UTC       | `OffsetDateTime.now()`          |
| `ZoneId`            | Represents a timezone ID                 | `ZoneId.of("Asia/Kolkata")`     |
| `Period`            | Amount of time in days/months/years      | `Period.between(d1, d2)`        |
| `Duration`          | Amount of time in seconds/nanoseconds    | `Duration.between(t1, t2)`      |
| `DateTimeFormatter` | For formatting/parsing date-time strings | `DateTimeFormatter.ofPattern()` |

 */
/*
 * | Feature           | **Old API** (`java.util.Date`)    | **New API** (`java.time`) |
| ----------------- | --------------------------------- | ------------------------- |
| Mutability        | Mutable                           | Immutable                 |
| Thread-safe       | ❌ No                              | ✅ Yes                     |
| Time zone support | Poor                              | Excellent                 |
| Clarity           | Confusing (`Month 0-based`, etc.) | Clear and consistent      |
| Formatter         | Error-prone                       | Easy and reusable         |

 */
/*
 * /*
 * With Java 8, a new Date-Time API is introduced to cover the following 
 * drawbacks of old date-time API.

1. Not thread safe - java.util.Date is not thread safe, thus developers have to deal with concurrency issue 
while using date. The new date-time API is immutable and does not have setter methods.

2.Poor design - Default Date starts from 1900, month starts from 1, and day 
starts from 0, so no uniformity.
 The old API had less direct methods for date operations.
  The new API provides numerous utility methods for such operations.

3.Difficult time zone handling - Developers had to write a lot of code to deal 
with timezone issues. 
The new API has been developed keeping domain-specific design in mind.

 */
/*
 * TIMEZONE:
 * 
 * | Reason                      | Impact if Ignored                      |
| --------------------------- | -------------------------------------- |
| Global users                | Users see incorrect or confusing times |
| Scheduling events           | Meetings happen at wrong times         |
| Server-client communication | Time mismatches lead to logic errors   |
| Logs and debugging          | Hard to track when issues occurred     |
| Travel and transport        | Wrong timings in itineraries           |
| Daylight saving adjustments | One-hour errors in critical systems    |

 */
public class DateTimeDemos {

	public static void main(String[] args) {
		// Get the current date and time
	      LocalDateTime currenttime = LocalDateTime.now();//STATIC METHOD
	      System.out.println("Current DateTime: " + currenttime);
	      
	      //get the date only
	      LocalDate date1 = currenttime.toLocalDate();
	      System.out.println("Date::: " + date1);

	      Month month = currenttime.getMonth();//Month is a BUILT In ENUM
	      int day = currenttime.getDayOfMonth();

	      System.out.println("Month: " + month  + " " + "Day: " + day);
	      
	      Month m = date1.getMonth();  
	      int mv = m.getValue();  
	      System.out.println("Specific Month is:" + m);  
	      System.out.println("Specific Month in Numbers is:" + mv);  
	      
	      /*
	       * February has a minimum length of 28 days. 
	       * February has a maximum length of 29 days
	       */

	      int minl = m.minLength();  
	      int maxl = m.maxLength();  
	      System.out.println("Minimum Days of Specific Month is:" + minl);  
	      System.out.println("Maximum Days of Specific Month is:" + maxl);  

  
	      LocalDateTime date2 = currenttime.withDayOfMonth(24).withYear(2029);
	      System.out.println("Date: " + date2);

	      LocalDate date3 = LocalDate.of(2021, Month.DECEMBER, 25);
	      System.out.println("Date: " + date3);

	    //LocalDate date3 = LocalDate.of(2021, Month.DECEMBER, 48);//Invalid value for DayOfMonth (valid values 1 - 28/31): 48
	      //The day must be valid for the year and month, 
	      //otherwise an exception will be thrown.

	      //Get the current date
	      LocalDate today = LocalDate.now();
	      System.out.println("Current date: " + today);
	      
	      /*
	       * java.time.temporal.ChronoUnit enum is added in Java 8 to 
	       * replace the integer values 
	       * used in old API to represent day, month,
	       */
	      //add 2 weeks(14days) to the current date
		  LocalDate nextWeek = today.plus(2, ChronoUnit.WEEKS);
	      System.out.println("Next week: " + nextWeek);

	      //add 1 month to the current date
	      LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
	      System.out.println("Next month: " + nextMonth);

	      //add 1 year to the current date
	      LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
	      System.out.println("Next year: " + nextYear);

	      LocalDate yest = LocalDate.now().minusDays(1);  
	      LocalDate tomm = LocalDate.now().plusDays(1);  
	      System.out.println("Yesterday Day was :" + yest);  
	      System.out.println("Tomorrow will be :" + tomm); 
	      
	      LocalDate fd = LocalDate.of(2020, 12, 27);  
	      LocalDate sd = LocalDate.of(2021, 6, 8);  

	      /*
	      Period - It deals with date based amount of time.
	      */
	      //The Period between two dates can be obtained using the between() method in the Period class in Java.
	      Period p = Period.between(fd, sd);  
	      int d = p.getDays();  
	      int m11 = p.getMonths();  
	      int y = p.getYears();  
	      System.out.println("Difference in Days is:" + d);  
	      System.out.println("Difference in Months is:" + m11);  
	      System.out.println("Difference in Years is:" + y); 
	      
	      Instant timeStamp= Instant.now();
	      System.out.println("Machine Time Now:" + timeStamp);
	      
	      ZoneId zone = ZoneId.systemDefault();     
	      System.out.println("Default Zone Id:: "+zone);  
	      System.out.println("Zone Country Name::"+ zone.getDisplayName(TextStyle.FULL, Locale.ROOT));  

	      //timeStamp in zone - "America/Los_Angeles"
	      ZonedDateTime LAZone= timeStamp.atZone(ZoneId.of("America/Los_Angeles"));
	      System.out.println("In Los Angeles(America) Time Zone:"+ LAZone);
	      
	        ZonedDateTime zonedDT = ZonedDateTime.now();


	        System.out.println("ZonedDateTime     : " + zonedDT);
	        System.out.println("DayOfMonth        : " + zonedDT.getDayOfMonth());
	        System.out.println("MonthValue        : " + zonedDT.getMonthValue());
	        System.out.println("Year              : " + zonedDT.getYear());
	        System.out.println("Hour              : " + zonedDT.getHour());
	        System.out.println("Minute            : " + zonedDT.getMinute());
	        System.out.println("Second            : " + zonedDT.getSecond());
	        System.out.println("Nano              : " + zonedDT.getNano());
	        System.out.println("DayOfWeek         : " + zonedDT.getDayOfWeek());
	        System.out.println("Month             : " + zonedDT.getMonth());
	        System.out.println("DayOfYear         : " + zonedDT.getDayOfYear());
	        System.out.println("DAY_OF_MONTH      : " + zonedDT.get(ChronoField.DAY_OF_MONTH));        
	        System.out.println("MONTH_OF_YEAR     : " + zonedDT.get(ChronoField.MONTH_OF_YEAR));
	        System.out.println("YEAR              : " + zonedDT.get(ChronoField.YEAR));
	        System.out.println("HOUR_OF_DAY       : " + zonedDT.get(ChronoField.HOUR_OF_DAY));        
	        System.out.println("MINUTE_OF_HOUR    : " + zonedDT.get(ChronoField.MINUTE_OF_HOUR));
	        System.out.println("SECOND_OF_MINUTE  : " + zonedDT.get(ChronoField.SECOND_OF_MINUTE));
	        System.out.println("MINUTE_OF_DAY     : " + zonedDT.getLong(ChronoField.MINUTE_OF_DAY));
	        System.out.println("SECOND_OF_DAY     : " + zonedDT.getLong(ChronoField.SECOND_OF_DAY));
	        System.out.println("Chronology        : " + zonedDT.getChronology()); 
	        System.out.println("toEpochSecond()   : " + zonedDT.toEpochSecond());
	        System.out.println("toInstant()       : " + zonedDT.toInstant());
	        System.out.println("toLocalDate()     : " + zonedDT.toLocalDate());
	        System.out.println("toLocalDateTime() : " + zonedDT.toLocalDateTime());
	        System.out.println("toLocalTime()     : " + zonedDT.toLocalTime());
	        System.out.println("toOffsetDateTime(): " + zonedDT.toOffsetDateTime());

	     // Ask user to enter DOB in yyyy-mm-dd format
	        @SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
	        System.out.print("Enter your date of birth (yyyy-mm-dd): ");
	        String input = sc.nextLine();

	        // Parse input to LocalDate
	        LocalDate dob = LocalDate.parse(input);

	        // Get today's date
	        LocalDate today1 = LocalDate.now();

	        // Calculate age using Period.between()
	        Period age = Period.between(dob, today1);

	        // Display the result
	        System.out.println("Your age is: " +
	                age.getYears() + " years, " +
	                age.getMonths() + " months, and " +
	                age.getDays() + " days.");





	}

}
/*
Current DateTime: 2025-07-25T12:07:57.085522900
Date::: 2025-07-25
Month: JULY Day: 25
Specific Month is:JULY
Specific Month in Numbers is:7
Minimum Days of Specific Month is:31
Maximum Days of Specific Month is:31
Date: 2029-07-24T12:07:57.085522900
Date: 2021-12-25
Current date: 2025-07-25
Next week: 2025-08-08
Next month: 2025-08-25
Next year: 2026-07-25
Yesterday Day was :2025-07-24
Tomorrow will be :2025-07-26
Difference in Days is:12
Difference in Months is:5
Difference in Years is:0
Machine Time Now:2025-07-25T06:37:57.091510100Z
Default Zone Id:: Asia/Calcutta
Zone Country Name::India Time
In Los Angeles(America) Time Zone:2025-07-24T23:37:57.091510100-07:00[America/Los_Angeles]
ZonedDateTime     : 2025-07-25T12:07:57.113928900+05:30[Asia/Calcutta]
DayOfMonth        : 25
MonthValue        : 7
Year              : 2025
Hour              : 12
Minute            : 7
Second            : 57
Nano              : 113928900
DayOfWeek         : FRIDAY
Month             : JULY
DayOfYear         : 206
DAY_OF_MONTH      : 25
MONTH_OF_YEAR     : 7
YEAR              : 2025
HOUR_OF_DAY       : 12
MINUTE_OF_HOUR    : 7
SECOND_OF_MINUTE  : 57
MINUTE_OF_DAY     : 727
SECOND_OF_DAY     : 43677
Chronology        : ISO
toEpochSecond()   : 1753425477
toInstant()       : 2025-07-25T06:37:57.113928900Z
toLocalDate()     : 2025-07-25
toLocalDateTime() : 2025-07-25T12:07:57.113928900
toLocalTime()     : 12:07:57.113928900
toOffsetDateTime(): 2025-07-25T12:07:57.113928900+05:30
Enter your date of birth (yyyy-mm-dd): 2000-12-25
Your age is: 24 years, 7 months, and 0 days.
*/