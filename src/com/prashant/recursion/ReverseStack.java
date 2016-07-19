package com.prashant.recursion;

import java.util.Stack;

import stacks.StackUtil;

public class ReverseStack {

	public static void main(String[] args){
		Stack<Integer> stack = StackUtil.getDefaultStack();
		reverseStack(stack);
	}
	
	public static void reverseStack(Stack<Integer> stack){
		if(!stack.isEmpty()){
			int temp = stack.pop();
			reverseStack(stack);
			System.out.println(temp);
		}
		System.out.println("After }");
			
	}
}
