//UIUC CS125 FALL 2013 MP. File: PlayListUtil.java, CS125 Project: Challenge4-Photoscoop, Version: 2013-10-05T03:10:10-0500.192963615
/**
 * Add you netid here..
 * @author alding2
 *
 */
public class PlayListUtil {

	/**
	 * Debug ME! Use the unit tests to reverse engineer how this method should work.
	 * Hint: Fix the formatting (shift-cmd-F) to help debug the following code
	 * @param list
	 * @param maximum
	 */
	public static void list(String[] list, int maximum) {
		int i;
		for (i = 0; maximum == -1 || i < maximum; i++) {
			TextIO.putln((i+1) + ". " + list[i]);
		}
	}

	/**
	 * Appends or prepends the title
	 * @param list
	 * @param title
	 * @param prepend if true, prepend the title otherwise append the title
	 * @return a new list with the title prepended or appended to the original list
	 */
	public static String[] add(String[] list, String title, boolean prepend) {					// testPrepend, testAppend
		int resultLength = list.length + 1;
		String[] result = new String[resultLength];
		if (prepend) {
			result[0] = title;
			for (int i = 1; i < resultLength; i++) {
				result[i] = list[i-1];
			}
		}
		else {
			for (int i = 0; i < resultLength - 1; i++) {
				result[i] = list[i];
			}
			result[resultLength - 1] = title;
		}
		return result;
	}
	/**
	 * Returns a new list with the element at index removed.
	 * @param list the original list
	 * @param index the array index to remove.
	 * @return a new list with the String at position 'index', absent.
	 */
	public static String[] discard(String[] list, int index) {
		String[] result = new String[list.length - 1];
		int i;
		for (i = 0; i <= index; i++) {
			result[i] = list[i];
		}
		for (i = index + 1; i < result.length + 1; i++) {
			result[i - 1] = list[i];
		}
		return result;
	}

}
