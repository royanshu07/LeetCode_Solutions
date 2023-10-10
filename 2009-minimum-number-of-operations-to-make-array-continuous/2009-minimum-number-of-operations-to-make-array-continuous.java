class Solution {
    public int minOperations(int[] nums) {
        HashSet<Integer> h = new HashSet<>();
        for(int i:nums) h.add(i);
        List<Integer> l = new ArrayList<>(h);
        Collections.sort(l);
        int a=Integer.MAX_VALUE,n=nums.length-1,r=l.size()-1;
        for(int i=l.size()-1;i>=0;i--){
            while(l.get(r)-l.get(i)>n)r--;
            a = Math.min(a,n-(r-i));
        }
        return a;
    }
}