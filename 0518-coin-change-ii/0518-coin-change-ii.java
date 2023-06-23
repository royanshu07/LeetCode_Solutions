class Solution {
    public int change(int amount, int[] coins) {
        int[][]dp = new int[coins.length+1][amount+1];
        for(int i = 0;i<=coins.length;i++){
            for(int j = 0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
      return change(amount,coins,dp,coins.length);  
    }
     public int change(int amount, int[] coins,int[][]dp,int item) {
         if(amount<0||item<0){
             return 0;
         }
         if(amount==0){
             dp[item][amount]=1;
             //System.out.println(item+" "+amount +" "+  dp[item][amount]);
             return dp[item][amount];
         }
         if(item==0){
             dp[item][amount]=0;
             //System.out.println(item+" "+amount +" "+  dp[item][amount]);
             return dp[item][amount];
         }
         if(dp[item][amount]!=-1){
            // System.out.println(item+" "+amount +" "+  dp[item][amount]);
             return dp[item][amount]; 
            // return 0;
         }
        
         if(amount<coins[item-1]){
             dp[item][amount]=change(amount,coins,dp,item-1);  
             //System.out.println(item+" "+amount +" "+  dp[item][amount]);
             return dp[item][amount];
         }
         
         int a = change(amount,coins,dp,item-1); 
         //int b = change(amount-coins[item-1],coins,dp,item-1); 
         int c = change(amount-coins[item-1],coins,dp,item);
      
         dp[item][amount] = a+c;
         //System.out.println(item+" "+amount +" "+  dp[item][amount]);
         return dp[item][amount];
         
    
}}