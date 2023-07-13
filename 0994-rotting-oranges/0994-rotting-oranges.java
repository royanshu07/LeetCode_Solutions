class Solution {
    static int curr = 0;
    public int orangesRotting(int[][] grid) {
        int countfresh = 0;
        curr = 0;
        int[][]visited = new int[grid.length][grid[0].length];
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==2&&visited[i][j]==0){
                    //System.out.println(i+" "+j);
                    visited[i][j]=1;
                    q.add(i);
                    q.add(j);
                    q.add(0);
                    
                }
                if(grid[i][j]==1){
                    countfresh++;
                }
            }
        }
        ans = bfs(q,grid,visited);        
        

        if(curr!=countfresh){
            return -1;
        }
        return ans;}
        
        public int bfs(  Queue<Integer> q,int[][]grid,int[][]visited){
           int ans = 0;
            int finala = 0;
            
          
            while(!q.isEmpty()){
                //System.out.println(i+" "+j);
                ans = 0;
                int a= q.poll();
                int b = q.poll();
                int c = q.poll();
                if(a+1<grid.length&&grid[a+1][b]==1&&visited[a+1][b]==0){
                    ans=1;
                    curr++;
                    //System.out.println(a+" "+b);
                    grid[a+1][b]=2;
                    visited[a+1][b]=1;
                    q.add(a+1);
                    q.add(b);
                    q.add(c+1);
                }
                if(b+1<grid[0].length&&grid[a][b+1]==1&&visited[a][b+1]==0){
                    ans=1;
                    curr++;
                    //System.out.println(a+" "+b);
                    grid[a][b+1]=2;
                    visited[a][b+1]=1;
                    q.add(a);
                    q.add(b+1);
                    q.add(c+1);
                }
                if(a-1>=0&&grid[a-1][b]==1&&visited[a-1][b]==0){
                    curr++;
                    grid[a-1][b]=2;
                    //System.out.println(a+" "+b);
                    ans=1;
                    visited[a-1][b]=1;
                    q.add(a-1);
                    q.add(b); 
                    q.add(c+1);
                }
                if(b-1>=0&&grid[a][b-1]==1&& visited[a][b-1]==0){
                    curr++;
                    grid[a][b-1]=2;
                    //System.out.println(a+" "+b);
                    ans=1;
                    visited[a][b-1]=1;
                    q.add(a);
                    q.add(b-1); 
                    q.add(c+1);
                }
                if(ans==1){
                    //System.out.println(a+" "+b);
                    finala = c+1;
                }
                
                
            }
           return finala; 
        }
        
    }
