class Solution {
    public int findPairs(int[] arr, int k) {
          HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int v = map.getOrDefault(arr[i], 0);
            map.put(arr[i], v + 1);
        }
        Set<Integer> keys = map.keySet();
        int count = 0;
        for (Integer i : keys) {
            
			int freq = map.getOrDefault(i- k, 0);
            if (freq > 0) {
                if (k == 0&&freq>1) {
                    count += 1;
					map.put(i,0);
                } else if(k!=0) {
                      count += 1;
                }
            }
        }
        return count;
        
    }
}
