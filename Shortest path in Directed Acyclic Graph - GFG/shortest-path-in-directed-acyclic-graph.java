//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

//User function Template for Java
class Pair{
    int wt;
    int neighbour;
}
class Solution {
    
    public static void dfs(int curr ,ArrayList<ArrayList<Pair>> graph,Stack<Integer> stk,int[]visited){
        ArrayList<Pair> temp = graph.get(curr);
        visited[curr]=1;
        for(int i = 0;i<temp.size();i++){
            Pair p = temp.get(i);
            if(visited[p.neighbour]==1){
                continue;
            }
            else{
                //visited[p.neighbour]=1;
                dfs(p.neighbour,graph,stk,visited);
                
            }
            
        }
        stk.add(curr);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
	    ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
	    for(int i = 0;i<N;i++){
	        ArrayList<Pair> temp = new ArrayList<>();
	        graph.add(temp);
	    }
	    for(int[]i:edges){
	        Pair p = new Pair();
	        p.wt = i[2];
	        p.neighbour = i[1];
	        ArrayList<Pair> temp  = graph.get(i[0]);
	        temp.add(p); 
	        
	    }
	    Stack<Integer> stk = new Stack<>();
	    
	    int[]visited = new int[N];
	    for(int i= 0;i<N;i++){
	        if(visited[i]==0){
	            //visited[i]=1;
	            dfs(i,graph,stk,visited);
	        }
	    }
	    
	    int[]dist = new int[N];
	    Arrays.fill(dist,(int)(1e9));
	    dist[0]=0;
	    while(!stk.isEmpty()){
	        int node = stk.pop();
	        ArrayList<Pair> adj = graph.get(node);
	        for(int i = 0;i<adj.size();i++){
	            Pair p = adj.get(i);
	            if(dist[node]+p.wt<dist[p.neighbour]){
	                dist[p.neighbour]=dist[node]+p.wt;
	            }
	        }
	    }
	    for(int i = 0;i<dist.length;i++){
	        if(dist[i]>=1e9){
	            dist[i]=-1;
	        }
	    }
	    return dist;
		
	}
}