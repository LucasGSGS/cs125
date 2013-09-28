//UIUC CS125 FALL 2013 MP. File: CaesarCipher.java, CS125 Project: Challenge3-TopSecret, Version: 2013-09-21T10:44:19-0500.077173321
/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author alding2
 */
public class CaesarCipher {
	public static void main(String[] strings) {
		int offset = 0;
		TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
		offset = TextIO.getlnInt();	
		
		while (offset <= -26 || offset == 0 || offset >= 26) {
			TextIO.putln(offset + " is not a valid shift value.");
			TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
			offset = TextIO.getlnInt();
		}		
		TextIO.putln("Using shift value of " + offset + "\nPlease enter the source text (empty line to quit)");
		String line = TextIO.getln();			
		
		while(!line.equals("")) {
			TextIO.putln("Source   :" + line);		
			line = line.toUpperCase();		      
			//String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			int i=0;
			int k=0;           
			int j=0;
			String result = "";
			
			TextIO.put("Processed:");
			while (Math.abs(offset) != 999 && !line.equals("")) {
			for (k=0; k < line.length(); k++) {		
				if (line.charAt(k)>64 && line.charAt(k)<91) {
					int alphNum = line.charAt(k) - 'A';
					int afterOffset = alphNum + offset;
					int alph = (afterOffset+26)%26 + 'A';			//change back to actual number in ascii
					char letter = (char)alph;
					TextIO.put(letter);
				}
				else 											// if (line.charAt(k) < 65 || (line.charAt(k) > 90 && line.charAt(k) < 97) || line.charAt(k) > 122) 
					TextIO.put(line.charAt(k));
			}	//end for		
			TextIO.putln("\nPlease enter the source text (empty line to quit)");
			line = TextIO.getln();
			}
		}	//end while
		TextIO.putln("Bye.");
	}
}
