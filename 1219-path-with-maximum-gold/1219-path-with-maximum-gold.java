class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n  = grid[0].length;
        int[][]dp= new int[m][n];
        int max = 0;
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j]=-1;
               
            }
        }
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(grid[i][j]!=0){
            int ans = helper(i,j,grid,dp,0);
                    if(ans>max){
                        max= ans;
                    }
                }
               
            }
        }
        return max;
       }
    public int helper(int i , int j , int[][] grid,int[][]dp,int curr) {
       
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0){
            return curr;
        }
        
        if(dp[i][j]==Integer.MAX_VALUE){
            return 0;
        }
        //  if(dp[i][j]!=-1){
        //     return dp[i][j];
        // }
        // if(grid[i][j]==0){
        //     return curr;
        // }
        dp[i][j]=Integer.MAX_VALUE;
        curr+=grid[i][j];
        int left = helper(i,j-1,grid,dp,curr);
        int right = helper(i,j+1,grid,dp,curr);
        int up = helper(i-1,j,grid,dp,curr);
        int down = helper(i+1,j,grid,dp,curr);
        
        dp[i][j]=Math.max(Math.max(left,right),Math.max(up,down));
        //System.out.println(dp[i][j]);
        return dp[i][j];
        
}}