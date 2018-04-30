/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  Program to make change in the optimal way usidng dynamic programming
 * @author    :  Veda Ashok
 * Date       :  2018-04-24
 * Description:  This program finds the best way to make a target value of change using an inputted
 *               array of integers representing the value of each coin. The program uses a dynamic
 *               programming algorithm
 * Notes      :  None
 * Warnings   :  None
 *
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    

  /**
   * This class uses a dynamic programming algorithm to calculte the optimal way of making a target amount of change
   *
   */
    public class DynamicChangeMaker{
        private static int rows;
        private static int cols;
        private static Tuple [][] theTable; 
        private static int targetAmount;
        private static int [] denom;
       

       /**
        * Constructor
        */
        public DynamicChangeMaker(){

        }


        /**
        * Method to find the last box in the "table" of the algorithm as the solution to the optimal way to make change
        *
        * @return the Tuple at the last row and last column
        */
        public static Tuple solution(){
            return theTable[denom.length - 1][targetAmount];
        }
          
        public static boolean isImpossible( Tuple t ){

            return t.equals(Tuple.IMPOSSIBLE);

        }

        public static void validateArguments(){

        }

        public static Tuple makeChangeWithDynamicProgramming(int [] denominations, int target){
             targetAmount = target;
             denom = denominations;
             rows = denominations.length;
             cols = targetAmount + 1;
             theTable = new Tuple[rows][cols];
             
             

            if (targetAmount < 0){
              throw new IllegalArgumentException("BAD INPUT: Target amount cannot be negative.");

            }
            for(int i = 0; i < denom.length; i++){
                if(denom[i] < 0){
                    throw new IllegalArgumentException("BAD INPUT: Inputs cannot be negative.");

                }
                if(denom[i] < 1){
                    throw new IllegalArgumentException("BAD INPUT: Inputs cannot be less than 1.");

                }
                for(int x = i + 1; x < denom.length; x++){
                    if(denom[x] == denom[i]){
                        throw new IllegalArgumentException("BAD INPUT: Inputs cannot be repeated");
                    }
                }
            
            }


            for( int r = 0; r < rows; r++ ) {
                for( int c = 0; c < cols; c++ ) {
                
                    theTable[r][c] = new Tuple(denom.length);
                    if(c > 0){
                        if(denom[r] > c){
                            theTable[r][c] = Tuple.IMPOSSIBLE;
                        }
                        else if(denom[r] <= c){
                            theTable[r][c].setElement(r,1);
                            if(!isImpossible(theTable[r][c - denom[r]])){
                                theTable[r][c] = theTable[r][c].add(theTable[r][c - denom[r]]);
                            }
                            else if(isImpossible(theTable[r][c - denom[r]])){
                                theTable[r][c] = Tuple.IMPOSSIBLE;

                            }
                        }


                    }

                    if(r > 0){
                        int totalCurrent = theTable[r][c].total();
                        int totalAbove = theTable[r-1][c].total();
                        if(isImpossible(theTable[r][c]) && (!isImpossible(theTable[r - 1][c]))){
                            theTable[r][c] = theTable[r-1][c];
                        }
                        else if(!isImpossible(theTable[r][c]) && !isImpossible(theTable[r-1][c])){
                            if(totalAbove < totalCurrent){
                                theTable[r][c] = theTable[r-1][c];
                            }
                        }
                    }
                }
            }
             return solution();
        }







    }
