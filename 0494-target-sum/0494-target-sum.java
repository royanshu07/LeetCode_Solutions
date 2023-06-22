class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String,Integer> map = new HashMap<>();
        return findTargetSumWays(nums,  target,0,0,map);
        
        
    }
     public int findTargetSumWays(int[] nums, int target,int sum,int start,HashMap<String,Integer> map) {
           
      
          if(start==nums.length){
             if(target==sum){
              return 1;}
              else{
                  return 0;
              }
         }
         String ke = start+","+sum;
         if(map.containsKey(ke)){
             return map.get(ke);
         }
         if(start>nums.length){
             return 0;
         }
         int first = findTargetSumWays(nums,  target, sum+nums[start],start+1,map);
         int second = findTargetSumWays(nums,  target, sum-nums[start],start+1,map);
         map.put(ke,first+second);
         return first+second;
        
    }
}