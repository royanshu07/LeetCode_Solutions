class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int oddCount = 0;
        map.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                oddCount++;
            }
            
            // Increment the count in the map for the current oddCount
            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
            
            if (oddCount >= k) {
                count += map.getOrDefault(oddCount - k, 0);
            }
        }
        
        return count;
    }
}
