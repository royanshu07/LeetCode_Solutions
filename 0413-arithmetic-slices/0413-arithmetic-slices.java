class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int d = 1;
        int[][]dp = new int[arr.length][arr.length];
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j=2;j<arr.length;j++){
                if(j-i<2){
                    continue;
                }
                if(j-i==2){
                    if(arr[j]-arr[j-1]==arr[j-1]-arr[j-2]){
                        d = arr[j]-arr[j-1];
                        dp[i][j]=1;
                        sum++;
                    }
                }
                else if(dp[i][j-1]==1){
                    if(arr[j]-arr[j-1]==d){
                        dp[i][j]=1;
                        sum++;
                    }
                }
            }
        }
        return sum;
        
    }
}