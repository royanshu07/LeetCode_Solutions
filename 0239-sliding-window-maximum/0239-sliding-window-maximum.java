class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
       Deque<Integer> q = new LinkedList<>();
        int[]ans = new int[nums.length-k+1];
        int i = 0;
        int j = 0;
        int counter = 0;
        while(j<nums.length){
            while(q.peekLast()!=null&&nums[j]>q.getLast()){
                q.removeLast();
            }
            q.addLast(nums[j]);
            if(j-i+1<k){
                j++;
            }
            else{
                ans[counter]=q.getFirst();
                counter++;
                if(q.getFirst()==nums[i]){
                    q.removeFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
        
    }
    public int maxfx(int[]nums,int i , int j){
        int max = Integer.MIN_VALUE;
        for(int a = i;a<=j;a++){
            if(nums[a]>max){
                max= nums[a];
            }
        }
        return max;
    }
    
}