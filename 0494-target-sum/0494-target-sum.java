class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            
       }
       if(target>sum){
           return 0;}
        if((sum-target)%2!=0){
            return 0;
        }
        int s2 = (sum-target)/2;
        
        int[][]dp = new int[nums.length+1][s2+1];
        
        dp[0][0]=1;
        for(int j = 1;j<=s2;j++){
            dp[0][j]=0;
        }
        
        for(int i = 1;i<=nums.length;i++){
            for(int j = 0;j<=s2;j++){
                if(nums[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];}
            }
        }
        return dp[nums.length][s2];
           
       
        
        
    }
}