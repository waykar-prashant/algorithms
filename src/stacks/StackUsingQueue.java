package stacks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Stack using 2 queues
 * @author waykarp
 *
 */
public class StackUsingQueue {

	private Queue<Integer> queue, tempQueue;
	
	public StackUsingQueue(){
		queue = new LinkedList<Integer>();
		tempQueue = new LinkedList<Integer>();
	}

	public void push(int data) throws Exception {
		queue.add(data);
	}
	
	public int pop() throws Exception {
		if(!queue.isEmpty()){
			//copy n-1 elements in temp and return the last element from the queue
			int queueSize = queue.size();
			for(int i = 0; i < queueSize - 1; i++){
				int temp = queue.remove();
				tempQueue.add(temp);
			}
			int temp = queue.remove();
			queue = tempQueue;
			return temp;
		}else{
			throw new Exception("Stack underflow exception");
		}
	}

	public void printStack(){
		System.out.println(Arrays.toString(queue.toArray()));
	}
}
