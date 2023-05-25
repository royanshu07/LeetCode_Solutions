class Solution {
    
    public static void downheapify(int[] nums, int start , int end){
       int parent = start;
       int left = 2*start+1;
       int right = 2*start +2;
       int minindex = parent;
       while(left<=end){
           if(nums[minindex]>nums[left]){
               minindex = left;
           }
            if(right<=end&&nums[minindex]>nums[right]){
               minindex = right;
           }
           if(minindex==parent){
               return;
           }
           else{
                int temp = nums[minindex];
                nums[minindex] = nums[parent];
                nums[parent]= temp;
                parent = minindex;
                left = parent*2+1;
                right = left+1;
               
           }
       }
    
    }
    public int findKthLargest(int[] nums, int k) {
       for(int i = k/2;i>=0;i--){
           downheapify(nums,i,k-1);
       }
        for(int i =k;i<nums.length;i++){
            if(nums[i]>nums[0]){
                int temp = nums[i];
                nums[i] = nums[0];
                nums[0]= temp;
                downheapify(nums,0,k-1);
            }
        }
        return nums[0];
       
    }
}