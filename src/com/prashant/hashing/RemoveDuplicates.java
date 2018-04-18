package com.prashant.hashing;

import java.util.Arrays;
import java.util.Hashtable;

public class RemoveDuplicates {

	private int[] removeDuplicatesUnsorted(int array[]) {
		int length = array.length;
		for(int i = 0; i < length; i++) {
			for(int j = i+1; j < length; j++ ) {
				if(array[i] == array[j]) {
					while(length > j) {
						if(array[j] != array[length - 1]) {
							array[j] = array[length - 1];
							array[length-1] = '\0';
							length--;
							break;
						} else if(array[j] == array[length -1]) {
							array[length-1] = '\0';
							length--;
						}
					}
				}
			}
		}
		return array;
	}
	
	private char[] removeDuplicatesUsingSort(char array[]) {
		Arrays.sort(array);
		int count = 0;
		for(int i = 1; i < array.length; i++) {
			if(array[count] != array[i] ) {
				count++;
				array[count] = array[i];
			} else if(array[count] == array[i]) {
				//move to the next item
				continue;
			}
		}
		//Empty the rest of the items
		for(int i = count+1; i < array.length; i++) {
			array[i] = '\0';
		}
		return array;
	}
	
	
	private void removeDuplicatesUsingHashTable(char array[]) {
		Hashtable<Integer, Character> hashtable = new Hashtable<>();
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			char c = array[i];
			if(!hashtable.containsValue(c)) {
				hashtable.put(count, c);
				count++;
			}
		}
		System.out.println("Removed elements: "+hashtable.values());
	}
	
	
	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		int array[] = {1,1,1};
		
		System.out.println("Remove duplicates (unsorted array as input) Output: " + Arrays.toString(rd.removeDuplicatesUnsorted(array)));
		char arr[] = {'a','a','b','b','c','c','c','d'};
		System.out.println("Remove duplicates from " + Arrays.toString(arr) + " (sorted array as input) Output: " + Arrays.toString(rd.removeDuplicatesUsingSort(arr)));
		
		System.out.println("Remove duplicates from " + Arrays.toString(arr) + " (sorted array as input) Output: " );
		rd.removeDuplicatesUsingHashTable(arr);

	}

}
