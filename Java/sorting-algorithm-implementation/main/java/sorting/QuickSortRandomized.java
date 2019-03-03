package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//RANDOMIZED-PARTITION(A, p, r)
//1   i = RANDOM(p, r)
//2   exchange A[r] with A[i]
//3   return PARTITION(A, p, r)
//
//RANDOMIZED-QUICKSORT(A, p, r)
//1   if p < r
//2       q = RANDOMIZED-PARTITION(A, p, r)
//3       RANDOMIZED-QUICKSORT(A, p, q - 1)
//4       RANDOMIZED-QUICKSORT(A, q + 1, r)

public class QuickSortRandomized {
	public static int randomizedPartition(List<Integer> array, int p, int r) {
		int i = random(p, r);
		int temp = array.get(r);
		array.set(r, array.get(i));
		array.set(i, temp);
		return QuickSort.partition(array, p, r);
	}

	private static int random(int p, int r) {
		int i = ThreadLocalRandom.current().nextInt(p, r + 1);
		return i;
	}
	
	public static void randomizedQuickSort(List<Integer> array, int p, int r) {
		if(p < r) {
			int q = randomizedPartition(array, p, r);
			randomizedQuickSort(array, p, q - 1);
			randomizedQuickSort(array, q + 1, r);
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

		randomizedQuickSort(array, 1, 6);
		
		System.out.println(array.toString());
	}
}
