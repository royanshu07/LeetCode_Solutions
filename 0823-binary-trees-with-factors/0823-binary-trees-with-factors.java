class Solution{

private static final int MOD = (int)1e9 + 7;

public static int numFactoredBinaryTrees(final int[] vals){
	final int valsLen = vals.length;

	Arrays.sort(vals);

	Map<Integer, Integer> valToIdx = new HashMap<>();
	for (int i = 0; i < valsLen; i += 1){
		valToIdx.put(vals[i], i);
	}

	int[] dp = new int[vals.length];
	dp[0] = 1;
	for (int i = 1; i < valsLen; i += 1){
		dp[i] = 1;
		for (int j = 0; j < i; j += 1){
			if (vals[i] % vals[j] != 0){
				continue;
			}

			final Integer k = valToIdx.get(vals[i] / vals[j]);
			if (k != null){
				dp[i] = (int)( (dp[i] + (long)dp[j] * dp[k]) % MOD );
			}
		}
	}

	int sum = 0;
	for (int i = 0; i < valsLen; i += 1){
		sum = (sum + dp[i]) % MOD;
	}
	return sum;
}

}