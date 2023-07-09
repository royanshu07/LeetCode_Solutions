class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxkad = -300000;
        int minkad = 300000;
        int sum = 0;
        int max= -300000;
        int min = 300000;
        int globalmax = -300000;
        
        
        for(int i = 0;i<nums.length;i++){
           if(nums[i]>globalmax){
               globalmax=nums[i];
           }
           minkad = Math.min(minkad+nums[i],nums[i]);
           maxkad = Math.max(maxkad+nums[i],nums[i]);
           if(max<maxkad){
               max = maxkad;
           }
            if(min>minkad){
               min = minkad;
           }
          

           sum+=nums[i];
        }
         
        
        
        if(globalmax<0){
            return max;
        }
        return Math.max(sum-min,max);
        
        
        
        
        
    }
}