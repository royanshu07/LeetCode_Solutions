class Solution {
    int min, max;
    public int maximumScore(int[] nums, int k) {
        min = nums[k];
        max = min;
        max(nums, k - 1, k + 1);
        return max;
    }
    public void max(int[] nums,int left, int right){
        int len = nums.length;
        if(left == - 1 && right == len) return;
        if(left == -1 || (right < len && nums[right] >= nums[left])){
            min = Math.min(nums[right], min);
            right++;
        }
        else if(right == len || (nums[right] < nums[left])){
            min = Math.min(nums[left], min);
            left--;
        }
        max = Math.max(max, min * (right - left - 1));
        max(nums, left, right);
    }
}