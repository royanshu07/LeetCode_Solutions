class Solution {
    public int getMaxLen(int[] nums) {
        int pref = 1;
        int suf = 1;
        int maxlen = 0;
        int prevzerp = 0;
        int prevzers = nums.length;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
            pref=pref*(nums[i]/Math.abs(nums[i]));
            if(pref>0){
                maxlen = Math.max(i+1-prevzerp,maxlen);
            }}
            if(nums[nums.length-1-i]!=0){
            suf=suf*(nums[nums.length-1-i]/Math.abs(nums[nums.length-1-i]));
            
            if(suf>0){
                maxlen = Math.max(i+1-(nums.length-prevzers),maxlen);
            }}
            if(nums[i]==0){
                pref=1;
                prevzerp = i+1;
            }
            if(nums[nums.length-1-i]==0){
                suf=1;
                prevzers = nums.length-1-i;
            }
        }
        return maxlen;
    }
}