
class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        
        int[]cuts2 = new int[cuts.length+2];
        cuts2[0]=0;
        int dp[][]= new int[cuts2.length][cuts2.length];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        cuts2[cuts2.length-1]=n;
        for(int i = 0;i<cuts.length;i++){
            cuts2[i+1]=cuts[i];
        }
        return minCost(cuts2,0,cuts2.length-1,dp);
    }
    public int minCost( int[] cuts,int start , int end,int[][]dp) {
        if(start>=end-1){
          return 0;
            
        }
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        int sum = (int)(1e9);
        for(int i = start+1;i<end;i++){
           int left = minCost(cuts,start,i,dp);
           int right = minCost(cuts,i,end,dp);
            sum = Math.min(sum,right+left);
            
        }
        //System.out.println(sum+n);
        sum+=(cuts[end]-cuts[start]);
        dp[start][end]=sum;
        return sum;
        
    }
}

