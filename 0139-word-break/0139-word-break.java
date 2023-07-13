
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[][] = new int[s.length()][s.length()];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<wordDict.size();i++){
            map.put(wordDict.get(i),1);
        }
        int ans= wordBreak( s,  map,0,0,dp);
        if(ans==0){
            return false;
        }
        return true;
        
    }
    public  int wordBreak(String s, HashMap<String,Integer> map,int i,int j,int[][]dp) {
        if(i==j&&i>=s.length()){
            return 1;
        }
        if(i>=s.length()||j>=s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(map.containsKey(s.substring(i,j+1))){
            int a = wordBreak( s,  map,j+1,j+1,dp);
            int  b = wordBreak(s,map,i,j+1,dp);
            if(a==1||b==1){
                dp[i][j]=1;
            }
            else{
                dp[i][j]=0;
            }
            return dp[i][j];
        }
        dp[i][j]= wordBreak(s,map,i,j+1,dp);
        return dp[i][j];
}}