package linkedlists;

public class DetectLoopLength {
	public static MyLinkedList myList = new MyLinkedList();
	public static void main(String args[]){
		myList.insertAtBegin(11);
		myList.insertAtEnd(12);
		myList.insertAtEnd(13);
		myList.insertAtEnd(14);
		myList.insertAtEnd(15);
		myList.insertAtEnd(16);
		myList.insertAtEnd(17);
		
		Node temp = myList.head.getNext().getNext().getNext();
		Node tempHead = myList.head;
		while(tempHead.getNext() != null){
			tempHead = tempHead.getNext();
		}
		tempHead.setNext(temp);
		//System.out.println(myList.toString());
		findLengthOfLoop();
	}
	
	public static void findLengthOfLoop(){
		//Detect Loop
		boolean hasLoop = false;
		Node hare = myList.head, turtle = myList.head;
		while(hare.getNext() != null && turtle.getNext() != null){
			hare = hare.getNext().getNext();
			turtle = turtle.getNext();
			if(hare.equals(turtle)){
				hasLoop = true;
				break;
			}
		}
		//if loop exists then find the head
		int counter = 0;
		if(hasLoop){
			//hare = myList.head;
			turtle = myList.head;
			while(turtle != hare){
				//hare = hare.getNext();
				counter++;
				turtle = turtle.getNext();
			}
			System.out.println("Length of Loop : " + counter);
		}
	}

}
