package com.prashant.recursion;

public class PrintPattern {

	public static void main(String[] args){
		printPattern(16, 16, true);
		//printPattern1(16);
	}

	private static void printPattern(int num, int currentNum, boolean flag) {
		System.out.println(currentNum);

		if(!flag && num == currentNum){ //base case
			return;
		}
		
		if(!flag && num == currentNum) {
			//flag = false; // to reverse the order
		}
		if(flag) {
			if(currentNum > 0)
				printPattern(num, currentNum - 5, true);
			else
				printPattern(num, currentNum + 5, false);
		}else
			printPattern(num, currentNum + 5, false);
	}
	
	
	private static void printPattern1(int num){
		if(num <= 0){
			System.out.println(num);
		}else{
			System.out.println(num);
			printPattern1(num-5);
			System.out.println(num);
		}
		
	}
}
