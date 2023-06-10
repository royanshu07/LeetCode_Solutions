class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
        
    }


    
        
    
    
    public  List<List<Integer>> permute(int[] nums,int start) {
        
        if(start==nums.length-1){
            List<List<Integer>>out = new ArrayList<>();
            List<Integer>smallout = new ArrayList<>();
            smallout.add(nums[start]);
            out.add(smallout);
            
            return out;
        }
        
     List<List<Integer>>smallout = permute(nums,start+1);
     List<List<Integer>> finalout = new ArrayList<>();
       int z = 0;
       
        for(List<Integer>i:smallout){
             for(int j=0;j<=i.size();j++){
               List<Integer> temp = new ArrayList<>();
                //temp[j]=nums[start];
                int k= 0;
                for(int l = 0;l<=i.size();l++){
                    if(l==j){
                        temp.add(-1);
                        
                    }
                    else{
                        temp.add(l,i.get(k));
                        k++;
                    }
                }
                temp.set(j,nums[start]);
                finalout.add(temp);
                z++;
                
            }
        }
        return finalout;
        
        
    }
}
