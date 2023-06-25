import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j]=-1;
        }}
        int res = coinChange(coins, amount, coins.length, dp);
        if (res >= Integer.MAX_VALUE-1) {
            return -1;
        }
        return res;
    }

    public int coinChange(int[] coins, int amount, int n,int[][]dp) {
        if (amount == 0) {
            
            dp[n][amount] = 0;
            return dp[n][amount];
        }
        if(n==1){
              if(amount%coins[n-1]!=0){
                  dp[n][amount] = Integer.MAX_VALUE-1;
                  return dp[n][amount];}
            else{
                dp[n][amount] = amount/coins[n-1];
                return dp[n][amount];}
            }
        
            
      
     
        

        
        
        if (n == 0) {
            dp[n][amount] = Integer.MAX_VALUE-1;
            return dp[n][amount];
        }
        if (dp[n][amount] != -1) {
           
                return dp[n][amount];
            
        }
        if (amount < coins[n - 1]) {
            return coinChange(coins, amount, n - 1, dp);
        }

        int a = 1+coinChange(coins, amount - coins[n - 1], n, dp);
        int b = coinChange(coins, amount, n - 1, dp);
        dp[n][amount] = Math.min(a, b);
      
        return dp[n][amount];
    }
}
