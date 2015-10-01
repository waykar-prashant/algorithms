package linkedlists;

public class MyDoubleLinkedList {
	private DLLNode head;
	private DLLNode tail;
	int listCount;
	
	public MyDoubleLinkedList(){
		head = null;
		tail = null;
		listCount = 0;
	}
	
	// Add a new value to the front of the list.
	public void insertAtBegin(Object data){
		DLLNode newNode = new DLLNode(data);
		if(isEmpty()){
			head = newNode;
			tail = newNode;
		}else{
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		}
		listCount++;
	}
	
	// Add a new value to the rear of the list.
	public void insertAtEnd(Object data){
		DLLNode newNode = new DLLNode(data);
		if(isEmpty()){
			head = newNode;
			tail = newNode;
		}else{
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
		listCount++;
	}
	
	// Add a new value to the list at a given position.
	// All values at that position to the end move over to make room.
	public void insert(Object data, int position){
		DLLNode newNode = new DLLNode(data);
		
		if(position < 0 ){
			position = 0;
		}
		
		if(position > listCount){
			position = listCount + 1; 
		}
		if(head == null){
			head = newNode;
			tail = newNode;
		}else if(position ==  0){
			insertAtBegin(data);
/*			head.setPrev(newNode);
			newNode.setNext(head);
			newNode.setPrev(null);
			head = newNode;
*/		}else if(position == listCount + 1){
			insertAtEnd(data);
		}else{
			DLLNode tempNode = head;
			for(int i = 1; i <= position; i++){
				if(i == position){
					newNode.setNext(tempNode.getNext());
					newNode.setPrev(tempNode);
					tempNode.setNext(newNode);
					tempNode.setPrev(newNode);
				}
				tempNode = tempNode.getNext();
			}
			listCount++;
		}
	}
	
	// Remove the head value from the list. If the list is empty, do nothing.
	public DLLNode removeFromBegin(){
		if(isEmpty())
			return null;
		else{
			head = head.getNext();
			if(head != null)
				head.setPrev(null);
			else{
				head = tail = null; //list is empty
			}
		}
		listCount--;
		return head;
	}
	
	// Remove the tail value from the list. If the list is empty, do nothing.
	public DLLNode removeFromEnd(){
		if(isEmpty())
			return null;
		else if(listCount == 1){
			head = tail = null;
		}else{
			DLLNode newTail = tail.getPrev();
			newTail.setNext(null);
			tail = newTail;
		}
		listCount--;
		return tail;
	}
	
	// Remove a node matching the specified node from the list.  
	// Use equals() instead of == to test for a matched node.	
	public DLLNode removeMatched(Object data){
		if(isEmpty()){
			return null;
		}
		else if(head.getData().equals(data)){
			removeFromBegin();
		}else if(tail.getData().equals(data)){
			removeFromEnd();
		}else{
			DLLNode tempNode = head.getNext();
			for(int i=2; i  < listCount; i++){
				if(tempNode.getData().equals(data)){
					DLLNode tempPrev = tempNode.getPrev();
					tempPrev.setNext(tempNode.getNext());
					tempNode.getNext().setPrev(tempPrev);
				}
				tempNode = tempNode.getNext();
			}
		}
		listCount--;
		return head;
	}
	
	// Remove the value at a given position.
	// If the position is less than 0, remove the value at position 0.
	// If the position is greater than 0, remove the value at the last position.
	public void remove(int position){
		if(position < 0){
			position = 0;
		}
		if(position > listCount)
			position = listCount;
		
		if(isEmpty()){
			return;
		}else if(position == 0){
			removeFromBegin();
		}else if(position == listCount){
			removeFromEnd();
		}else{
			DLLNode tempNode = head.getNext();
			for(int i = 2; i < position;  i++){
				if(position == i){
					DLLNode prevNode = tempNode.getPrev();
					prevNode.setNext(tempNode.getNext());
					tempNode.setPrev(prevNode);
				}
				tempNode = tempNode.getNext();
			}
		}
	}
	

	@Override
	public String toString() {
		String result = "[]";
		if (isEmpty())
			return result;
		result = "[" + head.getData();
		DLLNode temp = head.getNext();
		while (temp != null) {
			result += "," + temp.getData();
			temp =  temp.getNext();
		}
		return result + "]";
	}
	
	public boolean isEmpty(){
		if(head == null && listCount == 0){
			return true;
		}else
			return false;
	}
	
	
}
