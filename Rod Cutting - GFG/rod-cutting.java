//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
       int[][]dp = new int[n+1][n+1];
       for(int i = 0;i<dp.length;i++){
           for(int j = 0;j<dp.length;j++){
               dp[i][j]=-1;
           }
       }
       return cutRod( price, n,dp,n);
       
    }
    public int cutRod(int price[], int n,int[][]dp,int len) {
        if(n<=0||len<=0){
            dp[n][len]=0;
            return 0;
        }
        if(dp[n][len]!=-1){
            return dp[n][len];
        }
        if(len<n){
           dp[n][len] =cutRod( price, n-1,dp,len);
           return dp[n][len];
        }
        //int a = price[n-1]+cutRod( price, n-1,dp,len-n);
        int b = cutRod( price, n-1,dp,len);
        int c = price[n-1]+cutRod( price, n,dp,len-n);
        dp[n][len]=Math.max(b,c);
        return dp[n][len];
        
        
    }
}