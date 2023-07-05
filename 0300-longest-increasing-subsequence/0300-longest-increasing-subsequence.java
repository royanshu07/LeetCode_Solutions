class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<=nums.length;j++){
                dp[i][j] =-1;
            }
        }
        return lengthOfLIS(nums,0,-1,dp,nums.length);
        
        
    }
     public int lengthOfLIS(int[] nums,int start, int prev,int[][]dp,int len) {
         if(start==len){
             return 0;
         }
         if(dp[start][prev+1]!=-1){
             return dp[start][prev+1];
         }
         int take = 0;
         if(prev==-1||nums[start]>nums[prev]){
             take = 1+lengthOfLIS(nums,start+1,start,dp,len);
         }
         int nottake = lengthOfLIS(nums,start+1,prev,dp,len);
          dp[start][prev+1] = Math.max(take,nottake);
          return dp[start][prev+1];         
        

         
}}