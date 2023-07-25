class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            graph2.add(temp);
                
        }
        for(int i = 0;i<graph.length;i++){
            for(int j = 0;j<graph[i].length;j++){
                ArrayList<Integer> temp = graph2.get(graph[i][j]);
                temp.add(i);
            }
        }
        ArrayList<Integer>  temp = topoSort(graph2);
        Collections.sort(temp);      
        return temp;

      
        
    }
    static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) 
    {
        int[]indegree = new int[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<adj.size();i++){
            ArrayList<Integer> temp = adj.get(i);
            for(int j :temp){
                indegree[j]++;
            }
        }
        
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
