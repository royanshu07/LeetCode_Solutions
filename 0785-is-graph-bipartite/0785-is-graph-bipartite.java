class Solution {
    public boolean isBipartite(int[][] graph) {
        int [] colour = new int[graph.length];
       
        for(int i = 0;i<graph.length;i++){
        if(colour[i]==0){
        colour[i]=1;
        boolean b =  bfs(graph,i,colour);
        if(b==false){
            return false;}
        }}
        return true;
       
    }
    public boolean bfs(int[][] graph,int curr,int[]colour) {
       Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        while(!q.isEmpty()){
            curr = q.poll();
        for(int i = 0;i<graph[curr].length;i++){
            int iter = graph[curr][i];
            if(colour[curr]==colour[iter]){
                return false;
            }
            if(colour[iter]!=0){
               
            }
            else{
                colour[iter]=3-colour[curr]; 
                q.add(iter);
            }

            }
           
            
                
            }
        return true;
        }
        
        
    }
