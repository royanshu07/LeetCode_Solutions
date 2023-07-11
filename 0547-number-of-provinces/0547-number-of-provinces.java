class Solution {
    public int findCircleNum(int[][] isConnected) {
        int visited[] = new int[isConnected.length];
        int ans = 0;
       
        for(int i = 0;i<visited.length;i++){
            if(visited[i]==0){
                //System.out.print(i);
                visited[i]=1;
                ans++;
                bfs(i,isConnected,visited);
            }
        }
        return ans;
        
    }
    public void bfs(int k , int[][]connected,int[]visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        while(!q.isEmpty()){
            int b = q.poll();
            for(int i = 0;i<connected.length;i++){
                
            if(connected[b][i]!=0&&visited[i]==0){
                
                visited[i]=1;
                q.add(i);
            }
        }
        }
        
    }
   
}