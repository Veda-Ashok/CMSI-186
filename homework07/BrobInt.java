        /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * File name  :  BrobInt.java
         * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
         * @author    :  Veda Ashok
         * Date       :  27 March 2018
         * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
         * Notes      :  None
         * Warnings   :  None
         *
         *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * Revision History
         * ================
         *   Ver      Date     Modified by:  Reason for change or modification
         *  -----  ----------  ------------  ---------------------------------------------------------------------
         *  1.0.0  2017-04-04  B.J. Johnson  Initial writing and begin coding
         *  1.1.0  2017-04-13  B.J. Johnson  Completed addByt, addInt, compareTo, equals, toString, Constructor,
         *                                     validateDigits, two reversers, and valueOf methods; revamped equals
         *                                     and compareTo methods to use the Java String methods; ready to
         *                                     start work on subtractByte and subtractInt methods
         *
         *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        import java.util.Arrays;

        public class BrobInt {

           public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
           public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
           // public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
           // public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
           // public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
           // public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
           // public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
           // public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
           // public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
           // public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
           public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

           // // Some constants for other intrinsic data types
           // //  these can help speed up the math if they fit into the proper memory space
           // public static final BrobInt MAX_INT  = new BrobInt( new Integer( Integer.MAX_VALUE ).toString() );
           // public static final BrobInt MIN_INT  = new BrobInt( new Integer( Integer.MIN_VALUE ).toString() );
           // public static final BrobInt MAX_LONG = new BrobInt( new Long( Long.MAX_VALUE ).toString() );
           // public static final BrobInt MIN_LONG = new BrobInt( new Long( Long.MIN_VALUE ).toString() );

          /// These are the internal fields
                   private String internalValue = "";        // internal String representation of this BrobInt

                   private int  sign         = 0;         // "0" is positive, "1" is negative
                   private String reversed      = "";        // the backwards version of the internal String representation
                   private int[] intArray   = null;      // byte array for storing the string values; uses the reversed string

                  /**
                   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
                   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
                   *   for later use
                   *  @param  value  String value to make into a GinormousInt
                   */
                   public BrobInt( String value ) {

                         
                         internalValue = value;
                         reverser();
                         intArray = new int[internalValue.length()];
                         int len = internalValue.length() - 1;

                         if(internalValue.charAt(0) == '-'){
                                sign = 1;
                                //len -= 1; //which side is this chopping off?
                                //internalValue = internalValue.substring(1, internalValue.length());
                                System.out.println("Internal Value is: " + internalValue);
                         }

                         for(int i = 0; i <= len; i++){
                                 intArray[i] = this.reversed.charAt(i) - 48;
                                
                                
                         }

                    }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to validate that all the characters in the value are valid decimal digits
                   *  @return  boolean  true if all digits are good
                   *  @throws  IllegalArgumentException if something is hinky
                   *  note that there is no return false, because of throwing the exception
                   *  note also that this must check for the '+' and '-' sign digits
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public boolean validateDigits() {
                          String isValid = "+-0123456789";
                      

                           if(internalValue.length() == 0){
                                  throw new IllegalArgumentException("Please enter an argument.");

                           }
                      
                          for(int i = 0; i < internalValue.length(); i++){
                                  if(!(isValid.contains("" + internalValue.charAt(i)))){
                                         return false;
                                  }
                          }
                   


                        return true;


                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to reverse the value of this GinormousInt
                   *  @return GinormousInt that is the reverse of the value of this GinormousInt
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public void reverser() {
                          reversed = new StringBuffer(internalValue).reverse().toString();
                          
                  
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to reverse the value of a GinormousIntk passed as argument
                   *  Note: static method
                   *  @param  gint         GinormousInt to reverse its value
                   *  @return GinormousInt that is the reverse of the value of the GinormousInt passed as argument
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public static BrobInt reverser( BrobInt gint ) {

                          return new BrobInt(gint.reversed);
                    
                   }

                 

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to add the value of a GinormousIntk passed as argument to this GinormousInt using int array
                   *  @param  gint         GinormousInt to add to this
                   *  @return GinormousInt that is the sum of the value of this GinormousInt and the one passed in
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                  
                   public BrobInt add( BrobInt gint ) {
                        int carry = 0;  
                        int largerNumber = 0;
                        int smallerNumber = 0;
                        String result = "";
                        
                        
                     
                        if(gint.sign != this.sign ){
                          //subtract
                        }
                        else{

                              if(internalValue.length() <= gint.internalValue.length()){
                                      largerNumber = gint.internalValue.length();
                                      smallerNumber = internalValue.length();

                                      for(int y = smallerNumber; y < largerNumber - 1; y++){ //for every index after the smallerNumber until its length is the same as LargerNumber, store a 0
                                          intArray[y] = 0;

                                      
                                      }
                                      

                              }
                              else if(internalValue.length() > gint.internalValue.length()){
                                      largerNumber = internalValue.length();
                                      smallerNumber = gint.internalValue.length();

                                       for(int y = smallerNumber; y < largerNumber - 1; y++){
                                          gint.intArray[y] = 0;
                                      
                                      }
                                      

                              }




                             
                              int [] sum = new int[largerNumber + 1];
                              for(int x = 0; x < largerNumber; x++){
                                System.out.println("intArray at " + x + ": " + intArray[x]);
                              }

                              for(int x = 0; x < largerNumber-1; x++){
                                     //System.out.println("largerNumber is:  " + largerNumber);
                                      sum[x] = intArray[x] + gint.intArray[x] + carry;
                                     System.out.println("intArray at " + x + " is: " + intArray[x]); // why is this -3 at index 6?
                                      System.out.println("gint.intArray at  " + x + " is: " + gint.intArray[x]);
                                      System.out.println("Sum at " + x + " is: " + sum[x]);

                                      if(sum[x] > 9){
                                              carry = 1;
                                              sum[x] -= 10;
                                      }
                                      else{
                                              carry = 0;
                                      }

                                      //System.out.println("Carry at is: " + carry);


                                      sum[largerNumber-1] = carry;   //last number will either be 0 or 1 depending on the last carry
                                      //System.out.println("Last number is " + sum[largerNumber]);
                              }

                                       toArray(sum);
                                       sum[largerNumber-1] = carry;


                            System.out.println("Sign is: " + sign); 



                              if(sign == 1){
                                result = "-";
                              }



                              for(int i = largerNumber - 1; i >= 0; i--){
                                result += sum[i];
                                
                                
                              }

                                                                   
                        
                          
                        }


                        
                       // BrobInt sumBI = new BrobInt(result);

                        // System.out.println("sumBI is:  " + sumBI.reversed);
                        return new BrobInt(result);
                    

                      
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to subtract the value of a GinormousIntk passed as argument to this GinormousInt using bytes
                   *  @param  gint         GinormousInt to subtract from this
                   *  @return GinormousInt that is the difference of the value of this GinormousInt and the one passed in
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public BrobInt subtract( BrobInt gint ) {
                          // int borrow = 0;
                          // int[] difference = null;

                          // if(gint.sign == 1 && this.sign == 1){
                          //         gint.internalValue.add(this.internalValue);

                          // }

                      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
                    //check if both are negatve. if so add. otherwise, subtract.
                      
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to multiply the value of a GinormousIntk passed as argument to this GinormousInt
                   *  @param  gint         GinormousInt to multiply by this
                   *  @return GinormousInt that is the product of the value of this GinormousInt and the one passed in
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public BrobInt multiply( BrobInt gint ) {
                      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to divide the value of this GinormousIntk by the GinormousInt passed as argument
                   *  @param  gint         GinormousInt to divide this by
                   *  @return GinormousInt that is the dividend of this GinormousInt divided by the one passed in
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public BrobInt divide( BrobInt gint ) {
                      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to get the remainder of division of this GinormousInt by the one passed as argument
                   *  @param  gint         GinormousInt to divide this one by
                   *  @return GinormousInt that is the remainder of division of this GinormousInt by the one passed in
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public BrobInt remainder( BrobInt gint ) {
                      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to compare a GinormousInt passed as argument to this GinormousInt
                   *  @param  gint  GinormousInt to add to this
                   *  @return int   that is one of neg/0/pos if this GinormousInt precedes/equals/follows the argument
                   *  NOTE: this method performs a lexicographical comparison using the java String "compareTo()" method
                   *        THAT was easy.....
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public int compareTo( BrobInt gint ) {
                      return (internalValue.compareTo( gint.toString() ));
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to check if a GinormousInt passed as argument is equal to this GinormousInt
                   *  @param  gint     GinormousInt to compare to this
                   *  @return boolean  that is true if they are equal and false otherwise
                   *  NOTE: this method performs a similar lexicographical comparison as the "compareTo()" method above
                   *        also using the java String "equals()" method -- THAT was easy, too..........
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public boolean equals( BrobInt gint ) {
                      return (internalValue.equals( gint.toString() ));
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to return a GinormousInt given a long value passed as argument
                   *  @param  value         long type number to make into a GinormousInt
                   *  @return GinormousInt  which is the GinormousInt representation of the long
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public static BrobInt valueOf( long value ) throws NumberFormatException {
                      BrobInt gi = null;
                      try {
                         gi = new BrobInt( new Long( value ).toString() );
                      }
                      catch( NumberFormatException nfe ) {
                         System.out.println( "\n  Sorry, the value must be numeric of type long." );
                      }
                      return gi;
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to return a String representation of this GinormousInt
                   *  @return String  which is the String representation of this GinormousInt
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public String toString() {
                      String byteVersionOutput = "";

                      // if(sign == 1){

                      // return "-" + internalValue;

                      // }

                    
                      
                      return internalValue;
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to display an Array representation of this GinormousInt as its bytes
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public void toArray( int[] d ) {
                      System.out.println( Arrays.toString( d ) );
                   }

                   public void removeZeros(String value){

                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  the main method redirects the user to the test class
                   *  @param  args  String array which contains command line arguments
                   *  note:  we don't really care about these
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public static void main( String[] args ) {
                      System.out.println( "\n  Hello, world, from the GinormousInt program!!\n" );
                      System.out.println( "\n   You should run your tests from the GinormousIntTester...\n" );

                      System.exit( 0 );
                   }

        }
