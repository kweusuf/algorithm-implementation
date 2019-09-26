package divideNConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 1	Algorithm BinSrch(a, i, l, x)
 * 2	// Given an array a[i: l] of elements in non decreasing
 * 3	// order, i <= i <= l, determine whether x is present, and
 * 4	// if so, return j such that x = a[j]; else return 0.
 * 5	{
 * 6		if (l = i) then // If Small(P)
 * 7		{
 * 8			if (x = a[i]) then return i;
 * 9			else return 0;
 * 10		}
 * 11		else
 * 12		{ // Reduce P into a smaller subproblem.
 * 13			mid := floor((i + l) / 2);
 * 14			if (x = a[mid]) then return mid;
 * 15			else if (x < a[mid]) then
 * 16					return BinSrch(a, i, mid - 1, x);
 * 17				 else return BinSrch(a, mid + 1, l, x);
 * 18		}
 * 19	}		
 */
public class RecursiveBinarySearch {
	public static int binarySearch(List<Integer> array, int i, int l, int x) {
		if(l == i) {
			if(x == array.get(i)) {
				return i;
			} else {
				return 0;
			}
		} else {
			int mid = (int) Math.floor((i + l) / 2);
			if(x == array.get(mid)) {
				return mid;
			} else if(x < array.get(mid)) {
				return binarySearch(array, i, mid - 1, x);
			} else {
				return binarySearch(array, mid + 1, l, x);
			}
		}
	}
	
	public static void main(String args[]) {
		List<Integer> array = new ArrayList<>();
		
		array.add(1);
		array.add(3);
		array.add(5);
		array.add(6);
		array.add(7);
		array.add(8);
		array.add(17);
		array.add(132);
		array.add(199);
		array.add(1000);
		array.add(1005);
		
		int location = binarySearch(array, 0, 9, 8);
		System.out.println("x is located at index: " + location);
	}
}
