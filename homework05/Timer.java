/*
*
*
*
*
*/

public class Timer{
   private double hour = 0;
   private double minute = 0;
   private double second = 0;
   private final double MAX_TIME_SLICE_IN_SECONDS = 1800.00;
   private static final double DEFAULT_TIME_SLICE = 10.0;
   private static final double timeSlice = DEFAULT_TIME_SLICE;
   

   public double validateTimeSlice( String argValue ) {

    double enteredTimeSlice = Double.parseDouble(argValue);
    if(enteredTimeSlice <= 0 ){
      throw new IllegalArgumentException("Timeslice too small!");
    }
    if(enteredTimeSlice >1800){
      throw new IllegalArgumentException("TimeSlice too large!");
    }
    if(enteredTimeSlice > 0 && enteredTimeSlice < 1800){

      timeSlice = enteredTimeSlice;

    }

      return timeSlice;
   }


  /*
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

    public String toString() {
    	
    	DecimalFormat df = new DecimalFormat("#.0000");


      return " Hour: " + hour + " Minute: " + minute + " Second:" + df.format(second);
   }


   

}
