class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        int[][][] dp = new int[s1.length()][s1.length()][s1.length()];
        for(int i =0;i<s1.length();i++){
            for(int j = 0;j<s1.length();j++){
                for(int k = 0;k<s1.length();k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        int ans= isScramble( s1,  s2,0 , s1.length()-1 , 0, s2.length()-1,dp);
        if(ans==1){
            return true;
        }
        return false ;
        
    }
    public int isScramble(String s1, String s2,int i , int j , int a , int b,int[][][] dp ) {
        
        if(j-i!=b-a){
            return 0;
        }
        if(s1.substring(i,j+1).equals(s2.substring(a,b+1))){
            return 1;
        }
        if(i<0||j<0||a<0||b<0){
            return 0;
        }
        if(dp[j-i][i][a]!=-1){
            return dp[j-i][i][a];
        }
        
        for(int k=0;k<j-i;k++){
            int  c =  isScramble( s1,  s2,i,i+k, a, a+k,dp);
            int d =  isScramble( s1,  s2,k+1+i , j , a+k+1, b,dp);
            if(c==1&&d==1){
                dp[j-i][i][a]=1;
                return 1;
            }
            c = isScramble( s1,  s2,i,i+k, b-k, b,dp);
            d =isScramble( s1,  s2,k+1+i , j ,a, b-k-1,dp); 
            if(c==1&&d==1){
                dp[j-i][i][a]=1;
                return 1;
            }
        }
       dp[j-i][i][a]=0;
                return 0;
        
}}