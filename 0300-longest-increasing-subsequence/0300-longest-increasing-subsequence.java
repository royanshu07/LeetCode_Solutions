class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> helper = new ArrayList<Integer>();
        helper.add(nums[0]);
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>helper.get(helper.size()-1)){
                helper.add(nums[i]);
            }
            else{
                int index =  binarySearch(helper, nums[i]);
                helper.set(index,nums[i]);
            }
        }
        return helper.size();
        
    }
      static int binarySearch(ArrayList<Integer> ans, int key) {
        int low = 0;
        int high = ans.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ans.get(mid) == key) return mid;
            else if (ans.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high + 1;
    }
}