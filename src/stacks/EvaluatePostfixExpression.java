package stacks;

import java.util.Stack;

public class EvaluatePostfixExpression {
	public int evaluatePostfix(String expression) {
		
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < expression.length(); i++) {
			char item = expression.charAt(i);
			int operand = 0;
			if(StackUtil.isNumericDigit(item)){
				//stack.push(item);
				while (i < expression.length() && StackUtil.isNumericDigit(item)) {
					operand = (operand * 10) + (item - '0');
					i++;
					item = expression.charAt(i);
				}
				i--;
				stack.push(operand);
			}else if (StackUtil.isOperator(item)) {
				int operand1 = stack.peek(); stack.pop();
				int operand2 = stack.peek(); stack.pop();
				try {
					int result = StackUtil.performOperation(item, operand1, operand2);
					stack.push(result);
				} catch (Exception e) {
				}
			}
		}
		return stack.peek();
	}
}
