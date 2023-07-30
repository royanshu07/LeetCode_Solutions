//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((l1, l2) -> l1.get(1) - l2.get(1));
        ArrayList<Integer> temp = new ArrayList<>();
        distance[S] = 0;
        temp.add(S);
        temp.add(0);
        pq.add(temp);

        while (!pq.isEmpty()) {
            ArrayList<Integer> temp2 = pq.poll();
            int vertex = temp2.get(0);
            int dist = temp2.get(1);

            if (distance[vertex] < dist) {
                continue;
            }

            ArrayList<ArrayList<Integer>> neighbors = adj.get(vertex);
            for (ArrayList<Integer> neighbor : neighbors) {
                int nextVertex = neighbor.get(0);
                int weight = neighbor.get(1);

                if (distance[nextVertex] > dist + weight) {
                    distance[nextVertex] = dist + weight;
                    ArrayList<Integer> updatedNeighbor = new ArrayList<>();
                    updatedNeighbor.add(nextVertex);
                    updatedNeighbor.add(distance[nextVertex]);
                    pq.add(updatedNeighbor);
                }
            }
        }

        return distance;
    }
}
