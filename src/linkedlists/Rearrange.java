package linkedlists;

public class Rearrange {
	public static MyLinkedList myList = new MyLinkedList();
	
	public static void main(String args[]){
		myList.insertAtBegin(11);
		myList.insertAtEnd(13);
		myList.insertAtEnd(15);
		myList.insertAtEnd(17);
		myList.insertAtEnd(14);
		myList.insertAtEnd(12);
		System.out.println("Original List: " + myList.toString());

		reArrange();
		
	}

	private static void reArrange() {
		Node slow = myList.head, fast = myList.head;
		// 1) Find the muddle point using tortoise and hare method 
		while(fast != null && fast.getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		
		// 2) Split the linked list in two halves
	    // head1, head of first half    1 -> 2
	    // head2, head of second half   3 -> 4
		Node head1 = myList.head;
		Node head2 = slow.getNext();
		slow.setNext(null);
		
		 // 3) Reverse the second half, i.e.,  4 -> 3
		Node second = reverse(head2);
		Node tempHead = new Node();
		Node current = tempHead;
		while(head1!= null || second != null){
			if(head1 != null){
				current.setNext(head1);
				head1 = head1.getNext();
				current = current.getNext();
			}
			
			if(second != null){
				current.setNext(second);
				second = second.getNext();
				current = current.getNext();
			}
			
		}
		myList.head = tempHead.getNext();
		System.out.println("Rearranged List : " + myList.toString());
	}
	
	private static Node reverse(Node secondHead) {
		Node prev = null, current = secondHead, next;
		while(current != null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
		
	}

}
