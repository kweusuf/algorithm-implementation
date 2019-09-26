package sorting;

import java.util.ArrayList;
import java.util.List;

// Not a flawless implementation but still usable...

//COUNTING-SORT(A, B, k)
//1	let C[0..k] be a new array
//2	for i = 0 to k
//3		c[i] = 0
//4	for j = 1 to A.length
//5		C[A[j]] = C[A[j]] + 1
//6	// C[i] now contains the number of elements equal to i.
//7	for i = 1 to k
//8		C[i] = C[i] + C[i - 1]
//9	// C[i] now contains the number of elements less than or equal to i.
//10	for j = A.length downto 1
//11		B[C[A[j]]] = A[j]
//12		C[A[j]] = C[A[J]] - 1

public class CountingSort {
	public static void countingSort(List<Integer> A, List<Integer> B, int k) {
		List<Integer> C = new ArrayList<>();
		int i = 0;
		while(i <= k) {
			C.add(0);
			B.add(0);
			i++;
		}
		for(int j = 1; j <= A.size() - 1; j++) {
			C.set(A.get(j), C.get(A.get(j)) + 1);
		}
		for(i = 1; i <= k; i++) {
			C.set(i, C.get(i) + C.get(i - 1));
		}
		for(int j = A.size() - 1; j >= 1; j--) {
			B.set(C.get(A.get(j)), A.get(j));
			C.set(A.get(j), C.get(A.get(j)) - 1);
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

		List<Integer> B = new ArrayList<Integer>();
		int k = 15;
		
		countingSort(array, B, k);

		System.out.println(B.toString());
	}
}
