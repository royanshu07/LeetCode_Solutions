class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[]nums2 = new int[nums.length*2];
        for(int i = 0;i<nums.length;i++){
            nums2[i]=nums[i];
            nums2[i+nums.length]=nums[i];
        }
        
        
        int[]helper = new int[nums.length];
         Stack<Integer> stk = new Stack<>();
        
         for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= nums2[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                if(i<nums.length){
                helper[i] = stk.peek();}
            } else {
                if(i<nums.length){
                helper[i] = -1;}
            }
            stk.push(nums2[i]);
        }
        
        
       return helper;
    }
        
        
    }
