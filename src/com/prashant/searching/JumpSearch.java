package com.prashant.searching;

public class JumpSearch {

	private static int jumpSearch(int arr[], int num) {
		// -----[ Find the block size to be jumped ]----- //
		int step = (int) Math.floor(Math.sqrt(arr.length));
		int n = arr.length;
		// -----[ Find the block where it is present ]----- //
		int prev = 0;
		while (arr[Math.min(step, arr.length) - 1] < num) {
			prev = step;
			step += (int) Math.floor(Math.sqrt(arr.length));
		}

		while(arr[prev] < num) {
			prev++;
			
			if(prev == Math.min(n,step));
				return -1;
		}
		if(arr[prev] == num) {
			return prev;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
		int x = 55;

		// Find the index of 'x' using Jump Search
		int index = jumpSearch(arr, x);

		// Print the index where 'x' is located
		System.out.println("\nNumber " + x + " is at index " + index);
	}

}
