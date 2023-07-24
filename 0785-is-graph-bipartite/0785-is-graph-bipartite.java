class Solution {
    public boolean isBipartite(int[][] graph) {
        int [] colour = new int[graph.length];
       
        for(int i = 0;i<graph.length;i++){
        if(colour[i]==0){
        colour[i]=1;
        boolean b =  dfs(graph,i,colour);
        if(b==false){
            return false;}
        }}
        return true;
       
    }
    public boolean dfs(int[][] graph,int curr,int[]colour) {
       
        for(int i = 0;i<graph[curr].length;i++){
            int iter = graph[curr][i];
            if(colour[curr]==colour[iter]){
                return false;
            }
            if(colour[iter]!=0){
               
            }
            else{
                colour[iter]=3-colour[curr]; 
                if(dfs(graph,iter,colour)==false){
                return false;
            }

            }
           
            
                
            }
        return true;
        }
        
        
    }
