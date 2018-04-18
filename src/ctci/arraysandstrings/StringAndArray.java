package ctci.arraysandstrings;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;


public class StringAndArray {

	public static void main(String args[]){
		
		//1. Find the first non repeated character
		//getFirstNonRepeaterChar();
		
		//2. Remove Specified Characters
/*		String str = "Battle of the Vowels: Hawaii vs. Grozny";
		String remove = "aeiou";
		removeChars(str, remove);
*/
		//3. Reverse Words
/*		String str = "Do or do not, there is no try.";
		reverseWords(str);
*/		

		//4. String to Integer
		
		
		//CI 1.1 - String has all unique characters
/*		String str = "rhythm";
		checkForUniqueCharacters(str);
*/	
		
		//CT 1.2 - Reverse String
		//String str = "Prashant";
		//reverseString(str);
		
		//CT 1.3 Check if a string is a palindrome of other
		/*String str1 = "dog";
		String str2 = "god";
		checkIfPermutation(str1, str2);*/
		
		//CT 1.4 Replace empty spaces in string with %20
		//String str = "Prashant Waykar     ";
		//replaceEmptySpaces(str);
		
		//CT 1.5 String Compression using the counts of repeated characters
		//String str = "aabcccccaaa";
		//stringCompression1(str);
		//stringCompression2(str);
		
		//CT 1.6 Rotate NXN Matrix by 90 degree
		rotateMatrix();
		
		//CT 1.7 Set entire row and column of matrix having 0 in it
		int array[][] = new int[3][3];
		array[0][0] = 1;
		array[0][1] = 1;
		array[0][2] = 1;

		array[1][0] = 1;
		array[1][1] = 1;
		array[1][2] = 1;

		array[2][0] = 1;
		array[2][1] = 1;
		array[2][2] = 0;
		
		setMatrixZero(array);
		
		//Remove duplicates from the array
		int arr[] = {2, 8, 6, 2, 8, 6, 4, 5, 9};
		//int arr[] = {2,2,2,2,2,2,2,3,3,3,3,3,3,3};
		//System.out.println(Arrays.toString(deleteDuplicates(arr)));
		deleteDuplicates1(arr);
		
		//Find Maximum number
		arr = null;
		int val;
		try {
			val = findMaxNumber(arr);
			System.out.println("The returned value is: " + val);
		} catch (Exception e) {
			System.out.println("No return val");
		}
	}
	
	private static int findMaxNumber(int[] arr) throws Exception {
			if (arr != null && arr.length > 0) {
				return 1;
			} else {
				// array is null
				throw new Exception("Prashnt Exception");
			}
	}

