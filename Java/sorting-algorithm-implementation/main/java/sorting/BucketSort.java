package sorting;

import java.util.ArrayList;
import java.util.List;

//Does not work as expected. Will have to review later.

//BUCKET-SORT(A)
//1	let B[1..n - 1] be a new array
//2	n = A.length
//3	for i = 0 to n - 1
//4		make B[i] and empty list
//5	for i = 1 to n
//6		insert A[i] into list B[floor(nA[i])]
//7	for i = 0 to n - 1
//8		sort list B[i] with insertion sort
//9	concatenate the lists B[0], B[1] ....... B[n - 1] together in order

public class BucketSort {
	public static void bucketSort(List<Integer> array) {
		int n = array.size();
		List<Integer> B = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			B.add(0);
		}
		for(int i = 1; i < n; i++) {
			B.set((int) Math.floor(n / array.get(i)), array.get(i));
		}
		for(int i = 0; i < n; i++) {
			QuickSort.quickSort(B, 0, i);
		}
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

		bucketSort(array);
		
		System.out.println(array.toString());
	}
}
