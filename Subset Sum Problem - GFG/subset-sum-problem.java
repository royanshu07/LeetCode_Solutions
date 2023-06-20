//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
       int[][]dp = new int[arr.length+1][sum+1];
       for(int i = 0;i<dp.length;i++){
           for(int j = 0;j<dp[0].length;j++){
               dp[i][j]=-1;
           }
       }
      int ans =  isSubsetSum(N,  arr,  sum,dp);
      if(ans==0){
          return false;
      }
      return true;}
       
    static int isSubsetSum(int N, int arr[], int sum,int[][]dp){
        if(dp[N][sum]!=-1){
            return dp[N][sum];
        }
        if(sum==0){
           dp[N][sum]=1;
           return 1;
        }
         if(N==0){
           dp[N][sum]=0;
           return 0;
        }
        if(arr[N-1]>sum){
            return isSubsetSum(N-1,  arr,  sum,dp);
        }
        int n1 = isSubsetSum(N-1,  arr,  sum,dp);
        int n2 = isSubsetSum(N-1,  arr,  sum-arr[N-1],dp);
        if(n1==1||n2==1){
           dp[N][sum]=1;
           return 1;
        }
        dp[N][sum]=0;
        return 0;
       
    }
}