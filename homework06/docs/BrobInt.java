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
                   public String internalValue = "";        // internal String representation of this BrobInt

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

                         if(validateDigits()){
                       

                         
                         if(internalValue.charAt(0) == '-'){
                            
                                sign = 1;
                                len -= 1; //which side is this chopping off?
                                
                            
                               
                         }
                         


                         for(int i = 0; i <= len; i++){
                                 intArray[i] = this.reversed.charAt(i) - 48;
                                 
                                
                         }
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
                     
                        
                        

                              if(internalValue.length() <= gint.internalValue.length()){
                                      largerNumber = gint.internalValue.length();
                                      smallerNumber = internalValue.length();

                                      
                                       

                                      int [] smallerIntArrayWithZeros = new int[largerNumber];

                                        
                                      for(int y = 0; y <= largerNumber - 1; y++){ //for every index after the smallerNumber until its length is the same as LargerNumber, store a 0
                                         
                                          
                                          if(y < smallerNumber){
                                                smallerIntArrayWithZeros[y] = intArray[y];
                                                
                                          
                                                

                                          }
                                          else{
                                             
                                                smallerIntArrayWithZeros[y] = 0;
                                          }

                                         
                                      }

                                      int [] sum = new int[largerNumber + 1];
                                      int x = 0;
                                      for( x = 0; x < largerNumber; x++){
                                           
                                            sum[x] = smallerIntArrayWithZeros[x] + gint.intArray[x] + carry;

                                            if(sum[x] > 9){
                                                carry = 1;
                                                sum[x] -= 10;
                                            }
                                            else{
                                                carry = 0;
                                            }
                                
                                      }

                                      
                                      sum[x] = carry;
                                      
                                      for(int i = largerNumber; i >= 0 ; i--){
                                        result += sum[i]; 
                                      }

                                       
                                      result = removeZeros(result);
                                       

                                      if(sign == 1){
                                          result = "-" + result;
                                      }

                                      

                              }

                              else if(internalValue.length() > gint.internalValue.length()){
                                      largerNumber = internalValue.length();
                                      smallerNumber = gint.internalValue.length();




                                       int [] smallerIntArrayWithZeros = new int[largerNumber];
                                        
                                      for(int y = 0; y <= largerNumber - 1; y++){ //for every index after the smallerNumber until its length is the same as LargerNumber, store a 0
                                        
                                          
                                          if(y < smallerNumber){
                                                smallerIntArrayWithZeros[y] = gint.intArray[y];
                                                 
                                       
                                          }
                                          else{
                                                smallerIntArrayWithZeros[y] = 0;
                                          }

                                          
                                      
                                      }

                                      int [] sum = new int[largerNumber + 1];
                                      for(int x = 0; x < largerNumber; x++){
                                     
                                            sum[x] = intArray[x] + smallerIntArrayWithZeros[x] + carry;

                                            if(sum[x] > 9){
                                                carry = 1;
                                                sum[x] -= 10;
                                            }
                                            else{
                                                carry = 0;
                                            }

                                
                                      }

                                      
                                      sum[largerNumber] = carry;
                                    


                                      for(int i = largerNumber - 1; i >= 0; i--){
                                            result += sum[i]; 
                                      }
                                     
                                      result = removeZeros(result);
                                      

                                      if(sign == 1){
                                            result = "-" + result;
                                      }
                       
                          
                        }
         
                        return new BrobInt(result);
                    

                      
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to subtract the value of a GinormousIntk passed as argument to this GinormousInt using bytes
                   *  @param  gint         GinormousInt to subtract from this
                   *  @return GinormousInt that is the difference of the value of this GinormousInt and the one passed in
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public BrobInt subtract( BrobInt gint ) {
                        int borrow = 0;  
                        int largerNumber = 0;
                        int smallerNumber = 0;
                        String result = "";

        
                        if(this.sign != gint.sign){

                            if(this.sign == 0 && gint.sign == 1){
                              
                                BrobInt newGint = getPositive(gint);
                              
                            
                                    return this.add(newGint);
                               
                            }

                            else if(this.sign == 1 && gint.sign == 0){
                             
                               BrobInt newThis = getPositive(this);
                              

                                    return this.add(gint);

                            }
                        }

                        else{


                              if(internalValue.length() == gint.internalValue.length()){
                                if(this.internalValue.equals(gint.internalValue)){
                                   
                                    for(int i = 0; i < this.internalValue.length(); i++){
                                        result += "0";
                                    }


                                }

                                else if(((internalValue.charAt(0) == '-' && gint.internalValue.charAt(0) == '-' && 
                                   (internalValue.charAt(1) > gint.internalValue.charAt(1))) || internalValue.charAt(0) > gint.internalValue.charAt(0))){
                                
                                    largerNumber = internalValue.length();
                                    smallerNumber = gint.internalValue.length();

                                   

                                    int [] difference = new int[largerNumber+1];
                                      int x = 0;
                                      for( x = 0; x < largerNumber; x++){
                                           
                                            difference[x] = intArray[x] - gint.intArray[x] - borrow;
                                            
                                            if(difference[x] < 0){
                                                if(x == largerNumber-1){
                                                    difference[x] = difference[x];
                                                }

                                                else{
                                                     borrow = 1;
                                                    difference[x] = -(difference[x]);

                                                }

                                               
                                            }
                                            else{

                                                borrow = 0;
                                            }
       
                                            
                                      }

                                    
                                      
                                      for(int i = largerNumber; i >= 0 ; i--){
                                        result += difference[i]; 
                                      }
                                      
                                      
                                      result = removeZeros(result);
                                     
                                      


                                      if(gint.sign == 1 || this.sign == 1){
                                          result = "-" + result;
                                      }


                                      


                                }



                                  else if(((internalValue.charAt(0) == '-' && gint.internalValue.charAt(0) == '-' && 
                                   (internalValue.charAt(1) < gint.internalValue.charAt(1))) || internalValue.charAt(0) < gint.internalValue.charAt(0))){
                                    largerNumber = gint.internalValue.length();
                                    smallerNumber = internalValue.length();
                                    


                                    int [] difference = new int[largerNumber + 1];
                                      int x = 0;
                                      for( x = 0; x < largerNumber; x++){
                                           
                                            difference[x] = gint.intArray[x] - intArray[x] - borrow;
                                        

                                            if(difference[x] < 0){
                                                if(x == largerNumber-1){
                                                    difference[x] = difference[x];
                                                }

                                                else{
                                                     borrow = 1;
                                                     difference[x] = -(difference[x]);
                                                     gint.intArray[x+1] -= 1;

                                                }

                                               
                                            }
                                            else{
                                                borrow = 0;
                                            }

                                                
                                            
                                      }

                                     
                                      
                                      for(int i = largerNumber; i >= 0 ; i--){
                                        result += difference[i]; 
                                      }
                                      
                                      result = removeZeros(result);
                                      




                                    
                                }

                                     

                                      
                            }


                              else if(internalValue.length() < gint.internalValue.length() ){
                                      largerNumber = gint.internalValue.length();
                                      smallerNumber = internalValue.length();
                                      
                                      int [] smallerIntArrayWithZeros = new int[largerNumber];
                                        
                                      for(int y = 0; y <= largerNumber - 1; y++){ //for every index after the smallerNumber until its length is the same as LargerNumber, store a 0
                                          
                                          if(y < smallerNumber){
                                                smallerIntArrayWithZeros[y] = intArray[y];
                                                
                                          }
                                          else{
                                                smallerIntArrayWithZeros[y] = 0;
                                          }


                                      
                                      }

                                      int [] difference = new int[largerNumber + 1];
                                      int x = 0;
                                      for( x = 0; x < largerNumber; x++){
                                           
                                            difference[x] = gint.intArray[x] - smallerIntArrayWithZeros[x] - borrow;
                                            

                                            if(difference[x] < 0){
                                                if(x == largerNumber - 2){
                                                    difference[x] = -(difference[x]);
                                                }

                                                else{
                                                     borrow = 1;
                                                    difference[x] = -(difference[x]);
                                                    gint.intArray[x+1] -= 1;

                                                }

                                               
                                            }
                                            else{
                                                borrow = 0;
                                            }

                                                
                                            
                                
                                      }

                                    for(int i = largerNumber; i >= 0 ; i--){
                                        result += difference[i]; 
                                      }
                                      
                                      result = removeZeros(result);
                                
                                   
                                      result = "-" + result;
                                      
                             }

                              else if(internalValue.length() > gint.internalValue.length()){
                                      largerNumber = internalValue.length();
                                      smallerNumber = gint.internalValue.length();

                                       int [] smallerIntArrayWithZeros = new int[largerNumber];
                                        
                                      for(int y = 0; y < largerNumber - 1; y++){ //for every index after the smallerNumber until its length is the same as LargerNumber, store a 0
                                          
                                          if(y < smallerNumber){
                                                smallerIntArrayWithZeros[y] = gint.intArray[y];
                                          }
                                          else{
                                                smallerIntArrayWithZeros[y] = 0;
                                          }
                                      
                                      }

                                      int [] difference = new int[largerNumber + 1];
                                      for(int x = 0; x < largerNumber; x++){
                                     
                                            difference[x] = intArray[x] - smallerIntArrayWithZeros[x] - borrow;

                                            if(difference[x] < 0){
                                                if(x == largerNumber-1){
                                                    difference[x] = difference[x];
                                                }

                                                else{
                                                     borrow = 1;
                                                    difference[x] = -(difference[x]);

                                                }

                                               
                                            }
                                            else{
                                                borrow = 0;
                                            }

                                
                                      }

                                      
                                    


                                      for(int i = largerNumber - 1; i >= 0; i--){
                                            result += difference[i]; 
                                      }
                                     
                                      result = removeZeros(result);
                                     

                                      if(sign == 1){
                                            result = "-" + result;
                                      }
                       
                          
                           }
                        }
                        
                    
                        return new BrobInt(result);
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
                   *  Method to compare a BrobInt passed as argument to this BrobInt
                   *  @param  gint  BrobInt to add to this
                   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
                   *  NOTE: this method does not do a lexicographical comparison using the java String "compareTo()" method
                   *        It takes into account the length of the two numbers, and if that isn't enough it does a
                   *        character by character comparison to determine
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public int compareTo( BrobInt gint ) {
                      if( internalValue.length() > gint.internalValue.length() ) {
                         return 1;
                      } else if( internalValue.length() < gint.internalValue.length() ) {
                         return (-1);
                      } else {
                         for( int i = 0; i < internalValue.length(); i++ ) {
                            Character a = new Character( internalValue.charAt(i) );
                            Character b = new Character( gint.internalValue.charAt(i) );
                            if( new Character(a).compareTo( new Character(b) ) > 0 ) {
                               return 1;
                            } else if( new Character(a).compareTo( new Character(b) ) < 0 ) {
                               return (-1);
                            }
                         }
                      }
                      return 0;
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
           
                      return internalValue;
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to get the positive value of a negative GinormousInt
                   *  @param gint   GinormousInt that is negative
                   *  @return BrobInt which is the positive version of the negative value
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */ 
                   public BrobInt getPositive(BrobInt gint){
                    int gintLength = gint.internalValue.length();

                    String gintValue = gint.internalValue.substring(1, gintLength);
                
                    BrobInt temp = new BrobInt(gintValue);
                    temp.sign = 0;
                    return temp;
                    
              
                   }

                  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to display an Array representation of this GinormousInt as its bytes
                   * @param int[] which is the array to be represented
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
                   public void toArray( int[] d ) {
                      System.out.println( Arrays.toString( d ) );
                   }

                   /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   *  Method to remove zeros at the front of the result string
                   *  @param value which is the string representation of result before zeros are removed
                   *  @return String  with is the new representation of the result string with no zeros in the front
                   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */   
                   public String removeZeros(String value){
                    String newValue = "";
                    int newLen = 0;
                    
                        for(int x = 0; x <= value.length()-1; x++){
                            if(value.charAt(x) != '0'){
                               
                                newValue = value.substring(x , value.length());
                                newLen = newValue.length();

                                newLen -= 1;
                                
                                return newValue;
                                
                            }
                        }

                        return newValue;

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
