class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        int l=0;
        int r=0;
        long total=0;
        while(r<nums.length)
        {
            total+=nums[r];
            while(nums[r]*(r-l+1)>total+k)
            {
                total-=nums[l];
                l++;
            }
            ans = Math.max(ans,(r-l+1));
            r++;
        }
        return ans;
    }
}