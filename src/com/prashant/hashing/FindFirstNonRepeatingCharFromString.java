package com.prashant.hashing;

public class FindFirstNonRepeatingCharFromString {

	public Character getFirstNonRepeatingCharFromString(String input) {
		char strArray[] = input.toCharArray();
		int count[] = new int[256];
		char repeatingChar = 0;
		for(int i = 0; i < strArray.length; i++) {
			char c = strArray[i];
			count[strArray[i]]++;
		}
		
		for (int i = 0; i < strArray.length; i++) {
			if (count[strArray[i]] == 1) {
				System.out.println("Found the first non repeating character : " + strArray[i]);
				repeatingChar = strArray[i];
			}
		}
		return repeatingChar;
	}
	
	public static void main(String[] args) {
		FindFirstNonRepeatingCharFromString fc = new FindFirstNonRepeatingCharFromString();
		System.out.println(fc.getFirstNonRepeatingCharFromString("aabbccdeeffjj"));
	}

}
