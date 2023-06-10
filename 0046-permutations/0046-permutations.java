class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[][] out = permute(nums, 0);
        List<List<Integer>> finalOut = new ArrayList<>();
        for (int i = 0; i < out.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < out[i].length; j++) {
                tempList.add(out[i][j]);
            }
            finalOut.add(tempList);
        }
        return finalOut;
    }


    
        
    
    
    public int[][] permute(int[] nums,int start) {
        
        if(start==nums.length-1){
            int[][]out = new int[1][];
            out[0] = new int[]{nums[start]};
            
            return out;
        }
        
        int[][]smallout = permute(nums,start+1);
       int[][] finalout = new int[(smallout.length) * (smallout[0].length + 1)][];
       int z = 0;
       
        for(int[]i:smallout){
             for(int j=0;j<=i.length;j++){
                int[]temp = new int[i.length+1];
                temp[j]=nums[start];
                int k= 0;
                for(int l = 0;l<temp.length;l++){
                    if(l==j){
                        //l++;
                        
                    }
                    else{
                        temp[l]=i[k];
                        k++;
                    }
                }
                finalout[z]=temp;
                z++;
                
            }
        }
        return finalout;
        
        
    }
}
