class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> nums2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            nums2.add(nums[i]);
        }
         permute(nums2,ans,0);
         return ans;
        
       
    }
    public void permute(List<Integer> nums2,List<List<Integer>> ans,int start){
        if(start==nums2.size()-1){
            ans.add(new ArrayList<>(nums2));
            
        }
        for(int i = start;i<nums2.size();i++){
            swap(nums2,start,i);
            permute(nums2,ans,start+1);
            swap(nums2,start,i);
        }
        return;
    }
    
    public static void swap(List<Integer> nums2,int a,int b){
        int temp = nums2.get(a);
        nums2.set(a,nums2.get(b));
        nums2.set(b,temp);
        return;
    }
    
}