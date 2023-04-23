// 1 2 2 1   -- 1 1 2 2    
// 2 2       -- 2 2 
     


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int size1 = nums1.length;
        int size2 = nums2.length;
        int k = 0;
        int i = 0;
        int j = 0;
        int [] nums3 = new int[Math.min(size1,size2)];
        while(i<size1&&j<size2){
            if(nums1[i]==nums2[j]){
                if(k==0||nums3[k-1]!=nums1[i]){
                    nums3[k]=nums1[i];
                    k++;
                    
                }
                i++;
                j++;
                
            }
            
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            
        
        }
        
        int[] nums4 = new int[k];
        for(int l = 0;l<k;l++){
            nums4[l]=nums3[l];
        }
        return nums4;
        
        
    }
}