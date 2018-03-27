/**
* This program simulates a soccer ball with a radius of 4.45 inches. It calculates the velocity of the soccer ball after it is lauched at the requested
* velocity. It takes into accound friction.
*
*
*@Author Veda Ashok
*@Date 20 March 2018
*
*
*
*/

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
	


	public Ball(double x, double y, double xv, double yv, double ts){ //constructor for ball
		xPosition = x;
		yPosition = y;
		initialXSpeed = xv;
		initialYSpeed = yv;
		timeSlice = ts;

	}

	

	public double[] move(){  //calculates new positions and speeds as ball moves

		
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


	public double velocity(){    //uses hypotenuse as overall velocity

		

		velocity = Math.sqrt(Math.pow(initialXSpeed , 2) + Math.pow(initialYSpeed,2));

	    velocity *= (Math.pow(0.99, timeSlice));

	    //System.out.println("velocity = " + velocity);

	    return velocity;
	

	}


	public String toString(){   //displays results of soccer balls

		DecimalFormat xPos = new DecimalFormat("#0.00");
		DecimalFormat yPos = new DecimalFormat("#0.00");
		DecimalFormat xVel = new DecimalFormat("#0.000");
		DecimalFormat yVel = new DecimalFormat("#0.000");

		if(velocity > (1.0/12.0)){ 
			return ("<" + xPos.format(xPosition) + " , " + yPos.format(yPosition) + " > " +
		       "<" + xVel.format(initialXSpeed) + " , " + yVel.format(initialYSpeed) + " > ");
			
		}

		else if(velocity <= (1.0/12.0)){
		
			return ("<" + xPos.format(xPosition) + " , " + yPos.format(yPosition) + " > " +
		       "< At Rest > ");
		}

		return "";


		

	}

	public static void main(String []args){
		
		Ball test1 = new Ball(4.0,5.0,6.0,7.0, 1.0);
		Ball test2 = new Ball(20, 80, 700, 900, 7.0);
	

      System.out.println( "    Testing velocity");
      System.out.print( "      sending '  6.0 and 7.0', expecting double value   9.1273" );
      try { System.out.println( ((Math.sqrt(85) * Math.pow(0.99, 1.0))== test1.velocity()) ? " - got it" : " - no" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println( "    Testing velocity");
      System.out.print( "      sending '  700 and 900', expecting double value   1062.7180" );
      try { System.out.println( ((Math.sqrt(1300000) * Math.pow(0.99, 7.0))== test2.velocity()) ? " - got it" : " - no" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
       

	}


}
