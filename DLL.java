class DLL { 

	static class node{

		int data;
		node prev;
		node next;

		node(int val){
			this.data=val;
			this.prev=null;
			this.next=null;
		}
	}

	static void displayList(node head){

		System.out.println("Doubly Linked List");
		if(head==null)
			System.out.println("Empty List");

		node current=head;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println("");
	}

	static node insertFront(node head, int val){

		if(head==null){

			head = new node(val);
			return head;
		}

		node n = new node(val);
		n.prev=null;
		n.next=head;
		head.prev=n;
		head=n;

		return head;
	}

	static node insertEnd(node head,int val){

		if(head==null){

			head = new node(val);
			return head;
		}

		node current=head;
		while(current.next!=null)
			current=current.next;

		node n = new node(val);

		current.next=n;
		n.prev=current;
		n.next=null;

		return head;
	}

	static node insertAfter(node head, int val, int after_val){

		//after_val - the value in the node after which val is inserted

		if(head==null){

			head = new node(val);
			return head;
		}

		node current=head;
		while(current.data!=after_val){
			current=current.next;
		}

		if(current.next==null)
			return insertEnd(head,val);

		node temp = new node(val);
		node after = current.next;

		current.next = temp;
		temp.prev = current;
		temp.next = after;
		after.prev = temp;

		return head;
	}

	static node deleteFront(node head){

		if(head==null || head.next==null)
			return null;

		node after = head.next;
		after.prev=null;
		head=after;
		return head;

	}

	static node deleteEnd(node head){

		if(head==null || head.next==null)
			return null;

		node current=head;
		node prev=null;
		while(current.next!=null){
			prev=current;
			current=current.next;
		}

		prev.next=null;
		return head;
	}

	static node deleteNode(node head, int val){

		if(head==null)
			return null;
		
		node current=head;
		node prev=null;
		while(current.data!=val){
			prev=current;
			current=current.next;
		}


		node after=current.next;

		if(after==null){
			prev.next=null;
			return head;
		}

		prev.next=after;
		after.prev=prev;

		return head;

	}


	public static void main(String args[]) {

			node head=null;
			head = insertFront(head,0);
			for(int i=1;i<=10;i++)
				head=insertEnd(head,2*i);
			displayList(head);

			head=insertAfter(head, 100, 20);
			head=deleteEnd(head);

			displayList(head);


	}
}