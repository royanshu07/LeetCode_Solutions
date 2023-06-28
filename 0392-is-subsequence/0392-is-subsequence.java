class Solution {
    public boolean isSubsequence(String a, String b) {
        if(a.equals(b)){
            return true;
        }
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
   
    int i = a.length();
    int j = b.length();
    int[]prev = {i,j};
    while(i>=0&&j>=0){
        
        if(dp[i][j]==0){
           
            break;
        }
       
        if(a.charAt(i-1)==b.charAt(j-1)){
            
            out = a.charAt(i-1)+out;
            
            i--;
            j--;
        }
        else{
            if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
    }
    if(out.equals(a)){
        return true;
    }
    return false;
        
    }
}