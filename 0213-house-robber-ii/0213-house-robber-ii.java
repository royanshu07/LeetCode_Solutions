class Solution {
    public int rob(int[] nums) {
        int[][]dp =new int[nums.length][2];
        for(int i = 0;i<nums.length;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return rob(nums,dp,0,0); 
    }
    public int rob(int[] nums,int[][]dp,int n,int first) {
        if(n>=nums.length){
            return 0;
           }
        if(n==nums.length-1){
            if(first==0){
                return  nums[n]+rob(nums,dp,n+2,first);
            }
            return 0;
        }
        if(dp[n][first]!=-1){
            return dp[n][first];
        }
        if(n==0){
        int a = nums[n]+rob(nums,dp,n+2,1);
        int b= rob(nums,dp,n+1,0);
         
        return Math.max(a,b);
        }
        
        int a = nums[n]+rob(nums,dp,n+2,first);
        int b= rob(nums,dp,n+1,first);
        dp[n][first] = Math.max(a,b);
        return dp[n][first];
    }}