import java.lang.Math;
import java.text.DecimalFormat;

public class Ball{

	private static final double RADIUS = 4.45;
	public double xPosition = 0;
	public double yPosition = 0;
	public	double initialXSpeed = 0;
	public	double initialYSpeed = 0;
	public double timeSlice =0;
	public double velocity = 0;
	 
	// public double movingPosX = 0;
	// public double movingPosY = 0;



	public Ball(double x, double y, double xv, double yv, double ts){
		xPosition = x;
		yPosition = y;
		initialXSpeed = xv;
		initialYSpeed = yv;
		timeSlice = ts;

	}

	

	public void convertValues(String xArg, String yArg, String xSpeedArg, String ySpeedArg){

		try {
			xPosition = Double.parseDouble(xArg);
			yPosition = Double.parseDouble(yArg);
			initialXSpeed = Double.parseDouble(xSpeedArg);
			initialYSpeed = Double.parseDouble(ySpeedArg);
		}
		catch (NumberFormatException nfe){
			System.out.println("Invalid argument. Please try again.");
			System.exit(1);
		}


	}

	public double[] move(){

		
		xPosition += initialXSpeed;
		initialXSpeed *= Math.pow(0.99, timeSlice);
		
		yPosition += initialYSpeed;
		initialYSpeed *= Math.pow(0.99, timeSlice);
		
		
		

		double moveStats[] = new double[4];
		moveStats[0] = xPosition;
		moveStats[1] = yPosition;
		moveStats[2] = initialXSpeed;
		moveStats[3] = initialYSpeed;

		

		return moveStats; 


		
	}

/*
* This method is intended to calculate the velocity of the ball with friction as a factor
*
*
*/
	public  double velocity(){

		

		velocity = Math.sqrt(Math.pow(initialXSpeed , 2) + Math.pow(initialYSpeed,2));

	    velocity *= (Math.pow(0.99, timeSlice));

	    //System.out.println("velocity = " + velocity);

	    return velocity;
	

	}


	public String toString(){

		DecimalFormat xPos = new DecimalFormat("#0.00");
		DecimalFormat yPos = new DecimalFormat("#0.00");
		DecimalFormat xVel = new DecimalFormat("#0.000");
		DecimalFormat yVel = new DecimalFormat("#0.000");

		if(velocity <= (1.0/12.0)){
			return ("<" + xPos.format(xPosition) + " , " + yPos.format(yPosition) + " > " +
		       "< At Rest > ");
			
		}
		{

			
			return ("<" + xPos.format(xPosition) + " , " + yPos.format(yPosition) + " > " +
		       "<" + xVel.format(initialXSpeed) + " , " + yVel.format(initialYSpeed) + " > ");

		}


		

	}

	public static void main(String []args){
		
		Ball b = new Ball(4.0,5.0,6.0,7.0, 1.0);
		b.toString();
		b.velocity();

      System.out.println( "    Testing velocity");
      System.out.print( "      sending '  6.0 and 7.0', expecting double value   9.2195" );
      try { System.out.println( ((Math.sqrt(85) * Math.pow(0.99, 1.0))== b.velocity()) ? " - got 9.2195" : " - no" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }


	}
}
