class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
       
        
        
        int[]helper = new int[nums.length];
         Stack<Integer> stk = new Stack<>();
        
         for (int a = 2*(nums.length - 1); a >= 0; a--) {
             int i = a%nums.length;
            while (!stk.isEmpty() && stk.peek() <= nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                
                helper[i] = stk.peek();
            } else {
               
                helper[i] = -1;
            }
            stk.push(nums[i]);
        }
        
        
       return helper;
    }
        
        
    }
