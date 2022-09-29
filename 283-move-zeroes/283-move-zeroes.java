class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int end = len-1;
        int i =0;
        
        while(i<len){
            if(nums[i]==0){
                for(int j = i;j<len-1;j++){
                   nums[j]=nums[j+1];
               }
                nums[end]=0;
                end--;
                len--;
            }
            else{i++;
        }
        
    }
}}