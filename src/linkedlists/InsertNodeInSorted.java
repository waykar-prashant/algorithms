package linkedlists;

public class InsertNodeInSorted {

	public static MyLinkedList myList = new MyLinkedList();
	
	public static void main(String args[]){
		myList.insertAtBegin(11);
		myList.insertAtEnd(12);
		myList.insertAtEnd(13);
		//myList.insertAtEnd(14);
		myList.insertAtEnd(15);
		myList.insertAtEnd(16);
		myList.insertAtEnd(17);
		System.out.println(myList.toString());
		//find the 4th node from behind i.e Node value = 14
		Node newNode = new Node();
		newNode.setData(120);
		
		System.out.println("Original List: " + myList.toString());
		insertNodeInSorted(newNode);
		System.out.println("New List: " + myList.toString());
		
	}

	private static void insertNodeInSorted(Node newNode) {
		if(myList.head == null) {
			myList.head = newNode;
		}else if (Integer.parseInt(myList.head.getData().toString()) >= Integer.parseInt(newNode.getData().toString())){
			newNode.setNext(myList.head);
			myList.head = newNode;
		}else{
			Node tempNode = myList.head;
			Node prevNode = null;
			while(tempNode != null && (Integer.parseInt(tempNode.getData().toString()) < Integer.parseInt(newNode.getData().toString()))){
				prevNode = tempNode;
				tempNode = tempNode.getNext();
			}
			newNode.setNext(prevNode.getNext());
			prevNode.setNext(newNode);
		}
	}

}
