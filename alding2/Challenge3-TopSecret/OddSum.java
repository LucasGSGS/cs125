//UIUC CS125 FALL 2013 MP. File: OddSum.java, CS125 Project: Challenge3-TopSecret, Version: 2013-09-21T10:44:19-0500.077173321
/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author alding2
 */
public class OddSum { 
/**
Example output if user enters 10:
Max?
1 + 3 + 5 + 7 + 9 = 25
25 = 9 + 7 + 5 + 3 + 1

Example output if user enters 11:
Max?
1 + 3 + 5 + 7 + 9 + 11 = 36
36 = 11 + 9 + 7 + 5 + 3 + 1

 */
 public static void main(String[] args) { 
	 int i;
	 int max;
	 int sum = 0;
	 TextIO.putln("Max?");
	 max = TextIO.getlnInt();
	 for(i = 1; i <= max; i++) {
		 if (i%2 != 0) {
			sum = sum + i;
			if (i == 1)
				TextIO.put(i);
			else if (i > 1) 
				TextIO.put(" + " + i);		
			else if (i%2 != 0)
				TextIO.put(i);
	 	 }		 
	 } 	 
	 TextIO.putln(" = " + sum);
	 
	 TextIO.put(sum + " = ");
	 for(i = max; i > 0; i--) {
		 if (i%2 != 0) {
			sum = sum + i;
			if (i == max || i == (max-1))
				TextIO.put(i);
			else if (i > 0) 
				TextIO.put(" + " + i);		
			else
				TextIO.put(i);
	 	 }
	 }
  } // end of main method
} // end of class 
