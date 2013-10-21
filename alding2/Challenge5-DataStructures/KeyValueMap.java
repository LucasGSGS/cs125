//UIUC CS125 FALL 2013 MP. File: KeyValueMap.java, CS125 Project: Challenge5-DataStructures, Version: 2013-10-14T13:45:00-0500.576972931
//@author alding2
import java.awt.Color;

public class KeyValueMap { // aka Dictionary or Map
	private String[] str = new String[0];
	private int size = 0;
	private Color[] color = new Color[0];
	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	public void add(String key, Color key2) {
		size++;
		String[] old = str;
		str = new String[size];						
		str[0] = key;
		for (int i = 1; i < str.length; i++) {
			str[i] = old[i-1];
		}

		Color[] old2 = color;
		color = new Color[size];						
		color[0] = key2;
		for (int i = 1; i < str.length; i++) {
			color[i] = old2[i-1];
		}
	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		for (int i = 0; i < size; i++) {
			if (key.equals(str[i])) return color[i];
		}
		return null;
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		for (int i = 0; i < size; i++) {
			if (key.equals(str[i])) return true;
		}
		return false;
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		int found = 0;
		for (int i = 0; i < size; i++) {
			if (key.equals(str[i])) found = i;
		}
		size--;
		String[] old = str;
		str = new String[size];						
		for (int i = 0; i < found; i++) {
			str[i] = old[i];
		}
		for (int i = found+1; i < size; i++) {
			str[i-1] = old[i];
		} 		
	}

}
