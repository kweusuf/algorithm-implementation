package sorting;

import java.util.ArrayList;
import java.util.List;

import model.Heap;

/**
 * The Class HeapSort.
 */
public class HeapSort {

	/**
	Heapsort(A) {
	   BuildHeap(A)
	   for i <- length(A) downto 2 {
	      exchange A[1] <-> A[i]
	      heapsize <- heapsize -1
	      Heapify(A, 1)
	}
	*/
	/**
	 * Heap sort.
	 *
	 * @param heap the heap
	 */
	public static void heapSort(Heap heap) {
		buildHeap(heap);
		for (int i = heap.getArray().size() - 1; i >= 2; i--) {
			List<Integer> array = heap.getArray();
			int x = array.get(i);
			array.set(i, array.get(1));
			array.set(1, x);
			heap.setArray(array);
			heap.setHeapSize(heap.getHeapSize() - 1);
			heapify(heap, 1);
		}
	}
	/**
	BuildHeap(A) {
	   heapsize <- length(A)
	   for i <- floor( length/2 ) downto 1
	      Heapify(A, i)
	}
	*/

	/**
	 * Builds the heap.
	 *
	 * @param heap the heap
	 */
	public static void buildHeap(Heap heap) {
		heap.setHeapSize(heap.getArray().size() - 1);
		int i = (int) Math.floor(heap.getArray().size() / 2);
		for (; i >= 1; i--) {
			heapify(heap, i);
		}
	}

	/**
	Heapify(A, i) {
	   le <- left(i)
	   ri <- right(i)
	   if (le<=heapsize) and (A[le]>A[i])
	      largest <- le
	   else
	      largest <- i 
	   if (ri<=heapsize) and (A[ri]>A[largest])
	      largest <- ri
	   if (largest != i) {
	      exchange A[i] <-> A[largest]
	      Heapify(A, largest)
	   }
	}
	*/

	/**
	 * Heapify.
	 *
	 * @param heap the heap
	 * @param i    the i
	 */
	public static void heapify(Heap heap, int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int largest = 0;
		if ((left <= heap.getHeapSize()) && (heap.getArray().get(left) > heap.getArray().get(i))) {
			largest = left;
		} else {
			largest = i;
		}
		if (right <= heap.getHeapSize()) {
			if (heap.getArray().get(right) > heap.getArray().get(largest)) {
				largest = right;
			}
		}
		if (largest != i) {
			List<Integer> array = heap.getArray();
			int x = array.get(i);
			array.set(i, array.get(largest));
			array.set(largest, x);
			heap.setArray(array);
			heapify(heap, largest);
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		List<Integer> array = new ArrayList<>();
		array.add(0);
		array.add(12);
		array.add(11);
		array.add(13);
		array.add(5);
		array.add(6);
		array.add(7);

		Heap heap = new Heap();
		heap.setArray(array);
		heap.setHeapSize(array.size() - 1);
		heapSort(heap);

		System.out.println(heap.getArray().toString());
	}

}
