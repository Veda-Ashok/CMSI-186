/**
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  <Veda Ashok>
 *  Date          :  <18 January 2018>
 *  Description   :  This program calculates the number of days between two dates. The dates are specified 
 *					 as args[0] through args[5].
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2017-12-25  B.J. Johnson  Updated for Spring 2018
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
