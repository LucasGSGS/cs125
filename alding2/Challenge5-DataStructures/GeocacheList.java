//UIUC CS125 FALL 2013 MP. File: GeocacheList.java, CS125 Project: Challenge5-DataStructures, Version: 2013-10-14T13:45:00-0500.576972931
/**
 * Complete the following GeocacheList, to ensure all unit tests pass.
 * There are several errors in the code below
 *
 * Hint: Get the Geocache class working and passing its tests first.
 * @author alding2
 */
public class GeocacheList {
	private Geocache[] data = new Geocache[0];			// data is an instance variable that refers to an array that doesn't hold objects yet
	private int size = 0;

	public Geocache getGeocache(int i) {
		return data[i];
	}

	public int getSize() {
		return size;
	}

	public GeocacheList() {
	}

	public GeocacheList(GeocacheList list, boolean deepCopy) {			// GeocacheList constructor
		if (deepCopy) {													// testDeepCopy
			for (int i = 0; i < list.data.length; i++) {
				add(list.data[i]);
				data[i] = new Geocache(list.data[i].getX(),list.data[i].getY());
			}
		} else {														// testShallowCopy
			for (int i = 0; i < list.data.length; i++) {
				add(list.data[i]);
				data[i].setX(list.data[i].getX());
				data[i].setY(list.data[i].getY());
			}
		}
		size = list.getSize();
	}

	public void add(Geocache p) {
		size++;
		if (size > data.length) {
			Geocache[] old = data;
			data = new Geocache[size * 2];
			for (int i = 0; i < old.length; i++)
				data[i] = old[i];
		}
		data[size-1] = p;
	}

	public GeocacheList removeFromTop() {				// testRemoveFromTop
		this.size--;
		GeocacheList result = new GeocacheList();
		for (int i = 0; i < result.getSize(); i++) {
			result.data[i] = this.data[i+1];
		}
		return result;		
	}

	public String toString() {
		StringBuffer s = new StringBuffer("GeocacheList:");
		for (int i = 0; i < size; i++) {
			if (i > 0)
				s.append(',');
			s.append(data[i]);
		}
		return s.toString();
}	}
