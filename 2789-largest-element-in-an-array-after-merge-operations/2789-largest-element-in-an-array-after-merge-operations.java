class Solution {
    public long maxArrayValue(int[] nums) {
        long[]nums2 = new long[nums.length];
        for(int i = 0;i<nums.length;i++){
            nums2[i]=nums[i];
        }
      
        long  max = nums[0];
       
        for(int i =nums.length-1;i>=1;i--){
            if(nums2[i]>=nums2[i-1]){
                nums2[i-1]=nums2[i]+nums2[i-1];
                max = Math.max(nums2[i-1],max);
            }
             
           
            else{
              max = Math.max(max,nums2[i-1]);  
            }
               
             
        }
        return max;
        
    }
}