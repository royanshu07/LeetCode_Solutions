class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[]dp = new int[cost.length+1];
        for(int i = 0;i<=cost.length;i++){
            dp[i]=-1;
        }
        return minCostClimbingStairs( cost,dp,-1);
        
    }
     public int minCostClimbingStairs(int[] cost,int[]dp,int n) {
         if(n>=cost.length){
             return 0;
         }
         if(dp[n+1]!=-1){
             return dp[n+1];
         }
         if(n==-1){
             int one = minCostClimbingStairs(cost,dp,n+1);
             int two = minCostClimbingStairs(cost,dp,n+2);
             dp[n+1] = Math.min(one,two);
             return dp[n+1];
         }
        
             int one = minCostClimbingStairs(cost,dp,n+1);
             int two = minCostClimbingStairs(cost,dp,n+2);
             dp[n+1] = Math.min(one+cost[n],two+cost[n]);
             return dp[n+1];
        
    }
}