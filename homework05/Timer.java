/*
*
*
*
*
*/
import java.text.DecimalFormat;

public class Timer{
   private double hour = 0;
   private double minute = 0;
   private double second = 0;
   private final double MAX_TIME_SLICE_IN_SECONDS = 1800.00;
   private static final double DEFAULT_TIME_SLICE = 1.0;
   private static double timeSlice = DEFAULT_TIME_SLICE;
   private double totalSeconds = 0;

   public Timer(){

   }

   public Timer(double ts){
    this.timeSlice = ts;


   }
   

   public double validateTimeSlice( double argValue ) {

    //double enteredTimeSlice = Double.parseDouble(argValue);

    if(argValue <= 0 ){
      throw new IllegalArgumentException("Timeslice too small!");
    }
    if(argValue >1800){
      throw new IllegalArgumentException("TimeSlice too large!");
    }
    if(argValue > 0 && argValue < 1800){

      timeSlice = argValue;

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
    
    
      return totalSeconds;
   }


   public double getTotalSeconds() {

      return totalSeconds;
   }



    public String toString() {
    	
    	DecimalFormat df = new DecimalFormat("#.0000");


      return " Hour: " + hour + " Minute: " + minute + " Second: " + df.format(second);
   }


   public static void main(String [] args){
    
    Timer time = new Timer();

   while(time.getTotalSeconds() < 43200){
    time.tick();
    System.out.println(time.toString());
  }



   }

   

}
