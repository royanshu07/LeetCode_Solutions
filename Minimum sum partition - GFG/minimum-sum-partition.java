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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{


	public int minDifference(int[] nums,int n) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            
        }
       
        int elem = sum/2;
       int[][]dp = check(elem,nums);
       for(int i = elem;i>0;i--){
           if(dp[nums.length][i]==1){
               return sum-(2*i);
           }
       }
       return sum;
        
    }
    
    public int[][]  check(int sum,int[]nums){
        int[][]dp = new int[nums.length+1][sum+1];
        dp[0][0]=1;
        for(int j = 1;j<=sum;j++){
            dp[0][j]= 0;
        }
        for(int i = 1;i<=nums.length;i++){
            for(int j =0;j<=sum;j++ ){
                if(nums[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                    
                }
                else if(dp[i-1][j]==1||dp[i-1][j-nums[i-1]]==1){
                     dp[i][j]=1;
                }
                else{
                    dp[i][j]=0; 
                    
                }
            }
        }
       return dp;
    }
}



