package stacks;

import java.util.Stack;

public class ReverseStackRecursion {
	
	public Stack<Integer> reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty())
			return null;
		int temp = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, temp);
		return stack;
	}
	
	private void insertAtBottom(Stack<Integer> stack, int data) {
		if(stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
	}

}
