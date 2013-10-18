//UIUC CS125 FALL 2013 MP. File: Queue.java, CS125 Project: Challenge5-DataStructures, Version: 2013-10-14T13:45:00-0500.576972931
//@author alding2
public class Queue {
	private double[] data = new double[0];
	private int size = 0;
	
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	public void add(double value) {
		size++;
		double[] old = data;
		data = new double[size];						
		data[0] = value;
		for (int i = 1; i < data.length; i++) {
			data[i] = old[i-1];
		}	
	} 
	
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		if (size == 0) return 0;
		size--;
		double[] old = data;
		for (int i = 0; i < size; i++) {
			data[i] = old[i];			
		}
		return data[size];
	}

	/** Returns the number of items in the queue. */
	public int length() {
		return size;		
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		return data.length == 0;
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		String result = "";
		result = result + this.data[this.size - 1];
		for (int i = this.size - 2; i >= 0; i--) {
			result = result + "," + this.data[i];
		}
		return result;
	}
}
