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
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";     // {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
		char[] punct = {'"','-','\'','.','!',','};
		int i;
		int j=0;
		int countLetters = 0;
		int countDigits = 0;
		int countPunct = 0;
		int countSpaces = 0;
		char letter = ' ';
		
			for (i=0; i < line.length(); i++) {            // count letters
				for (j=0; j < letters.length(); j++) {
					if (line.charAt(i) == letters.charAt(j))
						break;
				}
			letter = letters.charAt(j);
			TextIO.putln(letter + ":" + countLetters);		
			}
		
		
		for (i=0; i < line.length(); i++) {            // count digits
			for (j=0; j < digits.length; j++) {
				if (line.charAt(i) == digits[j])
					countDigits++;
			}
		}
		
		for (i=0; i < line.length(); i++) {            // count spaces
			if (line.charAt(i) == ' ')
				countSpaces++;
		}		
		
		for (i=0; i < line.length(); i++) {            // count punctuation
			for (j=0; j < punct.length; j++) {
				if (line.charAt(i) == punct[j])
					countPunct++;
			}
		}		
		
		if (countLetters > 0)
			TextIO.putln(letter + ":" + countLetters);
		if (countDigits > 0)
			TextIO.putln("DIGITS:" + countDigits);
		if (countPunct > 0)
			TextIO.putln("PUNCTUATION:" + countPunct);
		if (countSpaces > 0)
			TextIO.putln("SPACES:" + countSpaces);
	}	
}
