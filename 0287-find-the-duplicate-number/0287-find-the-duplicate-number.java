import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        int a ;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            a = map.getOrDefault(nums[i],0);
            if(a==1){
                return nums[i];
            }
            map.put(nums[i],a+1);
        }
        return 1;
       
}
}