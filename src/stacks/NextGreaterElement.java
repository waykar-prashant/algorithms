package stacks;

import java.util.Stack;

public class NextGreaterElement {
	public void printNextGreaterElement(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int nge = -1;
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] > arr[i]){
					nge = arr[j];
					break;
				}
			}
			System.out.println(arr[i ] + " <-> " + nge + "\n");
		}
	}
	
	public void printNGEUsingStack(int arr[]) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				stack.push(arr[0]);
				continue;
			}

			if (!stack.isEmpty()) {
				int temp = stack.pop();
				while (temp < arr[i]) {
					System.out.println(temp + " <-> " + arr[i] + "\n");
					if (!stack.isEmpty()) {
						temp = stack.pop();
					}else break;
				}
				if (temp > arr[i]) {
					stack.push(temp);
				}
				stack.push(arr[i]);
			}
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop() + " <-> " + -1 + "\n");
		}
	}

}
