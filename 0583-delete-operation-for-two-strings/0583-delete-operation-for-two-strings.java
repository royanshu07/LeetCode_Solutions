class Solution {
    public int minDistance(String word1, String word2) {
        int[][]dp = new int[word1.length()+1][word2.length()+1];
        for(int i =0;i<dp.length;i++){
            dp[i][0]=0;
        }
         for(int i =0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=1+ dp[i-1][j-1];
                }
                else{
                    int a = dp[i][j-1];
                    int b = dp[i-1][j];
                    dp[i][j]= Math.max(a,b);

                }
            }
        }
        int ans = word1.length()+word2.length()-(2*dp[word1.length()][word2.length()]);
        return ans;
        
    }
}