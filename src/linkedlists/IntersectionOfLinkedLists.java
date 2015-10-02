package linkedlists;

import java.util.Hashtable;

public class IntersectionOfLinkedLists {
	public static MyLinkedList myList1 = new MyLinkedList();
	public static MyLinkedList myList2 = new MyLinkedList();
	
	public static void main(String args[]){
		myList1.insertAtBegin(11);
		myList1.insertAtEnd(12);
		myList1.insertAtEnd(13);
		myList1.insertAtEnd(14);
		myList1.insertAtEnd(15);
		myList1.insertAtEnd(16);
		myList1.insertAtEnd(17);
		System.out.println("Original List1: " + myList1.toString());
		
		myList2.insertAtBegin(113);
		myList2.insertAtEnd(124);
		myList2.insertAtEnd(134);
		myList2.insertAtEnd(14);
		myList2.insertAtEnd(154);
		myList2.insertAtEnd(164);
		myList2.insertAtEnd(174);
		System.out.println("Original List2: " + myList2.toString());
		findIntersectionBruteForce();
		findIntersectionHashtable();
		findIntersectionDifference();
		
	}

	private static void findIntersectionDifference() {
		int len1 = myList1.listCount;
		int len2 = myList2.listCount;
		int diff = 0, count = 0;
		Node tempNode;
		if(len1 > len2){
			diff = len1 - len2;
			tempNode = myList1.head;
			while(tempNode.getNext() != null && (count != diff)){
				count++;
				tempNode = tempNode.getNext();
			}
			//find intersection
			Node intersectionNode = findIntersection(tempNode, myList2.head);
			System.out.println("Intersection Node : " + intersectionNode.getData());
		}else{
			diff = len2 - len1;
			tempNode = myList2.head;
			while(tempNode.getNext() != null && (count != diff)){
				count++;
				tempNode = tempNode.getNext();
			}
			//find intersection
			Node intersectionNode = findIntersection(myList1.head, tempNode);
			System.out.println("Intersection Node : " + intersectionNode.getData());
		}
		
	}
	
	private static Node findIntersection(Node temp1, Node temp2){
		if(temp1 != null && temp2 != null){
			while(temp1.getNext() != null && temp2.getNext() != null){
				if(temp1.getData().equals(temp2.getData())){
					return temp1;
				}
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
			}
		}
		return null;
	}

	private static void findIntersectionHashtable() {
		Hashtable<Object, Boolean> hash = new Hashtable<>();
		Node tempNode = myList1.head;
		while(tempNode.getNext() != null){
			hash.put(tempNode.getData(), true);
			tempNode = tempNode.getNext();
		}
		tempNode = myList2.head;
		while(tempNode.getNext() != null){
			if(!hash.containsKey(tempNode.getData())){
				hash.put(tempNode.getData(), true);
				tempNode = tempNode.getNext();
			}else{
				//it contains and it is the intersection node
				System.out.println("Interserction At: " + tempNode.getData());
				break;
			}
		}
	}

	private static void findIntersectionBruteForce() {
		Node tempNode1, tempNode2;
		tempNode1 = myList1.head;
		for(int i = 0; i < myList1.listCount && (myList1.head.getNext() != null); i++){
			tempNode2 = myList2.head;
			for(int j = 0; j < myList2.listCount  && (myList2.head.getNext() != null); j++){
				if(tempNode1 != null && tempNode2 != null){
					if(tempNode1.getData().equals(tempNode2.getData())){
						System.out.println("Interserction At: " + tempNode1.getData());
						break;
					}else{
						tempNode2 = tempNode2.getNext();
					}
				}
			}
			tempNode1 = tempNode1.getNext();
		}
	}

}
