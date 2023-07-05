class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 1;
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(arr[i]-difference)){
                int temp = map.get(arr[i]-difference)+1;
                map.put(arr[i],temp);
                ans = Math.max(ans,temp);
            }
            else{
                map.put(arr[i],1);
            }
        }
        return ans;
        
        
    }
}