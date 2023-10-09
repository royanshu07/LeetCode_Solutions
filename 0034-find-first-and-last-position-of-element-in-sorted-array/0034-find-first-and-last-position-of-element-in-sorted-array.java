class Solution {
    public int[] searchRange(int[] nums, int target) {
       int ans[] = new int[2];
       ans[0]=left(nums,target);
       ans[1]=right(nums,target);
       return ans;        
    }
    
    public int left(int[]nums,int target){
        int i = 0;
        int j = nums.length-1;
        int ans = -1;
        while(i<=j){
            int mid =  i+((j-i)/2);
            if(nums[mid]==target){
                j = mid-1;
                ans=mid;
            }
            else if(nums[mid]>target){
                j = mid-1; 
            }
            else{
                i=mid+1;
            }
        }
        return ans;
    }
    public int right(int[]nums,int target){
        int i = 0;
        int j = nums.length-1;
        int ans = -1;
        while(i<=j){
            int mid =  i+((j-i)/2);
            if(nums[mid]==target){
                i = mid+1;
                ans=mid;
            }
            else if(nums[mid]>target){
                j = mid-1; 
            }
            else{
                i=mid+1;
            }
        }
        return ans;
    }
}