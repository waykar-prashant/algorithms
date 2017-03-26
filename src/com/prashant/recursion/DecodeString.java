package com.prashant.recursion;

import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {
		String res = "";
		Stack<String> resStack = new Stack<String>();
		Stack<Integer> countStack = new Stack<Integer>();
		int idx = 0;
		while(idx < s.length()) {
			if(Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while(Character.isDigit(s.charAt(idx))) {
					count = 10 * count + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.push(count);
			}else if(s.charAt(idx) == '[') {
				//if(!Character.isDigit(s.charAt(idx-1))) {
					//countStack.push(1);
				//}
				resStack.push(res);
				res = "";
				idx++;
			} else if(s.charAt(idx) == ']') {
				int count = countStack.pop();
				String tempRes = resStack.pop();
				StringBuilder strRes = new StringBuilder(resStack.pop());
				for(int i = 0; i < count; i++) {
					strRes.append(tempRes);
				}
				//resStack.push(strRes.toString());
				res = strRes.toString();
				idx++;
			} else {
				res = res + s.charAt(idx);
				//resStack.push(res);
				idx++;
			}
		}
		
		return resStack.pop();
	}
	public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		System.out.println(ds.decodeString("3[b2[ca]]"));
	}

}
