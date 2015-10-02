package linkedlists;

public class MiddleNode {

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
		
		System.out.println("Original List: " + myList.toString());
		findMiddleNode();
		
		findMiddleNodeByOddPlaces();
		
	}

	private static void findMiddleNodeByOddPlaces() {
		Node temp = myList.head, mid = myList.head;
		int counter = 0;
		while(temp.getNext() != null){
			if(counter%2 != 0){
				mid = mid.getNext();
			}
			counter++;
			temp = temp.getNext();
		}
		System.out.println("Middle Node : " + mid.getData());
	}

	private static void findMiddleNode() {
		Node slow, fast;
		slow = myList.head;
		fast = myList.head;
		while(fast != null && fast.getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		System.out.println("Middle Node : " + slow.getData());
	}
	
	

}
