package stacks;

import java.util.Stack;

public class StackUtil {

	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		
	}
	
	public static Stack<Integer> getDefaultStack(){
		stack.push(60);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		//
		return stack;
	}

}
