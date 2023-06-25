import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        //Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0;i<=coins.length;i++){
            dp[i][0] = 0; 
        }
        for(int j = 1;j<=amount;j++){
             if(j%coins[0]!=0){
                  dp[1][j] = Integer.MAX_VALUE-1;
                  }
            else{
                dp[1][j] = j/coins[0];
                }
            }
        for(int j = 0;j<=amount;j++){
           dp[0][j]=Integer.MAX_VALUE-2; 
        }
        
        for(int i = 2;i<=coins.length;i++){
            for(int j = 1;j<=amount;j++){
                if (j < coins[i - 1]) {
                    dp[i][j]=dp[i-1][j];}
                else{
                    
                   int a = 1+dp[i][j-coins[i-1]];
                   int b = dp[i-1][j];
                   dp[i][j] = Math.min(a, b);  
                }
           
        
                
            }
        }
        if(dp[coins.length][amount]>=Integer.MAX_VALUE-1){
            return -1;
        }
        return dp[coins.length][amount];
        
    }}

  