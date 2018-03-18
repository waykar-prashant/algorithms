package com.prashant.searching;

public class LocalMinimaUtil {

	private int getLocalMinima(int arr[], int low, int high) {
		int mid = (high + low) / 2;
		 if (mid > 0 || (arr[mid - 1] > arr[mid] && mid == arr.length-1) || (arr[mid] < arr[mid + 1])) {
			return mid;
		} else if(mid > 0 && arr[mid - 1] < arr[mid]){
			//search in the left
			System.out.println("Search in the left");
			return getLocalMinima(arr, low, mid-1);
		} else{
			//search in the right
			System.out.println("Search in the right");
			return getLocalMinima(arr, mid+1, high);
		}
	}
	
	public static void main(String[] args) {
		LocalMinimaUtil lm = new LocalMinimaUtil();
		int arr[] = {23, 8, 15, 2, 3};//{9, 6, 3, 14, 5, 7, 4};
		System.out.println("index - " + lm.getLocalMinima(arr, 0, arr.length-1));
	}

}
