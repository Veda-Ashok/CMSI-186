/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  Veda Ashok
 *  Date          :  2018 February 7
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-06  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-02-17  B.J. Johnson  Filled in method code
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Die {

  //isIdentical() 3 dice, 4 sides each, same sum OR 3 dice, 4 sides each, same values, same order

  
  /**
   * private instance data
   */
   private int sides;
   private int pips;
   private final int MINIMUM_SIDES = 4;
   private int rollCount;

   // public constructor:
  /**
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws       IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die( int nSides ) {
    sides = nSides;
    pips = 1;
    rollCount = 0;
    
    if(nSides < 4){
      throw new IllegalArgumentException("Too few sides of a die!");
    }
    if(nSides > 25){
      throw new IllegalArgumentException("Too many sides of a die!");
    }

   }

  /**
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   */
   public int roll() {  //rolls die
          pips = (int)((Math.random() * sides) + 1);
          //System.out.println("Pips equals:" + pips);
          return pips;
   }

  /**
   * Get the value of THIS die to return to the caller; note that the way
   *  the count is determined is left as a design decision to the programmer
   *  For example, what about a four-sided die - which face is considered its
   *  "value"?
   * @return the pip count of THIS die instance
   */
   public int getValue() {  //gets value of die without rolling it again
       
       return pips;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public void setSides( int nSides ) { 
      sides = nSides;
      
   }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public String toString() {
         
      return "[" + this.pips + "]";
   }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public static String toString( Die d ) { 

      return d.toString();
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {

      Die die = new Die(4);
      Die die2 = new Die(7);
      Die die3 = new Die(12);
      Die die4 = new Die(23);

      System.out.println( " Test for roll: " );
      System.out.println();
      System.out.println("Die 1 rolled:" + die.roll()); 
      System.out.print( " Test for roll: " );
      System.out.println("Die 2 rolled:" + die2.roll());
      System.out.print( " Test for roll: " );
      System.out.println("Die 3 rolled:" + die3.roll()); 
      System.out.print( " Test for roll: " );
      System.out.println("Die 4 rolled:" + die4.roll()); 
      System.out.println();

      System.out.println("Test for getValue:");
      System.out.println();
      System.out.println(die.getValue());
      System.out.println(die2.getValue());
      System.out.println(die3.getValue());
      System.out.println(die4.getValue());
      System.out.println();

      System.out.println("Test for toString non-Static:");
      System.out.println();
      System.out.println(die.toString());
      System.out.println(die2.toString());
      System.out.println(die3.toString());
      System.out.println(die4.toString());
      System.out.println();

      System.out.println("Test for toString static:");
      System.out.println();
      System.out.println(Die.toString(die));
      System.out.println(Die.toString(die2));
      System.out.println(Die.toString(die3));
      System.out.println(Die.toString(die4));
      System.out.println();
     
      System.out.println("Test for setSides:");
      System.out.println();
      die.setSides(6);
      System.out.println("Die 1 now has " + die.sides + " sides.");
      die2.setSides(9);
      System.out.println("Die 2 now has " + die2.sides + " sides.");
      die3.setSides(25);
      System.out.println("Die 3 now has " + die3.sides + " sides.");
      die4.setSides(16);
      System.out.println("Die 4 now has " + die4.sides + " sides.");
      System.out.println();
      
      Die die5 = new Die(5);
      Die die6 = new Die(24);
      Die die7 = new Die(14);
      Die die8 = new Die(90);

      System.out.println( " Test for roll: " );
      System.out.println();
      System.out.println("Die 5 rolled:" + die5.roll()); 
      System.out.print( " Test for roll: " );
      System.out.println("Die 6 rolled:" + die6.roll());
      System.out.print( " Test for roll: " );
      System.out.println("Die 7 rolled:" + die7.roll()); 
      System.out.print( " Test for roll: " );
      System.out.println("Die 8 rolled:" + die8.roll()); 
      System.out.println();

      System.out.println("Test for getValue:");
      System.out.println();
      System.out.println(die5.getValue());
      System.out.println(die6.getValue());
      System.out.println(die7.getValue());
      System.out.println(die8.getValue());
      System.out.println();

      System.out.println("Test for toString non-Static:");
      System.out.println();
      System.out.println(die5.toString());
      System.out.println(die6.toString());
      System.out.println(die7.toString());
      System.out.println(die8.toString());
      System.out.println();

      System.out.println("Test for toString static:");
      System.out.println();
      System.out.println(Die.toString(die5));
      System.out.println(Die.toString(die6));
      System.out.println(Die.toString(die7));
      System.out.println(Die.toString(die8));
      System.out.println();
     
      System.out.println("Test for setSides:");
      System.out.println();
      die.setSides(6);
      System.out.println("Die 5 now has " + die5.sides + " sides.");
      die2.setSides(9);
      System.out.println("Die 6 now has " + die6.sides + " sides.");
      die3.setSides(25);
      System.out.println("Die 7 now has " + die7.sides + " sides.");
      die4.setSides(16);
      System.out.println("Die 8 now has " + die8.sides + " sides.");
      System.out.println();
       
     

   }

}
