package com.prashant.hashing;

public class FindFirstRepeatingCharFromString {

	public Character getFirstRepeatingCharFromString(String input) {
		char strArray[] = input.toCharArray();
		int count[] = new int[256];
		char repeatingChar = 0;
		for(int i = 0; i < strArray.length; i++) {
			char c = strArray[i];
			if(count[strArray[i]] == 1) {
				System.out.println("Found the first repeating character : " + strArray[i]);
				repeatingChar = strArray[i];
			} else {
				count[strArray[i]]++;
			}
		}
		return repeatingChar;
	}
	
	public static void main(String[] args) {
		FindFirstRepeatingCharFromString fc = new FindFirstRepeatingCharFromString();
		System.out.println(fc.getFirstRepeatingCharFromString("prashent"));
	}

}
