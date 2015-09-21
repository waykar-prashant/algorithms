package linkedlists;

public class CheckBasicLinkedListFunction {

	public static MyLinkedList myLinkedList;
	
	public static void main(String[] args) {
		myLinkedList = new MyLinkedList();
		myLinkedList.insertAtBegin(11);
		printList();

		myLinkedList.insertAtBegin(22);
		printList();		
		myLinkedList.insertAtEnd(33);
		printList();		
		myLinkedList.insert(44, 0);
		printList();		
		
		myLinkedList.removeFromBegin();
		printList();		
		myLinkedList.removeFromEnd();
		printList();		
		myLinkedList.removeMatched(22);
		printList();		
		myLinkedList.remove(0);
		printList();		
		
	}
	
	public static void printList(){
		System.out.println("List : " + myLinkedList.toString());
		System.out.println("Length : " + myLinkedList.listCount);
		System.out.println("\n\n");
	}

}
