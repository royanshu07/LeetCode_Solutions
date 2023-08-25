class Solution {
    public int maxScore(int[] cardPoints, int k) {
       int end = cardPoints.length-1;
      int currsum = 0;
      int maxsum = 0;
      for(int iter = 0;iter<k;iter++){
          currsum+=cardPoints[end];
          end--;
      }
      if(k==cardPoints.length){
          return currsum;
      }
      int i = 0;
      int j = cardPoints.length-k;
     
     
      maxsum = Math.max(currsum,maxsum); 
      while(j<cardPoints.length){
          currsum+=cardPoints[i];
          currsum-=cardPoints[j];
          i++;
          j++;
          maxsum = Math.max(currsum,maxsum); 
      }
      return maxsum;
        
            
    }
}