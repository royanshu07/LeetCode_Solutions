class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] t = new int[n];
        for(int i=0;i<n;i++)
        {
            t[i] = nums[i];
        }
        Deque<Integer> q = new ArrayDeque<>();
        int result = t[0];

        for(int i=0;i<n;i++)
        {
            while(!q.isEmpty() && i - q.peekFirst() > k)
            {
                q.pollFirst();
            }

            if(!q.isEmpty())
            {
                 t[i] = Math.max(t[i] , nums[i] + t[q.peekFirst()]);
            }

            while(!q.isEmpty() && t[i] >= t[q.peekLast()])
            {
                q.pollLast();
            }
           
            q.offerLast(i);
            result = Math.max(result , t[i]);
        }

        return result;

    }
}