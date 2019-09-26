package sorting;

import java.util.ArrayList;
import java.util.List;

import model.Heap;

/**
 * The Class HeapSort_failed.
 */
public class HeapSort_failed {

//	A --> arr
//	heap-size --> size
//	HEAPSORT(A)
//	1   BUILD-MAX-HEAP(A)
//	2   for i = A.length downto 2
//	3       exchange A[1] with A[i]
//	4       A.heap-size = A.heap-size - 1
//	5       MAX-HEAPIFY(A,1)
//
//	BUILD-MAX-HEAP(A)
//	1   A.heap-size = A.length
//	2   for i = floor(A.length / 2) downto 1
//	3   	MAX-HEAPIFY(A, i)
//
//	MAX-HEAPIFY(A,i)
//	1   left = LEFT(i)
//	2   r = RIGHT(i)
//	3   if left <= A.heap-size and A[left] > A[i]
//	4       largest = left
//	5   else largest = i
//	6   if r <= A.heap-size and A[r] > A[largest]
//	7       largest = r
//	8   if largest != i
//	9       exchange A[i] with A[largest]
//	10      MAX-HEAPIFY(A, largest)

	/**
	 * Parent.
	 *
	 * @param i the i
	 * @return the int
	 */
	public int parent(int i) {
		return (int) Math.floor(i / 2);
	}

	/**
	 * Left.
	 *
	 * @param i the i
	 * @return the int
	 */
	public static int left(int i) {
		return 2 * i;
	}

	/**
	 * Right.
	 *
	 * @param i the i
	 * @return the int
	 */
	public static int right(int i) {
		return 2 * i + 1;
	}

//	BUILD-MAX-HEAP(A)
//	1   A.heap-size = A.length
//	2   for i = floor(A.length / 2) downto 1
	/**
	 * Builds the max heap.
	 *
	 * @param heap the heap
	 */
//	3   	MAX-HEAPIFY(A, i)
	private static void buildMaxHeap(Heap heap) {
		List<Integer> array = heap.getArray();
		heap.setHeapSize(array.size());
		for (int i = (int) Math.floor(array.size() / 2); i >= 1; i--) {
			maxHeapify(heap, i);
		}
	}

//	MAX-HEAPIFY(A,i)
//	1   left = LEFT(i)
//	2   r = RIGHT(i)
//	3   if left <= A.heap-size and A[left] > A[i]
//	4       largest = left
//	5   else largest = i
//	6   if r <= A.heap-size and A[r] > A[largest]
//	7       largest = r
//	8   if largest != i
//	9       exchange A[i] with A[largest]
	/**
	 * Max heapify.
	 *
	 * @param heap the heap
	 * @param i    the i
	 */
//	10      MAX-HEAPIFY(A, largest)
	private static void maxHeapify(Heap heap, int i) {
		List<Integer> array = heap.getArray();
		int left = left(i);
		int right = right(i);
		int largest = 0;
		if (left <= heap.getHeapSize() && array.get(left) > array.get(i)) {
			largest = left;
		} else {
			largest = i;
		}
//		if(right <= heap.getHeapSize() && array.get(right) > array.get(largest)) {
//			largest = right;
//		}
		if (right <= heap.getHeapSize() - 1) {
			if (right <= heap.getHeapSize() && array.get(right) > array.get(largest)) {
				largest = right;
			}
		}
		if (largest != i) {
			int x = array.get(i);
			array.set(i, array.get(largest));
			array.set(largest, x);
			heap.setArray(array);
			maxHeapify(heap, largest);
		}
	}

//	HEAPSORT(A)
//	1   BUILD-MAX-HEAP(A)
//	2   for i = A.length downto 2
//	3       exchange A[1] with A[i]
//	4       A.heap-size = A.heap-size - 1
	/**
	 * Heap sort.
	 *
	 * @param heap the heap
	 */
//	5       MAX-HEAPIFY(A,1)
	public static void heapSort(Heap heap) {
		buildMaxHeap(heap);
		for (int i = heap.getArray().size() - 1; i >= 1; i--) {
			List<Integer> array = heap.getArray();
			int x = array.get(1);
			array.set(1, array.get(i));
			array.set(i, x);
			heap.setArray(array);
			heap.setHeapSize(heap.getHeapSize() - 1);
			maxHeapify(heap, 1);
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
		heap.setHeapSize(array.size());
		heapSort(heap);

		System.out.println(heap.getArray().toString());
	}
}
