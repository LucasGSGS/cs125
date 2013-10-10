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
				int srcX = tgtH - 1 - tgtY;
				rotated[tgtX][tgtY] = source[srcX][srcY]; 
			}
		}
		return rotated;
	}

	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {					// testMerge
		int[][] result = new int[sourceB.length][sourceB[0].length];
		sourceA = resize(sourceA, sourceB);
		int redA, greenA, blueA;
		int redB, greenB, blueB;
		int avgRed, avgGreen, avgBlue, avgRGB;
		for (int a = 0; a < sourceA.length; a++) {
			for (int b = 0; b < sourceA[0].length; b++) {
				int rgbA = sourceA[a][b];
				int rgbB = sourceB[a][b];
				redA = RGBUtilities.toRed(rgbA);
				redB = RGBUtilities.toRed(rgbB);
				avgRed = (int)(redA + redB)/2;
				greenA = RGBUtilities.toGreen(rgbA);
				greenB = RGBUtilities.toGreen(rgbB);
				avgGreen = (int)(greenA + greenB)/2;
				blueA = RGBUtilities.toBlue(rgbA);
				blueB = RGBUtilities.toBlue(rgbB);
				avgBlue = (int)(blueA + blueB)/2;				
				avgRGB = RGBUtilities.toRGB(avgRed,avgGreen,avgBlue);
				result[a][b] = avgRGB;
			}
		}
		return result;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		int[][] newForeImage = resize(foreImage,backImage);
		int width = backImage.length;
		int height = backImage[0].length;
		int[][] result = new int[width][height];
		int greenAmount;
		for(int w = 0; w < width; w++) {
			for(int h = 0; h < height; h++) {
				greenAmount = RGBUtilities.toGreen(foreImage[w][h]);
				if (greenAmount > 50) result[w][h] = backImage[w][h];
				else result[w][h] = newForeImage[w][h];
			}
		}
		return result;
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.		
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source, int[][] sourceB) {
		int width = source.length;
		int height = source[0].length;
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
	public static int[][] funky(int[][] source, int[][] sourceB) {						// negative effect
		int width = source.length;
		int height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				red = 256 - red;
				green = 256 - green;
				blue = 256 - blue;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}
		return result;
		// You need to invent your own image effect
		// Minimum boring requirements to pass autograder:		
		// Does not ask for any user input and returns a new 2D array
		// Todo: remove this return null
	}
}
