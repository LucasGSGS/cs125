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
		TextIO.putln("Using shift value of " + offset);		
		TextIO.putln("Please enter the source text (empty line to quit)");
		String line = TextIO.getln();		
		while(!line.equals("")) {
			TextIO.putln("Source   :" + line);		
			line = line.toUpperCase();		      
			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			int i;                                                 // stepper for alphabet
			int k;                                                 // stepper for line
			String result = "";
			for (k=0; k < line.length(); k++) {
				for (i=0; i < alphabet.length(); i++) {
					int letter = 0;
					if (line.charAt(k) == alphabet.charAt(i)) {
						letter = i + offset;
						if(letter > 26 || letter < 0) letter = (letter+26)%26;
						result = result + alphabet.charAt(letter);
					}
				}
				
			}
			TextIO.putln("Processed:" + result);
			TextIO.putln("Please enter the source text (empty line to quit)");
			line = TextIO.getln();
		}
		TextIO.putln("Bye.");
	}
}
