class Solution {
    public int climbStairs(int n) {
       int count = 0;
       int[]dp = new int[n+1];
       return climbStairs(n,dp);
        
    }
    public int climbStairs(int n,int[] dp) {
        if(n==0){
            return 1;
        }
        if(n<0){
            return -1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int ways=0;
        int two = climbStairs(n-2,dp);
        int one =  climbStairs(n-1,dp);
        if(two>0){
          ways+=two;  
        }
         if(one>0){
             ways+=one;
         } 
        dp[n]=ways;
        return ways;

            
    }
}