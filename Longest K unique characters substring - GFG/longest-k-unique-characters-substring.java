//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = -1;
        while(j<s.length()){
            int a = map.getOrDefault(s.charAt(j),0);
            map.put(s.charAt(j),a+1);
            if(map.size()==k){
                if(j-i+1>max){
                    max = j-i+1;
                }
                
                
                j++;
                
            }
            if(map.size()<k){
               j++;
            }
            
            if(map.size()>k){
                while(map.size()>k){
                 if(map.size()==k&&j-i+1>max){
                    max = j-i+1;
                }
                a = map.getOrDefault(s.charAt(i),0);
                if(a>1){
                    map.put(s.charAt(i),a-1);
                }
                else{
                    map.remove(s.charAt(i));
                }
                i++;
                }
                j++;
            }
            
            
        }
        return max;
    }
}