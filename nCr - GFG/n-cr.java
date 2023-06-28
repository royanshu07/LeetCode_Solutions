//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        int[][]dp = new int[n+1][r+1];
        for(int i = 0;i<n+1;i++){
            dp[i][0] =1;
        }
        for(int i = 1;i<r+1;i++){
            dp[0][i] =0;
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=r;j++){
                int a= dp[i-1][j-1];
                int b = dp[i-1][j];
                dp[i][j]=(a+b)%(1000000007);
            }
        }
        return dp[n][r];
    }
}