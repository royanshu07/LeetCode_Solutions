class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums,  target,0,0);
        
        
    }
     public int findTargetSumWays(int[] nums, int target,int sum,int start) {
        
      
          if(start==nums.length){
             if(target==sum){
              return 1;}
              else{
                  return 0;
              }
         }
         if(start>nums.length){
             return 0;
         }
         int first = findTargetSumWays(nums,  target, sum+nums[start],start+1);
         int second = findTargetSumWays(nums,  target, sum-nums[start],start+1);
         return first+second;
        
    }
}