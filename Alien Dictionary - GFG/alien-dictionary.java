//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java


// class Solution {
//     public String findOrder(String[] dict, int N, int K) {
//         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//         for (int i = 0; i < K; i++) {
//             ArrayList<Integer> temp = new ArrayList<>();
//             graph.add(temp);
//         }

//         for (int i = 0; i < dict.length - 1; i++) {
//             String a = dict[i];
//             String b = dict[i + 1];
//             int j = 0;
//             while (j < a.length() && j < b.length()) {
//                 if (a.charAt(j) != b.charAt(j)) {
//                     graph.get(a.charAt(j) - 'a').add(b.charAt(j) - 'a');
//                     break;
//                 }
//                 j++;
//             }
//         }

//         int[] ans = topoSort(graph);
//         StringBuilder out = new StringBuilder();
//         for (int i = 0; i < ans.length; i++) {
//             out.append((char) (ans[i] + 'a'));
//         }
//         return out.toString();
//     }

//     static int[] topoSort(ArrayList<ArrayList<Integer>> adj) {
//         int[] indegree = new int[adj.size()];
//         int[] ans = new int[adj.size()];
//         Queue<Integer> q = new LinkedList<>();
//         for (int i = 0; i < adj.size(); i++) {
//             ArrayList<Integer> temp = adj.get(i);
//             for (int j : temp) {
//                 indegree[j]++;
//             }
//         }

//         for (int i = 0; i < indegree.length; i++) {
//             if (indegree[i] == 0) {
//                 q.add(i);
//             }
//         }
//         int count = 0;
//         while (!q.isEmpty()) {
//             ans[count] = q.poll();
//             ArrayList<Integer> temp = adj.get(ans[count]);
//             count++;
//             for (int k : temp) {
//                 indegree[k]--;
//                 if (indegree[k] == 0) {
//                     q.add(k);
//                 }
//             }
//         }
//         return ans;
//     }
// }

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for(int i = 0;i<K;i++){
          ArrayList<Integer> temp = new ArrayList<>();
          graph.add(temp);
      }
       
      for(int i = 0;i<dict.length-1;i++){
          String a = dict[i];
          String b = dict[i+1];
          int j = 0;
          while(j<a.length()&&j<b.length()){
              if(a.charAt(j)==b.charAt(j)){
                  j++;
                  continue;
              }
              else{
                 ArrayList<Integer> temp = graph.get(a.charAt(j)-'a');
                 temp.add(b.charAt(j)-'a');
                 break;
              }
               
          }
      }
      int[]ans = topoSort(graph);
      String out ="";
      for(int i = 0;i<ans.length;i++){
          out+=(char)(ans[i]+'a');
      }
      return out;
       
       
        
        
    }
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj) 
    {
        int[]indegree = new int[adj.size()];
        int[]ans = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<adj.size();i++){
            ArrayList<Integer> temp = adj.get(i);
            for(int j :temp){
                indegree[j]++;
            }
        }
        
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            ans[count]=q.poll();
            ArrayList<Integer> temp = adj.get(ans[count]);
            count++;
            for(int k:temp){
                indegree[k]--;
                if(indegree[k]==0){
                    q.add(k);
                }
            }
            
        }
        return ans;
    }
}
