import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][][] dp = new int[coins.length + 1][amount + 1][2];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j][0] = -1;
            }
        }
        int res = coinChange(coins, amount, coins.length, 0, dp);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public int coinChange(int[] coins, int amount, int n, int no, int[][][] dp) {
        if (amount == 0) {
            dp[n][amount][0] = no;
            return dp[n][amount][0];
        }
        if (n == 0) {
            dp[n][amount][0] = Integer.MAX_VALUE;
            return dp[n][amount][0];
        }
        if (dp[n][amount][0] != -1) {
            if (dp[n][amount][1] <= no) {
                return dp[n][amount][0];
            }
        }
        if (amount < coins[n - 1]) {
            return coinChange(coins, amount, n - 1, no, dp);
        }
        int a = coinChange(coins, amount - coins[n - 1], n, no + 1, dp);
        int b = coinChange(coins, amount, n - 1, no, dp);
        dp[n][amount][0] = Math.min(a, b);
        dp[n][amount][1] = no;
        return dp[n][amount][0];
    }
}
