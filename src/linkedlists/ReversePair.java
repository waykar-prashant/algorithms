package linkedlists;

import org.omg.CORBA.NO_IMPLEMENT;

public class ReversePair {
	public static MyLinkedList myList = new MyLinkedList();
	
	public static void main(String args[]){
		myList.insertAtBegin(11);
		myList.insertAtEnd(12);
		myList.insertAtEnd(13);
		myList.insertAtEnd(14);
		myList.insertAtEnd(15);
		myList.insertAtEnd(16);
		myList.insertAtEnd(17);
		myList.insertAtEnd(18);
		myList.insertAtEnd(19);
		
		
		System.out.println("Original List: " + myList.toString());
		//reversePairIterative();
		myList.head = reversePaidRecursive(myList.head);
		System.out.println("Original List2: " + myList.toString());
		
	}

	private static Node reversePaidRecursive(Node head) {
		if(head.getNext() == null && head.getNext().getNext() == null){
			return head;
		}
		
		Node remaining = head.getNext().getNext();
		
		Node newHead = head.getNext();
		
		head.getNext().setNext(head);
		head.setNext(reversePaidRecursive(remaining));
		System.out.println(myList.toString());
		return newHead;
		
		
	}

	private static void swap(Node temp1, Node temp2) {
		Node tempNode = temp1;
		temp1.setData(temp2.getData());
		temp2.setData(temp1.getData());
	}

	private static void reversePairIterative() {
		Node temp1 = myList.head;
		Node temp2 = temp1.getNext();
		Node tempHead = null;
		Node connectorNode = null;
		while(temp1 != null && temp1.getNext() != null){

			temp1 = swapNodes(temp1, temp1.getNext());
			if(connectorNode != null){
				connectorNode.setNext(temp1);
			}
			if(tempHead == null){
				tempHead = myList.head = temp1;
			}
			connectorNode = temp1.getNext();

			if(temp1.getNext().getNext() != null){
				temp1 = temp1.getNext().getNext();
			}else break;
		}
		System.out.println(myList.toString());
		
	}

	private static Node swapNodes(Node temp1, Node temp2) {
		Node prevNode = temp2;
		temp1.setNext(temp2.getNext());
		temp2.setNext(temp1);
		return temp2;
	}

}
