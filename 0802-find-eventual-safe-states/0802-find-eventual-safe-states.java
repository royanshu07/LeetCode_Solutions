class Solution {
    List<Integer> answer;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        answer = new ArrayList<>();
        int[]path = new int[graph.length];
        int[]visit = new int[graph.length];
        
        for(int i =0 ;i<graph.length;i++){
            if(visit[i]==0){
                visit[i]=1;
                path[i]=1;
                dfs(i,graph,answer,visit,path);
            }
        }
        Collections.sort(answer);
        return answer;
        
    }
    
    
    public boolean dfs(int curr,int[][]graph, List<Integer> answer,int[]visit,int[]path){
        int[]adj = graph[curr];
        if(adj==null||adj.length==0){
            path[curr]=0;
            answer.add(curr);
            return true;
        }
        
        for(int i:adj){
            if(path[i]==1){
               return false; 
            }
            if(visit[i]==1){
                continue;
            }
            path[i]=1;
            visit[i]=1;
           if (dfs(i,graph,answer,visit,path)==false){
              return false; 
           }
        }
        path[curr]=0;
        answer.add(curr);
        return true;
        
    }
}