class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        int[]helper = new int[nums2.length];
         for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= nums2[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                helper[i] = stk.peek();
            } else {
                helper[i] = -1;
            }
            stk.push(nums2[i]);
        }
        
        
        for(int i = 0;i<nums1.length;i++){
            int a = findindex(nums1[i],nums2);
            nums1[i]=helper[a];
        }
        
        return nums1;
    }
    
    public static int findindex(int a ,int[]arr ){
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==a){
              return i;  
            }
        }
        //System.out.print("hiii");
        return -1;
    }
}