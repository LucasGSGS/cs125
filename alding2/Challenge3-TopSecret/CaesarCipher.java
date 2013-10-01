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
		
		while (Math.abs(offset) != 999 && (offset <= -26 || offset == 0 || offset >= 26)) {
			TextIO.putln(offset + " is not a valid shift value.");
			TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
			offset = TextIO.getlnInt();
		}		
		if(Math.abs(offset) == 999) {
			TextIO.putln("Using position shift");
			TextIO.putln("Please enter the source text (empty line to quit)");
		}
		else 
			TextIO.putln("Using shift value of " + offset + "\nPlease enter the source text (empty line to quit)");
		String line = TextIO.getln();			
		int k=0;
		
		while(offset == 999) {										//testPositionShift
			TextIO.putln("Source   :" + line);
			line = line.toUpperCase();			
			TextIO.put("Processed:");
			for (k=0; k < line.length(); k++) {
				if (line.charAt(k)>64 && line.charAt(k)<91) {
					offset = k;
					char letter = line.charAt(k);
					letter = (char)((letter - 'A' + offset + 26)%26 + 'A');
					TextIO.put(letter);
				}
				else
					TextIO.put(line.charAt(k));
			}//end for
			TextIO.putln("\nPlease enter the source text (empty line to quit)");
			line = TextIO.getln();		
			//end while
			
		}
		
		while(offset == -999) {										//testDecodePositionShift
			TextIO.putln("Source   :" + line);
			line = line.toUpperCase();			
			TextIO.put("Processed:");
			for (k=0; k < line.length(); k++) {
				if (line.charAt(k)>64 && line.charAt(k)<91) {
					offset = -k;
					char letter = line.charAt(k);
					letter = (char)((letter - 'A' + offset + 130)%26 + 'A');
					TextIO.put(letter);
				}
				else
					TextIO.put(line.charAt(k));
			}//end for
			TextIO.putln("\nPlease enter the source text (empty line to quit)");
			line = TextIO.getln();		
			//end while
			
		}	//end main while
		
		while(!line.equals("") && Math.abs(offset) != 999) {			//normal tests
			TextIO.putln("Source   :" + line);
			line = line.toUpperCase();         
			
			TextIO.put("Processed:");
			for (k=0; k < line.length(); k++) {		
				if (line.charAt(k)>64 && line.charAt(k)<91) {
					char letter = line.charAt(k);
					letter = (char)((letter - 'A' + offset + 26)%26 + 'A');
					TextIO.put(letter);
				}
				else 
					TextIO.put(line.charAt(k));
			}
			TextIO.putln("\nPlease enter the source text (empty line to quit)");
			line = TextIO.getln();					
		}
		
		System.out.println("Bye.");
	}
	}
