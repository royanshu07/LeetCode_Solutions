//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           out.println(new Solution().findFloor(arr, n, x));
          
        }
        out.close();
    }
    
}
// } Driver Code Ends


class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
      int i = 0;
      int j = arr.length-1;
      long ans = arr[i];
      int ansindex = i;
      while(i<=j){
          int mid = (i+j)/2;
          if(arr[mid]<x){
             if(arr[mid]>ans){
                 ans=arr[mid];
                 ansindex= mid;
             }
              i  =mid+1;
              
          }
          else if(arr[mid]==x){
              return mid;
          }
          else{
             j = mid-1; 
          }
      }
      if(arr[ansindex]>x){
          return -1;
      }
      return ansindex;
    }
    
}
