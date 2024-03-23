package application;


public class Stack {
	Node head,tail;
	public Stack() {
		super();
	}



	public void push(State x) {
		Node newnode=new Node(x);
		if(head==null) {
			head=tail=newnode;
		}
		else {
			newnode.next=head;
			head=newnode;
		}
	}
	
	public String pop() {
		String res="";
		if(head==null) {
			return res;
		}
		else {
			Node cur=head;
			head=cur.next;
			cur.next=null;
			res=cur.getElement().toString();
			return res;
		}		
	}
	public String print(Stack q) {
		Node cur=q.head;
		String x="";
		if(cur==null) {
			x="";
		}
		else {
			while(cur!=tail) {
				x+=cur.getElement()+"\n";
				cur=cur.next;
			}
			x+=tail.getElement();
		}
		return x;	
	}
	public boolean isEmpty(){
		Node cur=head;
		if(cur==null) {
			return true;
		}
		return false;
		
	}
	public boolean isVisited(State s) {
		Node cur=head;
		if(cur==null) {
			return false;
		}
		else {
			while(cur!=tail) {
				if(cur.getElement().toString().equals(s.toString())) {
					return true;
				}
				cur=cur.next;
			}
			if(tail.getElement().toString().equals(s.toString()))
				return true;
		}
		return false;
	
	}

}

