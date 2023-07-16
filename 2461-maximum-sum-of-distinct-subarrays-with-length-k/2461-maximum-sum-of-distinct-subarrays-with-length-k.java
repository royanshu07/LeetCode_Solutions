class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i=0,j=0;
        int n = nums.length;
        long sum=0, maxSum=0;
        HashSet set = new HashSet<>();

        while(j<n){
          
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
            set.add(nums[j]);
            sum+=nums[j];

            if(j-i+1<k){     
                j++;
            }else{      
                maxSum= Math.max(maxSum, sum);
                set.remove(nums[i]);
                sum-=nums[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }}