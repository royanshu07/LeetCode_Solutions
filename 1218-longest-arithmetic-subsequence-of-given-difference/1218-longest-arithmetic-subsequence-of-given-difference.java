class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 1;
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(arr[i]-difference)){
                map.put(arr[i],map.get(arr[i]-difference)+1);
                ans = Math.max(ans,map.get(arr[i]));
            }
            else{
                map.put(arr[i],1);
            }
        }
        return ans;
        
        
    }
}