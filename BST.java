class BST{

	public static Node root;
	public BST(){
		this.root=null;
	}
	
	class Node{

		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}

	void display(Node root){

		if(root!=null){
			display(root.left);
			System.out.print(" "+root.data);
			display(root.right);	
		}
	}

	void insert(int data){

		Node newNode = new Node(data);
		if(root==null){
			root=newNode;
			return;
		}

		Node current=root;
		Node parent=null;

		while(true){

			parent=current;
			if(data<parent.data){
				
				current=parent.left;
				
				if(current==null){
					parent.left=newNode;
					return;
				}
			}

			else{

				current=parent.right;
				if(current==null){
					parent.right=newNode;
					return;
				}
			}
		}

	}

	public static void main(String args[]){

		BST b = new BST();
		b.insert(10);
		b.insert(5);
		b.insert(20);
		b.insert(25);
		b.insert(1);

		b.display(b.root);
		System.out.println();

	}

}