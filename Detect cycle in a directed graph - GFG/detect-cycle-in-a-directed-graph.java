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
        int[]visited = new int[adj.size()];
        int[]path = new int[adj.size()];
        for(int i = 0;i<adj.size();i++){
            if(visited[i]==0){
                visited[i]=1;
                path[i]=1;
                boolean b = dfs(i,visited,path,adj);
                if(b){
                    return b;
                }
                
            }path[i]=0;
        }
        return false;
    }
    
    
    public boolean dfs(int curr, int[]visited,int[]path, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> curradj = adj.get(curr);
        for(int i : curradj){
            if(visited[i]==1&&path[i]==1){
                return true;
            }
            else if(visited[i]==1){
                
            }
            else{
                visited[i]=1;
                path[i]=1;
                if(dfs(i,visited,path,adj)){
                    return true;
                }
               
            } path[i]=0;
        }
        return false;
        
        
    }
}