class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = 0;
        int t =0;
        int b = nums.length;
        for(int i = 0;i<b-1;i++){
            if(nums[i]>nums[i+1]){
                n++;
            }
            else if(nums[i]==nums[i+1]){
                t--;
                n++;
            }
            else{
                t--;
            }
        }
        // System.out.print(n);
        if((n==b-1)||(t==1-b)){
            return true;
        }
        else{
            return false;
        }
    }
}