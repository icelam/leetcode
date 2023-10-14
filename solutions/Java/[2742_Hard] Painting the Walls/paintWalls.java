class Solution {
  public int paintWalls(int[] cost, int[] time) {
    int n = cost.length;
    int[] dp = new int[n + 1];

    // Initial value = Max cost * max item length
    Arrays.fill(dp, 1000000 * 500);
    dp[0] = 0;

    for (int i = 0; i < n; i++) {
      for (int j = n; j > 0; j--) {
        dp[j] = Math.min(dp[j], dp[Math.max(j - time[i] - 1, 0)] + cost[i]);
      }
    }

    return dp[n];
  }
}
