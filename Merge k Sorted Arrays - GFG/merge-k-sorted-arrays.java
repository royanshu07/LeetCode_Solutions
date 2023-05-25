//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java
class arrnode implements Comparable<arrnode> {
    int val;
    int i;
    int j;

    public arrnode(int val, int i, int j) {
        this.val = val;
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(arrnode other) {
        return this.val - other.val;
    }
}


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
       arrnode temp;
       ArrayList<Integer> out = new ArrayList<>();
       PriorityQueue<arrnode> pq = new PriorityQueue<>();
       for(int i = 0;i<K;i++){
           pq.add(new arrnode(arr[i][0],i,0));
       }
       
       while(!pq.isEmpty()){
           temp = pq.poll();
           out.add(temp.val);
           if(temp.j+1<K){
               pq.add(new arrnode((arr[temp.i][temp.j+1]),temp.i,temp.j+1));
           }
       }
       
       return out;
       
        
        
    }
}