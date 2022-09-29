class Solution {
    public void sortColors(int[] nums) {
        int red =0;
        int white = 0;
        int blue= 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                red++;
            }
              if(nums[i]==1){
                white++;
            }
              if(nums[i]==2){
                blue++;
            }
        }
        System.out.print(red + " "+white+ ""+ blue);
        int j =0;
        while(j<red){
            nums[j]=0;
            j++;
        }
        while(j<red+white){
            nums[j]=1;
            j++;
        }
        while(j<red+white+blue){
            nums[j]=2;
            j++;
        }
        
    
        
    }
}