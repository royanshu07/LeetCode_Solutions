class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n  = grid[0].length;
        
        int max = 0;
        
       
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
            int ans = helper(i,j,grid,0);
                    if(ans>max){
                        max= ans;
                    }
                }
               
            }
        }
        return max;
       }
    public int helper(int i , int j , int[][] grid,int curr) {
       
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0){
            return curr;
        }
        
        if(grid[i][j]==Integer.MAX_VALUE){
            return 0;
        }
        int temp = grid[i][j];
        curr+=grid[i][j];
        grid[i][j]=Integer.MAX_VALUE;
        
        int left = helper(i,j-1,grid,curr);
        int right = helper(i,j+1,grid,curr);
        int up = helper(i-1,j,grid,curr);
        int down = helper(i+1,j,grid,curr);
        grid[i][j] = temp;
        return Math.max(Math.max(left,right),Math.max(up,down));
        //System.out.println(dp[i][j]);
        
        
}}