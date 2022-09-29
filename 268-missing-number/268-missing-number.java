class Solution {
    public int missingNumber(int[] nums) {
      
        for(int i = 0;i<=nums.length;i++){
            int m =0;
            for(int j = 0;j<nums.length;j++){
                if(nums[j]==i){
                    m = 1;
                }
            }
            if(m==0){
                return i;
            }
        }
      return 0;  
    }
}