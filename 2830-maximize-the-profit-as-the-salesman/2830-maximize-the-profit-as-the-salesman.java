class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] memo = new int[offers.size()];
        Collections.sort(offers, (a, b)->a.get(0)-b.get(0));
        return dfs(offers, 0, memo);
    }

    private int dfs(List<List<Integer>> offers, int i, int[] memo){
        if (i==offers.size()) return 0;
        if (memo[i]>0) return memo[i];

        int curr = dfs(offers, i+1, memo);
        int next = bs(offers, i);
        curr = Math.max(curr, offers.get(i).get(2)+dfs(offers, next, memo));
        memo[i] = curr;
        return curr;
    }

    private int bs(List<List<Integer>> offers, int i){
        int key = offers.get(i).get(1);
        int l = i+1, r = offers.size();
        while(l<r){
            int m = l+(r-l)/2;
            if (offers.get(m).get(0)>key)
                r = m;
            else
                l = m+1;
        }
        return r;
    }
}