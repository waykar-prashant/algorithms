package linkedlists;

import java.util.Stack;

public class PalindromeCheck {
	public static MyLinkedList myList = new MyLinkedList();
	
	public static void main(String args[]){
		myList.insertAtBegin(11);
		myList.insertAtEnd(12);
		myList.insertAtEnd(13);
		myList.insertAtEnd(11);
		myList.insertAtEnd(12);
		myList.insertAtEnd(11);
		System.out.println("Original List: " + myList.toString());

		boolean isPalindrome = checkPalindrome();
		System.out.println("Output : " + isPalindrome);
		isPalindrome = checkIfPalindrome();
		System.out.println("Output : " + isPalindrome);
		
	}

	private static boolean checkIfPalindrome() {
		Node slow = myList.head, fast = myList.head;
		Node secondHead, prevOfSlow = myList.head;
		Node middle = null;
		/* Get the middle of the list. Move slow_ptr by 1
        and fast_ptrr by 2, slow_ptr will have the middle
        node */
		while(fast != null && fast.getNext() != null){
			fast = fast.getNext().getNext();
			
			/*We need previous of the slow_ptr for
            linked lists  with odd elements */
			prevOfSlow = slow;
			slow = slow.getNext();
		}
		
		/* fast_ptr would become NULL when there are even elements in list. 
        And not NULL for odd elements. We need to skip the middle node 
        for odd case and store it somewhere so that we can restore the
        original list*/
		if(fast != null){
			middle = slow;
			slow = slow.getNext();
		}
		
		 // Now reverse the second half and compare it with first half
		secondHead = slow;
		prevOfSlow.setNext(null); // NULL terminate first half
		Node reverseListHead = reverse(secondHead); // Reverse the second half
		boolean isPalindrome = compare(myList.head, reverseListHead);
		/* Construct the original list back */
		secondHead = reverse(reverseListHead);
		if(middle != null){
			prevOfSlow.setNext(middle);
			middle.setNext(secondHead);
		}else{
			prevOfSlow.setNext(secondHead);
		}
		System.out.println(myList.toString());
		
		return isPalindrome;
	}

	private static boolean compare(Node head, Node reverseListHead) {
		Node temp1 = head, temp2 = reverseListHead;
		while(temp1 != null && temp2 != null){
			if(temp1.getData().equals(temp2.getData())){
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
			}else return false;
		}
		/* Both are empty reurn 1*/
		if(temp1 == null && temp2 == null){
			return true;
		}
		/* Will reach here when one is NULL
	      and other is not */
		return false;
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

	private static boolean checkPalindrome() {
		Node tempNode = myList.head;
		Stack<Node> stack = new Stack<>();
		while(tempNode != null){
			stack.push(tempNode);
			tempNode = tempNode.getNext();
		}
		
		tempNode = myList.head;
		while(tempNode != null && !stack.isEmpty()){
			//compare LL node and Stack node
			if(tempNode.getData().equals(stack.pop().getData())){
				tempNode = tempNode.getNext();
			}else{
				return false;
			}
		}
		return true;
	}
}
