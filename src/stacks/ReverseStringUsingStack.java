package stacks;

import java.util.Stack;

public class ReverseStringUsingStack {

	public String reverseString(String str) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder s = new StringBuilder();
		if(str != null) {
			for(int i = 0; i < str.length(); i++) {
				stack.push(str.charAt(i));
			}

			while(!stack.isEmpty()) {
				s.append(stack.pop());
			}
		}
		return s.toString();
	}
}
