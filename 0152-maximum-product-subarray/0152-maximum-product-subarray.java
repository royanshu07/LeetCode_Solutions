class Solution {
    public int maxProduct(int[] nums) {
        int prefmul = 1;
        int sufmul = 1;

        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            prefmul*=nums[i];
            sufmul*=nums[nums.length-1-i];
            max = Math.max(max,Math.max(prefmul,sufmul));
            if(prefmul==0){
                prefmul=1;
            }
             if(sufmul==0){
                sufmul=1;
            }
        }
        return max;
        
    }
}