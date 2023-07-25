class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        int[]indegree = new int[graph.length];
        for(int i = 0;i<graph.length;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            graph2.add(temp);
                
        }
        for(int i = 0;i<graph.length;i++){
            for(int j = 0;j<graph[i].length;j++){
                ArrayList<Integer> temp = graph2.get(graph[i][j]);
                temp.add(i);
                indegree[i]++;
            }
        }
        ArrayList<Integer>  temp = topoSort(graph2,indegree);
        Collections.sort(temp);      
        return temp;

      
        
    }
    static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj,int[]indegree) 
    {
       
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
       
        
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int b=q.poll();
            ans.add(b);
            ArrayList<Integer> temp = adj.get(b);
            count++;
            for(int k:temp){
                indegree[k]--;
                if(indegree[k]==0){
                    q.add(k);
                }
            }
            
        }
        return ans;
    }
}
