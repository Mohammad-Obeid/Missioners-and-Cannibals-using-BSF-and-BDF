package application;


public class Queue {
	Node head,tail;
	public Queue() {
		super();
	}



	public void insertq(State x) {
		Node newnode=new Node(x);
		if(head==null) {
			head=tail=newnode;
		}
		else {
			tail.next=newnode;
			tail=newnode;
		}
	}
	
	public String remove() {
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
	public String travers(Queue q) {
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
	
	public boolean isEmpty() {
		Node cur=head;
		if(cur==null) {
			return true;
		}
		return false;
		
		
	}


	public boolean contains(State s) {
	    Node cur = head;
	    while (cur != null) {
	        State curState = (State) cur.getElement();
	        if (curState.toString().equals(s.toString())) {
	            return true;
	        }
	        cur = cur.next;
	    }
	    return false;
	}

	
}
