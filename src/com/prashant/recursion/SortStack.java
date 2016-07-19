package com.prashant.recursion;

import java.util.Stack;

import stacks.StackUtil;

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> stack = StackUtil.getDefaultStack();
		System.out.println("Initial Stack : " +stack);
		sortStack(stack);
	}

	private static void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()){
			int temp = stack.pop();
			sortStack(stack);
			//insert it into the stack after the stack is empty
			addToStack(stack, temp);
		}
		System.out.println(stack);
	}

	private static void addToStack(Stack<Integer> stack, int temp) {
		if(stack.isEmpty() || temp > stack.peek()){
			stack.push(temp);
			return;
		}else{
			int elem = stack.pop();
			addToStack(stack, temp);
			stack.push(elem);
		}
	}

}
			