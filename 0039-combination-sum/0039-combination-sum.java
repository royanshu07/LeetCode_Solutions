class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>small = new ArrayList<Integer>();
        List<List<Integer>> finalout = new ArrayList<>();
        return combinationSum( candidates, target, 0,small,finalout);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target, int start,List<Integer>small,  List<List<Integer>> finalout ) {
       
        if(target==0){
            finalout.add(small);
            return finalout;
            
        }
        if(start ==candidates.length||target<0){
            return finalout;
        }
         
        
          combinationSum( candidates, target, start+1, new ArrayList<>(small),finalout);
          //small.add(candidates[start]);
           //List<Integer> temp =  new ArrayList<>(small);
          int k = target;
           k = k-candidates[start];
          while(k>=0){
          
           small.add(candidates[start]);
           combinationSum( candidates, k, start+1, new ArrayList<>(small),finalout);
           k = k-candidates[start];
                                  }
          
          
   
        
        return finalout;
        
        
    }}