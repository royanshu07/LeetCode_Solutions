//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       int count = 0;
       int[]indegree = new int[adj.size()];
       for(int i= 0;i<adj.size();i++){
           ArrayList<Integer> temp = adj.get(i);
           for(int j : temp){
               indegree[j]++;
           }
       }
       Queue<Integer> q = new LinkedList<>();
       for(int i = 0;i<indegree.length;i++){
           if(indegree[i]==0){
               q.add(i);
           }
       }
       
       while(!q.isEmpty()){
           int curr = q.poll();
           count++;
           ArrayList<Integer> temp = adj.get(curr);
           for(int i:temp){
               indegree[i]--;
               if(indegree[i]==0){
                   q.add(i);
               }
           }
       }
       if(count==adj.size()){
           return false;
       }
       return true;
    }
}