	private static void setMatrixZero(int[][] array) {
		boolean[] rows = new boolean[array.length];
		boolean[] cols = new boolean[array[0].length];
		
		for(int i = 0; i < rows.length; i++){
			for(int j = 0; j < cols.length; j++){
				if(array[i][j] == 0){
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for(int i = 0; i < rows.length; i++){
			for(int j = 0; j < cols.length; j++){
				if(rows[i] || cols[j]){
					array[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < rows.length; i++){
			for(int j = 0; j < cols.length; j++){
				System.out.println("[" + i + " ][" + j + "] ==> " + array[i][j]);
			}
		}

		
		
	}

	private static void rotateMatrix() {
		
		int n = 3;
		int counter = 0;
		int[][] matrix = new int[n][n];
		int[][] newmatrix = new int[n][n];
		int i,j;
		for(i = 0; i < n; i++){
			for(j = 0; j < n; j++){
				matrix[i][j] = counter;
				System.out.println("[" + i + " ][" + j + "] ==> " + counter);
				counter++;
			}
		}
		
		System.out.println("After rotating the matrix");
		
		for(i = 0; i < n; i++){
			for(j = 0; j < n; j++){
				//newmatrix[i][j] = counter;
				int x = n - j - 1;
				System.out.println("[" + i + " ][" + x + "] ==> " + matrix[i][x]);
				//counter++;
			}
		}
		
	}

	private static void stringCompression2(String str) {
		
		int len = compressCount(str);
		System.out.println("Compressed String length - " + len);
		if(len <  str.length()){
			StringBuffer sbuf = new StringBuffer();
			char[] strChar = str.toCharArray();
			char lastElement = str.charAt(0);
			String size ="";
			int count = 1;
			for(int i = 1; i < strChar.length; i++){
				if(strChar[i] == lastElement){
					count++;
				}else{
					size+= lastElement + String.valueOf(count);
					sbuf.append(lastElement).append(count);
					lastElement = strChar[i];
					count = 1;
				}
			}
			sbuf.append(lastElement).append(count);
			System.out.println("Compressed j - " + sbuf.toString());
		}else{
			System.out.println("Original String - " + str);
		}
	}

	private static int compressCount(String str) {
		if(str == null || str.isEmpty()){
			return 0;
		}
		
		char[] strChar = str.toCharArray();
		char lastElement = str.charAt(0);
		String size ="";
		int count = 1;
		for(int i = 1; i < strChar.length; i++){
			if(strChar[i] == lastElement){
				count++;
			}else{
				size+= lastElement + String.valueOf(count);
				lastElement = strChar[i];
				count = 1;
				
			}
		}
		size+= lastElement + String.valueOf(count);
		//System.out.println(size);
		return size.length();
	}

	private static void stringCompression1(String str) {
		//Start parsing the string
		char[] charArray = str.toCharArray();
		int counter = 1;
		StringBuffer sbuf = new StringBuffer();
		for(int i = 0; i < charArray.length; i++){
			char currentChar = charArray[i];
			//System.out.println("Current Char - " + currentChar);
			for(int j = i+1; j < charArray.length; j++){
				if(charArray[i] == charArray[j]){
					counter++;
					i++;
				}else{
					//counter = 1;
					break;
				}
			}
			sbuf.append(currentChar).append(counter);
			counter = 1;
		}
		if(sbuf.length() < str.length()){
			System.out.println("Compressed String - " + sbuf.toString());
		}else{
			System.out.println("Original String - " + str);
		}
	}
	
	private static int calculateOccurrence(String str, char c, int index){
		
		//for()
		return 0;
	}

	
	private static void replaceEmptySpaces(String str) {
/*		String a = str.replaceAll(" ", "%20");
		System.out.println(a);
*/		
		char[] stringChar = str.toCharArray();
		//First count the number of empty spaces in the string
		System.out.println(stringChar.length);
		int emptySpaceCount = 0, newLength = 0;
		for(int i = 0; i < str.length(); i++){
			if(stringChar[i] == ' '){
				emptySpaceCount++;
			}
		}
		
		newLength = stringChar.length + 2 * emptySpaceCount;
		char[] tempChar = new char[newLength];
		System.arraycopy(str.toCharArray(), 0, tempChar, 0, tempChar.length);
		//stringChar[newLength] = '\0';+
		
		for(int i = stringChar.length -1; i >= 0; i--){
			if(stringChar[i] == ' '){
				stringChar[newLength--] = '0';
				stringChar[newLength--] = '2';
				stringChar[newLength--] = '%';
			}else{
				stringChar[newLength--] = stringChar[i];
			}
		}
		
		for(char a: stringChar){
			System.out.println(a);
		}
		
	}

	private static void checkIfPermutation(String str1, String str2) {
		//Method 1
		//Sort both the strings and then compare them
		if(str1.length() != str2.length()){
			System.out.println("Method 1 - Not a Permutation");
		}
		
		if(sortStrings(str1).equals(sortStrings(str2))){
			System.out.println("Method 1 - Is Permutation");
		}
		
		//Method 2
		//check for string length
		if(str1.length() != str2.length()){
			System.out.println("Method 1 - Not a Permutation");
		}
		
		int[] letters = new int[256];
		char[] s_array = str1.toCharArray();
		for(char c: s_array){
			letters[c]++;
		}
		
		for(int i = 0; i < str2.length(); i++){
			int c = (int) str2.charAt(i);
			int x = --letters[c];
			if(x < 0){
				System.out.println("Method 1 - Not a Permutation");
			}
			//if(--)
		}
		
		System.out.println("Method 2 - IS a Permutation");

	}
	
	private static String sortStrings(String str){
			char[] toChar = str.toCharArray();
			Arrays.sort(toChar);
			return new String(toChar);
	}

	private static void reverseString(String str) {
		//Method 1
		StringBuffer str1 = new StringBuffer(str);
		System.out.println("Method 1 String reverse - " + str1.reverse());

		//Method 2
		// convert to char array
		char[] array = str.toCharArray();
		int start = 0; 
		int end = array.length - 1;
		while(start<end){
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		System.out.println("Method 2 - Reversed String - " + new String(array));
		
	}

	//CI 1.1 - String has all unique characters
	public static void checkForUniqueCharacters(String str){
		Vector<String> a = new Vector<String>();
		
		boolean isUnique = true;
		for(int i = 0; i < str.length(); i++){
			Character c = str.charAt(i);
			if(a.contains(String.valueOf(c))){
				//Not Unique
				isUnique = false;
			}else{
				a.addElement(String.valueOf(c));
			}
		}
		if(!isUnique){
			System.out.println("String is not Unique");
		}else{
			System.out.println("String is Unique");
		}
	}
	
	//3. Reverse Words
	public static void reverseWords(String str){
		//Split the string
		String[] splitStr = str.split(" ");
		StringBuffer sbuf = new StringBuffer();
		for(int i = splitStr.length-1; i >= 0; i--){
			sbuf.append(splitStr[i]).append(" ");
		}
		
		System.out.println("Method 1 - Reversed String - " + sbuf.toString());
	}
	
	
	
	//2. Remove Specified Characters
	public static void removeChars(String str, String remove){
		//My Method 1
		for(int i = 0; i < remove.length(); i++){
			Character c = remove.charAt(i);
			System.out.println("Remove Character - " + String.valueOf(c));
			str = str.replaceAll(String.valueOf(c), "");
			System.out.println("String - " + str);
		}
		
		//Method 2:
		//Convert the strings into chars
		char[] s = str.toCharArray();
		char[] r = remove.toCharArray();
		int src, d = 0;
		
		//flags automatically initialized to false, size of 128 assumes ASCII
		boolean[] flags = new boolean[128];
		
		for(src = 0; src < r.length; src++){
			flags[r[src]] = true;
		}
		
		for(src = 0; src < s.length; src++){
			if(!flags[src])
				s[d++] = s[src];
		}
		
		System.out.println(new String(s, 0, d));
	}

	//1. Find the first non repeated character
	public static Character getFirstNonRepeaterChar(){
		String str = "total";
		Hashtable<Character, Boolean> charHash = new Hashtable<Character, Boolean>();
		Character c; 
		for(int i=0; i< str.length(); i++){
			c = str.charAt(i);
			if(c != null){
				if(charHash.containsKey(c)){
					charHash.put(c, Boolean.FALSE);
				}else{
					charHash.put(c, Boolean.TRUE);
				}
			}
		}
		
		for(int i = 0; i < str.length(); i++){
			c = str.charAt(i);
			if(charHash.get(c) == Boolean.TRUE){
				System.out.println("Found the first char - " + c);
				return c;
			}
		}

		//For traversing HashMap
		/*for(Character k: charHash.keySet()){

		}*/
		return null;
	}
	
	/*
	 * Delete duplicates from the unsorted array	
	 */
	public static int[] deleteDuplicates(int arr[]){
		int len = arr.length, originalLength = arr.length;
		int count = 0;
		for(int i = 0; i < len; i++){
			for(int j = i+1; j < len; j++){
				if(arr[j] == arr[i]){
					for(int k = j; k < len - 1; k++){
						//Shifting items to the left
						arr[k] = arr[k+1];
					}
					//reducing the length of the array
					len = len -1;
					//Counting the items which are duplicates
					count = count +1;
					j--;
				}
			}
		}
		
		int newLength = originalLength - count;
		int newArray[] = new int[newLength];
		for(int i = 0; i < newLength; i++){
			newArray[i] = arr[i];
		}
		return newArray;
	}
	
	public static int[] deleteDuplicates1(int[] arr){
		Hashtable<Integer, Boolean> alreadyPresent = new Hashtable<Integer, Boolean>();
		int count = 0;
		int aheadPointer = 0;
		while(aheadPointer < arr.length){
			if(alreadyPresent.containsKey(arr[aheadPointer])){
				aheadPointer++;
			}else{
				alreadyPresent.put(arr[aheadPointer], true);
				arr[count] = arr[aheadPointer];
				count++;
				aheadPointer++;
			}
		}
		for(int x = 0; x < count; x++){
			System.out.println(arr[x]);
		}
		return arr;
	}

}