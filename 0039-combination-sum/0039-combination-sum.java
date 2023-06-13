class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       Arrays.sort(candidates);
       List<Integer> small = new ArrayList<>();
       List<List<Integer>> finalout = new ArrayList<>();
       combinationSum(candidates,target,  small,finalout,0);
       return finalout;
        
        
        
    }
     public boolean combinationSum(int[] candidates,int target,List<Integer> small,List<List<Integer>> finalout,int start) {
         if(target==0){
             finalout.add(new ArrayList<>(small));
             return false;
         }
         if(target<0){
             return false;
         }
         for(int i = start;i<candidates.length;i++){
             small.add(candidates[i]);
             boolean b1 =  combinationSum(candidates,target-candidates[i],        small,finalout,i); 
            
             small.remove(small.size()-1);
              if(b1==false){
                 break;
             }
         }
         return true;
         
         
         
         
     }
}