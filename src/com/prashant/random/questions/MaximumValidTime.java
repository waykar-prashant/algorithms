package com.prashant.random.questions;
/**
 * sort numbers in high -> low iterate over each digit [i] and search through
 * the list until you find the highest number that fits the requirements. [0]
 * must be <=2 [1] must be <=3 if [0]==2 [2] must be <=5 [3] can be anything
 * Remove that number from the list, and place it in position [i] repeat for
 * each digit
 */
public class MaximumValidTime {

	public static void main(String[] args) {
		MaximumValidTime mt = new MaximumValidTime();
		int A = 2;
		int B = 3;
		int C = 6;
		int D = 9;
		System.out.println(mt.solution(A, B, C, D));
	}

	private String solution(int A, int B, int C, int D) {
		int numbers[] = new int[4];
		numbers[0] = A;
		numbers[1] = B;
		numbers[2] = C;
		numbers[3] = D;
		try {
			return createTime(numbers);
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	private int findMax(int arr[], int valToFind) throws Exception {
		if (arr.length != 4)
			return -1;
		int numToFind = -1;
		int indexToRemove = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= valToFind) {
				if (arr[i] > numToFind) {
					numToFind = arr[i];
					indexToRemove = i;
				}
			}
		}
		if (indexToRemove == -1)
			throw new Exception("NOT POSSIBLE");
		arr[indexToRemove] = -1;
		return numToFind;
	}

	private String createTime(int[] numbers) throws Exception {
		int[] time = new int[4];
		time[0] = findMax(numbers, 2);
		time[1] = time[0] == 2 ? findMax(numbers, 3) : findMax(numbers, 9);
		time[2] = findMax(numbers, 5);
		time[3] = findMax(numbers, 9);
		String timeInString = time[0] + "" + time[1] + ":" + time[2] + "" + time[3];
		return timeInString;
	}

}
