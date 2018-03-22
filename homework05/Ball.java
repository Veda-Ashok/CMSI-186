import java.lang.Math;

public class Ball{

	private static final double RADIUS = 4.45;
	private double startXPosition = 0;
	private double startYPosition = 0;
	private	double initialXSpeed = 0;
	private	double initalYSpeed = 0;
	private double timeSlice =0;

	
	private static double timeSlice = 0;


	public Ball(double x, double y, double xv, double yv, double timeslice){
		startXPosition = x;
		startYPosition = y;
		initialXSpeed = xv;
		initalYSpeed = yv;
		this.timeslice = timeslice;

	}

	

	public static void convertValues(String xArg, String yArg, String xSpeedArg, String ySpeedArg){

		try {
			startXPosition = Double.parseDouble(xArg);
			startYPosition = Double.parseDouble(yArg);
			initialXSpeed = Double.parseDouble(xSpeedArg);
			initalYSpeed = Double.parseDouble(ySpeedArg);
		}
		catch (NumberFormatException nfe){
			System.out.println("Invalid argument. Please try again.");
			System.exit(1);
		}


	}

	public static double move(){

		for( int x = initialXSpeed; x > 0; x*=0.99){
			startXPosition = startXPosition + initialXSpeed;
		}
		
		for( int y = initialYSpeed; x > 0; x*=0.99){
			startYPosition = startYPosition + initialYSpeed;
		}
		
		

		double moveStats[] = new Double[4];
		moveStats[0] = startXPosition;
		moveStats[1] = startYPosition;
		moveStats[2] = initialXSpeed;
		moveStats[3] = initialYSpeed;

		

		return moveStats; 


		
	}

/*
* This method is intended to calculate the velocity of the ball with friction as a factor
*
*
*/
	public static double velocity(){


		double velocity = Math.sqrt(initialXSpeed + initialYSpeed);

	    velocity =  (velocity) * (Math.pow(0.99, timeSlice));

	    return velocity;
	

	}


	public static String toString(){

		DecimalFormat xPos = new DecimalFormat(#.00);
		DecimalFormat yPos = new DecimalFormat(#.00);
		DecimalFormat xVel = new DecimalFormat(#.000);
		DecimalFormat yVel = new DecimalFormat(#.000);

		


		return "<" + xPos.format(startXPosition) + " , " + yPos.format(startYPosition) + " > " +
		       "<" + xVel.format(initialXSpeed) + " , " + yVel.format(initialYSpeed) + " > "   );

	}

	public static void main(String []args){
		


	}
}
