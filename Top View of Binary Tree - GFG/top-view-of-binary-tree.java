//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/


class Pair {
    Node nd;
    int line;
}

class Solution {
    static ArrayList<Integer> topView(Node root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        Pair rootp = new Pair();
        rootp.nd = root;
        rootp.line = 0;
        q.add(rootp);

        while (!q.isEmpty()) {
            Pair temp = q.poll(); // Changed pop() to poll()
            if(!map.containsKey(temp.line)){
            map.put(temp.line, temp.nd.data); }// Changed Map.put() to map.put()
            
            if (temp.nd.left != null) {
                Pair rootl = new Pair();
                rootl.nd = temp.nd.left;
                rootl.line = temp.line - 1;
                q.add(rootl);
            }
            
            if (temp.nd.right != null) {
                Pair rootr = new Pair();
                rootr.nd = temp.nd.right; // Changed temp.nd.left to temp.nd.right
                rootr.line = temp.line + 1;
                q.add(rootr);
            }
        }
        
        ArrayList<Integer> trav = new ArrayList<>();
        Set<Integer> st = map.keySet();
        
        List<Integer> sortedKeys = new ArrayList<>(st);
        Collections.sort(sortedKeys);

        for (int i : sortedKeys) {
            trav.add(map.get(i));
        }
        return trav;
    }
}
