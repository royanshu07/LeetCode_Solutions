
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE;
        int left = values[0]+0;
        for(int i = 1;i<values.length;i++){
            int right = values[i]-i;
            ans = Math.max(ans,right+left);
            left = Math.max(left,values[i]+i);
            
            
        }
        return ans;
        
    }
}
