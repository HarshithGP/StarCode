class Node{
    int val;
    Node left;
    Node right;
    Node(int x){
        val=x;
        left=null;
        right=null;
    }
}

public class Tree{
    
    static void inorder(Node root){
        
        if(root!=null){
            inorder(root.left);
            System.out.print(" "+root.val);
            inorder(root.right);
        }
    }
    
    static void preorder(Node root){
        
        if(root!=null){
            System.out.print(" "+root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    static void postorder(Node root){
        
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(" "+root.val);
        }
    }
    
    public static void main(String args[]){
        
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        
       
        System.out.println("Inorder");
        inorder(root);
        
        System.out.println("\nPreorder");
        preorder(root);
        
        System.out.println("\nPostorder");
        postorder(root);
    }
}