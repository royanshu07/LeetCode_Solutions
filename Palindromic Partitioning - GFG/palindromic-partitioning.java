//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int palindromicPartition(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return palindromicPartition(str, 0, str.length() - 1, dp);
    }

    static int palindromicPartition(String str, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (ispal(str, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = j;
        for (int k = i; k < j; k++) {
            int a = palindromicPartition(str, i, k, dp);
            int b = palindromicPartition(str, k + 1, j, dp);
            if (min > a + b + 1) {
                min = a + b + 1;
            }
        }
        dp[i][j] = min;
        return min;
    }

    static boolean ispal(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
