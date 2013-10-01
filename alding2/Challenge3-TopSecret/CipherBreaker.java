//UIUC CS125 FALL 2013 MP. File: CipherBreaker.java, CS125 Project: Challenge3-TopSecret, Version: 2013-09-21T10:44:19-0500.077173321
/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author alding2
 */
public class CipherBreaker {

	public static void main(String[] args) {
		TextIO.putln("Text?");
		String line = TextIO.getln();
		TextIO.putln(line);
		line = line.toUpperCase();
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";    
		char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
		char[] punct = {'"','-','\'','.','!',','};
		int i=0;
		int j=0;
		int k=0;
		int countLetters = 0;
		int countDigits = 0;
		int countPunct = 0;
		int countSpaces = 0;
		
		for (k=0; k < letters.length(); k++) {			// count individual letters
			countLetters = 0;
			for (j=0; j < line.length(); j++) {
				if (line.charAt(j) == letters.charAt(k))			
					countLetters++;                           
			}	
			if (countLetters > 0)
				TextIO.putln(letters.charAt(k) + ":" + countLetters);	
		}
		
		for (i=0; i < line.length(); i++) {
			for (j=0; j < digits.length; j++) {			// count digits
				if (line.charAt(i) == digits[j])
					countDigits++;
			}
			if (line.charAt(i) == ' ')					// count spaces
				countSpaces++;
			for (j=0; j < punct.length; j++) {			// count punctuation
				if (line.charAt(i) == punct[j])
					countPunct++;
			}
		}		
				
		if (countDigits > 0)
			TextIO.putln("DIGITS:" + countDigits);
		if (countSpaces > 0)
			TextIO.putln("SPACES:" + countSpaces);
		if (countPunct > 0)
			TextIO.putln("PUNCTUATION:" + countPunct);
		
	}	
}
