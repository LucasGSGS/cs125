//UIUC CS125 FALL 2013 MP. File: GeneAnalysis.java, CS125 Project: Challenge6-RecursionSee, Version: 2013-11-05T16:03:10-0600.767323587
/**
 * @author alding2
 *
 */
public class GeneAnalysis
{
	/** Wrapper method. Returns the length of the longest 
	 * common subsequence
	 */
	public static int score(String gene1, String gene2)
	{
		char[] g1 = gene1.toCharArray();
		char[] g2 = gene2.toCharArray();
		return score(g1,g2,g1.length-1,g2.length-1);
		
		//throw new IllegalArgumentException("Not Yet Implemented");
		// Hint: Use toCharArray() to convert each string to a char array.
		 // call your recursive implementation here with
		// the genes as char arrays, starting at the end of each gene.
	}

	/** Implements longest common subsequence recursive search
The recursive case is defined as
					S(i-1, j)
S(i,j) = max {		S(i,j-1)
					S(i-1,j-1)
					S(i-1,j-1) + 1 if gene1[i] = gene2[j]

NB  0<=i < gene1.length
    0<=j < gene2.length

You need to figure out the base case.
	 * */
	private static int score(char[] gene1, char[] gene2, int i, int j) {
		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		int s4 = 0;
		int s12 = 0;
		int s34 = 0;
		if (i < 0 || j < 0) return 0;
		if (gene1[i] == gene2[j]) return 1;
		else {
			s1 += score(gene1,gene2,i-1,j);
			s2 += score(gene1,gene2,i,j-1);
			s3 += score(gene1,gene2,i-1,j-1);
			s4 += score(gene1,gene2,i-1,j-1) + 1;
			s12 = Math.max(s1, s2);
			s34 = Math.max(s3, s4);
			return Math.max(s12,s34);
		}
	}
//	define a private recursive Class method 'score' that 
//	returns an integer the score.
//	The method should take four parameters- 
//	two char arrays and two integers (gene1,gene2,i,j)
//	i and j are the indices into gene1 and gene2 respectively.

}
// Use local variables to store a recursive result so that you  do not need to calculate it again.

// Do not use a loops.
