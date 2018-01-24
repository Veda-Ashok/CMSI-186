public class CountTheDays{
	public static void main(String[] args){
	   Scanner m1 = new Scanner(System.in); // user input for month
	   Scanner d1 = new Scanner(System.in); // user input for day
	   Scanner y1 = new Scanner(System.in); // user input for year
	   Scanner m2 = new Scanner(System.in); // second user input for month
	   Scanner d2 = new Scanner(System.in); // second user input for day
	   Scanner y2 = new Scanner(System.in); // second user input for year

	   System.out.print("Please enter a value that corresponds to a month: "); // prompt user to enter first month
	   long month = m1.nextLong();
	   System.out.print("Please enter a value that corresponds to a day: "); // prompt user to enter first day
	   long day = d1.nextLong();
	   System.out.print("Please enter a value that corresponds to a year: "); //prompt user to enter first year
	   long year = y1.nextLong();

	    System.out.print("Please enter another value that corresponds to a month: "); // prompt user to enter second month
	   long month = m2.nextLong();
	   System.out.print("Please enter another value that corresponds to a day: "); // prompt user to enter second day
	   long day = d2.nextLong();
	   System.out.print("Please enter another value that corresponds to a year: "); //prompt user to enter second year
	   long year = y2.nextLong();

	   CalendarStuff.daysBetween(m1 , d1, y1, m2, d2, y2);



	}
}
