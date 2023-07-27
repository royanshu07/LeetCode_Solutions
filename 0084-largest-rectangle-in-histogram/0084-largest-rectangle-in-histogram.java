class Solution {
    public int largestRectangleArea(int[] heights) {
        int[]leftsmall = new int[heights.length];
        int[]rightsmall = new int[heights.length];
        Stack<Integer> stk = new Stack<>();
        
        for(int i =0;i<heights.length;i++){
            while(!stk.isEmpty()&&heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                leftsmall[i]=-1;
                stk.add(i);
            }
            else{
                leftsmall[i]=stk.peek();
                stk.add(i); 
            }
        }
        stk = new Stack<>();
         for(int i =heights.length-1;i>=0;i--){
            while(!stk.isEmpty()&&heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
               rightsmall[i]=-1;
                stk.add(i);
            }
            else{
                rightsmall[i]=stk.peek();
                stk.add(i); 
            }
        }
        
       int maxarea = 0;
       int currarea = 0;
       for(int i = 0;i<heights.length;i++){
           int height = heights[i];
           int leftarea = height*(i-leftsmall[i]);
           if(leftsmall[i]==-1){
             leftarea = height*(i+1);  
           }
           int rightarea = height*(rightsmall[i]-i);
           if(rightsmall[i]==-1){
             rightarea = height*(heights.length-i);  
           }
           maxarea= Math.max(leftarea+rightarea-height,maxarea);
           
       }
        return maxarea;
        
    }
}