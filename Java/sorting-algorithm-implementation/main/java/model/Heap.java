package model;

import java.util.List;

/**
 * The Class Heap.
 */
public class Heap {
	
	/** The array. */
	List<Integer> array;
	
	/** The heap size. */
	int heapSize;
	
	/**
	 * Gets the array.
	 *
	 * @return the array
	 */
	public List<Integer> getArray() {
		return array;
	}
	
	/**
	 * Sets the array.
	 *
	 * @param array the new array
	 */
	public void setArray(List<Integer> array) {
		this.array = array;
	}
	
	/**
	 * Gets the heap size.
	 *
	 * @return the heap size
	 */
	public int getHeapSize() {
		return heapSize;
	}
	
	/**
	 * Sets the heap size.
	 *
	 * @param heapSize the new heap size
	 */
	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Heap [array=" + array + ", heapSize=" + heapSize + "]";
	}
}
