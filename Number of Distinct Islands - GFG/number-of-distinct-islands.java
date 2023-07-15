//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        Set<ArrayList<Integer>> set = new HashSet<> ();
        
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
              if(grid[i][j]==1){
                  ArrayList<Integer> temp = new ArrayList<Integer>();
                  set.add(dfs(i,j,temp,i,j,grid));
              }  
            }
        }
        return set.size();
        
    }
    
    public static ArrayList<Integer> dfs(int i , int j ,ArrayList<Integer> temp ,int ibase,int jbase,int[][]grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return temp;
        }
        if(grid[i][j]==0){
            return temp;
        }
        grid[i][j]=0;
        temp.add(i-ibase,j-jbase);
        dfs(i+1,j,temp,ibase,jbase,grid);
        dfs(i,j+1,temp,ibase,jbase,grid);
        dfs(i-1,j,temp,ibase,jbase,grid);
        dfs(i,j-1,temp,ibase,jbase,grid);
        return temp;
    }
}
