package linkedlists;

public class DLLNode {
	private Object data;
	private DLLNode next;
	private DLLNode prev;
	
	public DLLNode(Object data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public DLLNode(Object data, DLLNode next, DLLNode prev){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public DLLNode getPrev() {
		return prev;
	}

	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}
	
	
}
