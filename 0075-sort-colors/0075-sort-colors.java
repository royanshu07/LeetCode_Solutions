//1  
//p1    p2

//   i<=p2


class Solution {
    public void sortColors(int[] nums) {
    int p1= 0;
    int p2 = nums.length-1;
    int i = 0;
    int temp;
    while(i<=p2){
        if(nums[i]==0){
            temp = nums[p1];
            nums[p1] = nums[i];
            nums[i]=temp;
            p1++;
            i++;
            
        }
        else if(nums[i]==2){
            temp = nums[p2];
            nums[p2] = nums[i];
            nums[i]=temp;
            p2--;
            
            
        }
        else{
            i++;
        }

    }
        
    }
}
