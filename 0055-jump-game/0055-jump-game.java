class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<=1){
            return true;
        } 
        int  goal = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=goal){
                goal=i;
            }
            if(goal<=0){
                return true;
            }
        }
        return false;
        
    }
}