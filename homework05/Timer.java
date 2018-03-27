/**
* This program is a timer. It "ticks" every second, and uses a given timeslice to keep tract of time.
*
*
* @Author Veda Ashok
* @Date 20 March 2018
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

   public Timer(double ts){  //constructor for Timer
    this.timeSlice = ts;


   }
   

   public double validateTimeSlice( double argValue ) {  //Check if timeslice is usable

    if(argValue <= 0 ){
      throw new IllegalArgumentException("Timeslice too small!");
    }
    if(argValue > 1800){
      throw new IllegalArgumentException("TimeSlice too large!");
    }
    if(argValue > 0 && argValue < 1800){

      timeSlice = argValue;

    }

      return timeSlice;
   }


   public double tick() {    //tick: increment time by timeslice
    totalSeconds += timeSlice;
    hour = Math.floor(totalSeconds/3600);
    minute = Math.floor((totalSeconds % 3600)/60);
    second = totalSeconds - (hour * 3600) - (minute * 60);
    
    
      return totalSeconds;
   }


   public double getTotalSeconds() {

      return totalSeconds;
   }



    public String toString() {   //display results of time
    	
    	DecimalFormat df = new DecimalFormat("#.0000");


      return " Hour: " + hour + " Minute: " + minute + " Second: " + df.format(second);
   }


   public static void main(String [] args){
    
    Timer time = new Timer();

      while(time.getTotalSeconds() < 500){
         time.tick();
         System.out.println(time.toString());
      }
  


   }

   

}
