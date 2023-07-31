//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class Edge{
    int currnode;
   
    int wt;
    
    public Edge(int currnode,int wt){
        this.wt = wt;
      
        this.currnode= currnode;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	   ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
	   for(int i = 0;i<V;i++){
	       ArrayList<Edge> temp = new ArrayList<>();
	       graph.add(temp);
	   }
	   for(int i = 0;i<edges.length;i++){
	       int[]e = edges[i];
	       ArrayList<Edge> temp1 = graph.get(e[0]);
	       ArrayList<Edge> temp2 = graph.get(e[1]);
	       temp1.add(new Edge(e[1],e[2]));
	       temp2.add(new Edge(e[0],e[2]));
	   }
	   int sum = 0;
	   int[]visited = new int[V];
	   PriorityQueue<Edge> pq = new PriorityQueue<>((p1,p2)->p1.wt-p2.wt);
	   Edge curr = new Edge(0,0);
	   pq.add(curr);
	   while(!pq.isEmpty()){
	       curr = pq.poll();
	       if(visited[curr.currnode]==1){
	           continue;
	       }
	       visited[curr.currnode]=1;
	       sum+=curr.wt;
	       ArrayList<Edge> nbr = graph.get(curr.currnode);
	       for(Edge a:nbr){
	           if(visited[a.currnode]==0){
	               pq.add(a);
	           }
	       }
	     
	       
	   }
	   return sum;
	}
}