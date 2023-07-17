class Solution {
    public int subarraySum(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int sum = 0;
            int count = 0;
            int j = 0;
            map.put(0,1);
            while(j<nums.length){
                sum+=nums[j];
                int a = map.getOrDefault(sum-k,0);
                if(a>0){
                   count+=a;
                }
                //System.out.println(sum);
                map.put(sum,map.getOrDefault(sum,0)+1);
                j++;
            }
        return count;
        
        
    }
}