package com.prashant.searching;

import java.util.Arrays;

public class FindThreeNumsSum {

	public static void searchThreeNumbersHavingSum(int arr[], int sum) {
		// -----[ Sort ]----- //
		Arrays.sort(arr);
		int n = arr.length;
		for (int k = 0; k < n; k++) {
			for (int i = k + 1, j = n - 1; i < j;) {
				if (arr[i] + arr[j] + arr[k] == sum) {
					System.out.println("Numbers at indexs i: " + i + " j:" + j + " k:" + k);
				} else if (arr[i] + arr[j] + arr[k] < sum) {
					i++;
				} else {
					j--;
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {10,1,2,3,4,5,6,7,8,9};
		searchThreeNumbersHavingSum(arr, 15);
		
	}

}
