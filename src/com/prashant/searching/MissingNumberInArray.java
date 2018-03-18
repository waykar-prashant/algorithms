package com.prashant.searching;

public class MissingNumberInArray {

	private static int getMissingNumber(int arr[]) {
		// -----[ Use n*(n+1)/2]----- //
		int totalValue = ((arr.length+1) *(arr.length +1 + 1))/2;
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			total+=arr[i];
		}
		
		return totalValue-total;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,5,6,7};
		System.out.println("Missing Number : " + getMissingNumber(arr));
	}

}
