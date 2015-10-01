package linkedlists;

public class CheckDLLFunctions {
	static MyDoubleLinkedList myDll;
	public static void main(String args[]){
		myDll = new MyDoubleLinkedList();
		myDll.insertAtBegin(44);
		printList();
		myDll.insertAtBegin(33);
		printList();
		myDll.insertAtBegin(22);
		printList();
		myDll.insertAtEnd(55);
		printList();
		myDll.insert(66, 5);
		printList();
		myDll.insertAtBegin(11);
		printList();
		System.out.println("Remove Nodes\n");
		myDll.removeFromBegin();
		printList();
		
		myDll.removeFromEnd();
		printList();
		
		myDll.removeMatched(33);
		printList();
		
		myDll.remove(0);
		printList();

		myDll.remove(2);
		printList();
		
		
		
		
		
	}
	
	public static void printList(){
		System.out.println("List : " + myDll.toString());
		System.out.println("Length : " + myDll.listCount);
		System.out.println("\n\n");
	}

}
