/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Veda Ashok
 *  Date          :  2018 February 7
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;
   private int rollingDice[] = new int[count];

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
      ds = new Die[ count ];
      for(int x = 0; x < count; x++){
        ds[x] = Die(sides);             // creating each die for the given number of dice
      }

   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
    for(int y = 0; y < count; y++){
      int s += rollingDice[y];          //add values returned by the roll method
    }
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
    for(int m = 0; m < count; m ++){
        for(int i = 0 ; i < count; i++){
           rollingDice[m] = ds[i].roll();

    }
  }

   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {

      ds[dieIndex].roll();
      
      return 0;
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {

      ds[dieIndex].getValue();
    
      return -999;
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
    for (int i = 0; i < count; i++){
      String result = "[" +  ds[i].getValue(); + "]";
    }
    
      return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) { //for given dice set
    for(int i = 0; i < count; i++){
      return ds[i].toString();
    }
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {
      return true;
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      DiceSet die = new DieSet(2,6);
      DiceSet die2 = new DieSet(7,4);
      DiceSet die3 = new DieSet(10,17);
      DiceSet die4 = new DieSet(15,4);

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

      System.out.println( " Test for rollIndividual: " );
      System.out.println();
      System.out.println("Die 1 rolled:" + die.rollIndividual()); 
      System.out.print( " Test for roll: " );
      System.out.println("Die 2 rolled:" + die2.rollIndividual()); 
      System.out.print( " Test for roll: " );
      System.out.println("Die 3 rolled:" + die3.rollIndividual()); 
      System.out.print( " Test for roll: " );
      System.out.println("Die 4 rolled:" + die4.rollIndividual());  
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
   }

}

