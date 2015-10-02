package linkedlists;

public class ReverseSLL {

	public static MyLinkedList myList = new MyLinkedList();
	
	public static void main(String args[]){
		myList.insertAtBegin(11);
		myList.insertAtEnd(12);
		myList.insertAtEnd(13);
		//myList.insertAtEnd(14);
		myList.insertAtEnd(15);
		myList.insertAtEnd(16);
		myList.insertAtEnd(17);
		
		System.out.println("Original List: " + myList.toString());
		reverseList();
		System.out.println("New List: " + myList.toString());
		reverseListRecursive(myList.head);
		System.out.println("Recursive New List: " + myList.toString());
		
	}

	private static Node reverseList() {
		Node prevNode = null, currentNode, nextNode;
		currentNode = myList.head;
		if(myList.head == null)
			return null;
		else if(myList.head.getNext() == null){
			return myList.head;
		}else{
			while(currentNode != null){
				nextNode = currentNode.getNext();
				currentNode.setNext(prevNode);
				prevNode = currentNode;
				currentNode = nextNode;
			}
			myList.head = prevNode;
		}
		return myList.head;
	}
	
	private static void reverseListRecursive(Node tempHead){
		//base condition
		if(tempHead.getNext() == null){
			myList.head = tempHead;
			return;
		}
		reverseListRecursive(tempHead.getNext());
		Node nextNode = tempHead.getNext();
		nextNode.setNext(tempHead);
		tempHead.setNext(null);
	}
	
	

}
