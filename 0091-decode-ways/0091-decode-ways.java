class Solution {
    public int numDecodings(String s) {
        int[][]dp = new int[s.length()][s.length()];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],(-1));
        }
        return numDecodings(s,dp,0,s.length()-1);
    }
    public int numDecodings(String s,int[][]dp,int i , int j ) {
      
        if(i>j){
            return 1;
        }
       
        if(s.charAt(i)=='0'){
            return 0;
        }
          if(i==j){
            return 1;
        }
        
       
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i+1)=='0'){
             int a;
            if(Integer.parseInt(s.substring(i,i+2)) <= 26){
          a = numDecodings(s,dp,i+2,j);}
            else{
               a=0;
            }
            dp[i][j]=a;
            return a ;
        }
        else{
            int a = numDecodings(s,dp,i+1,j);
            int b = 0;
            //System.out.println(s.substring(i,i+1));
            if(Integer.parseInt(s.substring(i,i+2)) <= 26){
              b = numDecodings(s,dp,i+2,j);}
            dp[i][j]=a+b;
            return a+b;
        }
    }
}