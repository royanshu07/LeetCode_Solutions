//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String a,String b,int m,int n)
    {
          int[][]dp = new int[a.length()+1][b.length()+1];
    for(int i = 0;i<=a.length();i++){
        dp[i][0]=0;
    }
    String out ="";
    for(int i = 0;i<=b.length();i++){
        dp[0][i]=0;
    }
    for(int i = 1;i<=a.length();i++){
        for(int j =1;j<=b.length();j++){
            if(a.charAt(i-1)==b.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
                
                
            }
            else{
               dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]); 
            }
        }
    }
    int ans = a.length()+b.length()-dp[a.length()][b.length()];
    return ans;
    
    }
}