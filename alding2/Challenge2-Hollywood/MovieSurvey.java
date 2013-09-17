//UIUC CS125 FALL 2013 MP. File: MovieSurvey.java, CS125 Project: Challenge2-Hollywood, Version: 2013-09-17T08:34:45-0500.110567916
/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author alding2
 */
public class MovieSurvey {
	public static void main(String[] arg) {
		int cinema;
		int dvd;
		int computer;
		int total;
		double cinemaFraction;
		double notCinemaFraction;
		TextIO.putln("Welcome. We're interested in how people are watching movies this year.");
		TextIO.putln("Thanks for your time. - The WRITERS GUILD OF AMERICA.");
		TextIO.putln("Please tell us about how you've watched movies in the last month.");
		TextIO.putln("How many movies have you seen at the cinema?");
		cinema = TextIO.getlnInt();
		TextIO.putln("How many movies have you seen using a DVD or VHS player?");
		dvd = TextIO.getlnInt();
		TextIO.putln("How many movies have you seen using a Computer?");
		computer = TextIO.getlnInt();
		TextIO.putln("Summary: " + cinema + " Cinema movies, " + dvd + " DVD/VHS movies, " + computer + " Computer movies");
		total = cinema + dvd + computer; 
		TextIO.putln("Total: " + total + " movies");
		cinemaFraction = (cinema/(double)total)*100.00;
		TextIO.put("Fraction of movies seen at a cinema: ");
		TextIO.putf("%.2f",cinemaFraction);
		TextIO.putln("%");
		notCinemaFraction = 100.00 - cinemaFraction;
		TextIO.put("Fraction of movies seen outside of a cinema: ");
		TextIO.putf("%.2f",notCinemaFraction);
		TextIO.putln("%");
	}
}
