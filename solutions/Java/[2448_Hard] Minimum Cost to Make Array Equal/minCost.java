class Solution {
  public long minCost(int[] nums, int[] cost) {
    int n = nums.length;

    Integer[][] numsCostPair = new Integer[n][2];

    for (int i = 0; i < n; i++) {
      numsCostPair[i] = new Integer[]{nums[i], cost[i]};
    }

    Arrays.sort(numsCostPair, Comparator.comparingInt(a -> a[0]));

    long[] prefixSum = new long[n];
    prefixSum[0] = numsCostPair[0][1];

    for (int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i - 1] + numsCostPair[i][1];
    }

    int i = 0;
    while (i < n && prefixSum[i] <= prefixSum[n - 1] / 2) {
      i++;
    }

    long result = 0;
    for (int j = 0; j < n; j++) {
      result += Math.abs(numsCostPair[j][0] - numsCostPair[i][0]) * (long) numsCostPair[j][1];
    }

    return result;
  }
}
