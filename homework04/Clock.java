import java.lang.Math;
import java.text.DecimalFormat;
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Veda Ashok
 *  Date written  :  22 February 2018
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
   private double minuteHandAngle = 0;
   private double hourHandAngle = 0;
   private double totalSeconds = 0;
   private double timeSlice = DEFAULT_TIME_SLICE_IN_SECONDS;
   private double hour = 0;
   private double minute = 0;
   private double second = 0;
   private double handAngle = 0;
   

  /**
   *  Constructor goes here
   */
   public Clock() {

    
   }

   public Clock(double t){
    this.timeSlice = t;

   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick() {
    totalSeconds += timeSlice;
    hour = Math.floor(totalSeconds/3600);
    minute = Math.floor((totalSeconds % 3600)/60);
    second = totalSeconds - (hour * 3600) - (minute * 60);
    
    //System.out.println("Total Seconds are: " + totalSeconds);


      return totalSeconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException {
    double value = Double.parseDouble(argValue);
    double newValue = 0;
      
      if(value >= 0 && value <= 360){
        
        newValue = value;
      }

      else{
       throw new IllegalArgumentException("Angle must be between 0.0 and 360.0");
      }

      
      return newValue;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) {

    double opTimeSlice = Double.parseDouble(argValue);
    if(opTimeSlice <= 0 ){
      throw new IllegalArgumentException("Timeslice too small!");
    }
    if(opTimeSlice >1800){
      throw new IllegalArgumentException("TimeSlice too large!");
    }
    if(opTimeSlice > 0 && opTimeSlice < 1800){

      timeSlice = opTimeSlice;

    }

      return timeSlice;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {
      
      
      return HOUR_HAND_DEGREES_PER_SECOND * totalSeconds;
      
      

      
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {


    
      minuteHandAngle = (MINUTE_HAND_DEGREES_PER_SECOND * totalSeconds) % 360;
      

      return minuteHandAngle;
   }


  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
    
    handAngle = Math.abs(getHourHandAngle() - getMinuteHandAngle());

    //System.out.println("Hand Angle is " + handAngle);
    
    
      return handAngle;

   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {

      return totalSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {

    DecimalFormat df = new DecimalFormat("#.0000");

      return "Angle at--- Hour: " + hour + " Minute: " + minute + " Second:" + df.format(second);
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  20.0 degrees', expecting double value   20.0" );
      try { System.out.println( (20.0 == clock.validateAngleArg( "20.0" )) ? " - got 20.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  -20.0 degrees', expecting error" );
      try { System.out.println( (-20.0 == clock.validateAngleArg( "-20.0" )) ? " bad value" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing validateAngleArg()....");
      System.out.print( "      sending '  400.0 degrees', expecting error" );
      try { System.out.println( (400.0 == clock.validateAngleArg( "400.0" )) ? " bad value" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
   
   }
}

