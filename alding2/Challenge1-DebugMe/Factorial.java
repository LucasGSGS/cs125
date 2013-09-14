//UIUC CS125 FALL 2013 MP. File: Factorial.java, CS125 Project: Challenge1-DebugMe, Version: 2013-09-10T09:27:43-0500.723066467

/**
 * A program to calculate a factorial. The given code may contain errors. Fix the
 * given code and add additional code to calculate a factorial and pass the unit
 * tests. Hint sometimes an 'int' just 'aint big enough.
 * 
 * @see Factorial-ReadMe.txt for details on how to complete this program.
 * @author alding2
 */
public class Factorial {
	public static void main(String[] args) {
		int max = 1;
		long product = 1;
		int nextNum = 1;
		System.out.println("Enter a number between 1 and 20 inclusive.");
		max = TextIO.getlnInt();
		while (max < 1 || max >= 21) {
				System.out.println("Enter a number between 1 and 20 inclusive.");
				max = TextIO.getlnInt();
			}
		while (nextNum <= max) {
				product = product*nextNum;
				//TextIO.putln(product + "   " + nextNum);
				nextNum ++; 
		}
		TextIO.putln(max + "! = " + product);
	}
}
