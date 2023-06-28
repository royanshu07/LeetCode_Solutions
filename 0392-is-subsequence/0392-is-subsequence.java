class Solution {
    public boolean isSubsequence(String a, String b) {
        // if(a.equals(b)){
        //     return true;
        //  }
        int[][]dp = new int[a.length()+1][b.length()+1];
    for(int i = 0;i<=a.length();i++){
        dp[i][0]=0;
    }
    String out ="";
    for(int i = 0;i<=b.length();i++){
        dp[0][i]=0;
    }
    for(int i = 1;i<=a.length();i++){
        for(int j =1;j<=b.length();j++){
            if(a.charAt(i-1)==b.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
                
                
            }
            else{
               dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]); 
            }
        }
    }
   
   if(dp[a.length()][b.length()]==a.length()){
       return true;
   }
        return false;
        
    }
}