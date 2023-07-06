class Solution {
    public int rob(int[] nums) {
        int[]dp =new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            dp[i]=-1;
        }
        return rob(nums,dp,0); 
    }
    public int rob(int[] nums,int[]dp,int n) {
        if(n>=nums.length){
            return 0;
           }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a = nums[n]+rob(nums,dp,n+2);
        int b= rob(nums,dp,n+1);
        dp[n] = Math.max(a,b);
        return dp[n];
    }}