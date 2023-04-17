class Solution {
   // 0,0,2,1,1,2

    public void sortColors(int[] nums) {
       int zer = 0;
       int one = 0;
       int two = 0;
       
       for(int i = 0; i<nums.length;i++){
           if(nums[i]==0){
               zer++;
           }
           if(nums[i]==1){
               one++;
           }
            if(nums[i]==2){
               two++;
           }
       }
       for(int i = 0;i<zer;i++){
           nums[i]=0;
       }
       for(int i = zer;i<one+zer;i++){
           nums[i]=1;
       }
       for(int i = one+zer;i<nums.length;i++){
           nums[i]=2;
      }
      
    
        
        
    }
}