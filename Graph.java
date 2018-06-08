import java.util.*;

class Node{
    int val;
    boolean visited;
    ArrayList<Node> children;
    
    Node(int v){
        val=v;
        visited=false;
        children = new ArrayList<Node>();
    }
}

public class Graph{
    
    static void bfs(Node root){
        
        Queue<Node> queue = new LinkedList<Node>();
        
        queue.add(root);
        root.visited=true;
        
        while(queue.size()!=0){
            
            Node src = queue.poll();
            System.out.print(src.val+"->");
            for(Node child:src.children){
                if(child.visited==false){
                    child.visited=true;
                    queue.add(child);
                }
            }
        }
    }
    
    static void dfs(Node root){
        
        root.visited=true;
        System.out.println(root.val+"->");
            
        Iterator<Node> iter=root.children.listIterator();
        while(iter.hasNext()){
            Node n=iter.next();
            if(n.visited==false)
                dfs(n);
        }
    }
    
    public static void main(String args[]){
        
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        
        one.children.addAll(new ArrayList<Node>(Arrays.asList(two,five)));
        two.children.addAll(new ArrayList<Node>(Arrays.asList(one,three)));
        three.children.addAll(new ArrayList<Node>(Arrays.asList(four)));
        five.children.addAll(new ArrayList<Node>(Arrays.asList(one,six,seven)));
        seven.children.addAll(new ArrayList<Node>(Arrays.asList(five,eight)));
        
        //dfs(one);
        bfs(one);
   
    }
}
