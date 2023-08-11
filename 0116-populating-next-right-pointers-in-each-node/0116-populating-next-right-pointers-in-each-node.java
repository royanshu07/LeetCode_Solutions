/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        if(root==null){
            return root;
        }
        
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            
            
            if(temp==null){
               if(queue.peek()!=null){
                   
                   queue.add(null);
               } 
            } 
            else {
                temp.next = queue.peek();
                
                queue.add(temp.left);
                
                queue.add(temp.right);
            }
        }
        
        return root;
    }
}

