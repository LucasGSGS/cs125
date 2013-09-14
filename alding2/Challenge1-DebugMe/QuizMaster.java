//UIUC CS125 FALL 2013 MP. File: QuizMaster.java, CS125 Project: Challenge1-DebugMe, Version: 2013-09-10T09:27:43-0500.723066467
/**
 * A program to test students' CS knowledge.
 * Watch out ! There may be deliberate bugs in some of the logic below :-)
 * @see QuizMaster-ReadMe.txt for details on how to complete this program.
 * @author alding2
 *
 */
public class QuizMaster {

	public static void main(String[] args) {
		
		System.out.println("Please enter your zip code.");
		String zip = TextIO.getln(); // Roughly, 61xxx-Illinois 48xxx = Michigan
	
		System.out.println("Which University CS Department was recently awarded $208 million to develop the worlds fastest computer?");
		System.out.println("1. Illinois\n2. Michigan\n3. MIT");
		int gridComputing = TextIO.getlnInt();
		
		System.out.println("Which University CS Department designed and built the pioneering ILLIAC series?");
		System.out.println("1. Illinois\n2. Wisconsin\n3. Berkeley");
		int illiac = TextIO.getlnInt();
		
		TextIO.putln("Which University released 'Mosaic' - the first multimedia cross-platform browser?");
		System.out.println("(Mosaic's source code was later licensed to Microsoft and Netscape Communications)");
		System.out.println("1. Illinois\n2. Michigan\n3. Wisconsin");
		int mosaic = TextIO.getlnInt();
		
		System.out.println("True/False? Variables have four things: a type, name, value and a memory location.");
		System.out.println("1. True\n2. False");
		int varTF = TextIO.getlnInt();
		
		int score = 0;                /* Computer score: + 10 points for each correct answer */
		if(gridComputing==1) score = score + 10;
		if(illiac==1) score = score + 10;
		if(mosaic==1) score = score +10;
		if(varTF==1) score = score + 10;
		
		/* Michigan students (zip code 48xxx) need to get all of them correct to receive any points */
		if((zip.charAt(0) == '4') && (zip.charAt(1) == '8')) {
			if (score < 40) score = 0;
			System.out.println("You scored:" + score);
		}
		/* If an Illinois student gets all questions correct print congratulations */
		if ((zip.charAt(0) == '6') && (zip.charAt(1) == '1')) {
			if(score == 40) {
				System.out.println("You scored:" + score); 
				System.out.println("Congratulations!");
			}
			else if (score < 40) System.out.println("You scored:" + score);
		}
		else if ((zip.charAt(0) != '4') && (zip.charAt(1) != '6'))
			System.out.println("You scored:" + score);
	}
}
