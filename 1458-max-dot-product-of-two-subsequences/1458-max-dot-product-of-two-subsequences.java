class Solution {
    Integer[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp=new Integer[nums1.length][nums2.length];

        int max=-1000000000;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]*nums2[j]>max){
                    max=nums1[i]*nums2[j];
                }
            }
        }
        int temp=findMax(nums1,nums2,0,0);
        if(temp!=0 && temp>max)
        return temp;
        else return max;
        
    }
    public int findMax(int[] nums1,int[] nums2,int i1,int i2){
        if(i1>=nums1.length || i2>=nums2.length)
        return 0;
        int ans=-100000000;
        if(dp[i1][i2]!=null)
        return dp[i1][i2];
        
        for(int j=i2;j<nums2.length;j++){
            int temp=(nums1[i1]*nums2[j])+findMax(nums1,nums2,i1+1,j+1);
            if(temp>ans)
            ans=temp;
        }
        return dp[i1][i2]=Math.max(ans,findMax(nums1,nums2,i1+1,i2));
    }
}