/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  CountTheDays.java program
 *  Author        :  <Veda Ashok>
 *  Date          :  <18 January 2018>
 *  Description   :  This program calculates the number of days between two dates. The dates are specified 
 *		     as args[0] through args[5].
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

public class CountTheDays{
	public static void main(String[] args){
	   long[] dateStuff = new long[6];
	   for(int i = 0; i < 6; i++){
	   	dateStuff[i] = Long.parseLong(args[i]);

	   }
	   
	   	System.out.println("The number of days between the two dates is:" + CalendarStuff.daysBetween(dateStuff[0], dateStuff[1], dateStuff[2], dateStuff[3], dateStuff[4], dateStuff[5]));

	}
}
