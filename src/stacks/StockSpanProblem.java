package stacks;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
	public void calculateStockSpan(int arr[]) {
		int S[] = new int[arr.length];
		for(int i = 0; i< arr.length; i++){
			int current = arr[i];
			int k = 1;
			for(int j = i-1; j >= 0; j--) {
				int temp = arr[j];
				if(current <= temp){
					break;
				}else if(current > temp){
					k++;
				}
			}
			S[i] = k;
		}
		System.out.println(Arrays.toString(S));
	}
	
	
	public void calculateStockSpanUsingStack(int arr[]){
		Stack<Integer> stack = new Stack<Integer>();
		int S[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			S[i] = 1;
			int item = arr[i];
			while(!stack.isEmpty() && arr[stack.peek()] <= item)
				stack.pop();
			
			if(stack.isEmpty())
				S[i] = i+1;
			else
				S[i] = i - stack.peek();
			
			stack.push(i);
		}
		System.out.println(Arrays.toString(S));
	}
}
