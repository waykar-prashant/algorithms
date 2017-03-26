package com.prashant.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCacheDemo {
	
	private HashMap<Integer, Node> cache; 
	private Node leastRecentlyUsed;
	private Node mostRecentlyUsed;
	private int capacity;
	private int currentSize;

	public LRUCacheDemo(int capacity) {
		this.capacity = capacity;
		leastRecentlyUsed = mostRecentlyUsed;
		cache = new HashMap<Integer, Node>();
		currentSize = 0;
	}
	
	public int get(int key) {
		if(cache.containsKey(key)) {
			//Remove Node and place it in the front of the linked list
			Node tempNode = cache.get(key);
			
			// -----[If MRU leave the list as it is]----- //
			if(tempNode.key == mostRecentlyUsed.key) {
				return mostRecentlyUsed.value;
			}
			
			// -----[Get the previous and next nodes]----- //
			Node nextNode = tempNode.next;
			Node previousNode = tempNode.previous;
			
			// -----[If LRU, bring it to the front]----- //
			if(tempNode.key == leastRecentlyUsed.key) {
				previousNode.next = null;
				leastRecentlyUsed = previousNode;
			}
			
			// -----[If we are in the middle, we need to update the items before and after our item]----- //
			else if(tempNode.key != mostRecentlyUsed.key) {
				previousNode.next = nextNode;
				nextNode.previous = previousNode;
			}
			
			// -----[Finally, move our item to MRU]----- //
			mostRecentlyUsed.previous = tempNode;
			tempNode.previous = null;
			tempNode.next = mostRecentlyUsed;
			mostRecentlyUsed = tempNode;
			
			return tempNode.value;
		}
		return -1;
	}
	

	public void put(int key, int value) {
		if(cache.containsKey(key)) {
			return;
		} else {
			// -----[Set as MRU node]----- //
			Node tempNode = new Node(key, value);
			
			if(currentSize == capacity) {
				// -----[Delete the right-most entry and update the LRU pointer]----- //
				cache.remove(leastRecentlyUsed.key);
				leastRecentlyUsed = leastRecentlyUsed.previous;
				leastRecentlyUsed.next = null;
			} else if (currentSize < capacity) {
				if (currentSize == 0) {
					leastRecentlyUsed = tempNode;
				}
				currentSize++;
			}
			mostRecentlyUsed.previous = tempNode;
			tempNode.next = mostRecentlyUsed;
			tempNode.previous = null;
			mostRecentlyUsed = tempNode;
		}
		
	}
	public static void main(String[] args) {
		LRUCacheDemo lru = new LRUCacheDemo(5);
		
		lru.put(1, 1);
		lru.put(2, 2);
		lru.put(3, 3);
		lru.put(4, 4);
		lru.put(5, 5);
		lru.put(6, 6);
		
		lru.printNodes(lru);
		
	}
	
	private void printNodes(LRUCacheDemo lru) {
		Node temp = lru.mostRecentlyUsed;
		System.out.print("MRU-->");
		while(temp != null) {
			System.out.print("["+temp.key+",{"+ temp.value +"}]-->");
		}
		
		/*for(Map.Entry<Integer, Node> entry : lru.cache.entrySet()) {
			int key = entry.getKey();
			Node n = entry.getValue();
			System.out.print("["+key+",{"+ n.value +"}]-->");
		}*/
		System.out.println("LRU");
		
	}
	
	public class Node {
		private Node previous= null, next = null;
		int key, value;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

}
