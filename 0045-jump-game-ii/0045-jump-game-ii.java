class Solution {
    public int jump(int[] nums) {
        int[]dp = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            dp[i]=-1;
        }
        
        return canJump( nums ,0,dp) ;
        
        
    }
    public int canJump(int[] nums ,int i,int[]dp) {
        if(i>=nums.length-1){
            return 0;
        }
        
        
       if(dp[i]!=-1){
           return dp[i];
           
       }
       int min = 100000;
       for(int j = nums[i];j>=1;j--){
           int a= 1+canJump(nums ,j+i,dp);
           if(a<min){
               min = a;
           }
          
           }
       
        dp[i]=min;
        return min;
        
    }
}