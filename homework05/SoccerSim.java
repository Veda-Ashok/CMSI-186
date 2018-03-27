/**
* This program simulates a field on which a number of soccer balls with a radius of 4.45 inches are launched at a certain speed in a certain direction. If two balls collide, or a ball collides with the
* pole, the program ends. At each timeslice, the program displays where each ball is and each ball's velocity. If not collision occurs, and the all the soccer balls slow down to at least one inch per second,
* the program displays that no collisions can occur. 
*
*
* @Author Veda Ashok
* @Date 20 March 2018
*
*
*
*/

import java.text.DecimalFormat;

public class SoccerSim {

	
	private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
  private static final double DEFAULT_TIME_SLICE= 1.0;
  private static  int Y_UPPER_BOUND = 0;
	private static int Y_LOWER_BOUND = 0;
	private static int X_UPPER_BOUND = 0;
	private static int X_LOWER_BOUND = 0; 
  private static Ball [] ball = null;
  private static double timeSlice = DEFAULT_TIME_SLICE;
  private static double collidePointX = 0;
  private static double collidePointY = 0;
  private static double sum = 0;
  private static double vel = 0;
  private static int collisionBallOne = 0;
  private static int collisionBallTwo = 0;
  private static String restStatement = null;
  Timer time = new Timer();
  static Ball pole = new Ball(20, 50, 0, 0, 0);


	public SoccerSim(String [] args){ //constructor for SoccerSime
		initialArguments(args);
	}    

	public static int[] fieldSize(String [] input){

		if(input.length % 4 == 0){
			X_UPPER_BOUND = input.length * 100;
			Y_UPPER_BOUND = input.length * 100;
			X_LOWER_BOUND = -(input.length * 100);
			Y_LOWER_BOUND = -(input.length * 100);

		}
		else if (input.length % 4 == 1){
			int argLength = input.length - 1;
			X_UPPER_BOUND = argLength * 100;
			Y_UPPER_BOUND = argLength * 100;
			X_LOWER_BOUND = -(argLength * 100);
			Y_LOWER_BOUND = -(argLength * 100);
		}
		else{
			System.out.println("Invalid number of arguments. Please try again.");
			System.exit(1);
		}

    int fieldStats[] = new int[4];
    fieldStats[0] = X_UPPER_BOUND;
    fieldStats[1] = X_LOWER_BOUND;
    fieldStats[2] = Y_UPPER_BOUND;
    fieldStats[3] = Y_LOWER_BOUND;

		return fieldStats;		

	}

	public void initialArguments( String [] args ) {  //validate commandline arguments entered
     
      int j = 0;

      System.out.println( "Welcome to SoccerSim" );


      if( 0 == args.length) {
         System.out.println( "Sorry you must enter at least one argument.");
         System.exit( 1 );
      }

       else if( args.length % 4 != 0 && args.length % 4 != 1) {
         System.out.println( "Invalid number of arguments. Please try again.");
         System.exit( 1 );
      }

      else if(args.length % 4 == 1){

      timeSlice = Double.parseDouble(args[args.length-1]); 
      time.validateTimeSlice(timeSlice);

      }

     	 ball = new Ball[(int)Math.floor(args.length / 4)];
      
     	 for(int n = 0; n < args.length - 1; n+=4){
            
       	 	ball[j] = new Ball(Double.parseDouble(args[n]), Double.parseDouble(args[n + 1]), Double.parseDouble(args[n + 2]), Double.parseDouble(args[n + 3]), timeSlice);
       		j++;   
      	 }
       
        
  }
     

    public boolean collision(){   //check if collision has occurred

      for(int n = 0; n < ball.length; n++){

          double poleVelocitySum = (((Math.pow((ball[n].xPosition - pole.xPosition), 2)) + (Math.pow((ball[n].yPosition - pole.yPosition), 2))));
      
        if(Math.sqrt(poleVelocitySum) <= 8.9 ){

    
                  collidePointX = pole.xPosition;
                  collidePointY = pole.yPosition;
                  System.out.println("Collision of Ball " + (n+1) + " and Pole at: ( " + collidePointX + " , " + collidePointY + " )");
                  System.exit(0);

            }

         else{ 
              for(int x = n+1; x < ball.length; x++){
          

            sum = Math.pow((ball[n].xPosition - ball[x].xPosition), 2) + Math.pow((ball[n].yPosition - ball[x].yPosition), 2);


                    if(Math.sqrt(sum) <= 8.9 ){

                         collidePointX = ((ball[n].xPosition + ball[x].xPosition)/2);
                         collidePointY = ((ball[n].yPosition + ball[x].yPosition)/2);

                         collisionBallOne = n+1;
                         collisionBallTwo = x+1;

                            return true;
                    }
            
              }
          }
       
      }

           return false;
    
  }
        

        
            
     

    public boolean ifAllAtRest(){   //check if all balls are at rest
    

      for(int x = 0; x < ball.length; x++){
          vel = ball[x].velocity();
          if(vel >= (1.0/12.0)){
            return false;
          
           }

      }

      return true;

        
    }
          
  
	public static void main (String [] args){
		SoccerSim s = new SoccerSim(args);
		Timer t = new Timer(timeSlice);
    int n = 0;


    System.out.printf("%-10s%20s%28s\n", "Ball", "Location", "Inital Velocity" );
    for(int i = 0; i < ball.length; i++){

       System.out.printf("%s%d%20s%#.4f%s%#.4f%s%12s%#.4f\n", "",  (i+1), "(", ball[i].xPosition, ",",  ball[i].yPosition, ")", "",  ball[i].velocity());
      

    }
    System.out.println("Pole at: ("  + pole.xPosition + " , " + pole.yPosition + ")");
    System.out.println();


       

        while(true){
    
            t.tick();
            
            if(s.collision()){
                System.out.println("Collision of Ball " + collisionBallOne + " and Ball " + collisionBallTwo +  " at: ( " + collidePointX + " , " + collidePointY + " )" + "at time" + t.toString());
                System.exit(0);
            }

            if(s.ifAllAtRest()){
              for(int i = 0; i < ball.length; i++){
              System.out.println("Ball " + (i+1) + " at: " + ball[i].toString() + " at " + t.toString());

              } 
              System.out.println();
              System.out.println("No collision possible. All balls at rest.");
              System.exit(0);
            }

            else{
              for(int i = 0; i < ball.length; i++){
                System.out.println("Ball " + (i+1) + " at: " + ball[i].toString() + " at " + t.toString());
                ball[i].move();
              }


             }
               System.out.println();
                         
               
         }    

  }

}
      

