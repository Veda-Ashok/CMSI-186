/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  Veda Ashok
 *  Date          :  2018 February 1
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods [if you want]
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-19  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson  Fill in methods to make the program actually work
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {

  /**
   * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
   * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
   * it gets included.
   *
   * @param s String containing the data to be checked for &quot;vowel-ness&quot;
   * @return  boolean which is true if there is a vowel, or false otherwise
   */
   public static boolean containsVowel( String s ) {
      if (s.contains("a") || s.contains("e") || s.contains("i")|| s.contains("o")|| s.contains("u") || s.contains("y") ||
         s.contains("A") || s.contains("E") || s.contains("I")|| s.contains("O")|| s.contains("U") || s.contains("Y") ){
         return true;
      }
      else{
         return false;
      }
      
   }

  /**
   * Method to determine if a string is a palindrome.  Does it the brute-force way, checking
   * the first and last, second and last-but-one, etc. against each other.  If something doesn't
   * match that way, returns false, otherwise returns true.
   *
   * @param s String containing the data to be checked for &quot;palindrome-ness&quot;
   * @return  boolean which is true if this a palindrome, or false otherwise
   */
   public static boolean isPalindrome( String s ) {
      String m = new String();
      m = reverse(s);

      if(m.equals(s)){
         return true;
      }
      else{
         return false;
      }
     
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even,
   * corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input
   */
   public static String evensOnly( String s ) {
      String evens = "BDFHJLNPRTVXZbdfhjlnprtvxz";
      String evenLetters = "";
      for(int x = 0; x < s.length(); x++){
         for(int y = 0; y < evens.length(); y++){
            if(s.charAt(x) == evens.charAt(y)){
                evenLetters += s.charAt(x);
            }

         }
         
      }

      return evenLetters;

   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd,
   * corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input
   */
   public static String oddsOnly( String s ) {
      String odds = "ACEGIKMOQSUWYacegikmoqsuwy";
      String oddLetters = "";
      for(int x = 0; x < s.length(); x++){
         for(int y = 0; y < odds.length(); y++){
            if(s.charAt(x) == odds.charAt(y)){
                oddLetters += s.charAt(x);
            }

         }
         
      }

      return oddLetters;

   }


  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input without duplicates
   */
   public static String evensOnlyNoDupes( String s ) {
      String evensNoDupes = "";
      String r = StringStuff.evensOnly(s);

      for(int x = 0; x < r.length(); x++){
         String n = "";
         n += r.charAt(x);                      //create a string to hold the letters of string r that come before the current index 

         if(evensNoDupes.contains(n) == false){  //if my output string does not contain string n, add the character to the output
            evensNoDupes += r.charAt(x);
         }
      }
   
      return evensNoDupes;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input without duplicates
   */
   public static String oddsOnlyNoDupes( String s ) {
      String r = StringStuff.oddsOnly(s);
      String oddsNoDupes = "";
      
      for(int x = 0; x < r.length(); x++){
         String n = "";                       //create a string to hold the letters of string r that come before the current index
         n += r.charAt(x);

         if(oddsNoDupes.contains(n) == false){    //if my output string does not contain string n, add the character to the output
            oddsNoDupes += r.charAt(x);
         }
      }
   
      return oddsNoDupes;
   }


  /**
   * Method to return the reverse of a string passed as an argument
   *
   * @param s String containing the data to be reversed
   * @return  String containing the reverse of the input string
   */
   public static String reverse( String s ) {
      char[] t = s.toCharArray();
      char[] n = new char[t.length];
      int y = 0;
     
      for(int x = t.length -1 ; x >= 0; x--){
          n[y] = t[x];
          y++;
      }

      String newS = new String(n);

      return newS;
   }

  /**
   * Main method to test the methods in this class
   *
   * @param args String array containing command line parameters
   */
   public static void main( String args[] ) {
      String blah = new String( "Blah blah blah" );
      String woof = new String( "BCDBCDBCDBCDBCD" );
      String pal1 = new String( "a" );
      String pal2 = new String( "ab" );
      String pal3 = new String( "aba" );
      String pal4 = new String( "amanaplanacanalpanama" );
      String pal5 = new String( "abba" );
      System.out.println( containsVowel( blah ) );
      System.out.println( containsVowel( woof ) );
      System.out.println( isPalindrome( pal1 ) );
      System.out.println( isPalindrome( pal2 ) );
      System.out.println( isPalindrome( pal3 ) );
      System.out.println( isPalindrome( pal4 ) );
      System.out.println( isPalindrome( pal5 ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "REHEARSALSZ" ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "REhearSALsz" ) );
      System.out.println( "evensOnlyNoDupes() returns: " + evensOnlyNoDupes( "REhearSALsz" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "xylophones" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "XYloPHonES" ) );
      System.out.println( "oddsOnlyNoDupes()  returns: " + oddsOnlyNoDupes( "XYloPHonES" ) );
      System.out.println( "reverse()          returns: " + reverse( "REHEARSALSZ" ) );
   }
}
