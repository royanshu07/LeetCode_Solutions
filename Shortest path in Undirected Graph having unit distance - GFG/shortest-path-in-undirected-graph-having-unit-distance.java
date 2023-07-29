//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        int[]distance = new int[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            graph.add(temp);
        }
        for(int[]i:edges){
            ArrayList<Integer> temp = graph.get(i[0]);
            temp.add(i[1]);
            temp = graph.get(i[1]);
            temp.add(i[0]);
        }
        Arrays.fill(distance,(int)1e9);
        distance[src]=0;
        q.add(src);
        while(!q.isEmpty()){
            int node = q.poll();
            ArrayList<Integer> temp = graph.get(node);
            for(int i = 0;i<temp.size();i++){
                if(distance[node]+1<distance[temp.get(i)]){
                    q.add(temp.get(i));
                    distance[temp.get(i)]=distance[node]+1;
                }
            }
        }
        for(int i = 0;i<distance.length;i++){
            if(distance[i]==(int)1e9){
                distance[i]=-1;
            }
        }
        return distance;
        
    }
}