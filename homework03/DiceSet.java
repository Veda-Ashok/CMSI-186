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
      this.count = count;
      this.sides = sides;
      ds = new Die[ count ];
      for(int x = 0; x < count; x++){
        ds[x] = new Die(sides);             // creating each die for the given number of dice
      }

   }

  /**
   * @return the sum of all the dice values in the set
   */

   public int sum() {
    int s = 0;
    for(int y = 0; y < this.count; y++){
      s += ds[y].getValue();          //add values returned by the roll method
    }
    
    return s;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
    
        for(int i = 0 ; i < count; i++){
           ds[i].roll();

        }
  

   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
      System.out.println();
      System.out.println("Die " + dieIndex + " rolled: " + ds[dieIndex].roll());
      System.out.println();
      return ds[dieIndex].roll();
      
      
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {

      return ds[dieIndex].getValue();
    
      
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
    int n = 0;
    String result = "";
    
      for (int i = 0; i < this.count; i++){
      
      n = ds[i].getValue();
      result += "[" +  n + "]";
      }
    
       return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) { //for given dice set
    
      return ds.toString();
    
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {
      if((this.count == ds.count) && (this.sides == ds.sides) && (this.sum() == ds.sum())){
        return true;
      }
      
        return false;

   }

      
   
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      DiceSet die = new DiceSet(2,6);
      DiceSet die2 = new DiceSet(7,4);
      DiceSet die3 = new DiceSet(10,17);
      DiceSet die4 = new DiceSet(15,4);
      DiceSet die5 = new DiceSet(7,4);
      

      System.out.println( "Test for roll: " );
      die.roll();
      System.out.println("Die 1 rolled:" + die.toString()); 
      die2.roll();
      System.out.println("Die 2 rolled:" + die2.toString());
      die3.roll();
      System.out.println("Die 3 rolled:" + die3.toString()); 
      die4.roll();
      System.out.println("Die 4 rolled:" + die4.toString()); 
      System.out.println();

      System.out.println( "Test for rollIndividual: " );
      System.out.println("Die 1 rolled:" + die.rollIndividual(1)); 
      System.out.println("Die 2 rolled:" + die2.rollIndividual(4)); 
      System.out.println("Die 3 rolled:" + die3.rollIndividual(7)); 
      System.out.println("Die 4 rolled:" + die4.rollIndividual(12));  
      System.out.println();

      System.out.println("Test for getIndividual:");
      
      System.out.println(die.getIndividual(1));
      System.out.println(die2.getIndividual(4));
      System.out.println(die3.getIndividual(7));
      System.out.println(die4.getIndividual(12));
      System.out.println();

      System.out.println("Test for toString non-Static:");
      
      System.out.println(die.toString());
      System.out.println(die2.toString());
      System.out.println(die3.toString());
      System.out.println(die4.toString());
      System.out.println();

      System.out.println("Test for toString static:");
      
      System.out.println(DiceSet.toString(die));
      System.out.println(DiceSet.toString(die2));
      System.out.println(DiceSet.toString(die3));
      System.out.println(DiceSet.toString(die4));
      System.out.println();


      System.out.println("Test for sum:");
      System.out.println(die.sum());
      System.out.println(die2.sum());
      System.out.println(die3.sum());
      System.out.println(die4.sum());
      System.out.println();


      System.out.println("Test for IsIdentical:");
      System.out.println(die.isIdentical(die2));
      System.out.println(die3.isIdentical(die4));
      System.out.println(die2.isIdentical(die5));
      System.out.println(die4.isIdentical(die2));
      System.out.println(die.isIdentical(die));
      System.out.println();




    
     
    
   }

}
