//UIUC CS125 FALL 2013 MP. File: FindScriptLine.java, CS125 Project: Challenge2-Hollywood, Version: 2013-09-17T08:34:45-0500.110567916
/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author alding2
 */
public class FindScriptLine {

	public static void main(String[] args) {
		int count = 0;
		String word = "";
		TextIO.putln("Please enter the word(s) to search for");
		word = TextIO.getln();
		TextIO.putln("Searching for '" + word + "'");
		String word2 = word.toLowerCase();
		TextIO.readFile("thematrix.txt");
		while ( TextIO.eof() == false) {
			String line = TextIO.getln();
			count++;
			String line2 = line.toLowerCase();
			if ( line2.indexOf(word2) >= 0 ) {
				line = line.trim();
				TextIO.putln(count + " - " + line);
			}
		}
		TextIO.putln("Done Searching for '" + word + "'");
	}
}
