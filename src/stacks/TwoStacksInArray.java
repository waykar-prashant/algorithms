package stacks;

import java.util.Stack;

public class TwoStacksInArray {
	int size, top1, top2;
	int array[];
	
	public TwoStacksInArray(int size) {
		array = new int[size];
		this.size = size;
		top1 = -1;
		top2 = size;
	}
	
	public void push1(int data) throws Exception{
		if(top1 < top2 -1) {
			array[++top1] = data;
		} else
			throw new StackOverflowError("Stack overflow stack 1");
	}
	
	public void push2(int data) throws Exception{
		if(top1 < top2 -1) {
			array[--top2] = data;
		} else
			throw new StackOverflowError("Stack overflow stack 2");
	}

	public int pop1() throws Exception {
		if(top1 != -1){
			int temp = array[top1];
			top1--;
			return temp;
		}else
			throw new Exception("Stack1 empty");
	}

	public int pop2() throws Exception {
		if(top2 != size){
			int temp = array[top2];
			top2++;;
			return temp;
		}else
			throw new Exception("Stack2 empty");
	}

}
