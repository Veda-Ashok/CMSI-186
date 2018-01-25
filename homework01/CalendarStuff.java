/**
 *  File name     :  CalendarStuff.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  <Veda Ashok>
 *  Date          :  <18 January 2018>
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
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
public class CalendarStuff {

      /**
       * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
       */
       private static final int SUNDAY    = 0;
       private static final int MONDAY    = SUNDAY    + 1;
       private static final int TUESDAY  = MONDAY + 1;
       private static final int WEDNESDAY  = TUESDAY + 1;
       private static final int THURSDAY  = WEDNESDAY + 1;
       private static final int FRIDAY  = THURSDAY + 1;
       private static final int SATURDAY  = FRIDAY + 1;


      
      /**
       * A listing of the months of the year, assigning numbers; I suppose these could be ENUMs instead, but whatever
       */
       private static final int JANUARY    = 1;
       private static final int FEBRUARY   = JANUARY   + 1;
       private static final int MARCH  = FEBRUARY + 1;
       private static final int APRIL  = MARCH + 1;
       private static final int MAY  = APRIL + 1;
       private static final int JUNE  = MAY + 1;
       private static final int JULY  = JUNE + 1;
       private static final int AUGUST  = JULY + 1;
       private static final int SEPTEMBER  = AUGUST + 1;
       private static final int OCTOBER  = SEPTEMBER + 1;
       private static final int NOVEMBER  = OCTOBER + 1;
       private static final int DECEMBER  = NOVEMBER + 1;
   

  

        /**
         * A method to determine if the year argument is a leap year or not<br />
         *  Leap years are every four years, except for even-hundred years, except for every 400
         * @param    year  long containing four-digit year
         * @return         boolean which is true if the parameter is a leap year
         */
         public static boolean isLeapYear( long year ) {

                if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ){
                     return true;  
                }
                else{
                  return false;
                }
               
         }

        /**
         * A method to calculate the days in a month, including leap years
         * @param    month long containing month number, starting with "1" for "January"
         * @param    year  long containing four-digit year; required to handle Feb 29th
         * @return         long containing number of days in referenced month of the year
         * notes: remember that the month variable is used as an indix, and so must
         *         be decremented to make the appropriate index value
         */
         public static long daysInMonth( long month, long year ) { 

                 if (month == JANUARY || month == MARCH || month == MAY || month == JULY || month == AUGUST || month == OCTOBER || month == DECEMBER){
                  
                  return 31;

                 } 
                 if (month == APRIL|| month == JUNE || month == SEPTEMBER || month == NOVEMBER) {

                  return 30;

                 }
                  
                 if (month == FEBRUARY) {

                    return isLeapYear(year) ? 29 : 28;

                 }
                  return 33;
          }
     
   

        /**
         * A method to determine if two dates are exactly equal
         * @param    month1 long    containing month number, starting with "1" for "January"
         * @param    day1   long    containing day number
         * @param    year1  long    containing four-digit year
         * @param    month2 long    containing month number, starting with "1" for "January"
         * @param    day2   long    containing day number
         * @param    year2  long    containing four-digit year
         * @return          boolean which is true if the two dates are exactly the same
         */
         public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {

                  if (month1 == month2 && day1 == day2 && year1 == year2){
                    return true;
                  }

                  else {
                    return false;

                  }
                  
         }

        /**
         * A method to compare the ordering of two dates
         * @param    month1 long   containing month number, starting with "1" for "January"
         * @param    day1   long   containing day number
         * @param    year1  long   containing four-digit year
         * @param    month2 long   containing month number, starting with "1" for "January"
         * @param    day2   long   containing day number
         * @param    year2  long   containing four-digit year
         * @return          int    -1/0/+1 if first date is less than/equal to/greater than second
         */
         public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
                   if (year1 < year2){
                     return -1;

                   }
                   else if (year1 > year2){
                    return 1;
                   }

                   while(year1 == year2){
                        if(month1 < month2){
                          return -1;
                        }
                        if(month1 > month2){
                          return 1;
                        }
                    while (month1 == month2){
                          if(day1 < day2){
                            return -1;
                          }
                          if(day1 > day2){
                            return 1;
                          }
                          if(day1 == day2){
                            return 0;
                          }
                    }
                    

                 }

              return 0; 
         }

  
         /**
         * A method to return whether a date is a valid date
         * @param    month long    containing month number, starting with "1" for "January"
         * @param    day   long    containing day number
         * @param    year  long    containing four-digit year
         * @return         boolean which is true if the date is valid
         * notes: remember that the month and day variables are used as indices, and so must
         *         be decremented to make the appropriate index value
         */
            public static boolean isValidDate( long month, long day, long year ) {
      
                        if (month > 12 || month <= 0){       // check for valid month
                           System.out.println();   
                           System.out.println("This is not a valid date.");
                           System.out.println();   
                           return false;
                        }

                        else if(year < 0){        // check for valid year
                           System.out.println();   
                           System.out.println("TThis is not a valid date.");
                           System.out.println();   
                           return false;
                        }

                        else if(day < 1){        // check for valid day
                           System.out.println();   
                           System.out.println("This is not a valid date");
                           System.out.println();   
                           return false;
                        }

                        else if (month == JANUARY && day > 31){    //set date limit for January
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                         }
                      
                        else if ((month == FEBRUARY) && isLeapYear(year)!= true &&  day > 28){     //Check if year is leap year
                              System.out.println();                                                // If not true, set Feb date limit to 28
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }

                        else if ((month == FEBRUARY) && isLeapYear(year) == true && day > 29){   // If year is leap year, Feb date limit is 29 
                            System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }

                        else if (month == MARCH && day > 31){        //March date limit is 31                
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }
                           else if (month == APRIL && day > 30){      //April date limit is 30
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }
                        else if (month == MAY &&  day > 31){          //May date limit is 31   
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }
                           else if (month == JUNE  && day > 30){    //June date limit is 30
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }
                           else if (month == JULY && day > 31){   //July date limit is 31   
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }
                        else if (month == AUGUST && day > 31){    //August date limit is 31   
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }
                        else if (month == SEPTEMBER && day > 30){   //September date limit is 30
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }
                           else if (month == OCTOBER && day > 31){    //October date limit is 31   
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }
                           else if (month == NOVEMBER  && day > 30){    //November date limit is 30
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }
                        else  if (month == DECEMBER && day > 31){   //December date limit is 31   
                              System.out.println();
                              System.out.println ("This is not a valid date.");
                              System.out.println();
                              return false;
                        }

                          else{                         //Any date entered outside of the exceptions above are invalid
                              System.out.println();
                              System.out.println("This is a valid date.");
                              System.out.println();
                              return true;

                        }   

                          
                    }


         /**
       * A method to return a string version of the month name
       * @param    month long   containing month number, starting with "1" for "January"
       * @return         String containing the string value of the month (no spaces)
       */
       public static String toMonthString( int month ) {
          switch( month - 1 ) {

               default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
           }
       }

        /**
         * A method to return a string version of the day of the week name
         * @param    day int    containing day number, starting with "1" for "Sunday"
         * @return       String containing the string value of the day (no spaces)
         */
         public static String toDayOfWeekString( int day ) {
            switch( day - 1 ) {
                default       : throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
           }
         }


        /**
         * A method to return a count of the total number of days between two valid dates
         * @param    month1 long   containing month number, starting with "1" for "January"
         * @param    day1   long   containing day number
         * @param    year1  long   containing four-digit year
         * @param    month2 long   containing month number, starting with "1" for "January"
         * @param    day2   long   containing day number
         * @param    year2  long   containing four-digit year
         * @return          long   count of total number of days
         */
         public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
              long dayCount = 0;
              long leap = 0;
              long d = 0;
      
     


                if (year1 > year2){  // if the first year is later than the second year
                long y = daysInMonth(month1, year1) - day1;   // y is the number of days counted in the month of the date itself
                long z = day2;
                long x = 1;
          
        
                        while((month1 + x) <= DECEMBER){  // while the incremented month is not December
                             y = y + (daysInMonth(month1 + x, year1));   // count the number of days NOT included in daycount of that year
                             x++;
                             
                             
                          }
                          x = 1;
                        while((month2 - x) >= JANUARY){     // do the same for the second date
                            z = z  + (daysInMonth(month2 - x, year2));
                            x++;
                            
                            
                         }

                

                         for(long year = year2; year <= year1; year++){  // counter year starts at year2 and increments until year 1
                              if(isLeapYear(year) == true){
                                  leap++;                                // if counted year is a leap year, increment counter leap
                              }
                       }

                        if(year1 - year2 > 1){                   // if there is 1 or more years between year 1 and year 2

                            d = ((year1-year2) - 1)  * 365;         // count 365 days per year

                        }

                            dayCount = (365 - y) + (365 - z) + d + leap;   //day count is the sum of 365 minus y and z plus d and plus one day per leap year

                           

                           return dayCount;
                 
                    }

               else if (year1 < year2){                 //if year 2 is later than year 1
                long y = daysInMonth(month2, year2) - day2;    //y is the number of days counted in month2 
                long z = day1;                              
                long x = 1;
        

      
                        while( (month2 + x) <= DECEMBER){                //while incremented month is not December
                             y = y + (daysInMonth((month2 + x), year2));
                             x++;    
                             
                          }
                          
                            x = 1;
                        while((month1 - x) >= JANUARY){                 //while decremented month is not January
                            z = z  + (daysInMonth((month1 - x), year1));
                            x++;  
                            
                         }
                        

                      for(long year = year1; year <= year2; year++){
                        if(isLeapYear(year) == true){
                          leap++;
                        }
                      }

                        if(year2 - year1 > 1){

                        d = ((year2-year1) - 1)  * 365;

                        }

                        else{
                            
                            d=0;
                          }

                          dayCount = (365 - y) + (365 - z) + d + leap;

                          

                    return dayCount;
                  }
   


                else if(year1 == year2){ // if years are equal
     
                      if(month1 > month2){     // check which month is later
                        long y = day1;
                        long z = (daysInMonth(month2, year2)) - day2 ;
                        int x = 1;

                        for( x = 1; (month1 - x) != month2; x++){
                            dayCount = y + z + daysInMonth(month1-x, year1); //dayCount equals days in month 1 plus total days in month 2 minus day2 plus days in between
                            return dayCount;
                        }
                        
                      }
      
                      if(month1 < month2){
                        long y = (daysInMonth(month1, year1)) - day1;
                        long z = day2;
                        int x = 1;

                            if((month2-x) == month1){
                              dayCount = y + z;
                              return dayCount;
                            }

                            else{

                            for( x = 1; (month2 - x) != month1; x++){
                              dayCount = y + z + daysInMonth(month2 - x, year1);
                              return dayCount;
                            }

                          }


                     } 

                      else if (month1 == month2){
                        if(day1 > day2){
                          dayCount = day1 - day2;
                        }
                        if(day2 > day1){
                          dayCount = day2 - day1;
                        }
                        if(day1 == day2){
                          dayCount = 0;
                        }
                        return dayCount;
                      }

      

                }
       return 0;

    }


 }




  

