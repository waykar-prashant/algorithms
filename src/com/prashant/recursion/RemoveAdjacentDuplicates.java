package com.prashant.recursion;

public class RemoveAdjacentDuplicates {

	public static void main(String[] args) {
		RemoveAdjacentDuplicates rd = new RemoveAdjacentDuplicates();
		String str = "geeks";
		System.out.println("After removing duplicates from "+ str +  " -->>> " + rd.removeDuplicates(str, str.length()));
	}

	private String removeDuplicates(String str, int n) {
		char strArray[] = str.toCharArray();
		int k = 0;
		// -----[ Start from the 2nd character ]----- //
		for (int i = 1; i < strArray.length; i++) {
			if (strArray[i - 1] != strArray[i]) {
				strArray[k] = strArray[i-1];
				k++;
			} else {
				/*while(strArray[i-1] == strArray[i]) {
					i++;
				}*/
			}
		}
		
		strArray[k] = strArray[strArray.length - 1];
		k++;
		strArray[k] = '\0';
		String newStr = String.valueOf(strArray); 
		System.out.println("String : " + newStr + " String Length =" + newStr.length());
		if (k != n) {
			removeDuplicates(newStr, k);
		} 
		return newStr;
	}

}
