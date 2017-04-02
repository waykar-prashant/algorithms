package stacks;

import java.util.Stack;

public class BalancedParentheses {

	public boolean areParenthesesBalanced(String expression) {
		if (expression != null) {
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < expression.length(); i++) {
				char currentChar = expression.charAt(i);
				if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
					stack.push(currentChar);
				} else if (currentChar == '}' || currentChar == ']' || currentChar == ')') {
					if (!stack.isEmpty() && isMatchingPair(stack.peek(), currentChar)) {
						stack.pop();
					} else
						return false;
				}
			}
		}
		return true;
	}
	
	private boolean isMatchingPair(char open, char close) {
		if (open == '(' && close == ')')
			return true;
		else if (open == '{' && close == '}')
			return true;
		else if (open == '[' && close == ']')
			return true;
		else
			return false;
	}
}
