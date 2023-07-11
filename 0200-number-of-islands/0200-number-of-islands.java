class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int[][]visited = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]=='1'&&visited[i][j]==0){
                    //System.out.println(i+" "+j);
                     ans++;
                    dfs(i,j,grid,visited);
                   
                }
            }
        }
        return ans;
        
    }
    
    public static void dfs(int i , int j , char[][]grid,int[][]visited){
       // System.out.println(i+" "+j);
        if(i<0||i>=grid.length||j<0||j>=grid[0].length){
            return;
        }
        if(visited[i][j]==1||grid[i][j]=='0'){
            return;
        }
        
        visited[i][j]=1;
        dfs( i+1 ,  j , grid,visited);
        dfs( i ,  j+1 , grid,visited);
        dfs( i-1 ,  j , grid,visited);
        dfs( i ,  j-1 , grid,visited);
       
        return;
    }
}