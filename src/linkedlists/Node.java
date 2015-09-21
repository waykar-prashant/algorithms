package linkedlists;

public class Node {
	private Node next;// Reference to the next node or null if there isn't one
	private Object data;//Data carried by this node and can be of any type
	
	public Node(Object dataValue, Node nextNode){
		this.next = nextNode;
		this.data = dataValue;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
	}

	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
