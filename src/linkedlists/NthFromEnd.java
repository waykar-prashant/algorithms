package linkedlists;

public class NthFromEnd {
	public static MyLinkedList myList = new MyLinkedList();
	public static int counter = 0;
	
	public static void main(String args[]){
		myList.insertAtBegin(11);
		myList.insertAtEnd(12);
		myList.insertAtEnd(13);
		myList.insertAtEnd(14);
		myList.insertAtEnd(15);
		myList.insertAtEnd(16);
		myList.insertAtEnd(17);
		System.out.println(myList.toString());
		//find the 4th node from behind i.e Node value = 14
		findNthNode(4);
		
		//Recursive
		findNthNodeRecursive(myList.head, 4);
		
		//2 pointers main and ref
		findNthNodeBy2Pointers(4);
	}
	
	private static void findNthNodeBy2Pointers(int position) {
		Node main = myList.head, ref = myList.head;
		for(int i = 1; i < position; i++){
			ref = ref.getNext();
		}
		//System.out.println(ref.getData());
		//Move ref pointer till ref = null 
		while(ref.getNext() != null){
			main = main.getNext();
			ref = ref.getNext();
		}
		System.out.println(main.getData());
		
		
		
	}

	private static void findNthNodeRecursive(Node head, int Nth) {
		if(head.getNext() != null)
			findNthNodeRecursive(head.getNext(), Nth);
		
		//Now popping from the top of the stack
		counter++;
		if(counter == Nth){
			//print the node
			System.out.println("Node : " + head.getData());
		}
	}

	private static Object findNthNode(int position){
		//find the length of ll
		int length = myList.listCount;
		int fromFront = length - position + 1;
		Node temp = myList.head;
		for(int i = 1; i < fromFront && temp != null; i++){
			temp = temp.getNext();
		}
		if(temp != null){
			System.out.println(temp.getData());
		}
		return 0;
	}
	
}
