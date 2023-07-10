
class Solution {
    public int maxProfit(int[] prices,int fee) {
        int[][]dp = new int[prices.length][2];
        for(int i= 0;i<prices.length;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return maxProfit(prices,0 , 0 , fee ,dp);
            
        
        
        
    }
     public int maxProfit(int[] prices,int i , int j , int fee,int[][]dp ) {
         if(i>=prices.length){
             return 0;
         }
         if(dp[i][j]!=-1){
             return dp[i][j];
         }
         if(j==0){
             int a = -prices[i]-fee+maxProfit( prices, i+1 , 1 , fee,dp );
             int b = maxProfit( prices, i+1 , 0 , fee,dp);
             dp[i][j] = Math.max(a,b);
             return Math.max(a,b);
             
         }
         if(j==1){
             int a = prices[i]+maxProfit( prices, i+1 , 0 , fee ,dp);
             int b = maxProfit( prices, i+1 , 1 , fee,dp);
             dp[i][j] = Math.max(a,b);
             return Math.max(a,b);
             
         }
         return 0;
         
     }
}