//UIUC CS125 FALL 2013 MP. File: MyScriptPrinter.java, CS125 Project: Challenge2-Hollywood, Version: 2013-09-17T08:34:45-0500.110567916
/**
 * A program to print one actor's lines. 
 * See ScriptPrinter.txt for more information.
 * TODO: add your netid to the line below
 * @author alding2
 */
public class MyScriptPrinter {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean output = false; //Set to true when we find the desired character
		String name=""; // Only print lines for this character		
		TextIO.putln("Which character's lines would you like? (NEO,MORPHEUS,ORACLE)");
		name = TextIO.getln();
		name = name.toUpperCase();
		TextIO.readFile("thematrix.txt");
		TextIO.putln(name + "'s lines:");
		output = false;
		while ( false == TextIO.eof()) {
			String line = TextIO.getln();
			if (line.isEmpty()) {
				output = false;
				line = TextIO.getln();
				if (line.indexOf(name) >= 0)
					output = true;
			}
			if (output) {
				line = TextIO.getln();
				line = line.trim();
				TextIO.putln(name + ":" + "\"" + line + "\"");
			}
		}
		TextIO.put("---");
	}
}
