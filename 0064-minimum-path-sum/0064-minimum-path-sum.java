class Solution {
    public int minPathSum(int[][] grid) {
        int[][]dp = new int[grid.length][grid[0].length];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],(int)1e9);
        }
        return minPathSum( grid,dp, 0,0);

        
    }
     public int minPathSum(int[][] grid,int[][]dp,int i , int j) {
         if (i >= dp.length || j >= dp[0].length) {
            return Integer.MAX_VALUE; // Return a large value for invalid indices
        }
         if(i==dp.length-1&&j==dp[0].length-1 ){
             return grid[i][j];
         }     
         if(dp[i][j]!=(int)1e9){
             return dp[i][j];
         }
         int a = minPathSum( grid,dp, i+1 ,  j);
         int b = minPathSum( grid,dp, i ,  j+1);
         dp[i][j]=Math.min(a,b)+grid[i][j];
         //System.out.println(dp[i][j]);
         return dp[i][j];
}}