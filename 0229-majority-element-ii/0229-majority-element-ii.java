class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Integer> se = map.keySet();
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i:se){
            if(map.get(i)>n/3){
                ans.add(i);
            }
        }
        return ans;
    }
}