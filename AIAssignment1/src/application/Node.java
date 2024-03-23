package application;


public class Node {
	private State element;
	Node next;
	public Node(State element) {
		super();
		this.element = element;
	}
	public Object getElement() {
		return element;
	}
	public void setElement(State element) {
		this.element = element;
	}

}
