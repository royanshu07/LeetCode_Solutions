import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        for (int n : nums) {
            if (nums[Math.abs(n)] < 0) {
                return Math.abs(n);
            } else {
                nums[Math.abs(n)] *= -1;
            }
        }
        return -1;
    }
}