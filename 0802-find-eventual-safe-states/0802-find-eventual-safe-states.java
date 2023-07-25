class Solution {
    List<Integer> ans;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
          int[]visit = new int[graph.length];
         ans = new ArrayList<>();
         for(int i = 0;i<graph.length;i++){
         // if(visit[i]!=0){
         //     continue;
         // }  
         visit[i]=2;    
         dfs(graph,ans,i,visit);}
        
        for(int i = 0;i<visit.length;i++){
            if(visit[i]==3){
                ans.add(i);
            }
        }
         return ans;
    }
    
     public int  dfs(int[][] graph,List<Integer> ans,int curr,int[]visit) {
         int[]adj = graph[curr];
         if(adj==null||adj.length==0){
             //System.out.println(curr);
             visit[curr]=3;
             return 1;
         }
        
         for(int i:adj){
             if(visit[i]==2){
                 
                 //System.out.println(curr+" "+i);
                 return 0;
             }
             if(visit[i]==1||visit[i]==3){
                 continue;
             }
             visit[i]=2;
            
             int a = dfs(graph,ans,i,visit);
             if(a==0){
                 System.out.println(curr+" "+i);
                 return 0;
             }
             visit[i]=1;
         }
         visit[curr]=3;
         return 1;
        
    }
    
    
}