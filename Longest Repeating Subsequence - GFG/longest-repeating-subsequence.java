//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
            String copy = "";
            for(int i = 0;i<str.length();i++){
                copy+=str.charAt(i);
            }
    int[][]dp = new int[str.length()+1][str.length()+1];
    for(int i = 0;i<=str.length();i++){
        dp[i][0]=0;
    }
   
    for(int i = 0;i<=str.length();i++){
        dp[0][i]=0;
    }
    for(int i = 1;i<=str.length();i++){
        for(int j =1;j<=str.length();j++){
            if((str.charAt(i-1)==str.charAt(j-1))&&i!=j){
                dp[i][j]=1+dp[i-1][j-1];
                
                
            }
            else{
               dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]); 
            }
        }
    }
    
    return dp[str.length()][str.length()];
            
    }
}