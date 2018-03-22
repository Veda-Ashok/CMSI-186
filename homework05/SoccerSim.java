public class SoccerSim{

	
	private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
    private static final double DEFAULT_TIME_SLICE= 10.0;
    private static final double EPSILON_VALUE   = 1.0; 
    private static final int Y_UPPER_BOUND = 0;
	private static final int Y_LOWER_BOUND = 0;
	private static final int X_UPPER_BOUND = 0;
	private static final int X_LOWER_BOUND = 0; 
	private static Ball [] ball = null;

	public SoccerSim(String [] args){
		initialArguments(args);
	}    

	

	public static int fieldSize(String input){

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
			throw new NumberFormatException("Invalid number of arguments.");
			System.exit(1);
		}

		return X_UPPER_BOUND, X_LOWER_BOUND, Y_UPPER_BOUND, Y_LOWER_BOUND;		

	}

	public void initialArguments( String [] args ) {
      int j = 0;

      System.out.println( "Hi! Enter parameters for the number of soccer balls you prefer is the following order: x-position, y-position, x-speed, y-speed" );
      if( 0 == args.length) {
         System.out.println( "Sorry you must enter at least one argument.");
         System.exit( 1 );
      }

      else if(args.length % 4 == 0){ 

     	 ball[] = new Ball[Math.floor(args.length / 4)];
     	 for(int n = 0; n < args.length; n+=4){
       	 	ball[j] = new Ball(double.parseDouble(args[n]), double.parseDouble(args[n + 1]), double.parseDouble(args[n + 2]), double.parseDouble(args[n + 3]), DEFAULT_TIME_SLICE);
       		j++;   
      	 }
       
        
      }
      else if (args.length % 4 == 1) {
      	  for(int n = 0; n < args.length - 2; n+=4){
       	 	  ball[j] = new Ball(double.parseDouble(args[n]), double.parseDouble(args[n + 1]), double.parseDouble(args[n + 2]), double.parseDouble(args[n + 3]), double.parseDouble(args[args.length - 1]));
       		  j++;   
      	 }
  	   }

        
     }

    public boolean collision(){

        if(ball.length % 4 == 1){ //if a timeslice is eneterd
            ball.length -= 1;
        }

        for(int x = 0; x < ball.length - 4; x+=4){
            if(Math.sqrt(Math.power(ball[x], 2) + Math.power(ball[x+1], 2)) <= 8.9){ // if hypotenuse between two balls is <=8.9
                return true;
            }
            
        }


        return false;


    }

    public boolean ifAtRest(){
        for(int x = 0; x < ball.length; x++){
            if(ball[x].velocity <= EPSILON_VALUE){
                return true;
            }

        }

        return false;
    }
          
  }
   
  

	public static void main (String [] args){
		SoccerSim s = new SoccerSim();
		Timer t = new Timer();
        Ball ball = new Ball();

        while(false){

            move();
            
            if(collision()){
                 System.out.println("Collision at: ( " + startXPosition + ", " + startYPosition + ").");
                 System.exit(0);

            }

            else if(ifAtRest()){
                System.out.println("No collision is possible.");
            }

        }






	}
}
