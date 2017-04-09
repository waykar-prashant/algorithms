package com.prashant.random.questions;

public class DecimalZipOf2Integers {

	public static void main(String[] args) {
		DecimalZipOf2Integers dz = new DecimalZipOf2Integers();
		System.out.println(dz.solution(12345, 678));
	}
	
	public int solution(int A, int B) {
		String strA = String.valueOf(A);
		String strB = String.valueOf(B);
		int result;
	    String output = "";

	    for (int i = 0; i < strA.length() || i < strB.length(); i++) {
	    	if(i < strA.length()) {
	    		output += String.valueOf(strA.charAt(i));
	    	}
	    	if(i < strB.length()) {
	    		output += String.valueOf(strB.charAt(i));
	    	}
	    }

	    System.out.println("The decimal zip of " + A + " & " + B + " is " + output);
	    result = Integer.parseInt(output);
	    if (result > 100000000) {
	        return -1;
	    } else {
	        return result;
	    }
	}

}
