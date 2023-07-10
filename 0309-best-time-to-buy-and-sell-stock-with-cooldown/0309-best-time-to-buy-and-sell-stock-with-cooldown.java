
class Solution {
    public int maxProfit(int[] prices) {
        int[][]dp = new int[prices.length][2];
        for(int i= 0;i<prices.length;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return maxProfit(prices,0 , 0 , 0 ,dp);
            
        
        
        
    }
     public int maxProfit(int[] prices,int i , int j , int price,int[][]dp ) {
         if(i>=prices.length){
             return 0;
         }
         if(dp[i][j]!=-1){
             return dp[i][j];
         }
         if(j==0){
             int a = -prices[i]+maxProfit( prices, i+1 , 1 , prices[i],dp );
             int b = maxProfit( prices, i+1 , 0 , 0,dp);
             dp[i][j] = Math.max(a,b);
             return Math.max(a,b);
             
         }
         if(j==1){
             int a = prices[i]+maxProfit( prices, i+2 , 0 , 0 ,dp);
             int b = maxProfit( prices, i+1 , 1 , price,dp);
             dp[i][j] = Math.max(a,b);
             return Math.max(a,b);
             
         }
         return 0;
         
     }
}