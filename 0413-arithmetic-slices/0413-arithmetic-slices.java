class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i+2;j<nums.length;j++){
                if(nums[i]-nums[i+1]==nums[j-1]-nums[j]){
                    sum++;
                }
                else{
                    break;
                }
            }
        }
        return sum;
        
    }
}