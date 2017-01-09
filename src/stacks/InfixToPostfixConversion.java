package stacks;

import java.util.Stack;

public class InfixToPostfixConversion {

	public String infixToPostfix(String expression) {
		Stack<Character> stack = new Stack<Character>();
		String postfixExpression = "";
		for(int i = 0; i < expression.length(); i++) {
			char item = expression.charAt(i);
			// if item is operator
			if (StackUtil.isOperand(item)) {
				postfixExpression += item;
			} else if (StackUtil.isOperator(item)) {
				// If character is operator, pop elements having higher precedence from stack 
				// perform operation and push the result back.
				while(!stack.isEmpty() && stack.peek() != '(' && StackUtil.hasHigherPrecedence(stack.peek(), item)){
					postfixExpression += stack.peek();
					stack.pop();
				}	
				stack.push(item);
			} else if(item == '(') {
				stack.push(item);
			} else if(item  == ')'){
				while(!stack.isEmpty() && stack.peek() != '('){
					postfixExpression += stack.peek();
					stack.pop();
				}
				stack.pop();
			}
		}
		while(!stack.isEmpty()) {
			postfixExpression += stack.peek();
			stack.pop();
		}
		return postfixExpression;
	}
}
