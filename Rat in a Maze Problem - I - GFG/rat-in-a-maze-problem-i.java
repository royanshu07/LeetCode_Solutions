//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
       String c = "";
       return findPath(m,0,0,n,c);
    }
     public static ArrayList<String> findPath(int[][] m, int a , int b ,int n, String c) {
         ArrayList<String> out = new ArrayList<String>();
        if(a>=m.length||a<0||b>=m.length||b<0||m[a][b]==0||m[a][b]==-1){
            return out;
        } 
        if(a==n-1&&b==n-1){
            out.add(c);
            return out;
        }
        
       
        m[a][b]=-1;
          ArrayList<String> out1 =findPath(m,a-1,b,n,c+"U");
          ArrayList<String> out2 =findPath(m,a+1,b,n,c+"D");
          ArrayList<String> out3 =findPath(m,a,b-1,n,c+"L");
          ArrayList<String> out4 =findPath(m,a,b+1,n,c+"R");
          if(out1.size()>0){
          for(String l:out1){
             
                  out.add(l);
              
          }}
          if(out2.size()>0){
          for(String i:out2){
                  out.add(i);
              
          }}
          if(out3.size()>0){
          for(String j:out3){
             
                  out.add(j);
              
          }}
          if(out4.size()>0){
          for(String k:out4){
              
                  out.add(k);
              
          }}
           m[a][b]=1;
         return out;
    }
}