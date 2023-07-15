class Solution {
    
    public int numEnclaves(int[][] grid) {
        int row= grid.length;
        int col = grid[0].length;
        
        int orgone = 0;
        for(int i= 0;i<row;i++){
          if(grid[i][0]==1){
              dfs(i,0,grid);
          }
          if(grid[i][col-1]==1){
              dfs(i,col-1,grid);
          }
            
        }
         for(int i= 0;i<col;i++){
          if(grid[0][i]==1){
              dfs(0,i,grid);
          }
          if(grid[row-1][i]==1){
              dfs(row-1,i,grid);
          }
            
        }
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j]==1){
                    orgone++;
                }
            }
        }
        return orgone;
        
        
        
    }
    
    public static void dfs(int row , int col ,int[][]grid){
        if(row<0||col<0||row>=grid.length||col>=grid[0].length){
            return;
        }
        if(grid[row][col]==0){
            return;
        }
        grid[row][col]=0;
        dfs(row+1,col,grid);
        dfs(row,col+1,grid);
        dfs(row-1,col,grid);
        dfs(row,col-1,grid);
    }
}