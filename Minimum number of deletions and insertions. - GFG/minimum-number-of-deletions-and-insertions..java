//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String word1, String word2) 
	{ 
	   int[][]dp = new int[word1.length()+1][word2.length()+1];
        for(int i =0;i<dp.length;i++){
            dp[i][0]=0;
        }
         for(int i =0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=1+ dp[i-1][j-1];
                }
                else{
                    int a = dp[i][j-1];
                    int b = dp[i-1][j];
                    dp[i][j]= Math.max(a,b);

                }
            }
        }
        int ans = word1.length()+word2.length()-(2*dp[word1.length()][word2.length()]);
        return ans;
        
	} 
}