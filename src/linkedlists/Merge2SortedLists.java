package linkedlists;

public class Merge2SortedLists {
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

		myList2.insertAtEnd(14);
		myList2.insertAtEnd(113);
		myList2.insertAtEnd(124);
		myList2.insertAtEnd(134);
		myList2.insertAtEnd(154);
		myList2.insertAtEnd(164);
		myList2.insertAtEnd(174);
		System.out.println("Original List2: " + myList2.toString());
		Node head = mergeLists(myList1.head, myList2.head);
		while(head.getNext() != null){
			System.out.print(head.getData() + "-");
			head = head.getNext();
		}
		
		head = mergeListRecursion(myList1.head, myList2.head);
		while(head.getNext() != null){
			System.out.print(head.getData() + " - ");
			head = head.getNext();
		}
	}

	private static Node mergeListRecursion(Node head1, Node head2) {
		Node head = null;
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		
		if(Integer.valueOf(head1.getData().toString()) <= Integer.valueOf(head2.getData().toString())){
			head = head1;
			head1 = mergeListRecursion(head1.getNext(), head2);
		}else{
			head = head2;
			head2 = mergeListRecursion(head1, head2.getNext());
		}
		return head;
	}

	private static Node mergeLists(Node head1, Node head2) {
		Node tempNode, head;
		if(head1.getData() == null)
			return head2;
		if(head2.getData() == null)
			return head1;
		
		if(Integer.valueOf(head1.getData().toString()) <= Integer.valueOf(head2.getData().toString())){
			tempNode = head1;
			head1 = head1.getNext();
		}else{
			tempNode = head2;
			head2 = head2.getNext();
		}
		head = tempNode;
		while(true){
			if(head1 == null){
				tempNode.setNext(head2);
				break;
			}
			if(head2 == null){
				tempNode.setNext(head1);
				break;
			}else if(Integer.valueOf(head1.getData().toString()) <= Integer.valueOf(head2.getData().toString())){
				tempNode.setNext(head1);
				tempNode = tempNode.getNext();
				head1 = head1.getNext();
			}else{
				tempNode.setNext(head2);
				tempNode = tempNode.getNext();
				head2 = head2.getNext();
			}
		}
		return head;
		
		
	}

}
