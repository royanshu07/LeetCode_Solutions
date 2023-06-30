//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N][N];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(arr, dp, 1, N - 1);
    }

    static int helper(int[] arr, int[][] dp, int i, int j) {
        int mod = 1000000007;
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int a = i; a < j; a++) {
            int leftCost = helper(arr, dp, i, a);
            int rightCost = helper(arr, dp, a + 1, j);
            int currentCost = arr[i - 1] * arr[a] * arr[j];
            int totalCost = leftCost + rightCost + currentCost;
            min = Math.min(min, totalCost % mod);
        }
        dp[i][j] = min;
        return min;
    }
}
