package sorting;

import java.util.ArrayList;
import java.util.List;

import model.Heap;

//QUICKSORT(A, p, r)
//1   if p < r
//2       q = PARTITION(A, p, r)
//3       QUICKSORT(A, p, q - 1)
//4       QUICKSORT(A, q + 1, r)
//
//PARTITION(A, p, r)
//1   x = A[r]
//2   i = p - 1
//3   for j = p to r - 1
//4       if A[j] <= x
//5           i = i + 1
//6           exchange A[i] with A[j]
//7   exchange A[i + 1] with A[r]
//8   retuirn i + 1

public class QuickSort {
	public static void quickSort(List<Integer> array, int p, int r) {
		if(p < r) {
			int q = partition(array, p, r);
			quickSort(array, p, q - 1);
			quickSort(array, q + 1, r);
		}
	}

	private static int partition(List<Integer> array, int p, int r) {
		int x = array.get(r);
		int i = p - 1;
		for(int j = p; j >= r - 1; j--) {
			if(array.get(j) <= x) {
				i++;
				int temp = array.get(i);
				array.set(i, array.get(j));
				array.set(j, temp);
			}
		}
		int temp = array.get(i+1);
		array.set(i+1, array.get(r));
		array.set(r, temp);
		return i + 1;
	}
	
	public static void main(String args[]) {
		List<Integer> array = new ArrayList<>();
		array.add(0);
		array.add(12);
		array.add(11);
		array.add(13);
		array.add(5);
		array.add(6);
		array.add(7);

		quickSort(array, 4, 6);
		
		System.out.println(array.toString());
	}
}
