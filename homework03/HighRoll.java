import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Die Rolling Game
 *  Author        :  Veda Ashok
 *  Date          :  2018 February 16
 *  Description   :  User of this program can play a die rolling game and choose from a list of options
 *                   on what they would like to do with the die or set of dice.
 */

public class HighRoll{
	
   public static void main( String args[] ) {
      System.out.println( "\nWelcome to High Roll!!\n" );
     
      int numDice = 0;
      int numSides = 0;
     
         try {
         	System.out.println();
         	System.out.println("Please enter the number of dice you would like in the set: ");
            BufferedReader nd = new BufferedReader( new InputStreamReader( System.in ));
            String inLine1 = nd.readLine();
            if( 0 == inLine1.length() ) {
               System.out.println("Please enter the number of dice you would like in the set: ");
            }
            else if(inLine1.length() > 0){
            	//System.out.println(nd.readLine());
            	numDice = Integer.parseInt(inLine1);

                
            }
             System.out.println();
             System.out.println("Please enter the number of sides you would like on each die: ");
             BufferedReader ns = new BufferedReader( new InputStreamReader( System.in ));
            String inLine2 = ns.readLine();
            if( 0 == inLine2.length() ) {
               System.out.println("Please enter the number of sides you would like in the die: ");
            }
            else if(inLine2.length() > 0){
                numSides = Integer.parseInt(inLine2);
            }
        }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      
  
    
      System.out.println();
      System.out.println("Please select an option from the list below:");
      System.out.println("Option A: ROLL ALL THE DICE");
      System.out.println("Option B: ROLL A SINGLE DIE");
      System.out.println("Option C: CACULATE THE SCORE FOR THIS SET");
      System.out.println("Option D: SAVE THIS SCORE AS THE HIGH SCORE");
      System.out.println("Option E: DISPLAY THE HIGH SCORE");
      System.out.println("Option Q: QUIT THE PROGRAM");
      System.out.println();
      

     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

      //int numDice = Integer.parseInt(input1);
      //int numSides = Integer.parseInt(input2);

      
      
      DiceSet set = new DiceSet(numDice, numSides);
      int highScore = 0;
      

      while( true ) {
         System.out.print( ">>" );
         String inputLine = null;
         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               System.out.println("Pick an option from the options above:");
            }

            System.out.println();
            System.out.println( "   You chose option: " + inputLine );
            
            if( 'Q' == inputLine.charAt(0) ) {
               break;
            }  
            else if('A' == inputLine.charAt(0)){
            	set.roll();
            	System.out.println();
            	System.out.println("You rolled: " + set.toString());
            	System.out.println();

            } 
            else if('B' == inputLine.charAt(0)){

            	System.out.println();
            	System.out.println("Which Die?: ");
            	System.out.println();
            	BufferedReader index = new BufferedReader( new InputStreamReader( System.in ) );
            	String inLine3 = index.readLine();
            	set.rollIndividual(Integer.parseInt(inLine3) - 1);

            }  
            else if('C' == inputLine.charAt(0)){
            	System.out.println();
    			System.out.println("Sum is: " + set.sum());
    			System.out.println();


            }  
            else if('D' == inputLine.charAt(0)){
            	 highScore = set.sum();

            }  
            else if('E' == inputLine.charAt(0)){
            	System.out.println();
            	System.out.println("The High Score is: " + highScore);
            	System.out.println();
            	

            }  
                  
        }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}
