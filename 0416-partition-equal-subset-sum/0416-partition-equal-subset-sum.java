class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        return isSubsetSum(nums.length,nums,sum/2);
        
    }
    
    
     public static Boolean isSubsetSum(int N, int arr[], int sum){
       int[][]dp = new int[arr.length+1][sum+1];
       for(int i = 0;i<dp.length;i++){
           for(int j = 0;j<dp[0].length;j++){
               dp[i][j]=-1;
           }
       }
      int ans =  isSubsetSum(N,  arr,  sum,dp);
      if(ans==0){
          return false;
      }
      return true;}
       
    public static int isSubsetSum(int N, int arr[], int sum,int[][]dp){
        if(dp[N][sum]!=-1){
            return dp[N][sum];
        }
        if(sum==0){
           dp[N][sum]=1;
           return 1;
        }
         if(N==0){
           dp[N][sum]=0;
           return 0;
        }
        if(arr[N-1]>sum){
            return isSubsetSum(N-1,  arr,  sum,dp);
        }
        int n1 = isSubsetSum(N-1,  arr,  sum,dp);
        int n2 = isSubsetSum(N-1,  arr,  sum-arr[N-1],dp);
        if(n1==1||n2==1){
           dp[N][sum]=1;
           return 1;
        }
        dp[N][sum]=0;
        return 0;
       
    }
}