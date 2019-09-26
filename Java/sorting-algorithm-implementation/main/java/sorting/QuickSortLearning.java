package test;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	public static int partition(List<Integer> array, int p, int r) {
		int x = array.get(r);
		int i = p - 1;
		for(int j = p; j < r; j++) {
			if(array.get(j) <= x) {
				i = i + 1;
				int temp = array.get(i);
				array.set(i, array.get(j));
				array.set(j, temp);
				System.out.println("i = " + i + "; j = " + j + "; A = " + array.toString());
			}
		}
		int temp = array.get(i + 1);
		array.set(i + 1, array.get(r));
		array.set(r, temp);
		System.out.println("Final A = " + array.toString());
		return i + 1;
	}
	
	public static void quickSort(List<Integer> array, int p, int r) {
		if(p < r) {
			int q = partition(array, p, r);
			quickSort(array, p, q - 1);
			quickSort(array, q + 1, r);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> array = new ArrayList<Integer>();
//		array.add(9);
//		array.add(6);
//		array.add(5);
//		array.add(0);
//		array.add(8);
//		array.add(2);
//		array.add(4);
//		array.add(7);
		
		array.add(1);
		array.add(3);
		array.add(2);
		array.add(5);
		array.add(7);
		array.add(6);
		array.add(4);
		
//		int q = partition(array, 0, 7);
		
		quickSort(array, 0, array.size()-1);
		System.out.println("Sorted Array: A = " + array.toString());
	}
}

