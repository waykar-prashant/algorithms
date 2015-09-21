package linkedlists;

public class MyLinkedList {

	public Node head;
	public int listCount;
	
	public MyLinkedList(){
		listCount = 0;
	}
	
	// Insert a node at the beginning of the list 
	public synchronized void insertAtBegin(Object data){
		Node tempHead = head;
		head = new Node();
		head.setData(data);
		head.setNext(tempHead);
		listCount++;
	}
	
	// Insert a node at the end of the list 
	public synchronized void insertAtEnd(Object data){
		if(head == null){
			head = new Node();
			head.setData(data);
		}else{
			Node currentNode = head;
			while(currentNode.getNext() != null){
				currentNode = currentNode.getNext();
			}
			Node newNode = new Node();
			newNode.setData(data);
			currentNode.setNext(newNode);
		}
		listCount++;
	}
	
	
	// Add a new value to the list at a given position.
	// All values at that position to the end move over to make room.
	public void insert(Object data, int position){
		//fix the position
		if(position < 0){
			position = 0;
		}
		if(position > listCount){
			position = listCount;
		}
		
		// if the list is empty, make it be the only element
		if(head == null){
			head = new Node();
			head.setData(data);
		}else if(position == 0) { // if adding at the front of the list...
			Node tempHead = head;
			head = new Node();
			head.setData(data);
			head.setNext(tempHead);
		}else {		// else find the correct position and insert
			Node currentNode = head;
			for(int i = 1; i < position; i++){
				currentNode = currentNode.getNext();
			}
			Node newNode = new Node();
			newNode.setData(data);
			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);
		}
		// the list is now one value longer
		listCount++;
	}
	
	// Remove and return the node at the head of the list 
	public synchronized Node removeFromBegin(){
		Node tempHead = head;
		if(tempHead != null){
			head = tempHead.getNext();
			tempHead.setNext(null);
			tempHead = null;
			listCount--;
		}
		return tempHead;
	}
	
	// Remove and return the node at the end of the list 
	public synchronized Node removeFromEnd(){
		if(head == null) //No elements in the list
			return null;

		Node currentNode = head;
		Node nextNode = head.getNext();

		if(nextNode == null){ //Only 1 element in the list
			head = null;
			// reduce the length of the list
			listCount--;
			return currentNode;
		}else{ //More than 1 element in the list
			while(nextNode.getNext() != null){
				currentNode = currentNode.getNext();
				nextNode = nextNode.getNext();
			}
			currentNode.setNext(null);
			// reduce the length of the list
			listCount--;
			return nextNode;
		}
	}
	
	// Remove a node matching the specified node from the list.  
		// Use equals() instead of == to test for a matched node.
	public synchronized void removeMatched(Object data){
		if(head == null)
			return;

		Node currentNode = head;
		Node nextNode = currentNode.getNext();
		
		if(currentNode.getData().equals(data)){
			//remove the head node
			head = currentNode.getNext();
			listCount--;
		}else{
			while(nextNode != null){
				if(nextNode.getData().equals(data)){
					currentNode.setNext(nextNode.getNext());
					listCount--;
					return;
				}
				
				currentNode = currentNode.getNext();
				nextNode = nextNode.getNext();
			}
			//currentNode.setNext(null);
			// reduce the length of the list
			listCount--;

		}
	}
	
	// Remove the value at a given position.
		// If the position is less than 0, remove the value at position 0.
		// If the position is greater than 0, remove the value at the last position.
	public void remove(int position){
		// fix position
		if(position < 0)
			position = 0;
		if(position >= listCount){
			position = listCount - 1;
		}
		
		// if nothing in the list, do nothing
		if(head == null)
			return;
		
		// if removing the head element...
		if(position == 0){
			head = head.getNext();
		}else{// else advance to the correct position and remove
			Node currentNode = head;
			for(int i = 1; i < position; i++){
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(currentNode.getNext().getNext());
		}
		// reduce the length of the list
		listCount--;
		
	}
	public Object get(int index){
		
		return null;
	}
	
	
	@Override
	public String toString(){
		String result = "[";
		if(head == null)
			return result = result + "]";
		result = result + head.getData();
		
		Node currentNode = head.getNext();
		while(currentNode != null){
			result += "," + currentNode.getData() ;
			currentNode = currentNode.getNext();
		}
		result += "]";
		return result;
	}
	
}
