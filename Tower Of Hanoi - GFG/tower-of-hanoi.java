//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}






// } Driver Code Ends


// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi {
    static int count = 0;
    public long toh(int N, int from, int to, int aux ){
        count = 0;
        if(N==1){
          System.out.println("move disk "+ 1+ " from rod " + from +" to rod " +to);
          return 1; 
        }
        toh2( N,  from, to, aux);
        return count;
    } 
    public long toh2(int N, int from, int to, int aux) {
        if(N==0){
            return count;
        }
        
        
        if(N==2){
            count = count+3;
            System.out.println("move disk "+ 1+ " from rod " + from +" to rod " +aux);
            System.out.println("move disk "+ 2+ " from rod " + from +" to rod " +to);
            System.out.println("move disk "+ 1+ " from rod " + aux +" to rod " +to);
            
            return count;
            
        }
        toh2( N-1,  from, aux, to);
        count++; 
        System.out.println("move disk "+ N+ " from rod " + from +" to rod " +to);
        toh2(N-1,aux,to,from);
        return count;
        
    }
}
