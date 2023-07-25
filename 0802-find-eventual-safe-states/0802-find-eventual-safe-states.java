class Solution {
    List<Integer> answer;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        answer = new ArrayList<>();
        //int[]path = new int[graph.length];
        int[]visit = new int[graph.length];
        
        for(int i =0 ;i<graph.length;i++){
            if(visit[i]==0){
                visit[i]=2;
                //path[i]=1;
                dfs(i,graph,answer,visit);
            }
        }
        Collections.sort(answer);
        return answer;
        
    }
    
    
    public boolean dfs(int curr,int[][]graph, List<Integer> answer,int[]visit){
        int[]adj = graph[curr];
        if(adj==null||adj.length==0){
            visit[curr]=1;
            //path[curr]=0;
            answer.add(curr);
            return true;
        }
        
        for(int i:adj){
            if(visit[i]==2){
               return false; 
            }
            if(visit[i]==1){
                continue;
            }
            //path[i]=1;
            visit[i]=2;
           if (dfs(i,graph,answer,visit)==false){
              return false; 
           }
        }
        visit[curr]=1;
       // path[curr]=0;
        answer.add(curr);
        return true;
        
    }
}