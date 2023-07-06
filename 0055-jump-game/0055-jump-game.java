class Solution {
    public boolean canJump(int[] nums) {
        int[]dp = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            dp[i]=-1;
        }
        int a = canJump(nums ,0,dp);
        if(a==1){
            return true;
        }
        return false;
        
        
    }
    public int canJump(int[] nums ,int i,int[]dp) {
        if(i==nums.length-1){
            return 1;
        }
        if(i>=nums.length){
            return 0;
        }
        if(nums[i]==0){
         return 0;}
       if(dp[i]!=-1){
           return dp[i];
           
       }
       for(int j = 1;j<=nums[i];j++){
           int a= canJump(nums ,j+i,dp);
           if(a==1){
               dp[i]=1;
               return 1;
           }
       }
        dp[i]=0;
        return 0;
        
    }
}