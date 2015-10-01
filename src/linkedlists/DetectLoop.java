package linkedlists;

import java.util.Hashtable;

public class DetectLoop {
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
		detectLoopHashtable();
		detectLoopFloydAlgorithm();
	}
	
	public static boolean detectLoopHashtable(){
		boolean hasLoop = false;
		Node temp = myList.head;
		Hashtable<Object, Boolean> hashTable = new Hashtable<>();
		
		while(temp != null){
			//check if exists
			if(!hashTable.containsKey(temp.getData())){
				hashTable.put(temp.getData(), true);
			}else{
				hasLoop = true;
				System.out.println("Loop Detected at :" + temp.getData());
				break;
			}
			temp = temp.getNext();
		}
		return hasLoop;
	}
	
	
	public static boolean detectLoopFloydAlgorithm(){
		boolean hasLoop = false;
		if(myList.head == null)
			return false;
		Node hare = myList.head, turtle = myList.head;
		
		while(hare.getNext() != null && turtle.getNext() != null){
			hare = hare.getNext().getNext();
			turtle = turtle.getNext();
			if(hare == turtle){
				System.out.println("Loop Detected at :" + hare.getData());
				hasLoop = true;
				break;
			}
		}
		
		return hasLoop;
	}
	
}
