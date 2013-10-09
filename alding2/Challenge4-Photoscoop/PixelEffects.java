//UIUC CS125 FALL 2013 MP. File: PixelEffects.java, CS125 Project: Challenge4-Photoscoop, Version: 2013-10-05T03:10:10-0500.192963615

/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author alding2
 */
public class PixelEffects {

	public static int[][] copy(int[][] source) {				//testCopy
		int width = source.length, height = source[0].length;
		int[][] copy = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				copy[i][j] = source[i][j];
			}
		}
		return copy;
		// Create a NEW 2D integer array and copy the colors across
		// See redeye code below
	}
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {		//testResizeToArray
		int width = source.length;
		int height = source[0].length;
		int[][] resized = new int[newWidth][newHeight];
		for(int x = 0; x < newWidth; x++) {
			for(int y = 0; y < newHeight; y++) {
				int origX = (int)x*width/newWidth;
				int origY = (int)y*height/newHeight;
				resized[x][y] = source[origX][origY]; 
			}
		}
		return resized;
		// Hints: Use two nested for loops between 0... newWidth-1 and 0.. newHeight-1 inclusive.
		// Hint: You can just use relative proportion to calculate the x (or y coordinate) in the original image.
		// For example if you're setting a pixel halfway across the image, 
		// you should be reading half way across the original image too.
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	public static int[][] half(int[][] source) {									//testHalf
		return resize(source, source.length/2, source[0].length/2);
	}
	
	/**
	 * Create a new image array that is the same dimensions of the reference
	 * array. The array may be larger or smaller than the source. Hint -
	 * this methods should be just one line - delegate the work to resize()!
	 * 
	 * @param source
	 *            the source image
	 * @param reference
	 * @return the resized image
	 */
	public static int[][] resize(int[][] source, int[][] reference) {				// testResizeToArray
		return resize(source, reference.length, reference[0].length);
	}

	/** Flip the image vertically */
	public static int[][] flip(int[][] source) {									// testFlip
		int width = source.length;
		int height = source[0].length;
		int[][] flipped = new int[width][height];
		for(int w = 0; w < width; w++) {
			for(int h = 0; h < height; h++) {
				int origW = w;
				int origH = source[0].length - 1 - h;
				flipped[w][h] = source[origW][origH]; 
			}
		}
		return flipped;
	}

	/** Reverse the image horizontally */
	public static int[][] mirror(int[][] source) {									// testMirror
		int width = source.length;
		int height = source[0].length;
		int[][] flipped = new int[width][height];
		for(int w = 0; w < width; w++) {
			for(int h = 0; h < height; h++) {
				int origW = source.length - 1 - w;
				int origH = h;
				flipped[w][h] = source[origW][origH]; 
			}
		}
		return flipped;
	}

	/** Rotate the image */
	public static int[][] rotateLeft(int[][] source) {								// testRotateLeft
		int srcW = source.length;
		int srcH = source[0].length;
		int tgtW = srcH;
		int tgtH = srcW;
		int[][] rotated = new int[tgtW][tgtH];
		for(int tgtX = 0; tgtX < tgtW; tgtX++) {
			for(int tgtY = 0; tgtY < tgtH; tgtY++) {
				int srcY = tgtX;
				int srcX = tgtH - tgtY - 1;
				rotated[tgtX][tgtY] = source[srcX][srcY]; 
			}
		}
		return rotated;
	}

	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {
		
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel ofthe background).
		return sourceA;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		return foreImage;
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source, int[][] sourceB) {

		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64)
					red = green = blue = 0;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}

		return result;
	}

	/* Upto you! do something fun to the image */
	public static int[][] funky(int[][] source, int[][] sourceB) {
		// You need to invent your own image effect
		// Minimum boring requirements to pass autograder:
		
		// Does not ask for any user input and returns a new 2D array
		// Todo: remove this return null
		return null;
	}
}
