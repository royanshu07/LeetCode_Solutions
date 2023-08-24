// O(N)+O(N) = O(2N)
// O(K);
class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero = 0;
        int currlen = 0;
        int maxlen = 0;
        int i= 0;
        int j = 0;
         
        while(j<nums.length){
            if(nums[j]==0&&zero==k){
                while(zero==k){
                    if(nums[i]==0){
                        zero--;
                    }
                    currlen--;
                    i++;
                }
            }
            if(nums[j]==0){
                zero++;
            }
            currlen++;
            maxlen = Math.max(currlen,maxlen);
            j++;
        }
        
        return maxlen;
        
    }
}