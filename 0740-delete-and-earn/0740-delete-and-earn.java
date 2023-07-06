import java.util.Comparator;
class Solution {
     
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int a = map.getOrDefault(nums[i],0);
            map.put(nums[i],a+1);
        }
         Set<Integer> keySet = map.keySet();
         int[]arr =new int[keySet.size()];
        int j = 0;
         for(int i:keySet){
             arr[j]=i;
             j++;
         }
             Arrays.sort(arr);
        
         int[]dp = new int[arr.length];
         for(int i = 0;i<arr.length;i++){
             dp[i]=-1;
         }
         
         return deleteAndEarn(arr,dp,arr.length-1,map);
        
         
        
        
    }
   public int deleteAndEarn(int[] arr, int[] dp, int i,HashMap<Integer,Integer> map) {
    if (i <0) {
        return 0;
    }
    if (dp[i] != -1) {
        return dp[i];
    }
    if (i>=1 && arr[i ] - arr[i-1] != 1) {
        int a = map.get(arr[i]) * arr[i] + deleteAndEarn(arr, dp, i -1,map);
        dp[i] = a;
        return a;
    }
    int num = arr[i]*map.get(arr[i]);
    //System.out.println(num);
    int a =  num + deleteAndEarn(arr, dp, i-2,map);
    int b = deleteAndEarn(arr, dp, i -1,map);

    dp[i] = Math.max(a, b);
    return dp[i];
}

}