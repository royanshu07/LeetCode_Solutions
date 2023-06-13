class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<Integer> small = new ArrayList<>();
       List<List<Integer>> finalout = new ArrayList<>();
       combinationSum(candidates,target,  small,finalout,0);
       return finalout;
        
        
        
    }
     public void combinationSum(int[] candidates,int target,List<Integer> small,List<List<Integer>> finalout,int start) {
         if(target==0){
             finalout.add(new ArrayList<>(small));
             return;
         }
         if(target<0){
             return;
         }
         for(int i = start;i<candidates.length;i++){
             small.add(candidates[i]);
             combinationSum(candidates,target-candidates[i],  small,finalout,i); 
             small.remove(small.size()-1);
             
         }
         return ;
         
         
         
         
     }
}