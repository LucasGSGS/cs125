//UIUC CS125 FALL 2013 MP. File: UsingPublicFieldsIsEasy.java, CS125 Project: Challenge5-DataStructures, Version: 2013-10-14T13:45:00-0500.576972931

/**
 * Complete the class method 'analyze' that takes a SimplePublicPair object as an argument
 * and returns a new SimplePublicTriple object.
 * The SimplePublicTriple needs to set up as follows:
 * x = the minimum value of 'a' and 'b'
 * y = the maximum value of 'a' and 'b'
 * description:a*b=M 
 *   where a,b, and M are replaced with the numerical values of a, b and the multiplication of a and b.
 * Your code will create a SimplePublicTriple, initializes the three fields and return a reference to the SimplePublicTriple object.
 * @author alding2
 */
public class UsingPublicFieldsIsEasy {	
	public static SimplePublicTriple analyze(SimplePublicPair in) {
		SimplePublicTriple result = new SimplePublicTriple();
		int M;
		if (in.a < in.b) {
			result.x = in.a;
			result.y = in.b;
		}
		else {
			result.x = in.b;
			result.y = in.a;
		}
		M = result.x*result.y;
		result.description = in.a + "*" + in.b + "=" + M;
		return result;
	}
}
