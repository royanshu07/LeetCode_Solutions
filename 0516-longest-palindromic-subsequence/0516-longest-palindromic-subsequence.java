class Solution {
    public int longestPalindromeSubseq(String s) {
        String  b  = "";
        for(int i = s.length()-1;i>=0;i--){
            b+=s.charAt(i);
        }
        int[][]dp = new int[s.length()+1][b.length()+1];
         for(int i =0;i<=s.length();i++){
             dp[i][0]=0;}
        for(int i =0;i<=s.length();i++){
             dp[0][i]=0;}
        for(int i =1;i<=s.length();i++){
            for(int j = 1;j<=b.length();j++){
                if(s.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                   int x =  dp[i-1][j];
                   int y =  dp[i][j-1];
                   dp[i][j]=Math.max(x,y);
                } 
                
            }
        }
        return dp[b.length()][b.length()];
        
    }
}